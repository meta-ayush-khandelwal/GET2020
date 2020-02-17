package com.metacube;

public class AreaOfTriangle {

    public double calculateArea(double side1, double side2, double side3) {

        double halfPoint = (side1 + side2 + side3) / 2;
        return (Math.sqrt(halfPoint * (halfPoint - side1) * (halfPoint - side2)
                * (halfPoint - side3)));
    }
}
