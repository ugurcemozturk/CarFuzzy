/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfuzzy;

import carfuzzy.CarSystem.Distance;
import carfuzzy.CarSystem.Output;
import carfuzzy.CarSystem.Speed;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ugurcem
 */
public class Operations {

    private Speed speed;
    private Distance distance;
    
    XYGraph graph = new XYGraph();
    ResultPanel result = new ResultPanel();
    Rules rules = new Rules();

    public double defuzzify(FIS[] fis) {
        double imp;
        double av;
        double impCount = 0;
        double minX, maxX;
        double res = 0;
        for (int i = 0; i < 4; i++) {
            imp = fis[i].getImplicationMembership();
            impCount += imp;
            minX = fis[i].getOutput().getValue()[0];
            maxX = fis[i].getOutput().getValue()[2];
            av = (maxX - minX) / 2;
            res += imp * av;
        }
        res /= impCount;
        return res;
    }
    /**
     * Creates four Fuzzy Interface System(FIS) object for each rules. Then,
     * calculates and sets their input memberships
     * @param speedCBoxes The selected 'speed' units for rules from JComboBoxes, as a List.
     * @param distanceCBoxes The selected 'distance' units for rules from JComboBoxes, as a List.
     * @param speed The speed input which typed by user, as an integer.
     * @param distance The distance input which typed by user, as an integer.
     */
    public void baseSystem(List<JComboBox> speedCBoxes, List<JComboBox> distanceCBoxes,
            int speed, int distance) {
        
        FIS[] fis = new FIS[4];
        for (int i = 0; i < 4; i++) {
            
            try {                                                                               //Tries to clone an object and cast to XYSeries(Line 84)
                fis[i] = new FIS();                                                             //Creates a new object of Fuzzy Interface System

                fis[i].setSpeedDataset((XYSeriesCollection) graph.speedDataset.clone());
                fis[i].setDistanceDataset((XYSeriesCollection) graph.distanceDataset.clone());

                fis[i].setSpeedMembership(getMembership(speedCBoxes.get(i), speed));
                fis[i].setDistanceMembership(getMembership(distanceCBoxes.get(i), distance));

                fis[i].setSpeed((Speed) speedCBoxes.get(i).getSelectedItem());
                fis[i].setDistance((Distance) distanceCBoxes.get(i).getSelectedItem());
                fis[i].setOutput(rules.table.get(fis[i].getSpeed(), fis[i].getDistance()));

                fis[i].setImplicationMembership(getImplication(fis[i].getSpeedMembership(),
                        fis[i].getDistanceMembership()));

                fis[i].setSpeedChart(setToChart(speed, fis[i].getSpeedMembership(),
                        fis[i].getSpeedInput(), fis[i].getSpeedDataset(), "Speed"));
                fis[i].setDistanceChart(setToChart(distance, fis[i].getDistanceMembership(),
                        fis[i].getDistanceInput(), fis[i].getDistanceDataset(), "Distance"));
                fis[i].setOutputChart(setToChart(graph.outputDataset, "Output"));

                fis[i].setImplication((XYSeries) graph.getOutputDataset(fis[i].getOutput()).clone());

                fis[i].setImplicationChart(setYAxisForImplication(fis[i].getImplicationMembership(),
                        fis[i].getImplication(), fis[i].getImplicationDataset(), fis[i].getOutput()));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }

           

        }
        
        fis[0].setAggregationChart(drawAggregation(fis));
        result.initCharts(fis,defuzzify(fis));
    }

    public JFreeChart drawAggregation(FIS[] fis) {

        XYSeriesCollection aggregationDataset = new XYSeriesCollection();
        for (int i = 0; i < 4; i++) {
            aggregationDataset.addSeries(fis[i].getImplication());
        }
        //aggregationDataset.getSeries(0).setKey("Agjujugregation");
        JFreeChart chart = setToChart(aggregationDataset, "Aggregation");

        XYPlot plot = chart.getXYPlot();
        XYAreaRenderer renderer = new XYAreaRenderer();
        renderer.setSeriesVisibleInLegend(false, true);
        renderer.setSeriesItemLabelsVisible(0, false, true);
        renderer.setSeriesItemLabelsVisible(3, true);
        renderer.setPaint(Color.RED.darker(), true);
        plot.setRenderer(renderer);
        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setRange(0, 10);
        return chart;
    }

    public Operations() {
    }

