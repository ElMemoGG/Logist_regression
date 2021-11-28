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
                LogistR  regresion = new LogistR(Reader.leer("DataMultiple.txt"));
                //double[] x = {3.5,4};
                regresion.LR(x);
            }
        } );
    }
    public void getSimple(final double[] x ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                LogistR  regresion = new LogistR(Reader.leer("datasetDiabetes.txt"));
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
