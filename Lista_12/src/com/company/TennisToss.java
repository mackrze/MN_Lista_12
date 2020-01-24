package com.company;

public class TennisToss implements CalculateAcceleration {
    @Override
    public double a(double x) {
        return -9.81;
    }
}