    public double trapezoidalMembership(int input, double[] boundries) {
        double a, b, c, d;
        a = boundries[0];
        b = boundries[1];
        c = boundries[2];
        d = boundries[3];
        return Double.max(Double.min(Double.min((input - a) / (b - a), 1), (d - input) / (d - c)), 0);
    }

    public double leftTrapezoidalMembership(int input, double[] boundries) { // BOUNDRIESDEN 3 SAYI GELICEK TEKRAR KONTROL ET!!!!!!
        double a = boundries[1], b = boundries[2];
        if (input <= a) {
            return 1d;
        } else if (input >= b) {
            return 0d;
        } else {
            return ((1 / (a - b)) * (input - b));
        }

    }

    public double rightTrapezoidalMembership(int input, double[] boundries) {
        double a = boundries[0], b = boundries[1];
        if (input <= a) {
            return 0d;
        } else if (input >= b) {
            return 1d;
        } else {
            return ((1 / (b - a)) * (input - a));
        }
    }

    public double triangularMembership(double x, double[] boundries) {
        double a = boundries[0],
                b = boundries[1],
                c = boundries[2];
        if (x >= a && x <= c) { // acceptable range {
            double res;
            res = Double.max(Double.min(((x - a) / (b - a)), ((c - x) / (c - b))), 0);
            return res;
        } else {
            return 0;
        }
    }

    public double getMembership(JComboBox s, int input) {
        double membership;
        if (s.getSelectedIndex() == 0) {                                        //veryslow ya da veryclose ise(left Trapezoid)
            if (s.getSelectedItem().getClass() == Speed.class) {
                speed = (Speed) s.getSelectedItem();
                membership = leftTrapezoidalMembership(input, speed.getValue());
                return membership;
            } else {
                distance = (Distance) s.getSelectedItem();
                membership = leftTrapezoidalMembership(input, distance.getValue());
                return membership;

            }
        } else if (s.getSelectedIndex() == s.getItemCount()-1) {                  //veryfast ya da away ise(right Trapezoid)
            if (s.getSelectedItem().getClass() == Speed.class) {
                speed = (Speed) s.getSelectedItem();
                membership = rightTrapezoidalMembership(input, speed.getValue());
                return membership;
            } else {
                distance = (Distance) s.getSelectedItem();
                membership = rightTrapezoidalMembership(input, distance.getValue());
                return membership;
            }

        } else {                                                                // Triangular ise
            if (s.getSelectedItem().getClass() == Speed.class) {
                speed = (Speed) s.getSelectedItem();
                membership = triangularMembership(input, speed.getValue());
                return membership;
            } else {
                distance = (Distance) s.getSelectedItem();
                membership = triangularMembership(input, distance.getValue());
                return membership;
            }
        }
    }

    public double getImplication(double membership1, double membership2) {
        return Double.min(membership1, membership2);
    }

    public JFreeChart setToChart(double input, double membership, XYSeries series, XYSeriesCollection collection, String x_axis) { // kurallari cizdirdikten sonra cizdir.

        series.add(input, membership);
        series.add(input, 0);
        series.add(0, membership);
        collection.addSeries(series);

        JFreeChart chart = XYGraph.drawChart(collection, x_axis, "Membership");
        XYPlot plot = chart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();

        renderer.setSeriesStroke(collection.getSeriesCount() - 1, new BasicStroke(3.5f));
        renderer.setSeriesStroke(collection.getSeriesCount() - 1, new BasicStroke(3.5f));
        plot.setRenderer(renderer);
        return chart;
    }

    public JFreeChart setYAxisForImplication(double imp, XYSeries series, XYSeriesCollection collection, Output out) {
        JFreeChart chart;
        if (out == Output.stop) {
            series.updateByIndex(0, imp);
            series.updateByIndex(1, imp);
            series.updateByIndex(2, imp);
        } else if (out == Output.speedUp) {
            series.updateByIndex(1, imp);
            series.updateByIndex(2, imp);
            series.updateByIndex(3, imp);
        } else {
            series.updateByIndex(1, imp);
            series.updateByIndex(2, imp);
        }
        collection.addSeries(series);
        String x_axis = "Implication";

        chart = XYGraph.drawChart(collection, x_axis, "Membership");
        XYPlot plot = chart.getXYPlot();
        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setRange(0, 10);
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(3.5f));
        return chart;
    }

    public JFreeChart setToChart(XYSeriesCollection collection, String x_axis) {
        return XYGraph.drawChart(collection, x_axis, "Membership");

    }

}
