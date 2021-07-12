package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarController {
    private CarServiceImpl carService = new CarServiceImpl();


    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", required = false, defaultValue = "5") int count, ModelMap model) {
        if (count > 0 && count < 5) {
            model.addAttribute("cars", carService.getCarByNum(count));
        } else {
            model.addAttribute("cars", carService.getCarByNum(5));
        }
        return "cars";
    }
}
