package pl.autobase.domain.brand.dto;
import pl.autobase.domain.brand.Brand;
import pl.autobase.domain.brand.dto.BrandDto;

public class BrandDtoMapper {
    public static BrandDto map(Brand brand) {
        return new BrandDto(
                brand.getId(),
                brand.getName()
        );
    }
}