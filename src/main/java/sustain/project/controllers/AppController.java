package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.models.*;
import sustain.project.service.*;

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

    @Autowired
    private TransportService ts;

    @Autowired
    private AddTransportService ats;

    @Autowired
    private TransportTotalService tts;

    @Autowired
    private HouseEnergyService hes;

    @Autowired
    private AddHouseService ahs;

    @Autowired
    private HouseEnergyTotalService hets;


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

    @RequestMapping("/statistics")
    public String stats() {
        return "statistics";
    }

    @RequestMapping("/activityPageView")
    public String activityPageView() {
        return "activityPage";
    }

    @RequestMapping("/addTransportView")
    public String showTransportForm(Model model) {
        AddTransport transObject = new AddTransport();
        model.addAttribute("transObject", transObject);

        return "addTransport";
    }

    @RequestMapping("/addHouseEnergyView")
    public String showHouseEnergyForm(Model model) {
        AddHouse houseObject = new AddHouse();
        model.addAttribute("houseObject", houseObject);

        return "addHouse";
    }


    // USER METHODS

    @PostMapping("/save")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        service.save(user);

        return "register_success";
    }


    // FOOD

    @PostMapping("/addFoodItems")
    public String AddUserFood(@ModelAttribute("foodItems") AddUserFood foodItems) {
        auf.save(foodItems);
        return "addFood";
    }

    @PostMapping(value = "/calcFood", params = "add")
    public ModelAndView calcFood(@ModelAttribute("foodObject") AddUserFood foodObject, @ModelAttribute("foodName") String foodN,
                                 @ModelAttribute("grams") double g, Model model) {
        double res = 0;
        String username = userDetails.returnUsername();
        List<Food> fl = f.listAll();


        for (Food food : fl) {

            if (food.getFoodName().equals(foodN)) {

                double oneG = food.getCo2g() / 100;
                res = g * oneG;
            }
        }

        foodObject.setRes(res);
        foodObject.setUsername(username);
        auf.save(foodObject);
        model.addAttribute("res", res);
        model.addAttribute("foodName", foodN);
        model.addAttribute("grams", g);

        return new ModelAndView("addFood");
    }

    @PostMapping(value = "/calcFood", params = "calc")
    public ModelAndView calcFoodTotal(@ModelAttribute("foodTotalObject") FoodTotal foodTotalObject,
                                      @ModelAttribute("foodObject") AddUserFood foodObject, @ModelAttribute("foodName") String foodN,
                                      @ModelAttribute("grams") double g, Model model) {

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


    // TRANSPORT

    @PostMapping("/addTransportActivity")
    public String AddTransport(@ModelAttribute("transportActivity") AddTransport transportActivity) {
        ats.save(transportActivity);
        return "addTransport";
    }

    @PostMapping(value = "/calcTransport", params = "add")
    public ModelAndView calcTransport(@ModelAttribute("transObject") AddTransport transObject, @ModelAttribute("type") String type,
                                 @ModelAttribute("distance") double d, Model model) {
        double res = 0;
        List<Transport> tl = ts.listAll();


        for (Transport tran : tl) {

            if (tran.getType().equals(type)) {

                res = tran.getCo2km() * d;
            }
        }

        transObject.setRes(res);
        transObject.setUsername(userDetails.returnUsername());
        ats.save(transObject);
        model.addAttribute("res", res);
        model.addAttribute("type", type);
        model.addAttribute("distance", d);

        return new ModelAndView("addTransport");
    }

    @PostMapping(value = "/calcTransport", params = "calc")
    public ModelAndView calcTransportTotal(@ModelAttribute("transTotalObject") TransportTotal transTotalObject,
                                      @ModelAttribute("transObject") AddTransport transObject, @ModelAttribute("type") String type,
                                      @ModelAttribute("distance") double d, Model model) {

        String username = userDetails.returnUsername();
        List<AddTransport> tl = ats.listAll();
        transTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddTransport addTrans : tl) {

            if (addTrans.getUsername().equals(username)) {

                total = total + addTrans.getRes();
            }
        }

        transTotalObject.setTotalCo2(total);
        transTotalObject.setDate(date);
        tts.save(transTotalObject);

        model.addAttribute("total", total);
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("type", type);
        model.addAttribute("distance", d);
        Iterable<AddTransport> deleteTransObject = ats.listAll();
        ats.deleteAll(deleteTransObject);

        return new ModelAndView("addTransport");
    }

    // HOUSE ENERGY

    @PostMapping("/addHouseActivity")
    public String AddHouse(@ModelAttribute("houseObject") AddHouse houseObject) {
        ahs.save(houseObject);
        return "addHouse";
    }

    @PostMapping(value = "/calcHouse", params = "add")
    public ModelAndView calcHouse(@ModelAttribute("houseObject") AddHouse houseObject, @ModelAttribute("etype") String etype,
                                      @ModelAttribute("kWh") double kWh, Model model) {
        double res = 0;
        List<HouseEnergy> hl = hes.listAll();


        for (HouseEnergy house : hl) {

            if (house.getEtype().equals(etype)) {

                res = house.getCo2() * kWh;
            }
        }

        houseObject.setRes(res);
        houseObject.setUsername(userDetails.returnUsername());
        ahs.save(houseObject);
        model.addAttribute("res", res);
        model.addAttribute("etype", etype);
        model.addAttribute("kWh", kWh);

        return new ModelAndView("addHouse");
    }

    @PostMapping(value = "/calcHouse", params = "calc")
    public ModelAndView calcHouseTotal(@ModelAttribute("houseTotalObject") HouseEnergyTotal houseTotalObject,
                                           @ModelAttribute("houseObject") AddHouse houseObject, @ModelAttribute("etype") String etype,
                                           @ModelAttribute("kWh") double kWh, Model model) {

        String username = userDetails.returnUsername();
        List<AddHouse> hl = ahs.listAll();
        houseTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddHouse addHouse : hl) {

            if (addHouse.getUsername().equals(username)) {

                total = total + addHouse.getRes();
            }
        }

        houseTotalObject.setTotal(total);
        houseTotalObject.setDate(date);
        hets.save(houseTotalObject);

        model.addAttribute("total", total);
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("etype", etype);
        model.addAttribute("kWh", kWh);
        Iterable<AddHouse> deleteHouseObject = ahs.listAll();
        ahs.deleteAll(deleteHouseObject);

        return new ModelAndView("addHouse");
    }










    // SECURITY

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