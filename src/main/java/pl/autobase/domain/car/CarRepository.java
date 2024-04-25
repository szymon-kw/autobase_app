package pl.autobase.domain.car;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByPopularIsTrue();
    @Query("select c from Car c join c.ratings r group by c order by avg(r.rating) desc")
    List<Car> findTopByRating(Pageable page);
}