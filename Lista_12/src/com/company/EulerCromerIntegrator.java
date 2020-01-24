package com.company;

public class EulerCromerIntegrator {

    private double dt;

    public EulerCromerIntegrator(double dt) {
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
            double vNew = v + a * dt;
            double xNew = x + vNew * dt;


            t += dt;
            x = xNew;
            v = vNew;

            odeUpdate.update(t, x, v);

        }

    }
}
