package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sustain.project.classes.AddUserFood;
import sustain.project.classes.AddUserFoodService;
import sustain.project.classes.Food;
import sustain.project.classes.FoodService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

//    @Autowired
//    private AddUserFoodService service;
//
//    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
//    public String AddUserFood(@ModelAttribute("foodItems") AddUserFood foodItems) {
//        service.save(foodItems);
//
//        return "addFood"; //eg. homepage
//    }


//    @RequestMapping("/addFoodToList")
//    public String addFoodToArrayList(@ModelAttribute("food") Food food, @RequestParam(name = "foodName") String foodName, @RequestParam(name = "grams") double grams) {
//        service.addFoodMethod(foodName, grams);
//
//    return "addFood";
//    }

//    @RequestMapping(value = "/calcFoodCo2")
//    public String calcFoodCo2(@PathVariable("foodName") String foodName, @PathVariable("grams") double grams ) {
//        service.calcFoodCo2(foodName,grams);
//
//        return "redirect:addFood";
//    }

}