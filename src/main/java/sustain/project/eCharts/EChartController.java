package sustain.project.eCharts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sustain.project.models.FoodTotal;
import sustain.project.service.CustomUserDetailsService;
import sustain.project.service.FoodTotalService;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

import java.util.*;
import java.util.ArrayList;


@RestController
@RequestMapping(value = "/echart")
public class EChartController {

    private static final int DATA_COUNT = 12;

    @Autowired
    private CustomUserDetailsService userDetails;

    @Autowired
    private FoodTotalService fts;

    @RequestMapping("/line")
    public EChartData line() {

        SustainEchartService service = new SustainEchartService();

        service.setTitle("Total Food CO2");
        service.setSubTitle("All Time");

        // X轴
        service.setXData(getXAxis());

        // 数据
        service.addLine("Food", createData(DATA_COUNT));
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
//            for (int j = 0; j < dateList.size(); j++) {

                    // changed date variable to string from LocalDate type.. check how to use type
                //dateList.get(j).equals("Jan") &&

            //db.get(i).getUsername().equals(username) &&

                    if (db.get(i).getUsername().equals(username) && db.get(i).getDate().equals(jan))
                        data.add(db.get(i).getTotalCo2());
//            }
        }
        return data;
    }

//    FoodTotalService fts;
//    private List<FoodTotal> createData(int count) {
//        List<FoodTotal> DB = fts.listAll();
//        List<FoodTotal> totals = new ArrayList<>();
//        double res = 0;
//
//        String username = userDetails.returnUsername();
//
//        for (int i = 0; i < count; i++) {
//
//            for (int j = 0; j < DB.size(); j++) {
//
//                if (DB.get(j).getUsername().equals(username))
//
//                    res = DB.get(j).getTotalCo2();
//            }
//            totals.add(new FoodTotal(res));
//        }
//        return totals;
//    }


    private ArrayList<String> getXAxis() {
        ArrayList<String> dateList = new ArrayList<>();
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
