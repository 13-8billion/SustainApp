package sustain.project.highCharts;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sustain.project.models.FoodTotal;
import sustain.project.models.OverAllTotal;
import sustain.project.service.FoodTotalService;

@Controller
public class ChartController {

    @Autowired
    private FoodTotalService fts;

//    @GetMapping("/eChartTest")
//    public String showFoodTotal(Model model) {
//
//        List<Double> monthTotals = new ArrayList<>();
//        List<FoodTotal> ft = fts.listAll();
//        OverAllTotal oat = new OverAllTotal();
//
//        int month = 0;
//        double totals = 0;
//
//        for (int i = 0; i < ft.size(); i++) {
//
//            if (ft.get(i).getDate().getMonthValue() == ft.get(i+1).getDate().getMonthValue())
//
//                month = ft.get(i).getDate().getMonthValue();
//
//                totals = totals + ft.get(i).getTotalCo2();
//        }
//
//        oat.setUsername("Test");
//        oat.setTotal(totals);
//        oat.setDate(month);
//
//        return "eChartTest";
//
//    }
}