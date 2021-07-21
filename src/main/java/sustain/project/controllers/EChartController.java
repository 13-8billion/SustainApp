package sustain.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sustain.project.eCharts.EChartData;
import sustain.project.eCharts.SustainEchartService;
import sustain.project.models.FoodTotal;
import sustain.project.models.OverAllTotal;
import sustain.project.service.CustomUserDetailsService;
import sustain.project.service.FoodTotalService;
import sustain.project.service.OverAllTotalService;

import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;



//@RestController
//@RequestMapping(value = "/echart")
@Controller
public class EChartController {

    private static final int DATA_COUNT = 12;

    @Autowired
    private CustomUserDetailsService userDetails;
    @Autowired
    private FoodTotalService fts;
    @Autowired
    private OverAllTotalService oats;

    // METHODS

    @GetMapping("/stats")
    public String showAnnualFood(Model model) {

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
//                oat1.setDate(1);
                oats.save(oat1);
            }

            if (foodTotal.getDate().getMonthValue() == 2 && foodTotal.getUsername().equals(username)) {
                total2 = total2 + foodTotal.getTotalCo2();
                oat2.setUsername(username);
                oat2.setTotal(total2);
                oat2.setDate("Feb");
//                oat2.setDate(2);
                oats.save(oat2);
            }


            if (foodTotal.getDate().getMonthValue() == 3 && foodTotal.getUsername().equals(username)) {
                total3 = total3 + foodTotal.getTotalCo2();
                oat3.setUsername(username);
                oat3.setTotal(total3);
                oat3.setDate("Mar");
//                oat3.setDate(3);
                oats.save(oat3);
            }

            if (foodTotal.getDate().getMonthValue() == 4 && foodTotal.getUsername().equals(username)) {
                total4 = total4 + foodTotal.getTotalCo2();
                oat4.setUsername(username);
                oat4.setTotal(total4);
                oat4.setDate("Apr");
//                oat4.setDate(4);
                oats.save(oat4);
            }

            if (foodTotal.getDate().getMonthValue() == 5 && foodTotal.getUsername().equals(username)) {
                total5 = total5 + foodTotal.getTotalCo2();
                oat5.setUsername(username);
                oat5.setTotal(total5);
                oat5.setDate("May");
//                oat5.setDate(5);
                oats.save(oat5);
            }

            if (foodTotal.getDate().getMonthValue() == 6 && foodTotal.getUsername().equals(username)) {
                total6 = total6 + foodTotal.getTotalCo2();
                oat6.setUsername(username);
                oat6.setTotal(total6);
                oat6.setDate("Jun");
//                oat6.setDate(6);
                oats.save(oat6);
            }

            if (foodTotal.getDate().getMonthValue() == 7 && foodTotal.getUsername().equals(username)) {
                total7 = total7 + foodTotal.getTotalCo2();
                oat7.setUsername(username);
                oat7.setTotal(total7);
                oat7.setDate("Jul");
//                oat7.setDate(7);
                oats.save(oat7);
            }

            if (foodTotal.getDate().getMonthValue() == 8 && foodTotal.getUsername().equals(username)) {
                total8 = total8 + foodTotal.getTotalCo2();
                oat8.setUsername(username);
                oat8.setTotal(total8);
                oat8.setDate("Aug");
//                oat8.setDate(8);
                oats.save(oat8);
            }

            if (foodTotal.getDate().getMonthValue() == 9 && foodTotal.getUsername().equals(username)) {
                total9 = total9 + foodTotal.getTotalCo2();
                oat9.setUsername(username);
                oat9.setTotal(total9);
                oat9.setDate("Sep");
//                oat9.setDate(9);
                oats.save(oat9);
            }

            if (foodTotal.getDate().getMonthValue() == 10 && foodTotal.getUsername().equals(username)) {
                total10 = total10 + foodTotal.getTotalCo2();
                oat10.setUsername(username);
                oat10.setTotal(total10);
                oat10.setDate("Oct");
//                oat10.setDate(10);
                oats.save(oat10);
            }

            if (foodTotal.getDate().getMonthValue() == 11 && foodTotal.getUsername().equals(username)) {
                total11 = total11 + foodTotal.getTotalCo2();
                oat11.setUsername(username);
                oat11.setTotal(total11);
                oat11.setDate("Nov");
//                oat11.setDate(11);
                oats.save(oat11);
            }

