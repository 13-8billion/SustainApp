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
import java.util.ArrayList;
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
    private OverAllTotalService oats;

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
    public String stats() {
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
                                      @ModelAttribute("grams") double g, Model model) {
//        FoodTotal fto = new FoodTotal();
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

//        fto.setDate(null);
//        fto.setUsername(null);
//        fto.setTotalCo2(0.0);
//        fto.setID(0);

        Iterable<AddUserFood> deleteFoodObject = auf.listAll();
        auf.deleteAll(deleteFoodObject);

        return new ModelAndView("addFood");
    }

//    @GetMapping("/eChartTest")
//    public String showFoodTotal(Model model) {
//
//
//        List<Double> total = fts.listAll().stream().map(x -> x.getTotalCo2()).collect(Collectors.toList());
//        List<LocalDate> date = fts.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
//        List<Integer> month = fts.listAll().stream().map(x -> x.getDate().getMonthValue()).collect(Collectors.toList());
//
//
//        List<Double> monthTotals = new ArrayList<>();
//        List<FoodTotal> ft = fts.listAll();
//
//        int aug = 7;
//        double augTotals = 0;
//
//        for (int i = 0; i < ft.size(); i++) {
//
//            if (ft.get(i).getDate().getMonthValue() == aug)
//
//                augTotals = augTotals + ft.get(i).getTotalCo2();
//
//            monthTotals.add(6, augTotals);
//
//        }
//
//        model.addAttribute("total", total);
//        model.addAttribute("month", monthTotals);
//        return "eChartTest";
//
//    }


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

    @GetMapping("/go")
    public String showFoodTotal(Model model) {

        List<FoodTotal> ft = fts.listAll();
        int month = 0;
        double total1 = 0;
        double total2 = 0;
        double total3 = 0;
        double total4 = 0;
        double total5 = 0;
        double total6 = 0;
        double total7 = 0;
        double total8 = 0;
        double total9 = 0;
        double total10 = 0;
        double total11 = 0;
        double total12 = 0;

        OverAllTotal oat1 = new OverAllTotal();
        OverAllTotal oat2 = new OverAllTotal();
        OverAllTotal oat3 = new OverAllTotal();
        OverAllTotal oat4 = new OverAllTotal();
        OverAllTotal oat5 = new OverAllTotal();
        OverAllTotal oat6 = new OverAllTotal();
        OverAllTotal oat7 = new OverAllTotal();
        OverAllTotal oat8 = new OverAllTotal();
        OverAllTotal oat9 = new OverAllTotal();
        OverAllTotal oat10 = new OverAllTotal();
        OverAllTotal oat11 = new OverAllTotal();
        OverAllTotal oat12 = new OverAllTotal();

        for (int i = 0; i < ft.size(); i++) {


            if (ft.get(i).getDate().getMonthValue() == 1) {
                month = 1;
                total1 = total1 + ft.get(i).getTotalCo2();
                oat1.setUsername("Test");
                oat1.setTotal(total1);
                oat1.setDate(month);
                oats.save(oat1);
            }

            if (ft.get(i).getDate().getMonthValue() == 2) {
                month = 2;
                total2 = total2 + ft.get(i).getTotalCo2();
                oat2.setUsername("Test");
                oat2.setTotal(total2);
                oat2.setDate(month);
                oats.save(oat2);
            }


            if (ft.get(i).getDate().getMonthValue() == 3) {
                month = 3;
                total3 = total3 + ft.get(i).getTotalCo2();
                oat3.setUsername("Test");
                oat3.setTotal(total3);
                oat3.setDate(month);
                oats.save(oat3);
            }

            if (ft.get(i).getDate().getMonthValue() == 4) {
                month = 4;
                total4 = total4 + ft.get(i).getTotalCo2();
                oat4.setUsername("Test");
                oat4.setTotal(total4);
                oat4.setDate(month);
                oats.save(oat4);
            }

            if (ft.get(i).getDate().getMonthValue() == 5) {
                month = 5;
                total5 = total5 + ft.get(i).getTotalCo2();
                oat5.setUsername("Test");
                oat5.setTotal(total5);
                oat5.setDate(month);
                oats.save(oat5);
            }

            if (ft.get(i).getDate().getMonthValue() == 6) {
                month = 6;
                total6 = total6 + ft.get(i).getTotalCo2();
                oat6.setUsername("Test");
                oat6.setTotal(total6);
                oat6.setDate(month);
                oats.save(oat6);
            }

            if (ft.get(i).getDate().getMonthValue() == 7) {
                month = 7;
                total7 = total7 + ft.get(i).getTotalCo2();
                oat7.setUsername("Test");
                oat7.setTotal(total7);
                oat7.setDate(month);
                oats.save(oat7);
            }

            if (ft.get(i).getDate().getMonthValue() == 8) {
                month = 8;
                total8 = total8 + ft.get(i).getTotalCo2();
                oat8.setUsername("Test");
                oat8.setTotal(total8);
                oat8.setDate(month);
                oats.save(oat8);
            }

            if (ft.get(i).getDate().getMonthValue() == 9) {
                month = 9;
                total9 = total9 + ft.get(i).getTotalCo2();
                oat9.setUsername("Test");
                oat9.setTotal(total9);
                oat9.setDate(month);
                oats.save(oat9);
            }

            if (ft.get(i).getDate().getMonthValue() == 10) {
                month = 10;
                total10 = total10 + ft.get(i).getTotalCo2();
                oat10.setUsername("Test");
                oat10.setTotal(total10);
                oat10.setDate(month);
                oats.save(oat10);
            }

            if (ft.get(i).getDate().getMonthValue() == 11) {
                month = 11;
                total11 = total11 + ft.get(i).getTotalCo2();
                oat11.setUsername("Test");
                oat11.setTotal(total11);
                oat11.setDate(month);
                oats.save(oat11);
            }

            if (ft.get(i).getDate().getMonthValue() == 12) {
                month = 12;
                total12 = total12 + ft.get(i).getTotalCo2();
                oat12.setUsername("Test");
                oat12.setTotal(total10);
                oat12.setDate(month);
                oats.save(oat12);
            }

        }

        return "eChartTest";

    }

    @RequestMapping(value = "/eChartTest")
    public ModelAndView showeChartTest() {
        return new ModelAndView("eChartTest");
    }


}