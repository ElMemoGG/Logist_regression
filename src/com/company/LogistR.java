package com.company;

public class LogistR {

    static private double[][] x;
    static private double[][] y;
    private double alpha =0.01;

    public LogistR(double[][] dataset) {
        x = utility.getX(dataset);
        y = utility.getY(dataset);

    }

    public void LR(){
        utility util = new utility();
        double[] Wold = util.getW(x[0].length);
        double[] Wnew = new double[Wold.length];


        for (int q = 0; q <= 8000; q++) {
            //System.out.println(Wold[0]+ " " + Wold[1]+ " ");

            for (int i = 0; i <x.length ; i++) {
                double wtem = 0;
                for (int j = 0; j < x[0].length; j++) {
                    wtem += (util.getFuncionC(j, Wold, x)-y[j][0] )*x[i][j];
                }
                if (i< x[0].length){
                    Wnew[i] = Wold[i] - alpha * wtem;
                }
                wtem = 0;
            }
            for (int i = 0; i <Wold.length ; i++) {
                Wold[i] = Wnew[i];

            }
        }
        ImprimirW(Wold);
    }
    private void ImprimirW(double[] w){
        for (int i = 0; i < w.length; i++) {
            System.out.print( "W"+i + "= "+w[i]+ "    ");
        }
    }





}
