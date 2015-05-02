/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluewalrus.chart;

import com.bluewalrus.bar.Interval;
import com.bluewalrus.renderer.LineRenderer;
import com.bluewalrus.bar.Category;
import com.bluewalrus.bar.Legendable;
import com.bluewalrus.bar.XAxis;
import com.bluewalrus.bar.XYDataSeries;
import com.bluewalrus.bar.XYDataSeriesType;
import com.bluewalrus.bar.YAxis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class XYChart extends Chart implements Legendable {

    public YAxis yAxis;
    public XAxis xAxis;

    public ArrayList<XYDataSeries> data = new ArrayList<XYDataSeries>();
    
    public XYChart(XAxis xAxis, YAxis yAxis) {
        this.yAxis = yAxis;
        this.xAxis = xAxis;
    }

    protected void drawGrid(Graphics2D g) {

        yAxis.drawYGridLineOnZero(g, this);

        drawGridLine(yAxis.interval3, g, 1);
        drawGridLine(yAxis.interval2, g, 1);
        drawGridLine(yAxis.interval1, g, 1);

        drawGridLine(xAxis.interval3, g, 0);
        drawGridLine(xAxis.interval2, g, 0);
        drawGridLine(xAxis.interval1, g, 0);
    }

    private void drawGridLine(Interval tick, Graphics2D g, int type) {

        if (tick != null && tick.graphLine != null) {
            if (type == 1) //type is y
            {
                yAxis.drawGridLine(tick, g, this);
            } else {
                xAxis.drawGridLine(tick, g, this);
            }
        }
    }

    /**
     * All XY Types need to have this. If you forget to call this your chart is
     * kinda gonna suck.
     *
     * @param g2d
     */
    protected void prePaint(Graphics2D g2d) {

        this.calculateHeighAndWidthOfChart();

        drawBackground(g2d);
        drawBottomLine(g2d);
        drawLeftLine(g2d);

        drawTitle(g2d);

        drawGrid(g2d);

        yAxis.drawIntervals(g2d, this);
        yAxis.drawIntervalLabels(this.yAxis.interval1.increment, g2d, Color.BLACK, this);
        yAxis.drawLabel(g2d, this);

    }

    public XYChart(ArrayList<XYDataSeries> listOfSeries, YAxis yAxis, XAxis xAxis) {
        this(xAxis, yAxis);
        this.data.addAll(listOfSeries);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        this.prePaint(g2d);

        xAxis.drawIntervals(g, this);

        System.out.println("xAxis.drawTickLabels(this.yAxis.tick1.increment " + this.yAxis.interval1.increment);

        xAxis.drawAllIntervalLabels(g, this);

        xAxis.drawLabel(g, this);

        xAxis.drawBorderLine(g2d, this);
        yAxis.drawBorderLine(g2d, this);

        drawGraph(g2d);

        drawLegend(g2d);
    }

    @Override
    protected void drawGraph(Graphics g) {
        LineRenderer.drawLinesOrPoints((Graphics2D) g, this, yAxis, xAxis, data);
    }

    @Override
    public void drawLegend(Graphics2D g) {

        ArrayList<Category> categories = new ArrayList<Category>();

        if (data.size() == 1) {
            return;
        }

        for (XYDataSeries series : data) {

            Category category;

            if (series.type == XYDataSeriesType.BUBBLE) {
                category = new Category(series.name, series.seriesColor);
            } else {
                category = new Category(series.name, series.point, series.line);
            }
            categories.add(category);
        }
        super.drawLegend(g, categories);
    }
}
