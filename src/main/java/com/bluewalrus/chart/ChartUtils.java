package com.bluewalrus.chart;

import java.awt.Color;
import java.util.ArrayList;

import com.bluewalrus.bar.Line;
import com.bluewalrus.bar.XYDataSeries;
import com.bluewalrus.datapoint.DataPoint;
import com.bluewalrus.datapoint.DataPointBar;
import com.bluewalrus.point.UIPointCircle;
import com.bluewalrus.point.UIPointSquare;
import com.bluewalrus.point.UIPointTriangle;

public class ChartUtils {

	
	static double calculateXAxisMax(ArrayList<DataPoint> values) {
		double d = getMaxXValue(values);
		return d;
	}

	static double calculateYAxisMin(ArrayList<DataPoint> values) {
		double d = getMinYValue(values);
		return d;
	}

	static double calculateYAxisMax(ArrayList<DataPoint> values) {
		double d = getMaxYValue(values);
		return d;
	}
	static double calculateXAxisMin(ArrayList<DataPoint> values) {
		double d = getMinXValue(values);
		return d;
	}
	
	static double getMinXValue(ArrayList<DataPoint> values) {
		
		double xMin = values.get(0).x;
		for (DataPoint dataPoint : values) {
			if (dataPoint.x < xMin)
				xMin = dataPoint.x;
		}
		return xMin;
	}

	static double getMinYValue(ArrayList<DataPoint> values) {
		double yMin = values.get(0).y;
		for (DataPoint dataPoint : values) {
			if (dataPoint.y < yMin)
				yMin = dataPoint.y;
		}
		return yMin;
	}

	static double getMaxYValue(ArrayList<DataPoint> values) {
		double yMax = values.get(0).y;
		for (DataPoint dataPoint : values) {
			if (dataPoint.y > yMax)
				yMax = dataPoint.y;
		}
		return yMax;
	}

	static double getMaxXValue(ArrayList<DataPoint> values) {
		double xMax = values.get(0).x;
		for (DataPoint dataPoint : values) {
			if (dataPoint.x > xMax)
				xMax = dataPoint.x;
		}
		return xMax;
	}

	public static double calculateYAxisMax(
			ArrayList<XYDataSeries> xySeriesList, boolean b) {

		double max = getMaxYValue(xySeriesList.get(0).dataPoints);
		
		for (XYDataSeries xyDataSeries : xySeriesList) {
			ArrayList<DataPoint> dps = xyDataSeries.dataPoints;
			
			double m = getMaxYValue(dps);
			if (m > max)
				max = m;
		}
		return max;
	}
	
	
	public static DataRange getDataRange(double yMax, double yMin, int paddingPercent) {
		double yDiff = yMax - yMin;
		
		// pad out to 10%
		double yMinAdj = yMin - (yDiff / paddingPercent);
		double yMaxAdj = yMax + (yDiff / paddingPercent);
		
		// Needs to be floored. If decimal place then crashes later
		yMaxAdj = Math.floor(yMaxAdj);
		yMinAdj = Math.floor(yMinAdj);
		
		DataRange drY = new DataRange();
		
		drY.min = yMinAdj;
		drY.max = yMaxAdj;
		return drY;
	}

	public static double calculateYAxisMin(
			ArrayList<XYDataSeries> xySeriesList, boolean b) {
		
		double min = getMinYValue(xySeriesList.get(0).dataPoints);
		
		for (XYDataSeries xyDataSeries : xySeriesList) {
			ArrayList<DataPoint> dps = xyDataSeries.dataPoints;
			
			double m = getMinYValue(dps);
			if (m < min)
				min = m;
		}
		return min;
	}

	public static double calculateXAxisMax(
			ArrayList<XYDataSeries> xySeriesList, boolean b) {
		
		double max = getMaxXValue(xySeriesList.get(0).dataPoints);
		
		for (XYDataSeries xyDataSeries : xySeriesList) {
			ArrayList<DataPoint> dps = xyDataSeries.dataPoints;
			
			double m = getMaxXValue(dps);
			if (m > max)
				max = m;
			
		}
		return max;
	}

	public static double calculateXAxisMin(ArrayList<XYDataSeries> xySeriesList, boolean b) {
		
		double min = getMinXValue(xySeriesList.get(0).dataPoints);
		
		for (XYDataSeries xyDataSeries : xySeriesList) {
			ArrayList<DataPoint> dps = xyDataSeries.dataPoints;
			
			double m = getMinXValue(dps);
			if (m < min)
				min = m;
		}
		return min;
	}
	
	/**
	 * Set up some default styles
	 * 
	 * @param xySeriesList
	 */
	public static void setUpSeriesStyle(ArrayList<XYDataSeries> xySeriesList, XYChart chart) {
		int i = 0;
		for (XYDataSeries xyDataSeries : xySeriesList) {
			
			if (i == 0) {
				xyDataSeries.pointType = new UIPointSquare(Color.BLUE);
				xyDataSeries.line = new Line(Color.BLUE, false, 2);
				
			}else if (i == 1) {
				xyDataSeries.pointType = new UIPointCircle(Color.GREEN);
				xyDataSeries.line = new Line(Color.GREEN, false, 2);
			}else if (i == 2) {
				xyDataSeries.pointType = new UIPointTriangle(Color.RED);
				xyDataSeries.line = new Line(Color.RED, false, 2);
			}else if (i == 3) {
				xyDataSeries.pointType = new UIPointTriangle(Color.CYAN);
				xyDataSeries.line = new Line(Color.CYAN, false, 2);
				
			}else if (i == 4) {
				xyDataSeries.pointType = new UIPointCircle(Color.MAGENTA);
				xyDataSeries.line = new Line(Color.MAGENTA, false, 2);
			}else {
				//create random TODO
			}
			i++;
		}

		chart.rightOffset = 200;
	}
	
	/**
	 * A DataPointBar, should have all its name set to a value, or no values set to name.
	 * 
	 * @param bars
	 */
	public static void validityCheck(ArrayList<DataPointBar> bars) {
		
		DataPointBar firstElem = bars.get(0);
		if (firstElem.name != null) {
			//enumerable
			for (DataPointBar dataPointBar : bars) {
				if (dataPointBar.name == null) {
					throw new RuntimeException("Error : All data points need to be either enumarable or numerical. Some data points have an xName and others do not");
				}
			}
		}
		
		if (firstElem.name == null) {
			//numerical
			for (DataPointBar dataPointBar : bars) {
				if (dataPointBar.name != null) {
					throw new RuntimeException("Error : All data points need to be either enumarable or numerical. Some data points have an xName and others do not");
				}
			}
		}
	}
	
	
}
