package com.bluewalrus.bar;

import java.awt.Color;

/**
 * @copyright 2014
 * @author Oliver Watkins (www.blue-walrus.com)
 *
 * All Rights Reserved
 * 
 */
@Deprecated //either a pointui or datapoint . why was this deprecated?? hmmmm... replace with UIPointbar? still being used in YY
public class Bar {

    GradiantRule gradiantRule;

    public double bottomValue = 0;

    public double value;
    public Color color;
    public String name;

    public Bar(double value, GradiantRule gradiantRule, String name) {
        this.value = value;
        this.color = gradiantRule.getColor(value);
        this.name = name;
    }

    public Bar(double value, Color color, String name) {
        this.value = value;
        this.color = color;
        this.name = name;
    }
}
