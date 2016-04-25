package carfuzzy;

import carfuzzy.CarSystem.Output;
import carfuzzy.CarSystem.Distance;
import carfuzzy.CarSystem.Speed;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ugurcem
 */
public class XYGraph {

    public XYGraph() {
        setSpeedDataset();
        setDistanceDataset();
        setOutputDataset();
    }
    
    private final XYSeries verySlow = new XYSeries("Very Slow");
    private final XYSeries slow = new XYSeries("Slow");
    private final XYSeries medium = new XYSeries("Medium");
    private final XYSeries fast = new XYSeries("Fast");
    private final XYSeries veryFast = new XYSeries("Very Fast");

    private final XYSeries veryClose = new XYSeries("Very Close");
    private final XYSeries close = new XYSeries("Close");
    private final XYSeries normal = new XYSeries("Normal");
    private final XYSeries away = new XYSeries("Away");

    private final XYSeries stop = new XYSeries("Stop");
    private final XYSeries slowDown = new XYSeries("Slow Down");
    private final XYSeries keepPace = new XYSeries("Keep Place");
    private final XYSeries speedUp = new XYSeries("Speed Up");
 
     XYSeriesCollection speedDataset = new XYSeriesCollection();
     XYSeriesCollection distanceDataset = new XYSeriesCollection();
     XYSeriesCollection outputDataset = new XYSeriesCollection();

    public final void setSpeedDataset() {
        verySlow.add(Speed.verySlow.getValue()[0], 1);
        verySlow.add(Speed.verySlow.getValue()[1], 1);
        verySlow.add(Speed.verySlow.getValue()[2], 0);
        slow.add(Speed.slow.getValue()[0], 0);
        slow.add(Speed.slow.getValue()[1], 1);
        slow.add(Speed.slow.getValue()[2], 0);
        medium.add(Speed.medium.getValue()[0], 0);
        medium.add(Speed.medium.getValue()[1], 1);
        medium.add(Speed.medium.getValue()[2], 0);
        fast.add(Speed.fast.getValue()[0], 0);
        fast.add(Speed.fast.getValue()[1], 1);
        fast.add(Speed.fast.getValue()[2], 0);
        veryFast.add(Speed.veryFast.getValue()[0], 0);
        veryFast.add(Speed.veryFast.getValue()[1], 1);
        veryFast.add(Speed.veryFast.getValue()[2], 1);

        speedDataset.addSeries(verySlow);
        speedDataset.addSeries(slow);
        speedDataset.addSeries(medium);
        speedDataset.addSeries(fast);
        speedDataset.addSeries(veryFast);
    }

    public final void setDistanceDataset() {
        veryClose.add(Distance.veryClose.getValue()[0], 1);
        veryClose.add(Distance.veryClose.getValue()[1], 1);
        veryClose.add(Distance.veryClose.getValue()[2], 0);
        close.add(Distance.close.getValue()[0], 0);
        close.add(Distance.close.getValue()[1], 1);
        close.add(Distance.close.getValue()[2], 0);
        normal.add(Distance.normal.getValue()[0], 0);
        normal.add(Distance.normal.getValue()[1], 1);
        normal.add(Distance.normal.getValue()[2], 0);
        away.add(Distance.away.getValue()[0], 0);
        away.add(Distance.away.getValue()[1], 1);
        away.add(Distance.away.getValue()[2], 1);

        distanceDataset.addSeries(veryClose);
        distanceDataset.addSeries(close);
        distanceDataset.addSeries(normal);
        distanceDataset.addSeries(away);

    }

    public final void setOutputDataset() {                                    
        stop.add(Output.stop.getValue()[0], 1);
        stop.add(Output.stop.getValue()[1], 1);
        stop.add(Output.stop.getValue()[2], 1);
        stop.add(Output.stop.getValue()[3], 0);
        slowDown.add(Output.slowDown.getValue()[0], 0);
        slowDown.add(Output.slowDown.getValue()[1], 1);
        slowDown.add(Output.slowDown.getValue()[2], 1);
        slowDown.add(Output.slowDown.getValue()[3], 0);
        keepPace.add(Output.keepPace.getValue()[0], 0);
        keepPace.add(Output.keepPace.getValue()[1], 1);
        keepPace.add(Output.keepPace.getValue()[2], 1);
        keepPace.add(Output.keepPace.getValue()[3], 0);
        speedUp.add(Output.speedUp.getValue()[0], 0);
        speedUp.add(Output.speedUp.getValue()[1], 1);
        speedUp.add(Output.speedUp.getValue()[2], 1);
        speedUp.add(Output.speedUp.getValue()[3], 0);

        outputDataset.addSeries(stop);
        outputDataset.addSeries(slowDown);
        outputDataset.addSeries(keepPace);
        outputDataset.addSeries(speedUp);
    }

    public final XYSeries getOutputDataset(Output output) {
        switch (output) {
            case stop:
                return this.stop;
            case slowDown:
                return this.slowDown;
            case keepPace:
                return this.keepPace;
            case speedUp:
                return this.speedUp;
        }
        return null;
    }

    public static JFreeChart drawChart(XYSeriesCollection dataset, String X_Axis, String Y_Axis) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                X_Axis,
                Y_Axis,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        XYPlot plot = chart.getXYPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0, 1.1);
        return chart;

    }

}
