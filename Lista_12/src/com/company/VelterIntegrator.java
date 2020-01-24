package com.company;

public class VelterIntegrator {

    private double dt;

    public VelterIntegrator(double dt) {
        this.dt = dt;
    }

    public void integrate(CalculateAcceleration calculateAcceleration, ODEUpdate odeUpdate, double tStart, double tStop, double x0, double v0) {

        int nSteps = (int) ((tStop - tStart) / dt); //liczba krokow
        double x = x0; // wartosci poczatkowe
        double v = v0;
        double t = tStart;

        odeUpdate.update(t, x, v); //

        double a = calculateAcceleration.a(x); // obliczenie przyspieszenia

        for (int i = 0; i < nSteps; i++) {

            double vHalf = v + dt * a / 2; // 1 krok, V 1/2
            double xNew = x + dt * vHalf;
            double aNew = calculateAcceleration.a(xNew);
            double vNew = v + dt * (a + aNew) / 2;

            a = aNew;
            t += dt;
            x = xNew;
            v = vNew;

            odeUpdate.update(t, x, v);

        }

    }
}
