package pl.autobase.domain.car;

import org.springframework.stereotype.Service;
import pl.autobase.domain.brand.Brand;
import pl.autobase.domain.brand.BrandRepository;
import pl.autobase.domain.car.dto.CarDto;
import pl.autobase.domain.car.dto.CarSaveDto;
import pl.autobase.storage.FileStorageService;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final FileStorageService fileStorageService;

    public CarService(CarRepository carRepository, BrandRepository brandRepository, FileStorageService fileStorageService) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<CarDto> findAllPopularCars() {
        return carRepository.findAllByPopularIsTrue().stream()
                .map(CarDtoMapper::map)
                .toList();    }



    public Optional<CarDto> findCarById(long id) {
        return carRepository.findById(id).map(CarDtoMapper::map);
    }

    public void addCar(CarSaveDto carToSave) {
        Car car = new Car();
        car.setModel(carToSave.getModel());
        car.setType(carToSave.getType());
        car.setPopular(carToSave.isPopular());
        car.setProductionYear(carToSave.getProductionYear());
        car.setShortDescription(carToSave.getShortDescription());
        car.setDescription(carToSave.getDescription());
        car.setYoutubeShowcaseId(carToSave.getYoutubeShowcaseId());
        Brand brand = brandRepository.findByNameIgnoreCase(carToSave.getBrand()).orElseThrow();
        car.setBrand(brand);
        if (carToSave.getPhoto() != null && !carToSave.getPhoto().isEmpty()) {
            String savedFileName = fileStorageService.saveImage(carToSave.getPhoto());
            car.setPhoto(savedFileName);
        }
        carRepository.save(car);
    }
}