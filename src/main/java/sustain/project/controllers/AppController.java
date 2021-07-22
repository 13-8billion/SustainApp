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

    @Autowired
    private AddFlightService afs;

    @Autowired
    private FlightTotalService flts;


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

    @RequestMapping("/addFoodView")
    public String showAddFoodForm(Model model) {
        AddUserFood foodObject = new AddUserFood();
        model.addAttribute("foodObject", foodObject);

        return "addFood";
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

    @RequestMapping("/addFlightView")
    public String showFlightForm(Model model) {
        AddFlight flightObject = new AddFlight();
        model.addAttribute("flightObject", flightObject);

        return "addFlight";
    }


    // USER METHODS

    @PostMapping(value = "/save", params = "save")
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


    // FLIGHT

    @PostMapping("/addFlightActivity")
    public String AddFlight(@ModelAttribute("flightObject") AddFlight flightObject) {
        afs.save(flightObject);
        return "addFlight";
    }

    @PostMapping(value = "/calcFlight", params = "add")
    public ModelAndView calcFlight(@ModelAttribute("flightObject") AddFlight flightObject, @ModelAttribute("distance") double distance,
                                   Model model) {

        double res = 0.115 * distance;

        flightObject.setRes(res);
        flightObject.setUsername(userDetails.returnUsername());
        afs.save(flightObject);
        model.addAttribute("res", res);
        model.addAttribute("distance", distance);

        return new ModelAndView("addFlight");
    }

    @PostMapping(value = "/calcFlight", params = "calc")
    public ModelAndView calcFlightTotal(@ModelAttribute("flightTotalObject") FlightTotal flightTotalObject,
                                       @ModelAttribute("flightObject") AddFlight flightObject, @ModelAttribute("distance") double distance,
                                       Model model) {

        String username = userDetails.returnUsername();
        List<AddFlight> fl = afs.listAll();
        flightTotalObject.setUsername(username);
        LocalDate date = LocalDate.now();
        double total = 0.0;

        for (AddFlight addFlight : fl) {

            if (addFlight.getUsername().equals(username)) {

                total = total + addFlight.getRes();
            }
        }

        flightTotalObject.setTotal(total);
        flightTotalObject.setDate(date);
        flts.save(flightTotalObject);

        model.addAttribute("total", total);
        // have to add above /calcFood method attributes here too
        // and in method parameters else form submit won't work
        model.addAttribute("distance", distance);
        Iterable<AddFlight> deleteFlightObject = afs.listAll();
        afs.deleteAll(deleteFlightObject);

        return new ModelAndView("addFlight");
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

//    FlightTotal obj = new FlightTotal();
//    FlightTotal obj2 = new FlightTotal();
//    FlightTotal obj3 = new FlightTotal();
//    FlightTotal obj4 = new FlightTotal();
//    FlightTotal obj5 = new FlightTotal();
//    FlightTotal obj6 = new FlightTotal();
//    FlightTotal obj7 = new FlightTotal();
//    FlightTotal obj8 = new FlightTotal();
//    FlightTotal obj9 = new FlightTotal();
//    FlightTotal obj10 = new FlightTotal();
//    FlightTotal obj11 = new FlightTotal();
//    FlightTotal obj12 = new FlightTotal();
//
//    @PostMapping(value = "/save", params = "nullify")
//    public String nullTables() {
//
//        LocalDate jan = LocalDate.parse("2021-01-01");
//        LocalDate feb = LocalDate.parse("2021-02-01");
//        LocalDate mar = LocalDate.parse("2021-03-01");
//        LocalDate apr = LocalDate.parse("2021-04-01");
//        LocalDate may = LocalDate.parse("2021-05-01");
//        LocalDate jun = LocalDate.parse("2021-06-01");
//        LocalDate jul = LocalDate.parse("2021-07-01");
//        LocalDate aug = LocalDate.parse("2021-08-01");
//        LocalDate sep = LocalDate.parse("2021-09-01");
//        LocalDate oct = LocalDate.parse("2021-10-01");
//        LocalDate nov = LocalDate.parse("2021-11-01");
//        LocalDate dec = LocalDate.parse("2021-12-01");
//
//        String username = userDetails.returnUsername();
//
//        obj.setId(1);
//        obj.setDate(jan);
//        obj.setTotal(0);
//        obj.setUsername(username);
//        flts.save(obj);
//
//        obj.setId(2);
//        obj2.setDate(feb);
//        obj2.setTotal(0);
//        obj2.setUsername(username);
//        flts.save(obj2);
//
//        obj.setId(3);
//        obj3.setDate(mar);
//        obj3.setTotal(0);
//        obj3.setUsername(username);
//        flts.save(obj3);
//
//        obj.setId(4);
//        obj4.setDate(apr);
//        obj4.setTotal(0);
//        obj4.setUsername(username);
//        flts.save(obj4);
//
//        obj.setId(5);
//        obj5.setDate(may);
//        obj5.setTotal(0);
//        obj5.setUsername(username);
//        flts.save(obj5);
//
//        obj.setId(6);
//        obj6.setDate(jun);
//        obj6.setTotal(0);
//        obj6.setUsername(username);
//        flts.save(obj6);
//
//        obj.setId(7);
//        obj7.setDate(jul);
//        obj7.setTotal(0);
//        obj7.setUsername(username);
//        flts.save(obj7);
//
//        obj.setId(8);
//        obj8.setDate(aug);
//        obj8.setTotal(0);
//        obj8.setUsername(username);
//        flts.save(obj8);
//
//        obj.setId(9);
//        obj9.setDate(sep);
//        obj9.setTotal(0);
//        obj9.setUsername(username);
//        flts.save(obj9);
//
//        obj.setId(10);
//        obj10.setDate(oct);
//        obj10.setTotal(0);
//        obj10.setUsername(username);
//        flts.save(obj10);
//
//        obj.setId(11);
//        obj11.setDate(nov);
//        obj11.setTotal(0);
//        obj11.setUsername(username);
//        flts.save(obj11);
//
//        obj.setId(12);
//        obj12.setDate(dec);
//        obj12.setTotal(0);
//        obj12.setUsername(username);
//        flts.save(obj12);
//
//        return "register_success";
//    }
//
//    private void deleteMethod(){
//        flts.delete(1);
//        flts.delete(2);
//        flts.delete(3);
//        flts.delete(4);
//        flts.delete(5);
//        flts.delete(6);
//        flts.delete(7);
//        flts.delete(8);
//        flts.delete(9);
//        flts.delete(10);
//        flts.delete(11);
//        flts.delete(12);
//
//
//    }


}