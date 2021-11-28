package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LogistR  regresion = new LogistR(Reader.leer("datasetDiabetes.txt"));
        double[] x = {92};
        regresion.LR(x);
    }
}
