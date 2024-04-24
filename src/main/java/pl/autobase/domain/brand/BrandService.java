package pl.autobase.domain.brand;

import org.springframework.stereotype.Service;
import pl.autobase.domain.brand.dto.BrandDto;
import pl.autobase.domain.brand.dto.BrandDtoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Optional<BrandDto> findBrandByName(String name) {
        return brandRepository.findByNameIgnoreCase(name)
                .map(BrandDtoMapper::map);
    }

    public List<BrandDto> findAllBrands() {
        return StreamSupport.stream(brandRepository.findAll().spliterator(), false)
                .map(BrandDtoMapper::map)
                .toList();
    }
}