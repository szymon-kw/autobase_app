package pl.autobase.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.autobase.domain.car.Car;
import pl.autobase.domain.car.CarService;
import pl.autobase.domain.car.dto.CarDto;

import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/auto/{id}")
    public String getCar(@PathVariable long id, Model model) {
        Optional<CarDto> optionalCar = carService.findCarById(id);
        optionalCar.ifPresent(car -> model.addAttribute("car", car));
        return "car";
    }
}