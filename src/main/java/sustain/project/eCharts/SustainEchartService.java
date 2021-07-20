package sustain.project.eCharts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SustainEchartService {

    List<SustainSeries> series;

    private List<String> xaxis;

    private String title = "", subTitle = "";

    private EChartData chartData;

    public SustainEchartService () {
        this.series = new ArrayList<>();

        chartData = new EChartData();
    }

    public EChartData getData() {
        chartData.setTitle(title);
        chartData.setSeries(series);
        chartData.setXaxis(xaxis);
        chartData.setSubTitle(subTitle);

        return chartData;
    }

    public void addLine(String name, List<?> data) {
        addData(name, "line", data);
    }

    public void addBar(String name, List<?> data) {
        addData(name, "bar", data);
    }



    /**
     *
     * @param name
     * @param chartType
     *            bar，line，K（此时data是一个是个浮点数的数组）
     * @param data
     */
    private void addData(String name, String chartType, List<?> data) {
        SustainSeries s = new SustainSeries();

        s.setName(name);
        s.setType(chartType);
        s.setData(data);

        this.series.add(s);
    }

    public void setXData(List<String> xAxis) {
        this.xaxis = xAxis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void addPie(String name, LinkedHashMap<String, Float> data) {
        chartData.setName(name);
        chartData.setData(data);
    }

}
