package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sustain.project.models.*;
import sustain.project.service.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Controller
public class ChartController {

    @Autowired
    private CustomUserDetailsService userDetails;
    @Autowired
    private EmissionTotalService ets;
    @Autowired
    private OverAllTotalService oats;
    @Autowired
    private TransportTotalService tts;
    @Autowired
    private HouseEnergyTotalService hets;
    @Autowired
    private FlightTotalService flts;

    private final LocalDate now = LocalDate.now();

    // METHODS


    @GetMapping("/lastYearStats")
    public String lastYearStats(Model model) {

        String username = userDetails.returnUsername();
        List<EmissionTotal> et = ets.listAll();

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

        for (EmissionTotal foodTotal : et) {
            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 1 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total1 = total1 + foodTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 2 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat2);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 3 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 4 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 5 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 6 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 7 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly((foodTotal.getDate().getMonthValue()));
                oats.save(oat7);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 8 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 9 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 10 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 11 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 12 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total12 = total12 + foodTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> total = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("total", total);
            List<Integer> date = oats.listAll().stream().map(x -> x.getMonthly()).collect(Collectors.toList());
            model.addAttribute("date", date);


        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // TRANSPORT


        for (EmissionTotal transTotal : et) {

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
                total12 = transTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalTrans = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalTrans", totalTrans);
            List<Integer> date = oats.listAll().stream().map(x -> x.getMonthly()).collect(Collectors.toList());
            model.addAttribute("date", date);

        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // HOUSE ENERGY


        for (EmissionTotal houseTotal : et) {

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 1 && houseTotal.getUsername().equals(username)) {
                total1 = houseTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 2 && houseTotal.getUsername().equals(username)) {
                total2 = houseTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 3 && houseTotal.getUsername().equals(username)) {
                total3 = houseTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 4 && houseTotal.getUsername().equals(username)) {
                total4 = houseTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 5 && houseTotal.getUsername().equals(username)) {
                total5 = houseTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 6 && houseTotal.getUsername().equals(username)) {
                total6 = houseTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 7 && houseTotal.getUsername().equals(username)) {
                total7 = houseTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 8 && houseTotal.getUsername().equals(username)) {
                total8 = houseTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 9 && houseTotal.getUsername().equals(username)) {
                total9 = houseTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 10 && houseTotal.getUsername().equals(username)) {
                total10 = houseTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 11 && houseTotal.getUsername().equals(username)) {
                total11 = houseTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 12 && houseTotal.getUsername().equals(username)) {
                total12 = houseTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalHouse = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalHouse", totalHouse);
            List<Integer> date = oats.listAll().stream().map(x -> x.getMonthly()).collect(Collectors.toList());
            model.addAttribute("date", date);
//
//
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // FLIGHT


        for (EmissionTotal flightTotal : et) {

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 1 && flightTotal.getUsername().equals(username)) {
                total1 = flightTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
//                Month month = Month.from(flightTotal.getDate());
                oat1.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 2 && flightTotal.getUsername().equals(username)) {
                total2 = flightTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
//                Month month = Month.from(flightTotal.getDate());
                oat2.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat2);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 3 && flightTotal.getUsername().equals(username)) {
                total3 = flightTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
//                Month month = Month.from(flightTotal.getDate());
                oat3.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 4 && flightTotal.getUsername().equals(username)) {
                total4 = flightTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
//                Month month = Month.from(flightTotal.getDate());
                oat4.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 5 && flightTotal.getUsername().equals(username)) {
                total5 = flightTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
//                Month month = Month.from(flightTotal.getDate());
                oat5.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 6 && flightTotal.getUsername().equals(username)) {
                total6 = flightTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
//                Month month = Month.from(flightTotal.getDate());
                oat6.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 7 && flightTotal.getUsername().equals(username)) {
                total7 = flightTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
//                Month month = Month.from(flightTotal.getDate());
                oat7.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 8 && flightTotal.getUsername().equals(username)) {
                total8 = flightTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
//                Month month = Month.from(flightTotal.getDate());
                oat8.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 9 && flightTotal.getUsername().equals(username)) {
                total9 = flightTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
//                Month month = Month.from(flightTotal.getDate());
                oat9.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 10 && flightTotal.getUsername().equals(username)) {
                total10 = flightTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
//                Month month = Month.from(flightTotal.getDate());
                oat10.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 11 && flightTotal.getUsername().equals(username)) {
                total11 = flightTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
//                Month month = Month.from(flightTotal.getDate());
                oat11.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 12 && flightTotal.getUsername().equals(username)) {
                total12 = flightTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
//                Month month = Month.from(flightTotal.getDate());
                oat12.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat12);
            }


            List<Double> totalFlight = oats.listAll().stream().map(OverAllTotal::getTotal).collect(Collectors.toList());
            List<Integer> date = oats.listAll().stream().map(OverAllTotal::getMonthly).collect(Collectors.toList());

            model.addAttribute("totalFlight", totalFlight);
            model.addAttribute("dateFl", date);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        //  PIE CHART

        double foodT = 0;
        double transT = 0;
        double houseT = 0;
        double flightT = 0;

        for (EmissionTotal food : et) {

            if (food.getEmissionType().equals("food") && food.getUsername().equals(username)) {

                foodT = foodT + food.getTotalCo2();
            }
        }

        for (EmissionTotal tran : et) {

            if (tran.getEmissionType().equals("transport") && tran.getUsername().equals(username)) {

                transT = transT + tran.getTotalCo2();
            }
        }

        for (EmissionTotal houseEnergyTotal : et) {

            if (houseEnergyTotal.getEmissionType().equals("food") && houseEnergyTotal.getUsername().equals(username)) {

                houseT = houseT + houseEnergyTotal.getTotalCo2();
            }
        }

        for (EmissionTotal flight : et) {

            if (flight.getEmissionType().equals("flight") && flight.getUsername().equals(username)) {

                flightT = flightT + flight.getTotalCo2();
            }
        }

        model.addAttribute("foodT", foodT);
        model.addAttribute("transT", transT);
        model.addAttribute("houseT", houseT);
        model.addAttribute("flightT", flightT);

        return "lastYearStats";
    }

