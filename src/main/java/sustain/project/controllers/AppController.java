package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.classes.AddUserFood;
import sustain.project.classes.Food;
import sustain.project.classes.FoodTotal;
import sustain.project.service.*;
import sustain.project.classes.User;

import java.security.Principal;
import java.util.List;


@Controller
public class AppController {

    @Autowired
    private UserService service;

    @Autowired
    private AddUserFoodService auf;

    @Autowired
    private FoodService f;

    @Autowired
    private CustomUserDetailsService userDetails;

    @Autowired
    private FoodTotalService fts;

    // VIEWS

    @RequestMapping("/test")
    public String viewHomePage(Model model) {

        List<Food> listFood = f.listAll();
        model.addAttribute("listFood", listFood);

        return "list"; // return is how the method takes you to the html page
        // must be same name as page
    }

    @RequestMapping(value = "/login")
    public ModelAndView showLogin() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/")
    public ModelAndView showLanding() {
        return new ModelAndView("index");
    }

    @RequestMapping("/logout")
    public ModelAndView viewLogout() {
        return new ModelAndView("index");
    }

    @RequestMapping("/signUp")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "signUp";
    }

    @RequestMapping("/addFoodView")
    public String showAddFoodForm(Model model) {
        AddUserFood foodObject = new AddUserFood();
        model.addAttribute("foodObject", foodObject);

        return "addFood";
    }

    @RequestMapping(value = "/dashboard")
    public ModelAndView showUserDashboard() {
        return new ModelAndView("dashboard");
    }


    // METHODS

    @PostMapping("/save")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        service.save(user);

        return "register_success";
    }


    @PostMapping("/addFoodItems")
    public String AddUserFood(@ModelAttribute("foodItems") AddUserFood foodItems) {
        auf.save(foodItems);
        return "addFood";
    }

    @PostMapping("/calcFood")
    public String calcFood(@ModelAttribute("foodObject") AddUserFood foodObject, @ModelAttribute("foodName") String foodN,
                           @ModelAttribute("grams") double g, Model model) {
        double res = 0;
        List<Food> fl = f.listAll();


        for (Food food : fl) {

            if (food.getFoodName().equals(foodN)) {

                double oneG = food.getCo2g() / 100;
                res = g * oneG;
            }
        }

        foodObject.setRes(res);
        foodObject.setUsername(userDetails.returnUsername());
        auf.save(foodObject);
        model.addAttribute("res", res);
        model.addAttribute("foodName", foodN);
        model.addAttribute("grams", g);

        return "addFood";
    }

    @PostMapping("/calcFoodTotal")
    public String calcFoodTotal(@ModelAttribute("foodTotalObject") FoodTotal foodTotalObject,
                                Model model){

        List<AddUserFood> ufl = auf.listAll();
        String username = userDetails.returnUsername();
        foodTotalObject.setUsername(username);
        double total = 0.0;
        for (int i = 0; i<ufl.size(); i++) {

            if (ufl.get(i).getUsername().equals(username)) {

                total = ufl.get(i).getRes();
            }
        }

        foodTotalObject.setTotalCo2(total);
        fts.save(foodTotalObject);
        model.addAttribute("listTotal", ufl);
        model.addAttribute("total", total);
        model.addAttribute("username", username);

        return "addFood";
    }



    @Controller
    public class SecurityController {

        @RequestMapping(value = "/username", method = RequestMethod.GET)
        @ResponseBody
        public String currentUserName(Principal principal) {
            return principal.getName();
        }
    }


    @RequestMapping("/edit/{username}")
    public ModelAndView showEditUserForm(@PathVariable(name = "username") String username) {

        ModelAndView mav = new ModelAndView("edit_user"); // name of html page
        User user = service.get(username);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/delete/{username}")
    public String deleteUser(@PathVariable(name = "username") String username) {
        service.delete(username);

        return "redirect:/"; //eg. homepage
    }
}