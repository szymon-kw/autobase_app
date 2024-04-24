package pl.autobase.domain.car.dto;

import org.springframework.web.multipart.MultipartFile;

public class CarSaveDto {

    private String model;
    private String type;
    private Integer productionYear;
    private String shortDescription;
    private String description;
    private String youtubeShowcaseId;
    private String brand;
    private boolean popular;
    private MultipartFile photo;

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

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
