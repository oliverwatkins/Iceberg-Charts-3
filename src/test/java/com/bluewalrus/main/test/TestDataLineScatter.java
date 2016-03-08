//package com.bluewalrus.main.test;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//
//import com.bluewalrus.bar.GridLine;
//import com.bluewalrus.bar.Line;
//import com.bluewalrus.bar.XYDataSeries;
//import com.bluewalrus.chart.Chart;
//import com.bluewalrus.chart.XYChart;
//import com.bluewalrus.chart.axis.NumericalInterval;
//import com.bluewalrus.chart.axis.XAxis;
//import com.bluewalrus.chart.axis.YAxis;
//import com.bluewalrus.chart.draw.LinearNumericalAxisDrawX;
//import com.bluewalrus.chart.draw.LinearNumericalAxisDrawY;
//import com.bluewalrus.datapoint.DataPoint;
//import com.bluewalrus.datapoint.DataPointBoxPlot;
//import com.bluewalrus.point.UIPointBoxPlot;
//import com.bluewalrus.point.UIPointCircle;
//import com.bluewalrus.point.UIPointSquare;
//import com.bluewalrus.point.UIPointTriangle;
//
//public class TestDataLineScatter extends ChartTester {
//
//	public static void main(String[] s) {
////		getChart();
//	}
//
//	
//	
//	
//
//
//	
//	
//	
//	
////	xySeriesList.add(new XYDataSeries(values, "First"));
////	xySeriesList.add(new XYDataSeries(values2, "Second"));
////	xySeriesList.add(new XYDataSeries(values3, "Third"));
//	
//	
//
//	public static XYChart getTestData_Scatter() {
//
//		ArrayList<XYDataSeries> xySeriesList = new ArrayList<XYDataSeries>();
//
//		ArrayList<DataPoint> values = new ArrayList<DataPoint>();
//		ArrayList<DataPoint> values2 = new ArrayList<DataPoint>();
//
//		values.add(new DataPoint(10, 73));
//		values.add(new DataPoint(15, 12));
//		values.add(new DataPoint(18, 61));
//		values.add(new DataPoint(45, 16));
//		values.add(new DataPoint(16, 13));
//		values.add(new DataPoint(35, 33));
//		values.add(new DataPoint(48, 67));
//		values.add(new DataPoint(55, 10));
//		values.add(new DataPoint(20, 12));
//		values.add(new DataPoint(35, 35));
//		values.add(new DataPoint(48, 63));
//		values.add(new DataPoint(46, 12));
//
//		values.add(new DataPoint(47, 23));
//		values.add(new DataPoint(46, 19));
//		values.add(new DataPoint(48, 15));
//		values.add(new DataPoint(32, 18));
//		values.add(new DataPoint(38, 17));
//		values.add(new DataPoint(39, 14));
//		values.add(new DataPoint(49, 19));
//		values.add(new DataPoint(41, 12));
//
//		values2.add(new DataPoint(45, 21));
//		values2.add(new DataPoint(44, 14));
//		values2.add(new DataPoint(42, 17));
//		values2.add(new DataPoint(36, 11));
//		values2.add(new DataPoint(33, 21));
//		values2.add(new DataPoint(32, 17));
//		values2.add(new DataPoint(46, 14));
//		values2.add(new DataPoint(54, 21));
//
//		XYDataSeries series = new XYDataSeries(new UIPointSquare(Color.RED, 8),
//				null, "1994");
//
//		series.dataPoints = values;
//
//		XYDataSeries series2 = new XYDataSeries(
//				new UIPointCircle(Color.ORANGE, 8), null, "1995xxxx");
//
//		series2.dataPoints = values2;
//
////		NumericalAxis yAxis = new NumericalAxis(3.0, 100.0, 50.0, 0.0, 0.0, "Length (inches) ");
////		NumericalAxis xAxis = new NumericalAxis(3.0, 100.0, 50.0, 10.0, 0.0, "Weight (kg)");
//		
//		YAxis yAxis = new YAxis(new LinearNumericalAxisDrawY(3.0, 100.0, 50.0, 0.0, 0.0), "Length (inches) ");
//		XAxis xAxis = new XAxis(new LinearNumericalAxisDrawX(3.0, 100.0, 50.0, 10.0, 0.0), "Weight (kg)");
//
//
////		new LinearNumericalAxisDrawY(minValue, maxValue, primaryIncrements, secondaryIncrements, tertiaryIncrements)
//		
//		xySeriesList.add(series);
//		xySeriesList.add(series2);
//		XYChart chart = new XYChart(xySeriesList, yAxis, xAxis);
////		ScatterChart chart = new ScatterChart(xySeriesList, yAxis, xAxis);
//
//		chart.setSize(1000, 500);
//		chart.rightOffset = 200;
//
//		chart.setTitleFont(new Font("Ariel", Font.PLAIN, 24));
//		chart.setTitle("Sea Lion Height versus Weight");
//
//		return chart;
//	}
//
//	public static XYChart getTestData_LineExamples() {
//
//		ArrayList<XYDataSeries> xySeriesList = new ArrayList<XYDataSeries>();
//
//		ArrayList<DataPoint> values1 = new ArrayList<DataPoint>();
//		values1.add(new DataPoint(1, 1));
//		values1.add(new DataPoint(4, 9));
//
//		ArrayList<DataPoint> values2 = new ArrayList<DataPoint>();
//		values2.add(new DataPoint(1, 1));
//		values2.add(new DataPoint(5, 4));
//
//		ArrayList<DataPoint> values3 = new ArrayList<DataPoint>();
//		values3.add(new DataPoint(1, 1));
//		values3.add(new DataPoint(7.5, 6));
//
//		ArrayList<DataPoint> values4 = new ArrayList<DataPoint>();
//		values4.add(new DataPoint(1, 1));
//		values4.add(new DataPoint(9, 9));
//
//		ArrayList<DataPoint> values5 = new ArrayList<DataPoint>();
//		values5.add(new DataPoint(1, 1));
//		values5.add(new DataPoint(8, 7));
//
//		XYDataSeries<DataPoint> series1 = new XYDataSeries<DataPoint>(
//				new UIPointCircle(Color.ORANGE, 15),
//				new Line(Color.RED, true, 11), "1");
//		XYDataSeries<DataPoint> series2 = new XYDataSeries<DataPoint>(
//				new UIPointSquare(Color.PINK), new Line(Color.PINK, true), "2");
//		XYDataSeries<DataPoint> series3 = new XYDataSeries<DataPoint>(
//				new UIPointCircle(Color.BLACK, 23),
//				new Line(Color.BLACK, true, 1), "3");
//		XYDataSeries<DataPoint> series4 = new XYDataSeries<DataPoint>(
//				new UIPointCircle(Color.GRAY), new Line(Color.GRAY), "4");
//		XYDataSeries<DataPoint> series5 = new XYDataSeries<DataPoint>(
//				new UIPointSquare(Color.CYAN), new Line(Color.CYAN), "5");
//
//		series1.dataPoints = values1;
//		series2.dataPoints = values2;
//		series3.dataPoints = values3;
//		series4.dataPoints = values4;
//		series5.dataPoints = values5;
//
//		YAxis yAxis = new YAxis(new LinearNumericalAxisDrawY(-5.0, 10.0, new NumericalInterval(4, 1.0), new NumericalInterval(
//				2, 0.5), null), "y");
//		XAxis xAxis = new XAxis(new LinearNumericalAxisDrawX(0.0, 10.0, 1.0, null, null), "x");
//
//		xySeriesList.add(series1);
//		xySeriesList.add(series2);
//		xySeriesList.add(series3);
//		xySeriesList.add(series4);
//		xySeriesList.add(series5);
//
//		XYChart chart = new XYChart(xySeriesList, yAxis, xAxis);
//
//		chart.setSize(1000, 500);
//		chart.rightOffset = 200;
//
//		chart.setTitleFont(new Font("Ariel", Font.PLAIN, 24));
//		chart.setTitle("xy");
//
//		return chart;
//	}
//
//
//
//
//
//	public static XYChart getTestData_BoxPlot() {
//
//		// TEST_DATA_START
//
//		ArrayList<XYDataSeries> xySeriesList = new ArrayList<XYDataSeries>();
//
//		ArrayList<DataPoint> values = new ArrayList<DataPoint>();
//		values.add(new DataPointBoxPlot(5, 53, 15, 26, 37, 49, 70));
//
//		values.add(new DataPointBoxPlot(10, 73, 15, 26, 37, 49, 70));
//		values.add(new DataPointBoxPlot(20, 50, 1, 25, 50, 75, 99));
//		values.add(new DataPointBoxPlot(30, 73, 20, 25, 32, 38, 76));
//		values.add(new DataPointBoxPlot(40, 73, 20, 40, 46, 73, 84));
//		values.add(new DataPointBoxPlot(50, 73, 23, 34, 39, 72, 89));
//		values.add(new DataPointBoxPlot(60, 73, 33, 36, 45, 58, 80));
//		values.add(new DataPointBoxPlot(70, 73, 38, 41, 45, 49, 57));
//		values.add(new DataPointBoxPlot(80, 73, 42, 45, 55, 63, 69));
//
//		XYDataSeries series = new XYDataSeries(values, new UIPointBoxPlot(
//				new Color(181, 197, 207, 100)), null, "1994");
//
//		YAxis yAxis = new YAxis(new LinearNumericalAxisDrawY(0.0, 100.0, 50.0, 10.0, null), "y Axis");
//		XAxis xAxis = new XAxis(new LinearNumericalAxisDrawX(0.0, 100.0, 50.0, 10.0, null), "x Axis");
//
//		xySeriesList.add(series);
//
//		XYChart chart = new XYChart(xySeriesList, yAxis, xAxis);
//
//		chart.setSize(1000, 500);
//		chart.rightOffset = 200;
//
//		chart.setTitleFont(new Font("Ariel", Font.PLAIN, 24));
//		chart.setTitle("Box Plot");
//
//		return chart;
//	}
//
//	public static Chart getTestData_Math() {
//
//		ArrayList<XYDataSeries> xySeriesList = new ArrayList<XYDataSeries>();
//
//		ArrayList<DataPoint> values = new ArrayList<DataPoint>();
//
//		for (int i = -10; i < 10; i++) {
//			values.add(new DataPoint(i, i * i));
//		}
//
//
//		ArrayList<DataPoint> values3 = new ArrayList<DataPoint>();
//		for (int i = -5; i < 5; i++) {
//
//			double x = Math.exp(i);
//			System.out.println(" x = " + x);
//
//			values3.add(new DataPoint(i, x));
//		}
//
//		XYDataSeries series = new XYDataSeries(new UIPointSquare(Color.BLUE),
//				new Line(Color.BLUE), "x^2");
//		series.dataPoints = values;
//
//		XYDataSeries series3 = new XYDataSeries(new UIPointTriangle(Color.PINK),
//				new Line(Color.PINK), "e^x");
//		series3.dataPoints = values3;
//
//		NumericalInterval t1x = new NumericalInterval(6, 10.0, new GridLine(Color.GRAY, false, 1));
//		NumericalInterval t2x = new NumericalInterval(3, 5.0, new GridLine(Color.LIGHT_GRAY, true, 1));
//		NumericalInterval t3x = new NumericalInterval(1, 1.0, new GridLine(Color.LIGHT_GRAY, true, 1));
//
//		YAxis yAxis = new YAxis(new LinearNumericalAxisDrawY(-10.0, 10.0, t1x, t2x, t3x), "Y Axis");
//
//		XAxis xAxis = new XAxis(new LinearNumericalAxisDrawX(-10.0, 10.0, t1x, t2x, t3x), "X Value");
//
//		xySeriesList.add(series);
//		xySeriesList.add(series3);
//
//		XYChart lineChart = new XYChart(xySeriesList, yAxis, xAxis);
//
//		lineChart.setSize(1000, 500);
//		lineChart.rightOffset = 200;
//
//		lineChart.setTitleFont(new Font("Ariel", Font.PLAIN, 24));
//		lineChart.setTitle("Maths");
//
//		return lineChart;
//	}
//
//}
