package sustain.project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.classes.AddUserFood;
import sustain.project.classes.AddUserFoodService;
import sustain.project.classes.User;
import sustain.project.classes.UserService;

import java.security.Principal;


@Controller
public class AppController{

    @Autowired
    private UserService service;

    @Autowired
    private AddUserFoodService auf;

    // VIEWS

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
        AddUserFood foodItems = new AddUserFood();
        model.addAttribute("foodItems", foodItems);

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


    @RequestMapping(value = "/addFoodItems", method = RequestMethod.POST)
    public String AddUserFood(@ModelAttribute("foodItems") AddUserFood foodItems) {
        auf.save(foodItems);;
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