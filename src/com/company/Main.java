package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LogistR  regresion = new LogistR(Reader.leer("datasetDiabetes.txt"));
        regresion.LR();
    }
}
