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


    @GetMapping("/statistics")
    public String showAnnualStats(Model model) {

        String username = userDetails.returnUsername();
        List<FoodTotal> ft = fts.listAll();

        double total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0, total7 = 0,
                total8 = 0, total9 = 0, total10 = 0, total11 = 0, total12 = 0;

        OverAllTotal oat1, oat2, oat3, oat4, oat5, oat6, oat7, oat8, oat9, oat10, oat11, oat12, oat13;
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
        oat13 = new OverAllTotal();


        // FOOD

        for (FoodTotal foodTotal : ft) {
            if (foodTotal.getDate().getMonthValue() == 1 && foodTotal.getUsername().equals(username)) {
                total1 = total1 + foodTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (foodTotal.getDate().getMonthValue() == 2 && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (foodTotal.getDate().getMonthValue() == 3 && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (foodTotal.getDate().getMonthValue() == 4 && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (foodTotal.getDate().getMonthValue() == 5 && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (foodTotal.getDate().getMonthValue() == 6 && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (foodTotal.getDate().getMonthValue() == 7 && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly((foodTotal.getDate().getMonthValue()));
                oats.save(oat7);
            }

            if (foodTotal.getDate().getMonthValue() == 8 && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (foodTotal.getDate().getMonthValue() == 9 && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (foodTotal.getDate().getMonthValue() == 10 && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (foodTotal.getDate().getMonthValue() == 11 && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (foodTotal.getDate().getMonthValue() == 12 && foodTotal.getUsername().equals(username)) {
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

        List<TransportTotal> tt = tts.listAll();

        for (TransportTotal transTotal : tt) {

            if (transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
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

        List<HouseEnergyTotal> het = hets.listAll();

        for (HouseEnergyTotal houseTotal : het) {

            if (houseTotal.getDate().getMonthValue() == 1 && houseTotal.getUsername().equals(username)) {
                total1 = houseTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (houseTotal.getDate().getMonthValue() == 2 && houseTotal.getUsername().equals(username)) {
                total2 = houseTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (houseTotal.getDate().getMonthValue() == 3 && houseTotal.getUsername().equals(username)) {
                total3 = houseTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (houseTotal.getDate().getMonthValue() == 4 && houseTotal.getUsername().equals(username)) {
                total4 = houseTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (houseTotal.getDate().getMonthValue() == 5 && houseTotal.getUsername().equals(username)) {
                total5 = houseTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (houseTotal.getDate().getMonthValue() == 6 && houseTotal.getUsername().equals(username)) {
                total6 = houseTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (houseTotal.getDate().getMonthValue() == 7 && houseTotal.getUsername().equals(username)) {
                total7 = houseTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (houseTotal.getDate().getMonthValue() == 8 && houseTotal.getUsername().equals(username)) {
                total8 = houseTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (houseTotal.getDate().getMonthValue() == 9 && houseTotal.getUsername().equals(username)) {
                total9 = houseTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (houseTotal.getDate().getMonthValue() == 10 && houseTotal.getUsername().equals(username)) {
                total10 = houseTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (houseTotal.getDate().getMonthValue() == 11 && houseTotal.getUsername().equals(username)) {
                total11 = houseTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (houseTotal.getDate().getMonthValue() == 12 && houseTotal.getUsername().equals(username)) {
                total12 = houseTotal.getTotal();
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


        List<FlightTotal> flt = flts.listAll();

        for (FlightTotal flightTotal : flt) {

            if (flightTotal.getDate().getMonthValue() == 1 && flightTotal.getUsername().equals(username)) {
                total1 = flightTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
//                Month month = Month.from(flightTotal.getDate());
                oat1.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (flightTotal.getDate().getMonthValue() == 2 && flightTotal.getUsername().equals(username)) {
                total2 = flightTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
//                Month month = Month.from(flightTotal.getDate());
                oat2.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (flightTotal.getDate().getMonthValue() == 3 && flightTotal.getUsername().equals(username)) {
                total3 = flightTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
//                Month month = Month.from(flightTotal.getDate());
                oat3.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (flightTotal.getDate().getMonthValue() == 4 && flightTotal.getUsername().equals(username)) {
                total4 = flightTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
//                Month month = Month.from(flightTotal.getDate());
                oat4.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (flightTotal.getDate().getMonthValue() == 5 && flightTotal.getUsername().equals(username)) {
                total5 = flightTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
//                Month month = Month.from(flightTotal.getDate());
                oat5.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (flightTotal.getDate().getMonthValue() == 6 && flightTotal.getUsername().equals(username)) {
                total6 = flightTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
//                Month month = Month.from(flightTotal.getDate());
                oat6.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (flightTotal.getDate().getMonthValue() == 7 && flightTotal.getUsername().equals(username)) {
                total7 = flightTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
//                Month month = Month.from(flightTotal.getDate());
                oat7.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (flightTotal.getDate().getMonthValue() == 8 && flightTotal.getUsername().equals(username)) {
                total8 = flightTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
//                Month month = Month.from(flightTotal.getDate());
                oat8.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (flightTotal.getDate().getMonthValue() == 9 && flightTotal.getUsername().equals(username)) {
                total9 = flightTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
//                Month month = Month.from(flightTotal.getDate());
                oat9.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (flightTotal.getDate().getMonthValue() == 10 && flightTotal.getUsername().equals(username)) {
                total10 = flightTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
//                Month month = Month.from(flightTotal.getDate());
                oat10.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (flightTotal.getDate().getMonthValue() == 11 && flightTotal.getUsername().equals(username)) {
                total11 = flightTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
//                Month month = Month.from(flightTotal.getDate());
                oat11.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (flightTotal.getDate().getMonthValue() == 12 && flightTotal.getUsername().equals(username)) {
                total12 = flightTotal.getTotal();
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

        return "statistics";
    }

    @GetMapping("/lastMonthStats")
    public String lastMonthStats(Model model) {

        // FOOD

        List<FoodTotal> ft = fts.listAll();
        String username = userDetails.returnUsername();

        for (FoodTotal foodTotal : ft) {
            LocalDate now = LocalDate.now();
            if (foodTotal.getDate().getMonthValue() == now.getMonthValue() && foodTotal.getUsername().equals(username)) {
                OverAllTotal foodMonth = new OverAllTotal();

                foodMonth.setUsername(username);
                foodMonth.setTotal(foodTotal.getTotalCo2());
                foodMonth.setFullDate(foodTotal.getDate());
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

        List<TransportTotal> tt = tts.listAll();

        for (TransportTotal transTotal : tt) {
            LocalDate now = LocalDate.now();
            if (transTotal.getDate().getMonthValue() == now.getMonthValue() && transTotal.getUsername().equals(username)) {
                OverAllTotal transMonth = new OverAllTotal();

                transMonth.setUsername(username);
                transMonth.setTotal(transTotal.getTotalCo2());
                transMonth.setFullDate(transTotal.getDate());
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

        List<HouseEnergyTotal> ht = hets.listAll();

        for (HouseEnergyTotal houseTotal : ht) {
            LocalDate now = LocalDate.now();
            if (houseTotal.getDate().getMonthValue() == now.getMonthValue() && houseTotal.getUsername().equals(username)) {
                OverAllTotal houseMonth = new OverAllTotal();

                houseMonth.setUsername(username);
                houseMonth.setTotal(houseTotal.getTotal());
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

        List<FlightTotal> flt = flts.listAll();

        for (FlightTotal flightTotal : flt) {
            LocalDate now = LocalDate.now();
            if (flightTotal.getDate().getMonthValue() == now.getMonthValue() && flightTotal.getUsername().equals(username)) {
                OverAllTotal flightMonth = new OverAllTotal();

                flightMonth.setUsername(username);
                flightMonth.setTotal(flightTotal.getTotal());
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

    public static LocalDate[] getPreviousWeek(LocalDate date) {
        final int dayOfWeek = date.getDayOfWeek().getValue();
        final LocalDate from = date.minusDays(dayOfWeek + 6); // (dayOfWeek - 1) + 7
        final LocalDate to = date.minusDays(dayOfWeek);

        return new LocalDate[]{from, to};
    }

    public static LocalDate[] getPreviousMonth(LocalDate date) {
        final LocalDate from = date.minusDays(date.getDayOfMonth() - 1).minusMonths(1);
        final LocalDate to = from.plusMonths(1).minusDays(1);

        return new LocalDate[]{from, to};
    }

    @GetMapping("/lastWeekStats")
    public String lastWeekStats(Model model) {

        // FOOD

        List<FoodTotal> ft = fts.listAll();
        String username = userDetails.returnUsername();

        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();

        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);

        List<LocalDate> listOfDates = LongStream.range(0, numOfDays)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toList());

        System.out.println(listOfDates);
        ArrayList<LocalDate> arListDates = new ArrayList<>(listOfDates);
        ArrayList<LocalDate> arrDate = new ArrayList<>();

        for (int i = 0; i < ft.size(); i++) {

           arrDate.add(ft.get(i).getDate());
        }
        System.out.println("Before: " + arrDate);
        arrDate.retainAll(arListDates);
        System.out.println("After: " + arrDate);


        for (int i = 0; i < ft.size(); i++) {

            if (arrDate.contains(ft.get(i).getDate()) && ft.get(i).getUsername().equals(username)) {

                OverAllTotal foodWeek = new OverAllTotal();

                foodWeek.setUsername(username);
                foodWeek.setTotal(ft.get(i).getTotalCo2());
                foodWeek.setFullDate(ft.get(i).getDate());
                oats.save(foodWeek);
            }

            List<Double> totalfw = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            model.addAttribute("totalfw", totalfw);
            List<Integer> datefw = oats.listAll().stream().map(x -> x.getFullDate().getDayOfMonth()).collect(Collectors.toList());
            model.addAttribute("datefw", datefw);
        }
//        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
//        oats.deleteAll(deleteTotalObject);


        return "lastWeekStats";
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
                oat1.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (foodTotal.getDate().getMonthValue() == 2 && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (foodTotal.getDate().getMonthValue() == 3 && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (foodTotal.getDate().getMonthValue() == 4 && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (foodTotal.getDate().getMonthValue() == 5 && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (foodTotal.getDate().getMonthValue() == 6 && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (foodTotal.getDate().getMonthValue() == 7 && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly((foodTotal.getDate().getMonthValue()));
                oats.save(oat7);
            }

            if (foodTotal.getDate().getMonthValue() == 8 && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (foodTotal.getDate().getMonthValue() == 9 && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (foodTotal.getDate().getMonthValue() == 10 && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (foodTotal.getDate().getMonthValue() == 11 && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(foodTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (foodTotal.getDate().getMonthValue() == 12 && foodTotal.getUsername().equals(username)) {
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

        List<TransportTotal> tt = tts.listAll();

        for (TransportTotal transTotal : tt) {

            if (transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(transTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
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

        List<HouseEnergyTotal> het = hets.listAll();

        for (HouseEnergyTotal houseTotal : het) {

            if (houseTotal.getDate().getMonthValue() == 1 && houseTotal.getUsername().equals(username)) {
                total1 = houseTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (houseTotal.getDate().getMonthValue() == 2 && houseTotal.getUsername().equals(username)) {
                total2 = houseTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (houseTotal.getDate().getMonthValue() == 3 && houseTotal.getUsername().equals(username)) {
                total3 = houseTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (houseTotal.getDate().getMonthValue() == 4 && houseTotal.getUsername().equals(username)) {
                total4 = houseTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (houseTotal.getDate().getMonthValue() == 5 && houseTotal.getUsername().equals(username)) {
                total5 = houseTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (houseTotal.getDate().getMonthValue() == 6 && houseTotal.getUsername().equals(username)) {
                total6 = houseTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (houseTotal.getDate().getMonthValue() == 7 && houseTotal.getUsername().equals(username)) {
                total7 = houseTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (houseTotal.getDate().getMonthValue() == 8 && houseTotal.getUsername().equals(username)) {
                total8 = houseTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (houseTotal.getDate().getMonthValue() == 9 && houseTotal.getUsername().equals(username)) {
                total9 = houseTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (houseTotal.getDate().getMonthValue() == 10 && houseTotal.getUsername().equals(username)) {
                total10 = houseTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (houseTotal.getDate().getMonthValue() == 11 && houseTotal.getUsername().equals(username)) {
                total11 = houseTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setMonthly(houseTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (houseTotal.getDate().getMonthValue() == 12 && houseTotal.getUsername().equals(username)) {
                total12 = houseTotal.getTotal();
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


        List<FlightTotal> flt = flts.listAll();

        for (FlightTotal flightTotal : flt) {

            if (flightTotal.getDate().getMonthValue() == 1 && flightTotal.getUsername().equals(username)) {
                total1 = flightTotal.getTotal();
                oat1.setUsername(username);
                oat1.setTotal(total1);
//                Month month = Month.from(flightTotal.getDate());
                oat1.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat1);
            }

            if (flightTotal.getDate().getMonthValue() == 2 && flightTotal.getUsername().equals(username)) {
                total2 = flightTotal.getTotal();
                oat2.setUsername(username);
                oat2.setTotal(total2);
//                Month month = Month.from(flightTotal.getDate());
                oat2.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat2);
            }


            if (flightTotal.getDate().getMonthValue() == 3 && flightTotal.getUsername().equals(username)) {
                total3 = flightTotal.getTotal();
                oat3.setUsername(username);
                oat3.setTotal(total3);
//                Month month = Month.from(flightTotal.getDate());
                oat3.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat3);
            }

            if (flightTotal.getDate().getMonthValue() == 4 && flightTotal.getUsername().equals(username)) {
                total4 = flightTotal.getTotal();
                oat4.setUsername(username);
                oat4.setTotal(total4);
//                Month month = Month.from(flightTotal.getDate());
                oat4.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat4);
            }

            if (flightTotal.getDate().getMonthValue() == 5 && flightTotal.getUsername().equals(username)) {
                total5 = flightTotal.getTotal();
                oat5.setUsername(username);
                oat5.setTotal(total5);
//                Month month = Month.from(flightTotal.getDate());
                oat5.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat5);
            }

            if (flightTotal.getDate().getMonthValue() == 6 && flightTotal.getUsername().equals(username)) {
                total6 = flightTotal.getTotal();
                oat6.setUsername(username);
                oat6.setTotal(total6);
//                Month month = Month.from(flightTotal.getDate());
                oat6.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat6);
            }

            if (flightTotal.getDate().getMonthValue() == 7 && flightTotal.getUsername().equals(username)) {
                total7 = flightTotal.getTotal();
                oat7.setUsername(username);
                oat7.setTotal(total7);
//                Month month = Month.from(flightTotal.getDate());
                oat7.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat7);
            }

            if (flightTotal.getDate().getMonthValue() == 8 && flightTotal.getUsername().equals(username)) {
                total8 = flightTotal.getTotal();
                oat8.setUsername(username);
                oat8.setTotal(total8);
//                Month month = Month.from(flightTotal.getDate());
                oat8.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat8);
            }

            if (flightTotal.getDate().getMonthValue() == 9 && flightTotal.getUsername().equals(username)) {
                total9 = flightTotal.getTotal();
                oat9.setUsername(username);
                oat9.setTotal(total9);
//                Month month = Month.from(flightTotal.getDate());
                oat9.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat9);
            }

            if (flightTotal.getDate().getMonthValue() == 10 && flightTotal.getUsername().equals(username)) {
                total10 = flightTotal.getTotal();
                oat10.setUsername(username);
                oat10.setTotal(total10);
//                Month month = Month.from(flightTotal.getDate());
                oat10.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat10);
            }

            if (flightTotal.getDate().getMonthValue() == 11 && flightTotal.getUsername().equals(username)) {
                total11 = flightTotal.getTotal();
                oat11.setUsername(username);
                oat11.setTotal(total11);
//                Month month = Month.from(flightTotal.getDate());
                oat11.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat11);
            }

            if (flightTotal.getDate().getMonthValue() == 12 && flightTotal.getUsername().equals(username)) {
                total12 = flightTotal.getTotal();
                oat12.setUsername(username);
                oat12.setTotal(total12);
//                Month month = Month.from(flightTotal.getDate());
                oat12.setMonthly(flightTotal.getDate().getMonthValue());
                oats.save(oat12);
            }


            List<Double> totalFlight = oats.listAll().stream().map(OverAllTotal::getTotal).collect(Collectors.toList());
            List<Integer> date = oats.listAll().stream().map(OverAllTotal::getMonthly).collect(Collectors.toList());

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

                houseT = houseT + house.get(i).getTotal();
            }
        }

        for (int i = 0; i < flights.size(); i++) {

            if (flights.get(i).getUsername().equals(username)) {

                flightT = flightT + flights.get(i).getTotal();
            }
        }

        model.addAttribute("foodT", foodT);
        model.addAttribute("transT", transT);
        model.addAttribute("houseT", houseT);
        model.addAttribute("flightT", flightT);

        return "dashboard";
    }

}


