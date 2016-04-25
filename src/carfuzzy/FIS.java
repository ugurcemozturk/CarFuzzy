/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfuzzy;

import carfuzzy.CarSystem.Distance;
import carfuzzy.CarSystem.Output;
import carfuzzy.CarSystem.Speed;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ugurcem
 */
public class FIS {

    public FIS() {
    }

    private Speed speed;
    private Distance distance;
    private Output output;
    private double speedMembership;
    private double distanceMembership;
    private double implicationMembership;
    private double aggregationMembership;

    private XYSeries speedInput = new XYSeries("Crisp Speed Input");
    private XYSeries implication= new  XYSeries(" Implication"); 
    private XYSeries aggregation= new XYSeries("Aggregation"); 
    private XYSeries distanceInput = new  XYSeries("Crisp Distance Input");

    private XYSeriesCollection aggregationDataset = new XYSeriesCollection();
    private XYSeriesCollection implicationDataset = new XYSeriesCollection();
    private XYSeriesCollection speedDataset = new XYSeriesCollection();
    private XYSeriesCollection distanceDataset = new XYSeriesCollection();

    private JFreeChart speedChart;
    private JFreeChart distanceChart;
    private JFreeChart outputChart;
    private JFreeChart implicationChart;
    private JFreeChart aggregationChart;
    private JFreeChart defuzzifyChart;

    private ChartPanel speedCP = new ChartPanel(speedChart);
    private ChartPanel distanceCP = new ChartPanel(distanceChart);
    private ChartPanel outputCP = new ChartPanel(outputChart);
    private ChartPanel implicationCP = new ChartPanel(implicationChart);
    private ChartPanel aggregationCP = new ChartPanel(aggregationChart);
    private ChartPanel defuzzifyCP;

  

    public XYSeries getImplication() {
        return implication;
    }

    public void setImplication(XYSeries implication) {
        this.implication = implication;
    }

    public XYSeries getAggregation() {
        return aggregation;
    }

    public void setAggregation(XYSeries aggregation) {
        this.aggregation = aggregation;
    }

    public XYSeriesCollection getAggregationDataset() {
        return aggregationDataset;
    }

    public void setAggregationDataset(XYSeriesCollection aggregationDataset) {
        this.aggregationDataset = aggregationDataset;
    }

    public XYSeriesCollection getImplicationDataset() {
        return implicationDataset;
    }

    public void setImplicationDataset(XYSeriesCollection implicationDataset) {
        this.implicationDataset = implicationDataset;
    }

    public ChartPanel getSpeedCP() {
        return speedCP;
    }

    public void setSpeedCP(ChartPanel speedCP) {
        this.speedCP = speedCP;
    }

    public ChartPanel getDistanceCP() {
        return distanceCP;
    }

    public void setDistanceCP(ChartPanel distanceCP) {
        this.distanceCP = distanceCP;
    }

    public ChartPanel getOutputCP() {
        return outputCP;
    }

    public void setOutputCP(ChartPanel outputCP) {
        this.outputCP = outputCP;
    }

    public ChartPanel getImplicationCP() {
        return implicationCP;
    }

    public void setImplicationCP(ChartPanel implicationCP) {
        this.implicationCP = implicationCP;
    }

    public ChartPanel getAggregationCP() {
        return aggregationCP;
    }

    public void setAggregationCP(ChartPanel aggregationCP) {
        this.aggregationCP = aggregationCP;
    }

    public ChartPanel getDefuzzifyCP() {
        return defuzzifyCP;
    }

    public void setDefuzzifyCP(ChartPanel defuzzifyCP) {
        this.defuzzifyCP = defuzzifyCP;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public XYSeries getSpeedInput() {
        return speedInput;
    }

    public void setSpeedInput(XYSeries speedInput) {
        this.speedInput = speedInput;
    }

    public XYSeries getDistanceInput() {
        return distanceInput;
    }

    public void setDistanceInput(XYSeries distanceInput) {
        this.distanceInput = distanceInput;
    }

    public XYSeriesCollection getSpeedDataset() {
        return speedDataset;
    }

    public void setSpeedDataset(XYSeriesCollection speedDataset) {
        this.speedDataset = speedDataset;
    }

    public XYSeriesCollection getDistanceDataset() {
        return distanceDataset;
    }

    public void setDistanceDataset(XYSeriesCollection distanceDataset) {
        this.distanceDataset = distanceDataset;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public double getSpeedMembership() {
        return speedMembership;
    }

    public void setSpeedMembership(double speedMembership) {
        this.speedMembership = speedMembership;
    }

    public double getDistanceMembership() {
        return distanceMembership;
    }

    public void setDistanceMembership(double distanceMembership) {
        this.distanceMembership = distanceMembership;
    }

    public double getImplicationMembership() {
        return implicationMembership;
    }

    public void setImplicationMembership(double implicationMembership) {
        this.implicationMembership = implicationMembership;
    }

    public double getAggregationMembership() {
        return aggregationMembership;
    }

    public void setAggregationMembership(double aggregationMembership) {
        this.aggregationMembership = aggregationMembership;
    }

    public JFreeChart getSpeedChart() {
        return speedChart;
    }

    public void setSpeedChart(JFreeChart speedChart) {
        this.speedChart = speedChart;
    }

    public JFreeChart getDistanceChart() {
        return distanceChart;
    }

    public void setDistanceChart(JFreeChart distanceChart) {
        this.distanceChart = distanceChart;
    }

    public JFreeChart getOutputChart() {
        return outputChart;
    }

    public void setOutputChart(JFreeChart outputChart) {
        this.outputChart = outputChart;
    }

    public JFreeChart getImplicationChart() {
        return implicationChart;
    }

    public void setImplicationChart(JFreeChart implicationChart) {
        this.implicationChart = implicationChart;
    }

    public JFreeChart getAggregationChart() {
        return aggregationChart;
    }

    public void setAggregationChart(JFreeChart aggregationChart) {
        this.aggregationChart = aggregationChart;
    }

    public JFreeChart getDefuzzifyChart() {
        return defuzzifyChart;
    }

    public void setDefuzzifyChart(JFreeChart defuzzifyChart) {
        this.defuzzifyChart = defuzzifyChart;
    }

}
