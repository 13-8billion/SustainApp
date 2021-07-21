package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sustain.project.models.FoodTotal;
import sustain.project.models.OverAllTotal;
import sustain.project.models.TransportTotal;
import sustain.project.service.CustomUserDetailsService;
import sustain.project.service.FoodTotalService;
import sustain.project.service.OverAllTotalService;
import sustain.project.service.TransportTotalService;


import java.util.*;
import java.util.stream.Collectors;


//@RestController
//@RequestMapping(value = "/echart")
@Controller
public class EChartController {

    @Autowired
    private CustomUserDetailsService userDetails;
    @Autowired
    private FoodTotalService fts;
    @Autowired
    private OverAllTotalService oats;
    @Autowired
    private TransportTotalService tts;

    // METHODS

    @GetMapping("/statistics")
    public String showAnnualStats(Model model) {

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

        for (FoodTotal foodTotal : ft) {
            if (foodTotal.getDate().getMonthValue() == 1 && foodTotal.getUsername().equals(username)) {
                total1 = total1 + foodTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate("Jan");
                oats.save(oat1);
            }

            if (foodTotal.getDate().getMonthValue() == 2 && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate("Feb");
                oats.save(oat2);
            }


            if (foodTotal.getDate().getMonthValue() == 3 && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate("Mar");
                oats.save(oat3);
            }

            if (foodTotal.getDate().getMonthValue() == 4 && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate("Apr");
                oats.save(oat4);
            }

            if (foodTotal.getDate().getMonthValue() == 5 && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate("May");
                oats.save(oat5);
            }

            if (foodTotal.getDate().getMonthValue() == 6 && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate("Jun");
                oats.save(oat6);
            }

            if (foodTotal.getDate().getMonthValue() == 7 && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate("Jul");
                oats.save(oat7);
            }

            if (foodTotal.getDate().getMonthValue() == 8 && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate("Aug");
                oats.save(oat8);
            }

            if (foodTotal.getDate().getMonthValue() == 9 && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate("Sep");
                oats.save(oat9);
            }

            if (foodTotal.getDate().getMonthValue() == 10 && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate("Oct");
                oats.save(oat10);
            }

            if (foodTotal.getDate().getMonthValue() == 11 && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate("Nov");
                oats.save(oat11);
            }

            if (foodTotal.getDate().getMonthValue() == 12 && foodTotal.getUsername().equals(username)) {
                total12 = total12 + foodTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate("Dec");
                oats.save(oat12);
            }

            List<Double> total = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            List<String> months = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());


            model.addAttribute("total", total);
            model.addAttribute("month", months);

        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);

        List<TransportTotal> tt = tts.listAll();


        for (TransportTotal transTotal : tt) {


            if (transTotal.getDate().getMonthValue() == 1 && transTotal.getUsername().equals(username)) {
                total1 = transTotal.getTotalCo2();
                oat1.setUsername(username);
                oat1.setTotal(total1);
                oat1.setDate("Jan");
                oats.save(oat1);
            }

            if (transTotal.getDate().getMonthValue() == 2 && transTotal.getUsername().equals(username)) {
                total2 = transTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate("Feb");
                oats.save(oat2);
            }


            if (transTotal.getDate().getMonthValue() == 3 && transTotal.getUsername().equals(username)) {
                total3 = transTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate("Mar");
                oats.save(oat3);
            }

            if (transTotal.getDate().getMonthValue() == 4 && transTotal.getUsername().equals(username)) {
                total4 = transTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate("Apr");
                oats.save(oat4);
            }

            if (transTotal.getDate().getMonthValue() == 5 && transTotal.getUsername().equals(username)) {
                total5 = transTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate("May");
                oats.save(oat5);
            }

            if (transTotal.getDate().getMonthValue() == 6 && transTotal.getUsername().equals(username)) {
                total6 = transTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate("Jun");
                oats.save(oat6);
            }

            if (transTotal.getDate().getMonthValue() == 7 && transTotal.getUsername().equals(username)) {
                total7 = transTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate("Jul");
                oats.save(oat7);
            }

            if (transTotal.getDate().getMonthValue() == 8 && transTotal.getUsername().equals(username)) {
                total8 = transTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate("Aug");
                oats.save(oat8);
            }

            if (transTotal.getDate().getMonthValue() == 9 && transTotal.getUsername().equals(username)) {
                total9 = transTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate("Sep");
                oats.save(oat9);
            }

            if (transTotal.getDate().getMonthValue() == 10 && transTotal.getUsername().equals(username)) {
                total10 = transTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate("Oct");
                oats.save(oat10);
            }

            if (transTotal.getDate().getMonthValue() == 11 && transTotal.getUsername().equals(username)) {
                total11 = transTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate("Nov");
                oats.save(oat11);
            }

            if (transTotal.getDate().getMonthValue() == 12 && transTotal.getUsername().equals(username)) {
                total12 = total12 + transTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total12);
                oat12.setDate("Dec");
                oats.save(oat12);
            }

            List<Double> totalTrans = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            List<String> monthsTrans = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());


            model.addAttribute("totalTrans", totalTrans);
            model.addAttribute("monthTrans", monthsTrans);

        }
        deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);
        return "statistics";

    }
}



