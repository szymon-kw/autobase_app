package pl.autobase.domain.car;

import pl.autobase.domain.car.dto.CarDto;
import pl.autobase.domain.rating.Rating;

public class CarDtoMapper {

    static CarDto map(Car car) {
        double avgRating = car.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(val -> val)
                .average().orElse(0);
        int ratingCount = car.getRatings().size();
        return new CarDto(
                car.getId(),
                car.getModel(),
                car.getType(),
                car.getProductionYear(),
                car.getShortDescription(),
                car.getDescription(),
                car.getYoutubeShowcaseId(),
                car.getBrand().getName(),
                car.isPopular(),
                car.getPhoto(),
                avgRating,
                ratingCount
        );
    }
}
