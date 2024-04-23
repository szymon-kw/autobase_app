package pl.autobase.domain.car;

import org.springframework.stereotype.Service;
import pl.autobase.domain.car.dto.CarDto;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> findAllPopularCars() {
        return carRepository.findAllByPopularIsTrue().stream()
                .map(CarDtoMapper::map)
                .toList();    }



    public Optional<CarDto> findCarById(long id) {
        return carRepository.findById(id).map(CarDtoMapper::map);
    }
}