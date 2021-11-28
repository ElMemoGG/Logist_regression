package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Reader {


    public static double[][] leer(String ru){
        double[][] matriz = new double[0][];
        try {
            FileReader ruta = new FileReader(ru);
            BufferedReader br = new BufferedReader(ruta);
            String linea = br.readLine();
            String[] aux = linea.split(",");
            int longitud = aux.length;
            int size = cantidad(ru);
            matriz = new double[size][longitud];

            int fila = 0;
            while(linea != null) {

                String[] dato = linea.split(",");
                for (int i = 0; i < dato.length; i++)
                    matriz[fila][i] = Double.parseDouble(dato[i]);

                fila++;
                linea = br.readLine();
            }
            br.close();

           /* for (int i = 0; i < size; i++) {
                for (int j = 0; j < longitud; j++)
                    System.out.print(matriz[i][j] + " ");
                System.out.println();
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matriz;
    }
    public static int cantidad(String ru ){
        int resultado=0;
        try {
            FileReader ruta = new FileReader(ru);
            BufferedReader r = new BufferedReader(ruta);
            String lee = r.readLine();

            while(lee != null){
                lee = r.readLine();
                resultado++;
            }
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }





}
