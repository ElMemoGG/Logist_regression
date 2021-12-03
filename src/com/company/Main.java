package com.company;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Main extends Agent {


    private AgentGUI myGUI;
    protected void setup() {
        myGUI=new AgentGUI(this);
        myGUI.showGui();
    }
    public void getMultiple(final double[] x ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                double[][] dataSet = new double[][]{
                        {1,1,72,1},
                        {1,2,72,1},
                        {1,3,72,1},
                        {1,4,72,0},
                        {1,5,64,1},
                        {1,6,64,0},
                        {1,7,64,1},
                        {2,1,72,1},
                        {2,2,72,1},
                        {2,3,72,0}
                };

                LogistR  regresion = new LogistR(dataSet);
                //double[] x = {3.5,4};
                regresion.LR(x);
            }
        } );
    }
    public void getSimple(final double[] x ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                LogistR  regresion = new LogistR(Reader.leer("DataMultiple.txt"));
                //double[] x = {3.5,4};
                regresion.LR(x);
            }
        } );
    }


   /* public static void main(String[] args) {
	// write your code here
        LogistR  regresion = new LogistR(Reader.leer("ejemplo.txt"));
        double[] x = {3.5,4};
        regresion.LR(x);
    }*/
}
