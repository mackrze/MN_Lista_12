package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Analyzer implements ODEUpdate {

    private ArrayList<Double> tValues = new ArrayList<>();
    private ArrayList<Double> xValues = new ArrayList<>();
    private ArrayList<Double> vValues = new ArrayList<>();

    public void clearData(){ // czyszczenie danych
        tValues.clear();
        xValues.clear();
        vValues.clear();
    }

    public void saveToFile(String fileName) throws FileNotFoundException {


        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println("t \t x \t v");
        for (int i = 0; i < xValues.size() ; i++) {
            printWriter.print(tValues.get(i).toString() + "\t");
            printWriter.print(xValues.get(i).toString() + "\t");
            printWriter.print(vValues.get(i).toString() + "\t ");
            printWriter.println(" ");
        }
        printWriter.close();

    }

    public ArrayList<Double> gettValues() {
        return tValues;
    }

    public ArrayList<Double> getxValues() {
        return xValues;
    }

    public ArrayList<Double> getvValues() {
        return vValues;
    }

    @Override
    public void update(double t, double x, double v) {

        tValues.add(t);
        xValues.add(x);
        vValues.add(v);

    }
}
