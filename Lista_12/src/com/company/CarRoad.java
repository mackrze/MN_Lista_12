package com.company;

public class CarRoad implements CalculateAcceleration {

    private double m;
    private double c;
    private double u;

    public CarRoad(double m, double c, double u) {
        this.m = m;
        this.c = c;
        this.u = u;
    }

    @Override
    public double a(double v) {
        return -u * 9.81 - (c * v * v) / m;
    }
}