    @GetMapping("/lastMonthStats")
    public String lastMonthStats(Model model) {

        // FOOD

        List<EmissionTotal> et = ets.listAll();
        String username = userDetails.returnUsername();

        for (EmissionTotal emissionTotal : et) {
            if (emissionTotal.getEmissionType().equals("food") && emissionTotal.getDate().getMonthValue() == now.getMonthValue() && emissionTotal.getUsername().equals(username)) {
                OverAllTotal foodMonth = new OverAllTotal();
                double total = 0;
                total = total + emissionTotal.getTotalCo2();
                foodMonth.setUsername(username);
                foodMonth.setTotal(total);
                foodMonth.setFullDate(emissionTotal.getDate());

//
//                if(ft.get(i).getDate() == ft.get(i).getDate()){
//                    total = ft.get(i).getTotalCo2() + ft.get(i).getTotalCo2();
//                    foodMonth.setTotal(total);
//                    foodMonth.setFullDate(ft.get(i).getDate());
//                    foodMonth.setUsername(username);
//                    oats.save(foodMonth);
//                }
                oats.save(foodMonth);

            }

            List<Double> totalfm = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalfm", totalfm);
            List<Integer> datefm = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datefm", datefm);
        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        // TRANSPORT

        for (EmissionTotal emissionTotal : et) {
            if (emissionTotal.getEmissionType().equals("transport") &&  emissionTotal.getDate().getMonthValue() == now.getMonthValue() && emissionTotal.getUsername().equals(username)) {
                OverAllTotal transMonth = new OverAllTotal();

                transMonth.setUsername(username);
                transMonth.setTotal(emissionTotal.getTotalCo2());
                transMonth.setFullDate(emissionTotal.getDate());
                oats.save(transMonth);
            }

            List<Double> totaltm = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totaltm", totaltm);
            List<Integer> datetm = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datetm", datetm);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        // HOUSE


        for (EmissionTotal houseTotal : et) {
            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == now.getMonthValue() && houseTotal.getUsername().equals(username)) {
                OverAllTotal houseMonth = new OverAllTotal();

                houseMonth.setUsername(username);
                houseMonth.setTotal(houseTotal.getTotalCo2());
                houseMonth.setFullDate(houseTotal.getDate());
                oats.save(houseMonth);
            }

            List<Double> totalhm = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalhm", totalhm);
            List<Integer> datehm = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datehm", datehm);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        // FLIGHT


        for (EmissionTotal flightTotal : et) {
            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == now.getMonthValue() && flightTotal.getUsername().equals(username)) {
                OverAllTotal flightMonth = new OverAllTotal();

                flightMonth.setUsername(username);
                flightMonth.setTotal(flightTotal.getTotalCo2());
                flightMonth.setFullDate(flightTotal.getDate());
                oats.save(flightMonth);
            }

            List<Double> totalflm = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalflm", totalflm);
            List<Integer> dateflm = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("dateflm", dateflm);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        return "lastMonthStats";
    }

    @GetMapping("/statistics")
    public String lastWeekStats(Model model) {

        // FOOD

        List<EmissionTotal> et = ets.listAll();
        String username = userDetails.returnUsername();
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();
        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);

        List<LocalDate> listOfDates = LongStream.range(0, numOfDays)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toList());

        ArrayList<LocalDate> arListDates = new ArrayList<>(listOfDates);
        ArrayList<LocalDate> arrDate = new ArrayList<>();

        for (EmissionTotal foodTotal : et) {

            arrDate.add(foodTotal.getDate());
        }
        arrDate.retainAll(arListDates);

        for (EmissionTotal foodTotal : et) {

            if (foodTotal.getEmissionType().equals("food") && arrDate.contains(foodTotal.getDate()) && foodTotal.getUsername().equals(username)) {

                OverAllTotal foodWeek = new OverAllTotal();
                foodWeek.setUsername(username);
                foodWeek.setTotal(foodTotal.getTotalCo2());
                foodWeek.setFullDate(foodTotal.getDate());
                oats.save(foodWeek);
            }


            List<Double> totalfw = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalfw", totalfw);
            List<Integer> datefw = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datefw", datefw);
        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // TRANSPORT


        for (EmissionTotal transTotal : et) {

            arrDate.add(transTotal.getDate());
        }
        arrDate.retainAll(arListDates);

        for (EmissionTotal transTotal : et) {

            if (transTotal.getEmissionType().equals("transport") && arrDate.contains(transTotal.getDate()) && transTotal.getUsername().equals(username)) {

                OverAllTotal transWeek = new OverAllTotal();

                transWeek.setUsername(username);
                transWeek.setTotal(transTotal.getTotalCo2());
                transWeek.setFullDate(transTotal.getDate());
                oats.save(transWeek);
            }

            List<Double> totaltw = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totaltw", totaltw);
            List<Integer> datetw = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datetw", datetw);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // HOUSE

        for (EmissionTotal houseTotal : et) {

            arrDate.add(houseTotal.getDate());
        }
        arrDate.retainAll(arListDates);

        for (EmissionTotal houseTotal : et) {

            if (houseTotal.getEmissionType().equals("home") && arrDate.contains(houseTotal.getDate()) && houseTotal.getUsername().equals(username)) {

                OverAllTotal houseWeek = new OverAllTotal();

                houseWeek.setUsername(username);
                houseWeek.setTotal(houseTotal.getTotalCo2());
                houseWeek.setFullDate(houseTotal.getDate());
                oats.save(houseWeek);
            }

            List<Double> totalhw = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalhw", totalhw);
            List<Integer> datehw = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datehw", datehw);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // FLIGHT

        for (EmissionTotal flightTotal : et) {

            arrDate.add(flightTotal.getDate());
        }
        arrDate.retainAll(arListDates);

        for (EmissionTotal flightTotal : et) {

            if (flightTotal.getEmissionType().equals("flight") && arrDate.contains(flightTotal.getDate()) && flightTotal.getUsername().equals(username)) {

                OverAllTotal flightWeek = new OverAllTotal();

                flightWeek.setUsername(username);
                flightWeek.setTotal(flightTotal.getTotalCo2());
                flightWeek.setFullDate(flightTotal.getDate());
                oats.save(flightWeek);
            }

            List<Double> totalflw = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalflw", totalflw);
            List<Integer> dateflw = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("dateflw", dateflw);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // PIE CHART

        double foodT = 0;
        double transT = 0;
        double houseT = 0;
        double flightT = 0;

        for (EmissionTotal food : et) {

            if (food.getEmissionType().equals("food") && arrDate.contains(food.getDate()) && food.getUsername().equals(username)) {

                foodT = foodT + food.getTotalCo2();
            }
        }

        for (EmissionTotal tran : et) {

            if (tran.getEmissionType().equals("transport") && arrDate.contains(tran.getDate()) && tran.getUsername().equals(username)) {

                transT = transT + tran.getTotalCo2();
            }
        }

        for (EmissionTotal houseEnergyTotal : et) {

            if (houseEnergyTotal.getEmissionType().equals("home") && arrDate.contains(houseEnergyTotal.getDate()) && houseEnergyTotal.getUsername().equals(username)) {

                houseT = houseT + houseEnergyTotal.getTotalCo2();
            }
        }

        for (EmissionTotal flight : et) {

            if (flight.getEmissionType().equals("flight") && arrDate.contains(flight.getDate()) && flight.getUsername().equals(username)) {

                flightT = flightT + flight.getTotalCo2();
            }
        }

        model.addAttribute("foodT", foodT);
        model.addAttribute("transT", transT);
        model.addAttribute("houseT", houseT);
        model.addAttribute("flightT", flightT);


        return "statistics";
    }

    @GetMapping("/dashboard")
    public String dashStats(Model model) {


        String username = userDetails.returnUsername();
        List<EmissionTotal> et = ets.listAll();

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

        for (EmissionTotal foodTotal : et) {
            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 1 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total1 = total1 + foodTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 2 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat2);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 3 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 4 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 5 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 6 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 7 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly((foodTotal.getDate().getMonthValue()));
                oats.save(oat7);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 8 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 9 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 10 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 11 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (foodTotal.getEmissionType().equals("food") && foodTotal.getDate().getMonthValue() == 12 && foodTotal.getDate().getYear() == now.getYear() && foodTotal.getUsername().equals(username)) {
                total12 = total12 + foodTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> total = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("total", total);
            List<Integer> date = oats.listAll().stream().map(x -> x.getMonthly()).collect(Collectors.toList());
            model.addAttribute("date", date);


        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // TRANSPORT


        for (EmissionTotal transTotal : et) {

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (transTotal.getEmissionType().equals("transport") && transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
                total12 = transTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalTrans = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalTrans", totalTrans);
            List<Integer> date = oats.listAll().stream().map(x -> x.getMonthly()).collect(Collectors.toList());
            model.addAttribute("date", date);

        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // HOUSE ENERGY


        for (EmissionTotal houseTotal : et) {

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 1 && houseTotal.getUsername().equals(username)) {
                total1 = houseTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 2 && houseTotal.getUsername().equals(username)) {
                total2 = houseTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 3 && houseTotal.getUsername().equals(username)) {
                total3 = houseTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 4 && houseTotal.getUsername().equals(username)) {
                total4 = houseTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 5 && houseTotal.getUsername().equals(username)) {
                total5 = houseTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 6 && houseTotal.getUsername().equals(username)) {
                total6 = houseTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 7 && houseTotal.getUsername().equals(username)) {
                total7 = houseTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 8 && houseTotal.getUsername().equals(username)) {
                total8 = houseTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 9 && houseTotal.getUsername().equals(username)) {
                total9 = houseTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 10 && houseTotal.getUsername().equals(username)) {
                total10 = houseTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 11 && houseTotal.getUsername().equals(username)) {
                total11 = houseTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (houseTotal.getEmissionType().equals("home") && houseTotal.getDate().getMonthValue() == 12 && houseTotal.getUsername().equals(username)) {
                total12 = houseTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat12);
            }

            List<Double> totalHouse = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalHouse", totalHouse);
            List<Integer> date = oats.listAll().stream().map(x -> x.getMonthly()).collect(Collectors.toList());
            model.addAttribute("date", date);
//
//
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);


        // FLIGHT


        for (EmissionTotal flightTotal : et) {

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 1 && flightTotal.getUsername().equals(username)) {
                total1 = flightTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
//                Month month = Month.from(flightTotal.getDate());
                oat1.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 2 && flightTotal.getUsername().equals(username)) {
                total2 = flightTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
//                Month month = Month.from(flightTotal.getDate());
                oat2.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat2);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 3 && flightTotal.getUsername().equals(username)) {
                total3 = flightTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
//                Month month = Month.from(flightTotal.getDate());
                oat3.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 4 && flightTotal.getUsername().equals(username)) {
                total4 = flightTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
//                Month month = Month.from(flightTotal.getDate());
                oat4.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 5 && flightTotal.getUsername().equals(username)) {
                total5 = flightTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
//                Month month = Month.from(flightTotal.getDate());
                oat5.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 6 && flightTotal.getUsername().equals(username)) {
                total6 = flightTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
//                Month month = Month.from(flightTotal.getDate());
                oat6.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 7 && flightTotal.getUsername().equals(username)) {
                total7 = flightTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
//                Month month = Month.from(flightTotal.getDate());
                oat7.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 8 && flightTotal.getUsername().equals(username)) {
                total8 = flightTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
//                Month month = Month.from(flightTotal.getDate());
                oat8.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 9 && flightTotal.getUsername().equals(username)) {
                total9 = flightTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
//                Month month = Month.from(flightTotal.getDate());
                oat9.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 10 && flightTotal.getUsername().equals(username)) {
                total10 = flightTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
//                Month month = Month.from(flightTotal.getDate());
                oat10.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 11 && flightTotal.getUsername().equals(username)) {
                total11 = flightTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
//                Month month = Month.from(flightTotal.getDate());
                oat11.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (flightTotal.getEmissionType().equals("flight") && flightTotal.getDate().getMonthValue() == 12 && flightTotal.getUsername().equals(username)) {
                total12 = flightTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
//                Month month = Month.from(flightTotal.getDate());
                oat12.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat12);
            }


            List<Double> totalFlight = oats.listAll().stream().map(OverAllTotal::getTotal).collect(Collectors.toList());
            List<Integer> date = oats.listAll().stream().map(OverAllTotal::getMonthly).collect(Collectors.toList());

            model.addAttribute("totalFlight", totalFlight);
            model.addAttribute("dateFl", date);
        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        //  PIE CHART

        double foodT = 0;
        double transT = 0;
        double houseT = 0;
        double flightT = 0;

        for (EmissionTotal food : et) {

            if (food.getEmissionType().equals("food") && food.getUsername().equals(username)) {

                foodT = foodT + food.getTotalCo2();
            }
        }

        for (EmissionTotal tran : et) {

            if (tran.getEmissionType().equals("transport") && tran.getUsername().equals(username)) {

                transT = transT + tran.getTotalCo2();
            }
        }

        for (EmissionTotal houseEnergyTotal : et) {

            if (houseEnergyTotal.getEmissionType().equals("food") && houseEnergyTotal.getUsername().equals(username)) {

                houseT = houseT + houseEnergyTotal.getTotalCo2();
            }
        }

        for (EmissionTotal flight : et) {

            if (flight.getEmissionType().equals("flight") && flight.getUsername().equals(username)) {

                flightT = flightT + flight.getTotalCo2();
            }
        }

        model.addAttribute("foodT", foodT);
        model.addAttribute("transT", transT);
        model.addAttribute("houseT", houseT);
        model.addAttribute("flightT", flightT);

        return "dashboard";
    }

}


