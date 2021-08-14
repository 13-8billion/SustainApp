package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.models.*;
import sustain.project.service.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService service;

    @Autowired
    private AddEmissionService aes;

    @Autowired
    private FoodService f;

    @Autowired
    private CustomUserDetailsService userDetails;

    @Autowired
    private FoodTotalService fts;

    @Autowired
    private TransportService ts;

    @Autowired
    private TransportTotalService tts;

    @Autowired
    private HouseEnergyService hes;

    @Autowired
    private HouseEnergyTotalService hets;

    @Autowired
    private FlightTotalService flts;

    // VIEWS

    @RequestMapping("/test")
    public String viewHomePage(Model model) {

        List<User> listUser = service.listAll();
        String username = userDetails.returnUsername();
        User user = null;

        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                user = listUser.get(i);
            }
        }
        model.addAttribute("userInfo", user);

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

    @RequestMapping(value = "/dashboard")
    public ModelAndView showUserDashboard() {
        return new ModelAndView("dashboard");
    }

    @RequestMapping("/lastYearStats")
    public String lastYearStats() {
        return "lastYearStats";
    }

    @RequestMapping("/mealPlanner")
    public String mealPlanner() {
        return "mealPlanner";
    }

    @RequestMapping("/foodSpringSummer")
    public String foodSpring() {
        return "foodSpringSummer";
    }

    @RequestMapping("/foodAutumnWinter")
    public String foodAutumn() {
        return "foodAutumnWinter";
    }

    @RequestMapping("/lastMonthStats")
    public String lastMonthStats() {
        return "lastMonthStats";
    }

    @RequestMapping("/statistics")
    public String lastWeekStats() {
        return "statistics";
    }

    @RequestMapping("/activityPageView")
    public String activityPageView() {
        return "activityPage";
    }

    @RequestMapping(value = "/addFoodView", method = RequestMethod.GET)
    public String showAddFoodForm(Model model) {
        AddEmission foodObject = new AddEmission();
        model.addAttribute("foodObject", foodObject);

        return "addFood";
    }

    @RequestMapping("/addTransportView")
    public String showTransportForm(Model model) {
        AddEmission transObject = new AddEmission();
        model.addAttribute("transObject", transObject);

        return "addTransport";
    }

    @RequestMapping("/addHouseEnergyView")
    public String showHouseEnergyForm(Model model) {
        AddEmission houseObject = new AddEmission();
        model.addAttribute("houseObject", houseObject);

        return "addHouse";
    }

    @RequestMapping("/addFlightView")
    public String showFlightForm(Model model) {
        AddEmission flightObject = new AddEmission();
        model.addAttribute("flightObject", flightObject);

        return "addFlight";
    }


    // USER METHODS
    @PostMapping("/save")
    public String processRegister(@Valid User user, BindingResult bindingResult,
                                  @ModelAttribute("username") String username,
                                  @ModelAttribute("email") String email,
                                  @ModelAttribute("location") String location,
                                  @ModelAttribute("uErr") String uErr,
                                  @ModelAttribute("lErr") String lErr,
                                  @ModelAttribute("eErr") String eErr, Model model) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < service.listAll().size(); i++) {
            names.add(service.listAll().get(i).getUsername());
        }

        ArrayList<String> emails = new ArrayList<>();

        for (int i = 0; i < service.listAll().size(); i++) {
            emails.add(service.listAll().get(i).getEmail());
        }

        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("location", location);

        if (bindingResult.hasErrors()) {

            return "signUp";

        }
        if (names.contains(username)) {
            uErr = "*Username already exists!";
            model.addAttribute("uErr", uErr);
            return "signUp";

        }
        if (emails.contains(email)) {

            eErr = "*Email already exists!";
            model.addAttribute("eErr", eErr);
            return "signUp";
        }
            if (location.equals("")) {
                    lErr = "*Choose a location!";
                model.addAttribute("lErr", lErr);
                return "signUp";

        } else {
            service.save(user);
            return "register_success";
        }
    }

    // FOOD

    @PostMapping("/addFoodItems")
    public String AddUserFood(@ModelAttribute("foodItems") AddEmission foodItems) {
        aes.save(foodItems);
        return "addFood";
    }

    @PostMapping(value = "/calcFood", params = "add")
    public ModelAndView calcFood(@ModelAttribute("foodObject") AddEmission foodObject, @ModelAttribute("type") String foodN,
                                 @ModelAttribute("quantity") double g, Model model) {
        double res = 0;
        String username = userDetails.returnUsername();
        List<Food> fl = f.listAll();

        for (Food food : fl) {

            if (food.getFoodName().equals(foodN)) {

                double oneG = food.getCo2g() / 100; // oneG = kg of co2 per 1gram of food.. co2g is kg co2 per 100 gram of food
                res = g * oneG; // result is user input grams * oneG (kg of co2 per 1 gram of food item)
                res = Math.round(res * 100);
                res = res / 100; // get to the nearest 2 decimal place
            }
        }

        if (foodN.equals("")) {
            String fErr = "*food/drink required!";
            model.addAttribute("fErr", fErr);
            return new ModelAndView("addFood");
        }

        if (g == 0.0 || String.valueOf(g).equals(" ")) {
            String gErr = "*quantity required!";
            model.addAttribute("gErr", gErr);
            return new ModelAndView("addFood");

        } else {
            foodObject.setRes(res);
            foodObject.setUsername(username);
            aes.save(foodObject);
            model.addAttribute("res", "CO₂ emissions: " + res + " kg");
            model.addAttribute("type", foodN);
            model.addAttribute("quantity", g);
            return new ModelAndView("addFood");
        }
    }

    @PostMapping(value = "/calcFood", params = "calc")
    public ModelAndView calcFoodTotal(@ModelAttribute("foodTotalObject") FoodTotal foodTotalObject,
                                      @ModelAttribute("foodObject") AddEmission foodObject, @ModelAttribute("type") String foodN,
                                      @ModelAttribute("quantity") double g, Model model) {

        List<AddEmission> ufl = aes.listAll();
        String username = userDetails.returnUsername();
        foodTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddEmission addUserFood : ufl) {

            if (addUserFood.getUsername().equals(username)) {

                total = total + addUserFood.getRes();
                total = Math.round(total * 100);
                total = total / 100;
            }
        }

        if (foodN.equals("")) {
            String fErr = "*food/drink required!";
            model.addAttribute("fErr", fErr);
            return new ModelAndView("addFood");
        }

        if (g == 0.0 || String.valueOf(g).equals(" ")) {
            String gErr = "*quantity required!";
            model.addAttribute("gErr", gErr);
            return new ModelAndView("addFood");

        } else {

            foodTotalObject.setTotalCo2(total);
            foodTotalObject.setDate(date);
            fts.save(foodTotalObject);

            model.addAttribute("total", "Total CO₂ emissions: " + total + " kg");
            // have to add above /calcFood method attributes here too
            // and in method parameters else form submit won't work
            model.addAttribute("type", foodN);
            model.addAttribute("quantity", g);
            Iterable<AddEmission> deleteFoodObject = aes.listAll();
            aes.deleteAll(deleteFoodObject);

            return new ModelAndView("addFood");
        }
    }


    // TRANSPORT

    @PostMapping("/addTransportActivity")
    public String AddTransport(@ModelAttribute("transportActivity") AddEmission transportActivity) {
        aes.save(transportActivity);
        return "addTransport";
    }

    @PostMapping(value = "/calcTransport", params = "add")
    public ModelAndView calcTransport(@ModelAttribute("transObject") AddEmission transObject, @ModelAttribute("type") String type,
                                      @ModelAttribute("quantity") double d, Model model) {
        double res = 0;
        List<Transport> tl = ts.listAll();


        for (Transport tran : tl) {

            if (tran.getType().equals(type)) {

                res = tran.getCo2km() * d;
                res = Math.round(res * 100);
                res = res / 100;
            }
        }

        if (type.equals("")) {
            String Err = "*vehicle required!";
            model.addAttribute("Err", Err);
            return new ModelAndView("addTransport");
        }

        if (d == 0.0 || String.valueOf(d).equals(" ")) {
            String tErr = "*distance required!";
            model.addAttribute("tErr", tErr);
            return new ModelAndView("addTransport");

        } else {

            transObject.setRes(res);
            transObject.setUsername(userDetails.returnUsername());
            aes.save(transObject);
            model.addAttribute("res", "CO₂ emissions: " + res + " kg");
            model.addAttribute("type", type);
            model.addAttribute("quantity", d);

            return new ModelAndView("addTransport");
        }
    }

    @PostMapping(value = "/calcTransport", params = "calc")
    public ModelAndView calcTransportTotal(@ModelAttribute("transTotalObject") TransportTotal transTotalObject,
                                           @ModelAttribute("transObject") AddEmission transObject, @ModelAttribute("type") String type,
                                           @ModelAttribute("quantity") double d, Model model) {

        String username = userDetails.returnUsername();
        List<AddEmission> tl = aes.listAll();
        transTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddEmission addTrans : tl) {

            if (addTrans.getUsername().equals(username)) {

                total = total + addTrans.getRes();
                total = Math.round(total * 100);
                total = total / 100;
            }
        }

        if (type.equals("")) {
            String Err = "*vehicle required!";
            model.addAttribute("Err", Err);
            return new ModelAndView("addTransport");
        }

        if (d == 0.0 || String.valueOf(d).equals(" ")) {
            String tErr = "*distance required!";
            model.addAttribute("tErr", tErr);
            return new ModelAndView("addTransport");

        } else {

            transTotalObject.setTotalCo2(total);
            transTotalObject.setDate(date);
            tts.save(transTotalObject);

            model.addAttribute("total", "Total CO₂ emissions: " + total + " kg");
            // have to add above /calcFood method attributes here too
            // and in method parameters else form submit won't work
            model.addAttribute("type", type);
            model.addAttribute("quantity", d);
            Iterable<AddEmission> deleteTransObject = aes.listAll();
            aes.deleteAll(deleteTransObject);

            return new ModelAndView("addTransport");
        }
    }

    // HOUSE ENERGY

    @PostMapping("/addHouseActivity")
    public String AddHouse(@ModelAttribute("houseObject") AddEmission houseObject) {
        aes.save(houseObject);
        return "addHouse";
    }

    @PostMapping(value = "/calcHouse", params = "add")
    public ModelAndView calcHouse(@ModelAttribute("houseObject") AddEmission houseObject, @ModelAttribute("type") String etype,
                                  @ModelAttribute("quantity") double kWh, Model model) {
        double res = 0;
        List<HouseEnergy> hl = hes.listAll();


        for (HouseEnergy house : hl) {

            if (house.getEtype().equals(etype)) {

                res = house.getCo2() * kWh;
                res = Math.round(res * 100);
                res = res / 100;
            }
        }

        if (etype.equals("")) {
            String eErr = "*type required!";
            model.addAttribute("eErr", eErr);
            return new ModelAndView("addHouse");
        }

        if (kWh == 0.0 || String.valueOf(kWh).equals(" ")) {
            String kErr = "*quantity required!";
            model.addAttribute("kErr", kErr);
            return new ModelAndView("addHouse");

        } else {

            houseObject.setRes(res);
            houseObject.setUsername(userDetails.returnUsername());
            aes.save(houseObject);
            model.addAttribute("res", "CO₂ emissions: "+ res+" kg");
            model.addAttribute("type", etype);
            model.addAttribute("quantity", kWh);

            return new ModelAndView("addHouse");
        }
    }

    @PostMapping(value = "/calcHouse", params = "calc")
    public ModelAndView calcHouseTotal(@ModelAttribute("houseTotalObject") HouseEnergyTotal houseTotalObject,
                                       @ModelAttribute("houseObject") AddEmission houseObject, @ModelAttribute("type") String etype,
                                       @ModelAttribute("quantity") double kWh, Model model) {

        String username = userDetails.returnUsername();
        List<AddEmission> hl = aes.listAll();
        houseTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddEmission addHouse : hl) {

            if (addHouse.getUsername().equals(username)) {

                total = total + addHouse.getRes();
                total = Math.round(total * 100);
                total = total / 100;
            }
        }
        if (etype.equals("")) {
            String eErr = "*type required!";
            model.addAttribute("eErr", eErr);
            return new ModelAndView("addHouse");
        }

        if (kWh == 0.0 || String.valueOf(kWh).equals(" ")) {
            String kErr = "*quantity required!";
            model.addAttribute("kErr", kErr);
            return new ModelAndView("addHouse");

        } else {

            houseTotalObject.setTotal(total);
            houseTotalObject.setDate(date);
            hets.save(houseTotalObject);

            model.addAttribute("total", "Total CO₂ emissions: " + total + " kg");
            // have to add above /calcFood method attributes here too
            // and in method parameters else form submit won't work
            model.addAttribute("type", etype);
            model.addAttribute("quantity", kWh);
            Iterable<AddEmission> deleteHouseObject = aes.listAll();
            aes.deleteAll(deleteHouseObject);

            return new ModelAndView("addHouse");
        }
    }


    // FLIGHT

    @PostMapping("/addFlightActivity")
    public String AddFlight(@ModelAttribute("flightObject") AddEmission flightObject) {
        aes.save(flightObject);
        return "addFlight";
    }

    @PostMapping(value = "/calcFlight", params = "add")
    public ModelAndView calcFlight(@ModelAttribute("flightObject") AddEmission flightObject, @ModelAttribute("quantity") double distance,
                                   Model model) {

        double res = 0.115 * distance;
        res = Math.round(res * 100);
        res = res / 100;


        if (distance == 0.0 || String.valueOf(distance).equals(" ")) {
            String fErr = "*distance required!";
            model.addAttribute("fErr", fErr);
            return new ModelAndView("addFlight");

        } else {

            flightObject.setType("plane");
            flightObject.setRes(res);
            flightObject.setUsername(userDetails.returnUsername());
            aes.save(flightObject);
            model.addAttribute("res", "CO₂ emissions: "+res+" kg");
            model.addAttribute("quantity", distance);

            return new ModelAndView("addFlight");
        }
    }

    @PostMapping(value = "/calcFlight", params = "calc")
    public ModelAndView calcFlightTotal(@ModelAttribute("flightTotalObject") FlightTotal flightTotalObject,
                                        @ModelAttribute("flightObject") AddEmission flightObject, @ModelAttribute("quantity") double distance,
                                        Model model) {

        String username = userDetails.returnUsername();
        List<AddEmission> fl = aes.listAll();
        flightTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddEmission addFlight : fl) {

            if (addFlight.getUsername().equals(username)) {

                total = total + addFlight.getRes();
                total = Math.round(total * 100);
                total = total / 100;
            }
        }

        if (distance == 0.0 || String.valueOf(distance).equals(" ")) {
            String fErr = "*distance required!";
            model.addAttribute("fErr", fErr);
            return new ModelAndView("addFlight");

        } else {

            flightTotalObject.setTotal(total);
            flightTotalObject.setDate(date);
            flts.save(flightTotalObject);

            model.addAttribute("total", "Total CO₂ emissions: "+ total+" kg");
            // have to add above /calcFood method attributes here too
            // and in method parameters else form submit won't work
            model.addAttribute("quantity", distance);
            Iterable<AddEmission> deleteFlightObject = aes.listAll();
            aes.deleteAll(deleteFlightObject);

            return new ModelAndView("addFlight");
        }
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


    @RequestMapping("/edit/{userID}")
    public ModelAndView showEditUserForm(@PathVariable(name = "userID") int userID) {

        ModelAndView mav = new ModelAndView("editActivity"); // name of html page
        User user = service.get(userID);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/delete/{userID}")
    public String deleteUser(@PathVariable(name = "userID") int userID) {
        service.delete(userID);

        return "redirect:/"; //eg. homepage
    }

}