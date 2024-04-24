package pl.autobase.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.autobase.domain.car.CarService;
import pl.autobase.domain.car.dto.CarSaveDto;
import pl.autobase.domain.brand.dto.BrandDto;
import pl.autobase.domain.brand.BrandService;

import java.util.List;

@Controller
public class CarManagementController {
    private final CarService carService;
    private final BrandService brandService;

    public CarManagementController(CarService carService, BrandService brandService) {
        this.carService = carService;
        this.brandService = brandService;
    }

    @GetMapping("/admin/dodaj-auto")
    public String addCarForm(Model model) {
        List<BrandDto> allBrands = brandService.findAllBrands();
        model.addAttribute("brands", allBrands);
        CarSaveDto car = new CarSaveDto();
        model.addAttribute("car", car);
        return "admin/car-form";
    }

    @PostMapping("/admin/dodaj-auto")
    public String addCar(CarSaveDto car, RedirectAttributes redirectAttributes) {
        carService.addCar(car);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Auto %s zostało zapisane".formatted(car.getBrand() + " " + car.getModel()));
        return "redirect:/admin";
    }
}