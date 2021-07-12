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

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService service;

    @Autowired
    private AddUserFoodService auf;

    @RequestMapping("/")
    public String viewHomePage(Model model) {

        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "index"; // return is how the method takes you to the html page
        // must be same name as page
    }

    @RequestMapping("/signUp")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "signUp";
    }

    @PostMapping("/save")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        service.save(user);

        return "register_success";
    }

//    @RequestMapping(value = "/login")
//    public String showUserDashboard() {
//
//        return "dashboard"; //eg. homepage
//    }

    @RequestMapping("/addFoodPage")
    public String showAddFoodForm(Model model) {
        AddUserFood foodItems = new AddUserFood();
        model.addAttribute("foodItems", foodItems);

        return "addFood";
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public void AddUserFood(@ModelAttribute("foodItems") AddUserFood foodItems) {
        auf.save(foodItems);
    }



//    @PostMapping("/save")
//    public String saveUser(User user) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        service.save(user);
//
//        return "dashboard";
//    }

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