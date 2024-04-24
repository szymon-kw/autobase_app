package pl.autobase.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.autobase.domain.car.CarService;
import pl.autobase.domain.car.dto.CarDto;
import java.util.List;

@Controller
public class HomeController {
    private final CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<CarDto> popularCars = carService.findAllPopularCars();
        model.addAttribute("heading", "Najpopularniejsze auta");
        model.addAttribute("description", "Oto lista najczęściej wyszukiwanych aut");
        model.addAttribute("cars", popularCars);
        return "car-listing";
    }

//    @GetMapping("/admin")
//    public String getAdminPanel() {
//        return "admin/admin";
//    }
}