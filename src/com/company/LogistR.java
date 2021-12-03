package com.company;

public class LogistR {

    static private double[][] x;
    static private double[][] y;
    private double alpha =0.0005;
    //0.0005  -- 10,000  dataset del profe
    // 0.00001   -- 100,000  diabetes  basquet

    public LogistR(double[][] dataset) {
        x = utility.getX(dataset);
        y = utility.getY(dataset);

    }

    public void LR(double[] variables){
        utility util = new utility();
        double[] Wold = util.getW(x[0].length);
        double[] Wnew = new double[Wold.length];

        // j filas  y i son columnas
        // simple 8000 y 0.01 para diabetes  --- multiple 8000 0.0001  --- basquetball 100 0.1
        for (int q = 0; q < 10000; q++) {

            for (int i = 0; i <x[0].length ; i++) {   //j -- k
                double wtem = 0;
                for (int j = 0; j < x.length; j++) {
                    wtem += (util.getFuncionC(j, Wold, x)-y[j][0])*x[j][i];
                }
                //if (i< x[0].length){
                    Wnew[i] = Wold[i] - alpha * wtem;
                //}
                wtem = 0;
            }
            for (int i = 0; i <Wold.length ; i++) {
                Wold[i] = Wnew[i];
            }
        }
        ImprimirW(Wold);
        util.getProbabilidad(Wold, variables);
    }
    private void ImprimirW(double[] w){
        System.out.println();
        for (int i = 0; i < w.length; i++) {
            System.out.print( "W"+i + "= "+w[i]+ "    ");
        }
    }



}
