package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sustain.project.models.*;
import sustain.project.service.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ChartController {

    @Autowired
    private CustomUserDetailsService userDetails;
    @Autowired
    private FoodTotalService fts;
    @Autowired
    private OverAllTotalService oats;
    @Autowired
    private TransportTotalService tts;
    @Autowired
    private HouseEnergyTotalService hets;
    @Autowired
    private FlightTotalService flts;

    // METHODS


//    @GetMapping("/statistics")
//    public String getAllFood(Model model) {
//        String username = userDetails.returnUsername();
//        List<FoodTotal> ft = fts.listAll();
//
//        for (FoodTotal foodTotal : ft) {
//            if (foodTotal.getDate().getMonthValue() == 1 && foodTotal.getUsername().equals(username)) {
//
//                List<Double> total = fts.listAll().stream().map(x -> x.getTotalCo2()).collect(Collectors.toList());
//                List<Integer> date = fts.listAll().stream().map(x -> x.getDate().getMonthValue()).collect(Collectors.toList());
//                model.addAttribute("total", total);
//                model.addAttribute("date", date);
//            }
//        }
//        return "statistics";
//    }


    @GetMapping("/statistics")
    public String showAnnualStats(Model model) {

        String username = userDetails.returnUsername();
        List<FoodTotal> ft = fts.listAll();

        double total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0, total7 = 0,
                total8 = 0, total9 = 0, total10 = 0, total11 = 0, total12 = 0;

        OverAllTotal oat1, oat2, oat3, oat4, oat5, oat6, oat7, oat8, oat9, oat10, oat11, oat12;
        oat1 = new OverAllTotal();
        oat2 = new OverAllTotal();
        oat3 = new OverAllTotal();
        oat4 = new OverAllTotal();
        oat5 = new OverAllTotal();
        oat6 = new OverAllTotal();
        oat7 = new OverAllTotal();
        oat8 = new OverAllTotal();
        oat9 = new OverAllTotal();
        oat10 = new OverAllTotal();
        oat11 = new OverAllTotal();
        oat12 = new OverAllTotal();


        // FOOD

        for (FoodTotal foodTotal : ft) {
            if (foodTotal.getDate().getMonthValue() == 1 && foodTotal.getUsername().equals(username)) {
                total1 = total1 + foodTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (foodTotal.getDate().getMonthValue() == 2 && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (foodTotal.getDate().getMonthValue() == 3 && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (foodTotal.getDate().getMonthValue() == 4 && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (foodTotal.getDate().getMonthValue() == 5 && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (foodTotal.getDate().getMonthValue() == 6 && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (foodTotal.getDate().getMonthValue() == 7 && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate((foodTotal.getDate().getMonthValue()));
                oats.save(oat7);
            }

            if (foodTotal.getDate().getMonthValue() == 8 && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (foodTotal.getDate().getMonthValue() == 9 && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (foodTotal.getDate().getMonthValue() == 10 && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (foodTotal.getDate().getMonthValue() == 11 && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (foodTotal.getDate().getMonthValue() == 12 && foodTotal.getUsername().equals(username)) {
                total12 = total12 + foodTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> total = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("total", total);
            List<Integer> date = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
            model.addAttribute("date", date);


        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // TRANSPORT

        List<TransportTotal> tt = tts.listAll();

        for (TransportTotal transTotal : tt) {

            if (transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
                total12 = transTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalTrans = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalTrans", totalTrans);
            List<Integer> date = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
            model.addAttribute("date", date);

        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // HOUSE ENERGY

        List<HouseEnergyTotal> het = hets.listAll();

        for (HouseEnergyTotal houseTotal : het) {

            if (houseTotal.getDate().getMonthValue() == 1 && houseTotal.getUsername().equals(username)) {
                total1 = houseTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (houseTotal.getDate().getMonthValue() == 2 && houseTotal.getUsername().equals(username)) {
                total2 = houseTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (houseTotal.getDate().getMonthValue() == 3 && houseTotal.getUsername().equals(username)) {
                total3 = houseTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (houseTotal.getDate().getMonthValue() == 4 && houseTotal.getUsername().equals(username)) {
                total4 = houseTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (houseTotal.getDate().getMonthValue() == 5 && houseTotal.getUsername().equals(username)) {
                total5 = houseTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (houseTotal.getDate().getMonthValue() == 6 && houseTotal.getUsername().equals(username)) {
                total6 = houseTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (houseTotal.getDate().getMonthValue() == 7 && houseTotal.getUsername().equals(username)) {
                total7 = houseTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (houseTotal.getDate().getMonthValue() == 8 && houseTotal.getUsername().equals(username)) {
                total8 = houseTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (houseTotal.getDate().getMonthValue() == 9 && houseTotal.getUsername().equals(username)) {
                total9 = houseTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (houseTotal.getDate().getMonthValue() == 10 && houseTotal.getUsername().equals(username)) {
                total10 = houseTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (houseTotal.getDate().getMonthValue() == 11 && houseTotal.getUsername().equals(username)) {
                total11 = houseTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (houseTotal.getDate().getMonthValue() == 12 && houseTotal.getUsername().equals(username)) {
                total12 = houseTotal.getTotal();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalHouse = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalHouse", totalHouse);
            List<Integer> date = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
            model.addAttribute("date", date);
//
//
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        // FLIGHT


        List<FlightTotal> flt = flts.listAll();

        for (FlightTotal flightTotal : flt) {

            if (flightTotal.getDate().getMonthValue() == 1 && flightTotal.getUsername().equals(username)) {
                total1 = flightTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
//                Month month = Month.from(flightTotal.getDate());
                oat1.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (flightTotal.getDate().getMonthValue() == 2 && flightTotal.getUsername().equals(username)) {
                total2 = flightTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
//                Month month = Month.from(flightTotal.getDate());
                oat2.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (flightTotal.getDate().getMonthValue() == 3 && flightTotal.getUsername().equals(username)) {
                total3 = flightTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
//                Month month = Month.from(flightTotal.getDate());
                oat3.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (flightTotal.getDate().getMonthValue() == 4 && flightTotal.getUsername().equals(username)) {
                total4 = flightTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
//                Month month = Month.from(flightTotal.getDate());
                oat4.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (flightTotal.getDate().getMonthValue() == 5 && flightTotal.getUsername().equals(username)) {
                total5 = flightTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
//                Month month = Month.from(flightTotal.getDate());
                oat5.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (flightTotal.getDate().getMonthValue() == 6 && flightTotal.getUsername().equals(username)) {
                total6 = flightTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
//                Month month = Month.from(flightTotal.getDate());
                oat6.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (flightTotal.getDate().getMonthValue() == 7 && flightTotal.getUsername().equals(username)) {
                total7 = flightTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
//                Month month = Month.from(flightTotal.getDate());
                oat7.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (flightTotal.getDate().getMonthValue() == 8 && flightTotal.getUsername().equals(username)) {
                total8 = flightTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
//                Month month = Month.from(flightTotal.getDate());
                oat8.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (flightTotal.getDate().getMonthValue() == 9 && flightTotal.getUsername().equals(username)) {
                total9 = flightTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
//                Month month = Month.from(flightTotal.getDate());
                oat9.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (flightTotal.getDate().getMonthValue() == 10 && flightTotal.getUsername().equals(username)) {
                total10 = flightTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
//                Month month = Month.from(flightTotal.getDate());
                oat10.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (flightTotal.getDate().getMonthValue() == 11 && flightTotal.getUsername().equals(username)) {
                total11 = flightTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
//                Month month = Month.from(flightTotal.getDate());
                oat11.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (flightTotal.getDate().getMonthValue() == 12 && flightTotal.getUsername().equals(username)) {
                total12 = flightTotal.getTotal();
                oat12.setUsername(username);
                oat12.setTotal(total12);
//                Month month = Month.from(flightTotal.getDate());
                oat12.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat12);
            }


            List<Double> totalFlight = oats.listAll().stream().map(OverAllTotal::getTotal).collect(Collectors.toList());
            List<Integer> date = oats.listAll().stream().map(OverAllTotal::getDate).collect(Collectors.toList());

            model.addAttribute("totalFlight", totalFlight);
            model.addAttribute("dateFl", date);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


//        return "statistics";
//

            return "statistics";
        }


    @GetMapping("/dashboard")
    public String showStatsDash(Model model) {

        String username = userDetails.returnUsername();
        List<FoodTotal> ft = fts.listAll();
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

        // FOOD

        for (FoodTotal foodTotal : ft) {
            if (foodTotal.getDate().getMonthValue() == 1 && foodTotal.getUsername().equals(username)) {
                total1 = total1 + foodTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (foodTotal.getDate().getMonthValue() == 2 && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (foodTotal.getDate().getMonthValue() == 3 && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (foodTotal.getDate().getMonthValue() == 4 && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (foodTotal.getDate().getMonthValue() == 5 && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (foodTotal.getDate().getMonthValue() == 6 && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (foodTotal.getDate().getMonthValue() == 7 && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate((foodTotal.getDate().getMonthValue()));
                oats.save(oat7);
            }

            if (foodTotal.getDate().getMonthValue() == 8 && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (foodTotal.getDate().getMonthValue() == 9 && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (foodTotal.getDate().getMonthValue() == 10 && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (foodTotal.getDate().getMonthValue() == 11 && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (foodTotal.getDate().getMonthValue() == 12 && foodTotal.getUsername().equals(username)) {
                total12 = total12 + foodTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate(foodTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> total = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("total", total);
            List<Integer> date = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
            model.addAttribute("date", date);


        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // TRANSPORT

        List<TransportTotal> tt = tts.listAll();

        for (TransportTotal transTotal : tt) {

            if (transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
                total12 = transTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate(transTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalTrans = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalTrans", totalTrans);
            List<Integer> date = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
            model.addAttribute("date", date);

        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // HOUSE ENERGY

        List<HouseEnergyTotal> het = hets.listAll();

        for (HouseEnergyTotal houseTotal : het) {

            if (houseTotal.getDate().getMonthValue() == 1 && houseTotal.getUsername().equals(username)) {
                total1 = houseTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (houseTotal.getDate().getMonthValue() == 2 && houseTotal.getUsername().equals(username)) {
                total2 = houseTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (houseTotal.getDate().getMonthValue() == 3 && houseTotal.getUsername().equals(username)) {
                total3 = houseTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (houseTotal.getDate().getMonthValue() == 4 && houseTotal.getUsername().equals(username)) {
                total4 = houseTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (houseTotal.getDate().getMonthValue() == 5 && houseTotal.getUsername().equals(username)) {
                total5 = houseTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (houseTotal.getDate().getMonthValue() == 6 && houseTotal.getUsername().equals(username)) {
                total6 = houseTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (houseTotal.getDate().getMonthValue() == 7 && houseTotal.getUsername().equals(username)) {
                total7 = houseTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (houseTotal.getDate().getMonthValue() == 8 && houseTotal.getUsername().equals(username)) {
                total8 = houseTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (houseTotal.getDate().getMonthValue() == 9 && houseTotal.getUsername().equals(username)) {
                total9 = houseTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (houseTotal.getDate().getMonthValue() == 10 && houseTotal.getUsername().equals(username)) {
                total10 = houseTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (houseTotal.getDate().getMonthValue() == 11 && houseTotal.getUsername().equals(username)) {
                total11 = houseTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (houseTotal.getDate().getMonthValue() == 12 && houseTotal.getUsername().equals(username)) {
                total12 = houseTotal.getTotal();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate(houseTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalHouse = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalHouse", totalHouse);
            List<Integer> date = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());
            model.addAttribute("date", date);
//
//
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        // FLIGHT


        List<FlightTotal> flt = flts.listAll();

        for (FlightTotal flightTotal : flt) {

            if (flightTotal.getDate().getMonthValue() == 1 && flightTotal.getUsername().equals(username)) {
                total1 = flightTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
//                Month month = Month.from(flightTotal.getDate());
                oat1.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (flightTotal.getDate().getMonthValue() == 2 && flightTotal.getUsername().equals(username)) {
                total2 = flightTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
//                Month month = Month.from(flightTotal.getDate());
                oat2.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (flightTotal.getDate().getMonthValue() == 3 && flightTotal.getUsername().equals(username)) {
                total3 = flightTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
//                Month month = Month.from(flightTotal.getDate());
                oat3.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (flightTotal.getDate().getMonthValue() == 4 && flightTotal.getUsername().equals(username)) {
                total4 = flightTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
//                Month month = Month.from(flightTotal.getDate());
                oat4.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (flightTotal.getDate().getMonthValue() == 5 && flightTotal.getUsername().equals(username)) {
                total5 = flightTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
//                Month month = Month.from(flightTotal.getDate());
                oat5.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (flightTotal.getDate().getMonthValue() == 6 && flightTotal.getUsername().equals(username)) {
                total6 = flightTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
//                Month month = Month.from(flightTotal.getDate());
                oat6.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (flightTotal.getDate().getMonthValue() == 7 && flightTotal.getUsername().equals(username)) {
                total7 = flightTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
//                Month month = Month.from(flightTotal.getDate());
                oat7.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (flightTotal.getDate().getMonthValue() == 8 && flightTotal.getUsername().equals(username)) {
                total8 = flightTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
//                Month month = Month.from(flightTotal.getDate());
                oat8.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (flightTotal.getDate().getMonthValue() == 9 && flightTotal.getUsername().equals(username)) {
                total9 = flightTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
//                Month month = Month.from(flightTotal.getDate());
                oat9.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (flightTotal.getDate().getMonthValue() == 10 && flightTotal.getUsername().equals(username)) {
                total10 = flightTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
//                Month month = Month.from(flightTotal.getDate());
                oat10.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (flightTotal.getDate().getMonthValue() == 11 && flightTotal.getUsername().equals(username)) {
                total11 = flightTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
//                Month month = Month.from(flightTotal.getDate());
                oat11.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (flightTotal.getDate().getMonthValue() == 12 && flightTotal.getUsername().equals(username)) {
                total12 = flightTotal.getTotal();
                oat12.setUsername(username);
                oat12.setTotal(total12);
//                Month month = Month.from(flightTotal.getDate());
                oat12.setDate(flightTotal.getDate().getMonthValue());
                oats.save(oat12);
            }


            List<Double> totalFlight = oats.listAll().stream().map(OverAllTotal::getTotal).collect(Collectors.toList());
            List<Integer> date = oats.listAll().stream().map(OverAllTotal::getDate).collect(Collectors.toList());

            model.addAttribute("totalFlight", totalFlight);
            model.addAttribute("date", date);


        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        //  PIE CHART

        double foodT = 0;
        double transT = 0;
        double houseT = 0;
        double flightT = 0;

        List<FoodTotal> foods = fts.listAll();
        List<TransportTotal> trans = tts.listAll();
        List<HouseEnergyTotal> house = hets.listAll();
        List<FlightTotal> flights = flts.listAll();

            for (FoodTotal food : foods) {

                if (food.getUsername().equals(username)) {

                    foodT = foodT + food.getTotalCo2();
                }
            }

            for (TransportTotal tran : trans) {

                if (tran.getUsername().equals(username)) {

                    transT = transT + tran.getTotalCo2();
                }
            }

            for (int i = 0; i < house.size(); i++) {

                if (house.get(i).getUsername().equals(username)) {

                    houseT = houseT + foods.get(i).getTotalCo2();
                }
            }

            for (int i = 0; i < flights.size(); i++) {

                if (flights.get(i).getUsername().equals(username)) {

                    flightT = flightT + foods.get(i).getTotalCo2();
                }
            }

        model.addAttribute("foodT", foodT);
        model.addAttribute("transT", transT);
        model.addAttribute("houseT", houseT);
        model.addAttribute("flightT", flightT);

        return "dashboard";
    }

}


