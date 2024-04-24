package pl.autobase.domain.car.dto;

public class CarDto {

    private Long id;
    private String model;
    private String type;
    private Integer productionYear;
    private String shortDescription;
    private String description;
    private String youtubeShowcaseId;
    private String brand;
    private boolean popular;
    private String photo;

    public CarDto(Long id, String model, String type, Integer productionYear, String shortDescription,
                  String description, String youtubeShowcaseId, String brand, boolean popular, String photo) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.productionYear = productionYear;
        this.shortDescription = shortDescription;
        this.description = description;
        this.youtubeShowcaseId = youtubeShowcaseId;
        this.brand = brand;
        this.popular = popular;
        this.photo = photo;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeShowcaseId() {
        return youtubeShowcaseId;
    }

    public void setYoutubeShowcaseId(String youtubeShowcaseId) {
        this.youtubeShowcaseId = youtubeShowcaseId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}