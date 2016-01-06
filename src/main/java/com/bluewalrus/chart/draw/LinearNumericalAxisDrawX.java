package com.bluewalrus.chart.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.bluewalrus.bar.XYDataSeries;
import com.bluewalrus.chart.Chart;
import com.bluewalrus.chart.XYChart;
import com.bluewalrus.chart.axis.NumericalInterval;

public class LinearNumericalAxisDrawX extends LinearNumericalAxisDraw{

	
	public LinearNumericalAxisDrawX() {
		super();
	}
	
	public LinearNumericalAxisDrawX(double d, double e) {
		super(d,e);
	}

	public LinearNumericalAxisDrawX(Double primaryIncrements,
									Double secondaryIncrements, 
									Double tertiaryIncrements) {
		
		super(primaryIncrements, secondaryIncrements, tertiaryIncrements);
	}
	public LinearNumericalAxisDrawX(Double minValue, 
									Double maxValue,
									NumericalInterval interval1, 
									NumericalInterval interval2, 
									NumericalInterval interval3) {
		
		super(minValue, maxValue, interval1, interval2, interval3);
	}
	public LinearNumericalAxisDrawX(Double minValue, 
									Double maxValue,
									Double primaryIncrements, 
									Double secondaryIncrements,
									Double tertiaryIncrements) {
		
		super(minValue, maxValue, primaryIncrements, secondaryIncrements, tertiaryIncrements);
	}
	
	
	
	////////////////

	
	@Override
	public void drawAll(Graphics2D g2d, XYChart xyChart, ArrayList<XYDataSeries> data) {
		
		//NOTE! data is ignored here. It's only used for enumeration

		
		drawAllIntervalTickAndLabels(g2d, xyChart);
		
		drawGridLines(g2d, xyChart);
	}
	
	protected void drawIntervalLabel(NumericalInterval interval, Graphics g, 
			XYChart chart, int incrementNumber, double incrementInPixel) {
		
		g.setColor(chart.xAxis.axisColor);
    	
		Double increment = interval.getInterval();
		
        double factor = getMultiplicationFactor(chart); 
        
        //to first increment
    	double toFirstInPixels = getToFirstIntervalValueFromMinInPixels(increment, factor);
    	
    	double toFirst = getToFirstIntervalValueFromMin(increment);
    	
        String xLabel = "" + ((incrementNumber * increment) + toFirst);
        
        double fromLeft = getFromLeft(chart, toFirstInPixels, incrementInPixel,incrementNumber);
        
        /**
         * Draw X Label
         */
        XAxisDrawUtil.drawXLabel(g, chart, fromLeft, xLabel, chart.xAxis);
	}
	
	
	protected void drawIntervalTick(NumericalInterval interval, Graphics g, 
			XYChart chart, int i, double incrementInPixel) {
		
		g.setColor(chart.xAxis.axisColor);
		
		double factor = getMultiplicationFactor(chart); 
		
        //to first increment
    	double toFirstInPixels = getToFirstIntervalValueFromMinInPixels(interval.getInterval(), factor);
		
        double fromLeft = getFromLeft(chart, toFirstInPixels, incrementInPixel, i);
        
        XAxisDrawUtil.drawIntervalTick(interval, g, chart, fromLeft, chart.xAxis);
		
	}
	
    @Override
    public void drawGridLine(NumericalInterval interval, Graphics2D g, XYChart chart) {

		double factor = getMultiplicationFactor(chart); 
    	
        //to first increment
    	double toFirstInPixels = getToFirstIntervalValueFromMinInPixels(interval.getInterval(), factor);

        int incrementNo = (int) (maxValue / interval.getInterval());
        
        double incrementInPixel = (double) (interval.getInterval() * factor);

        g.setColor(interval.graphLine.color);

        for (int i = 0; i < incrementNo; i++) {
        	
            double fromLeft = getFromLeft(chart, toFirstInPixels, incrementInPixel, i);
            
            /**
             * Draw Grid line
             */
            XAxisDrawUtil.drawGridLine(interval, g, chart, fromLeft);
        }
    }
    
	@Override
	protected void drawGridLineOnZero(Graphics2D g) {
		// TODO 
		
	}
    
    @Override
	public void drawGridLineOnZero(Graphics2D g, XYChart chart) {
    	
        //TODO draw X Line
//    	XAxisDrawUtil.drawXGridLineOnZero(g, chart, -999, chart.xAxis);
    }
    
    
    
	private double getFromLeft(Chart chart, double toFirstInPixels, double incrementInPixel, int i) {
		double fromLeft = chart.leftOffset +  (i * incrementInPixel) + toFirstInPixels;
		return fromLeft;
	}
    
	@Override
	protected double getMultiplicationFactor(XYChart chart) {
    	return ((double) chart.widthChart / (double) (maxValue - minValue));

	}
}
