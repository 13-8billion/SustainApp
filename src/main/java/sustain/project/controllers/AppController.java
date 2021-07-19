package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.models.AddUserFood;
import sustain.project.models.Food;
import sustain.project.models.FoodTotal;
import sustain.project.service.*;
import sustain.project.models.User;

import java.security.Principal;
import java.time.LocalDate;
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

        List<AddUserFood> listFood = auf.listAll();
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

    @RequestMapping("/stats")
    public String stats(){
        return "stats";
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

    @PostMapping(value = "/calcFood", params = "add")
    public ModelAndView calcFood(@ModelAttribute("foodObject") AddUserFood foodObject, @ModelAttribute("foodName") String foodN,
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

        return new ModelAndView("addFood");
    }

    @PostMapping(value = "/calcFood", params = "calc")
    public ModelAndView calcFoodTotal(@ModelAttribute("foodTotalObject") FoodTotal foodTotalObject,
                                      @ModelAttribute("foodObject") AddUserFood foodObject, @ModelAttribute("foodName") String foodN,
                                      @ModelAttribute("grams") double g, Model model ) {

        List<AddUserFood> ufl = auf.listAll();
        String username = userDetails.returnUsername();
        foodTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddUserFood addUserFood : ufl) {

            if (addUserFood.getUsername().equals(username)) {

                total = total + addUserFood.getRes();
            }
        }

        foodTotalObject.setTotalCo2(total);
        foodTotalObject.setDate(date);
        fts.save(foodTotalObject);

        model.addAttribute("total", total);
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("foodName", foodN);
        model.addAttribute("grams", g);

        Iterable<AddUserFood> deleteFoodObject = auf.listAll();
        auf.deleteAll(deleteFoodObject);

        return new ModelAndView("addFood");
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