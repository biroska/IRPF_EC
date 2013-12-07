package Calculos;

import uteis.Constantes.*;

public class FGTS {

    public static Double calculo(Double valor) {

        Double vlrImposto = null;

        vlrImposto = 0.01 * aliquotaFGTS.aliquota * valor;
       
        return vlrImposto;
    }
}