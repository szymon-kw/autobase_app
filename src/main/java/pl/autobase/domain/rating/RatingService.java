package pl.autobase.domain.rating;

import org.springframework.stereotype.Service;
import pl.autobase.domain.car.Car;
import pl.autobase.domain.car.CarRepository;
import pl.autobase.domain.user.User;
import pl.autobase.domain.user.UserRepository;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, CarRepository carRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    public void addOrUpdateRating(String userEmail, long carId, int rating) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndCar_Id(userEmail, carId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Car car = carRepository.findById(carId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setCar(car);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForCar(String userEmail, long carId) {
        return ratingRepository.findByUser_EmailAndCar_Id(userEmail, carId)
                .map(Rating::getRating);
    }
}