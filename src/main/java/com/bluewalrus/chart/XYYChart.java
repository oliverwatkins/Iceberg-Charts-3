package com.bluewalrus.chart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.bluewalrus.bar.Bar;
import com.bluewalrus.bar.Category;
import com.bluewalrus.bar.XYDataSeries;
import com.bluewalrus.bar.XYDataSeriesType;
import com.bluewalrus.chart.axis.XAxis;
import com.bluewalrus.chart.axis.YAxis;
import com.bluewalrus.chart.plotter.LineRenderer;
import com.bluewalrus.datapoint.DataPoint;
import com.bluewalrus.datapoint.DataPointBar;
import com.bluewalrus.point.UIPointBar;


/**
 * XXYChart has line/point for one Y axis, and bar for the other Y axis. At this point in time
 * that is all that is planned for this chart.
 * 
 * @author Oliver Watkins
 */
public class XYYChart extends XYChart { 

    public int barWidth = 30;
    public YAxis yAxis2;
    public ArrayList<Bar> bars;
    private XYDataSeries<DataPointBar> barSeries;

    public XYYChart(XAxis xAxis, YAxis yAxis, YAxis yAxis2, ArrayList<Bar> bars, ArrayList<XYDataSeries<?>> xySeriesList) {
        this(xAxis, yAxis, yAxis2, bars, xySeriesList, 10);
    }

    public XYYChart(XAxis xAxis, YAxis yAxis, YAxis yAxis2, ArrayList<Bar> bars, ArrayList<XYDataSeries<?>> lineSeries, int barWidth) {
        super(xAxis, yAxis);

        this.bars = bars;

        this.yAxis2 = yAxis2;

        data = new ArrayList<XYDataSeries>();

        ArrayList<DataPointBar> dataPoints = new ArrayList<DataPointBar>();

        double xRange = (double) (this.xAxis.axisDraw.maxValue - this.xAxis.axisDraw.minValue);

//        space out
        //distance between points
        double pointDistance = (double) (xRange / (bars.size() + 1));

        int i = 1;
        for (Bar bar : bars) {

            int xPoint = (int) (pointDistance * i);

            for (XYDataSeries s : lineSeries) {

                DataPoint dp = (DataPoint) s.dataPoints.get(i - 1);
                dp.x = xPoint;

            }

            dataPoints.add(new DataPointBar(xPoint, (int) bar.value, bar.color, bar.name));
            i++;
        }

        barSeries = new XYDataSeries<DataPointBar>(
                dataPoints,
                new UIPointBar(Color.PINK, Color.YELLOW, this, barWidth),
                null,
                "");

        data.addAll(lineSeries);
    }

    @Override
    protected void drawGraph(Graphics g) {

    	//draw bars first
        drawLinesOrPointsXXY((Graphics2D) g, this, yAxis2, xAxis, barSeries);

        //...then the other series.
        LineRenderer.drawLinesOrPoints((Graphics2D) g, this, yAxis, xAxis, data);

        Graphics2D g2d = (Graphics2D) g;

        drawRightLine(g2d);
        
        yAxis2.rightSide = true;
        
        yAxis2.axisDraw.drawAll(g2d, this, null); //drawTicksAndLabels(g, this);
        
        yAxis2.drawLabel(g, this);

        drawLegend(g2d);
    }
    
    
    public static void drawLinesOrPointsXXY(Graphics2D g, XYChart chart,
            YAxis yAxis, XAxis xAxis, XYDataSeries<DataPointBar> barSeries) {

        ArrayList al = new ArrayList<>();
        al.add(barSeries);

        LineRenderer.drawLinesOrPoints(g, chart, yAxis, xAxis, al);
    }

    /**
     * This is slightly different to the super implementation, because an offset is used where the second
     * y axis is displyed.
     */
    @Override
    public void drawLegend(Graphics2D g) {

        ArrayList<Category> categories = new ArrayList<Category>();

        for (XYDataSeries series : data) {

            Category category;

            if (series.type == XYDataSeriesType.BUBBLE) {
                category = new Category(series.name, series.seriesColor);
            } else {
                category = new Category(series.name, series.pointType, series.line);
            }

            categories.add(category);
        }

        int offset = yAxis2.tickLabelOffset + yAxis2.labelOffset;

        super.drawLegend(g, categories, offset);
    }

}
