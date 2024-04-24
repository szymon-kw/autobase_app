package pl.autobase.domain.brand;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    Optional<Brand> findByNameIgnoreCase(String name);
}