package pl.autobase.domain.rating;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    Optional<Rating> findByUser_EmailAndCar_Id(String userEmail, Long carId);
}
