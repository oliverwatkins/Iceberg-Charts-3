package com.bluewalrus.scaling;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.bluewalrus.chart.Orientation;
import com.bluewalrus.chart.XYChart;
import com.bluewalrus.chart.XYDataSeries;

public abstract class EnumerationAxisScaling extends AxisScaling{

	//enum has always 0 to 100. It is arbitrary.
	public double maxValue = 100; 
	public double minValue = 0; 
	
	protected EnumerationAxisScaling(Orientation orientation) {
		super(orientation);
		
		maxValue = 100; 
		minValue = 0; 
	}
	
	
}
