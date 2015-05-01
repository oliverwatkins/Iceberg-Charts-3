package com.bluewalrus.point;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.bluewalrus.datapoint.DataPoint;
import com.bluewalrus.renderer.XYFactor;

public class CirclePoint extends SimpleXYPoint {

    public CirclePoint(Color color) {
        super(color);
    }

    public CirclePoint(Color color, int size) {
        super(color, size, .7);
    }

    public CirclePoint(Color color, int size, double transparancyFraction) {
        super(color, size, transparancyFraction);
    }

    public void draw(Graphics2D g, Point point, DataPoint dataPoint, XYFactor xyFactor) {

        int alpha = (int) (transparancyFraction * 255);
        Color c = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);

        g.setColor(c);

        g.fillOval((int) point.x - radiusOrWidthOfPointShape / 2,
                point.y - radiusOrWidthOfPointShape / 2,
                radiusOrWidthOfPointShape,
                radiusOrWidthOfPointShape
        );
    }

}