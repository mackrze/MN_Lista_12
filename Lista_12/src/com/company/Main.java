package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        //Zad 1
// znalezc max wysokosc ok 2.87
        VelterIntegrator velterIntegrator = new VelterIntegrator(0.01);
        Analyzer analyzer = new Analyzer();
        analyzer.clearData();
        TennisToss tennisToss = new TennisToss();
        velterIntegrator.integrate(tennisToss, analyzer, 0, 20, 1.5, 5.2);

        double xMax = 0;
        for (int i = 0; i < analyzer.getvValues().size(); i++) { // znajdowanie najwyzszego polozenia pilki
            if (analyzer.getvValues().get(i) < 0) {
                xMax = analyzer.getxValues().get(i);
                break;
            }
        }
        System.out.println("Najwyższe położenie piłki wynosi:" + xMax);


        for (int i = analyzer.getxValues().size() - 1; i >= 0; i--) {  // petla usuwajaca dane gdzie x<0 bo pilka nie moze spasc pod ziemie
            if (analyzer.getxValues().get(i) < 0) {
                analyzer.getxValues().remove(i);
                analyzer.gettValues().remove(i);
                analyzer.getvValues().remove(i);
            }
        }

        try {
            analyzer.saveToFile("Velter.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // zad 2
        // zmieniamy klase VelterIntegratro
        analyzer.clearData();
        EulerCromerIntegrator eulerCromerIntegrator = new EulerCromerIntegrator(0.01);
        eulerCromerIntegrator.integrate(tennisToss, analyzer, 0, 20, 1.5, 5.2);

        for (int i = 0; i < analyzer.getvValues().size(); i++) { // znajdowanie najwyzszego polozenia pilki
            if (analyzer.getvValues().get(i) < 0) {
                xMax = analyzer.getxValues().get(i);
                break;
            }
        }
        System.out.println("Najwyższe położenie piłki wynosi:" + xMax);

        for (int i = analyzer.getxValues().size() - 1; i >= 0; i--) {
            if (analyzer.getxValues().get(i) < 0) {
                analyzer.getxValues().remove(i);
                analyzer.gettValues().remove(i);
                analyzer.getvValues().remove(i);
            }
        }
        try {
            analyzer.saveToFile("EulerCromer.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        analyzer.clearData();
        //zad 3
        double v0 = 300; // km/h
        v0 = 300 * 1000 / 3600; // m/s
        CarRoad carRoad = new CarRoad(1200, 0.86, 0.7);
        velterIntegrator.integrate(carRoad, analyzer, 0, 20, 0, v0);
        double tBreaks = 0;
        double xBreaks = 0;
        for (int i = 0; i < analyzer.getvValues().size(); i++) { // znajdowanie czasu i drogi hamowania
            if (analyzer.getvValues().get(i) < 0) {
                tBreaks = analyzer.gettValues().get(i);
                xBreaks = analyzer.getxValues().get(i);
                break;
            }
        }

        System.out.println("Droga hamowania: " + xBreaks + " Czas hamowania: "+ tBreaks);


        for (int i = analyzer.getxValues().size() - 1; i >= 0; i--) {
            if (analyzer.getvValues().get(i) < 0) {
                analyzer.getxValues().remove(i);
                analyzer.gettValues().remove(i);
                analyzer.getvValues().remove(i);
            }
        }
        try {
            analyzer.saveToFile("CarRoad.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        analyzer.clearData();



        carRoad = new CarRoad(1200, 0, 0.7); // brak sił oporu powietrza


        velterIntegrator.integrate(carRoad, analyzer, 0, 20, 0, v0);
       tBreaks = 0;
        xBreaks = 0;

        for (int i = 0; i < analyzer.getvValues().size(); i++) { // znajdowanie czasu i drogi hamowania
            if (analyzer.getvValues().get(i) < 0) {
                tBreaks = analyzer.gettValues().get(i);
                xBreaks = analyzer.getxValues().get(i);
                break;
            }
        }

        System.out.println("Droga hamowania: " + xBreaks + " Czas hamowania: "+ tBreaks);


        for (int i = analyzer.getxValues().size() - 1; i >= 0; i--) {
            if (analyzer.getvValues().get(i) < 0) {
                analyzer.getxValues().remove(i);
                analyzer.gettValues().remove(i);
                analyzer.getvValues().remove(i);
            }
        }
        try {
            analyzer.saveToFile("CarRoadNoAir.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        analyzer.clearData();




        // am = -umg - cv^2 -->
        // a = -ug - (cv^2)/m
        // czyli zmieniamy tylko klase TennisToss

    }
}
