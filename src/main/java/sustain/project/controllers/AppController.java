package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sustain.project.models.*;
import sustain.project.service.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    //To implement CRUD operations in the AppController,
    // an instance of all the service classes is injected via a
    // private field using the @Autowired annotation.

    @Autowired
    private UserService service;

    @Autowired
    private CustomUserDetailsService userDetails;

    @Autowired
    private AddEmissionService aes;

    @Autowired
    private EmissionTotalService ets;

    @Autowired
    private FoodService f;

    @Autowired
    private TransportService ts;

    @Autowired
    private HouseEnergyService hes;



    // VIEWS
    //A View handler method is defined for each HTML5 template
    // and is responsible for rendering the content to the user.
    // Web requests defined in the HTML5 templates via hyperlinks,
    // are mapped onto the handler methods with the @RequestMapping annotation

    @RequestMapping(value = "/")
    public ModelAndView showLanding() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login")
    public ModelAndView showLogin() {
        return new ModelAndView("index");
    }

    @RequestMapping("/logout")
    public ModelAndView viewLogout() {
        return new ModelAndView("index");
    }

    @RequestMapping("/viewAccount")
    public ModelAndView viewAccount(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        EmissionTotal et = new EmissionTotal();
        model.addAttribute("et", et);

        List<User> listUser = service.listAll();
        String username = userDetails.returnUsername();
        String email=null;
        String location=null;
        int id=0;

        for (User value : listUser) {
            if (value.getUsername().equals(username)) {
                username=value.getUsername();
                email=value.getEmail();
                location= value.getLocation();
                id=value.getUserID();
            }
        }

        // to display user emissions data on their user profile with the option to delete
        List<EmissionTotal> listEmissions = ets.listAll();

        for (int j = 0; j<listEmissions.size();j++){

            if(listEmissions.get(j).getUsername().equals(username)) {

                model.addAttribute("listEmissions", listEmissions);
            }
        }

        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("location", location);
        model.addAttribute("id", id);

        return new ModelAndView("userAccount");
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
    public String saveUser(@Valid User user, BindingResult bindingResult,
                                  @ModelAttribute("username") String username,
                                  @ModelAttribute("email") String email,
                                  @ModelAttribute("location") String location,
                                  Model model) {

      //SPRING SECURITY PASSWORD ENCODER
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

        // INPUT VALIDATION
        if (bindingResult.hasErrors()) {
            return "signUp";

        }
        if (names.contains(username)) {
            String uErr = "*Username already exists!";
            model.addAttribute("uErr", uErr);
            return "signUp";

        }
        if (emails.contains(email)) {

            String eErr = "*Email already exists!";
            model.addAttribute("eErr", eErr);
            return "signUp";
        }
        if (location.equals("")) {
            String lErr = "*Choose a location!";
            model.addAttribute("lErr", lErr);
            return "signUp";

        } else {

            //the JpaRepository method save( ) to
            // persist the User object to the respective database table.
            service.save(user);
            return "register_success";
        }
    }

    // CALC FOOD

    @PostMapping(value = "/calcFood", params = "add")
    public ModelAndView addFood(@ModelAttribute("foodObject") AddEmission foodObject,
                                @ModelAttribute("type") String foodN,
                                @ModelAttribute("quantity") double g, Model model) {
        double res = 0;
        //the current user is associated with the calculator
        // instance by passing the username to a local variable
        // using a custom Spring Security method returnUsername( ).
        String username = userDetails.returnUsername();
        List<Food> fl = f.listAll();

        for (Food food : fl) {

            if (food.getFoodName().equals(foodN)) {

                double oneG = food.getCo2g() / 100;
                // oneG = kg of co2 per 1gram of food - co2g is kg co2 per 100 gram of food
                res = g * oneG;
                // result is user input grams * oneG (kg of co2 per 1 gram of food item)
                res = Math.round(res * 100);
                res = res / 100; // get to the nearest 2 decimal place
            }
        }

        // INPUT VALIDATION
        if (foodN.equals("")) {
            String fErr = "*food/drink required!";
            model.addAttribute("fErr", fErr);
            return new ModelAndView("addFood");
        }

        if (g == 0.0) {
            String gErr = "*quantity required!";
            model.addAttribute("gErr", gErr);
            return new ModelAndView("addFood");


        } else {
            foodObject.setRes(res);
            foodObject.setUsername(username);
         //   AddEmission object and temporarily stored in the
            //   respective table using the JpaRepository save( ) method.
            aes.save(foodObject);
            model.addAttribute("res", g + "g " + "of "
                    + foodN + " = " + res + " kg of CO₂");
            model.addAttribute("type", foodN);
            model.addAttribute("quantity", g);
            return new ModelAndView("addFood");
        }
    }

    @PostMapping(value = "/calcFood", params = "calc")
    public ModelAndView calcFoodTotal(@ModelAttribute("foodTotalObject") EmissionTotal foodTotalObject,
                                      @ModelAttribute("foodObject") AddEmission foodObject,
                                      @ModelAttribute("type") String foodN,
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

        foodTotalObject.setTotalCo2(total);
        foodTotalObject.setDate(date);
        foodTotalObject.setEmissionType("food");
        ets.save(foodTotalObject);
        model.addAttribute("total", "Total CO₂ = " + total + " kg");

        model.addAttribute("type", foodN);
        model.addAttribute("quantity", g);
        //AddEmission object is iterated over using the Java
        // Iterable interface and the JpaRepository method deleteAll( ) is called
       // Deleting the contents prepares the database table for the next calculated instance
        Iterable<AddEmission> deleteFoodObject = aes.listAll();
        aes.deleteAll(deleteFoodObject);

        return new ModelAndView("addFood");

    }


    // CALC TRANSPORT

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
            model.addAttribute("res", d + " km " + "in a " + type + " = " + res + " kg of CO₂");
            model.addAttribute("type", type);
            model.addAttribute("quantity", d);

            return new ModelAndView("addTransport");
        }
    }

    @PostMapping(value = "/calcTransport", params = "calc")
    public ModelAndView calcTransportTotal(@ModelAttribute("transTotalObject") EmissionTotal transTotalObject,
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


        transTotalObject.setTotalCo2(total);
        transTotalObject.setDate(date);
        transTotalObject.setEmissionType("transport");
        ets.save(transTotalObject);

        model.addAttribute("total", "Total CO₂ = " + total + " kg");
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("type", type);
        model.addAttribute("quantity", d);
        Iterable<AddEmission> deleteTransObject = aes.listAll();
        aes.deleteAll(deleteTransObject);

        return new ModelAndView("addTransport");

    }


    // CALC HOUSE ENERGY

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
            model.addAttribute("res", kWh + " kWh " + "of " + etype + " = " + res + " kg of CO₂");
            model.addAttribute("type", etype);
            model.addAttribute("quantity", kWh);

            return new ModelAndView("addHouse");
        }
    }

    @PostMapping(value = "/calcHouse", params = "calc")
    public ModelAndView calcHouseTotal(@ModelAttribute("houseTotalObject") EmissionTotal houseTotalObject,
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


        houseTotalObject.setTotalCo2(total);
        houseTotalObject.setDate(date);
        houseTotalObject.setEmissionType("home");
        ets.save(houseTotalObject);

        model.addAttribute("total", "Total CO₂ = " + total + " kg");
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("type", etype);
        model.addAttribute("quantity", kWh);
        Iterable<AddEmission> deleteHouseObject = aes.listAll();
        aes.deleteAll(deleteHouseObject);

        return new ModelAndView("addHouse");

    }


    // FLIGHT

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
            model.addAttribute("res", distance + " km " + " flight " + " = " + res + " kg of CO₂");
            model.addAttribute("quantity", distance);

            return new ModelAndView("addFlight");
        }
    }

    @PostMapping(value = "/calcFlight", params = "calc")
    public ModelAndView calcFlightTotal(@ModelAttribute("flightTotalObject") EmissionTotal flightTotalObject,
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

        flightTotalObject.setTotalCo2(total);
        flightTotalObject.setDate(date);
        flightTotalObject.setEmissionType("flight");
        ets.save(flightTotalObject);

        model.addAttribute("total", "Total CO₂ = " + total + " kg");
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("quantity", distance);
        Iterable<AddEmission> deleteFlightObject = aes.listAll();
        aes.deleteAll(deleteFlightObject);

        return new ModelAndView("addFlight");

    }


    // METHOD TO RETRIEVE CURRENT USERNAME

    @Controller
    public class SecurityController {

        @RequestMapping(value = "/username", method = RequestMethod.GET)
        @ResponseBody
        public String currentUserName(Principal principal) {
            return principal.getName();
        }
    }


    // DELETE METHODS
    @RequestMapping("user/delete/{userID}")
    public String deleteUser(@PathVariable(name = "userID") int userID) {
        service.delete(userID);

        return "redirect:/"; //eg. login
    }

    @RequestMapping("/delete/{ID}")
    public ModelAndView deleteEmission(@PathVariable(name = "ID") int id) {
        ets.delete(id);

        return new ModelAndView("redirect:/viewAccount");
    }

}