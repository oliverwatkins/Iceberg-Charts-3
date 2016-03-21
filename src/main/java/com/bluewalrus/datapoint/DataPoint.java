package com.bluewalrus.datapoint;

import java.io.Serializable;
import java.util.Date;

import com.bluewalrus.point.UIPointXY;

/**
 * Super type for boxplots, bar, multibar, piechart, bubble etc. But used individually for
 * things like scatter chart
 * 
 */
public class DataPoint implements Serializable{

    public double x;
    public Date xDate;
    
    public double y;

    public String name; //may have a name
    
    
    public UIPointXY uiPointXY;

	public DataPoint() {
	}
    /**
     * Y point only. The X value is determined by an equally spaced bar chart
     *
     * @param y
     */
    public DataPoint(double y) {
        this.y = y;
    }

    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public DataPoint(Date date, double y) {
        this.xDate = date;
        this.y = y;
    }



	public void setPoinUI(UIPointXY uiPointXY) {
		
		this.uiPointXY = uiPointXY;
		
	}

	@Override
	public String toString() {
		return "DataPoint [x=" + x + ", xDate=" + xDate + ", y=" + y
				+ ", name=" + name + ", uiPointXY=" + uiPointXY + "]";
	}

}
