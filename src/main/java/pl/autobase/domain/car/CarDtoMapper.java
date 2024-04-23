package pl.autobase.domain.car;

import pl.autobase.domain.car.dto.CarDto;

public class CarDtoMapper {

    static CarDto map(Car car) {
        return new CarDto(
                car.getId(),
                car.getModel(),
                car.getType(),
                car.getProductionYear(),
                car.getShortDescription(),
                car.getDescription(),
                car.getYoutubeShowcaseId(),
                car.getBrand().getName(),
                car.isPopular()
        );
    }
}
