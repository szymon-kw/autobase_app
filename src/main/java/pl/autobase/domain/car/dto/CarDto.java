package pl.autobase.domain.car.dto;

public class CarDto {

    private Long id;
    private String model;
    private String type;
    private Integer productionYear;
    private String brand;
    private boolean popular;

    public CarDto(Long id, String model, String type, Integer productionYear, String brand, boolean popular) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.productionYear = productionYear;
        this.brand = brand;
        this.popular = popular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }
}