            if (foodTotal.getDate().getMonthValue() == 12 && foodTotal.getUsername().equals(username)) {
                total12 = total12 + foodTotal.getTotalCo2();
                oat12.setUsername(username);
                oat12.setTotal(total10);
                oat12.setDate("Dec");
//                oat12.setDate(12);
                oats.save(oat12);
            }

            List<Double> total = oats.listAll().stream().map(x -> x.getTotal()).collect(Collectors.toList());
            List<String> months = oats.listAll().stream().map(x -> x.getDate()).collect(Collectors.toList());


            model.addAttribute("total", total);
            model.addAttribute("month", months);

        }
        Iterable<OverAllTotal> deleteTotalObject = oats.listAll();
        oats.deleteAll(deleteTotalObject);
        return "eChartTest";

    }




    @RequestMapping("/line")
    public EChartData line() {

        SustainEchartService service = new SustainEchartService();

        service.setTitle("Total Food CO2");
        service.setSubTitle("All Time");

        // X轴
        service.setXData(getXAxis());

        // 数据
        service.addLine("Food", createD(listft()));
//        service.addLine("Travel", createData(DATA_COUNT));

        return service.getData();
    }

    @RequestMapping("/bar")
    public EChartData bar() {

        SustainEchartService service = new SustainEchartService();

        service.setTitle("Total Food CO2");
        service.setSubTitle("All Time");

        // X轴
        service.setXData(getXAxis());

        // 数据
        service.addBar("Food", createData(DATA_COUNT));
//        service.addBar("柱2", createData(DATA_COUNT));

        return service.getData();
    }

    @RequestMapping("/lineAndBar")
    public EChartData lineAndBar() {

        SustainEchartService service = new SustainEchartService();

        service.setTitle("Total Food CO2");
        service.setSubTitle("All Time");

        // X轴
        service.setXData(getXAxis());

        // 数据
        service.addLine("Food", createData(DATA_COUNT));
//        service.addBar("柱1", createData(DATA_COUNT));

        return service.getData();
    }

    @RequestMapping("/pie")
    public EChartData pie() {

        SustainEchartService service = new SustainEchartService();

        service.setTitle("Total Food");

        // 数据
        service.addPie("Food", createMapData(5));

        return service.getData();
    }


    /**
     * 产生数据
     *
     * @param count
     * @return
     */


    private List<Double> createData(int count) {
        List<FoodTotal> db = fts.listAll();
        List<Double> data = new ArrayList<>();
        String username = userDetails.returnUsername();
        CharSequence myDate = "2021-07-16";
        LocalDate jan = LocalDate.parse(myDate);


        for (int i = 0; i < count; i++) {

                    if (db.get(i).getUsername().equals(username) && db.get(i).getDate().equals(jan))
                        data.add(db.get(i).getTotalCo2());
        }
        return data;
    }

    private int listft(){
        List<FoodTotal> db = fts.listAll();

        return db.size();

    }

    /**
     * 产生数据
     *
     * @param size
     * @return
     */
    private List<Double> createD(int size) {

        List<FoodTotal> db = fts.listAll();
        List<Double> data = new ArrayList<>();
        String username = userDetails.returnUsername();
        CharSequence myDate = "2021-07-16";
        LocalDate jan = LocalDate.parse(myDate);


        for (int i = 0; i < size; i++) {

            if (db.get(i).getUsername().equals(username))
                data.add(db.get(i).getTotalCo2());
//            }
        }
        return data;
    }


    private List<String> getXAxis() {
        List<String> dateList = new ArrayList<>();
        dateList.add("Jan");
        dateList.add("Feb");
        dateList.add("Mar");
        dateList.add("Apr");
        dateList.add("May");
        dateList.add("Jun");
        dateList.add("Jul");
        dateList.add("Aug");
        dateList.add("Sep");
        dateList.add("Oct");
        dateList.add("Nov");
        dateList.add("Dec");

        return dateList;
    }

    /**
     * 构建饼图的数据
     *
     * @param count
     * @return
     */
    private LinkedHashMap<String, Float> createMapData(int count) {
        LinkedHashMap<String, Float> result = new LinkedHashMap<>(count);
        for (int j = 1; j <= count; j++) {
            result.put(j + "Month", new Random().nextFloat());
        }

        return result;
    }



}
