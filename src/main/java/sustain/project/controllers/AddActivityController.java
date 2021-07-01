package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.classes.AddActivity;
import sustain.project.classes.AddActivityService;
import sustain.project.classes.Food;
import sustain.project.classes.FoodService;

import java.util.List;

@Controller
public class AddActivityController {

    @Autowired
    private AddActivityService service;

    @Autowired
    private FoodService foodService;

    @RequestMapping("/foodList")
    public String viewFoodList(Model model)
    {
        List<Food> listFood = foodService.listAll();
        model.addAttribute("listFood", listFood);

        return "addFood";
    }


    @RequestMapping("//")
    public String viewActivityPage(Model model) {

        AddActivity a = new AddActivity();
        model.addAttribute("activityType", a);

        return "activityPage"; // return is how the method takes you to the html page
        // must be same name as page
    }

    @RequestMapping("/addFood")
    public String showAddFoodForm(Model model) {
        Food food = new Food();
        model.addAttribute("food", food);

        return "addFood";
    }

    @RequestMapping(value = "//save", method = RequestMethod.POST)
    public String saveActivity(@ModelAttribute("activity") AddActivity a) {
        service.save(a);

        return "addFood"; //eg. homepage
    }


    @RequestMapping("/delete/{date}")
    public String delete(@PathVariable(name = "date") String date) {
        service.delete(date);

        return "editActivity"; //eg. homepage
    }
}
