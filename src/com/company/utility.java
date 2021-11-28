package com.company;

public class utility {

    public static double[][] getX(double[][] x){
        double[][] resultado = new double[x.length][x[0].length];
        for (int i = 0; i < x.length; i++) { //filas
            for (int j = 1; j <x[0].length ; j++) {
                resultado[i][0] =1;
                resultado[i][j] =x[i][j-1];
            }
        }
        return resultado;
    }
    public static double[][] getY(double[][] y){
        double[][] resultado = new double[y.length][1];
        for (int i = 0; i < y.length; i++) { //filas
            resultado[i][0] = y[i][y[0].length-1];

        }
        return resultado;
    }
    public static double Sigmoide(double x){
        return 1/(1+(Math.exp(-x)));
    }

    public static double getFuncionC(int numero, double[]w, double[][]x){
        double resultado  = 0;
        for (int i = 1; i < w.length; i++) {
            resultado += x[i][numero]*w[i];
        }
        return Sigmoide(w[0]+resultado);
    }

    public static double[] getW(int size){
        double[] w = new double[size];
        for (int i = 0; i <w.length ; i++) {
            w[i] = 0.0;
        }
        return w;
    }


    public static void getProbabilidad( double[]w, double[]x){
        double resultado  = 0;
        for (int i = 1; i < w.length; i++) {
            resultado += x[i-1]*w[i];
        }
        double re = Sigmoide(w[0]+resultado);
        System.out.println();
        if (re<=0.5){
            System.out.println("No hay probabilidad:   "+ re);
        }else{
            System.out.println("Si hay probabilidad:   "+ re);
        }
    }


}
