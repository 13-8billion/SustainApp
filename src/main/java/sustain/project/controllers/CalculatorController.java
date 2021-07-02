package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.classes.Food;
import sustain.project.classes.FoodService;

import java.util.ArrayList;

@Controller
public class CalculatorController {

    @Autowired
    private FoodService service;

    @RequestMapping("/addFoodButton")
    public String addFoodToArrayList(@PathVariable(name = "foodList") ArrayList<Object> foodList) {
        service.addFoodMethod(foodList);

        return "addFood";
    }

    @RequestMapping(value = "/calcFoodCo2")
    public String calcFoodCo2(@PathVariable("foodName") String foodName, @PathVariable("grams") double grams ) {
        service.calcFoodCo2(foodName,grams);

        return "redirect:addFood";
    }

}