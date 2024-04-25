package pl.autobase.web;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.autobase.domain.car.Car;
import pl.autobase.domain.car.CarService;
import pl.autobase.domain.car.dto.CarDto;
import pl.autobase.domain.rating.RatingService;

import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;
    private final RatingService ratingService;

    public CarController(CarService carService, RatingService ratingService) {
        this.carService = carService;
        this.ratingService = ratingService;
    }

    @GetMapping("/auto/{id}")
    public String getCar(@PathVariable long id,
                           Model model,
                           Authentication authentication) {
        CarDto car = carService.findCarById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("car", car);
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            Integer rating = ratingService.getUserRatingForCar(currentUserEmail, id).orElse(0);
            model.addAttribute("userRating", rating);
        }
        return "car";
    }
}