/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import uteis.Constantes.*;

public class INSS {
    
    public static Double calculo( Double valor ){
        
        Double vlrImposto = null;
        
        if ( valor <= faixaINSS.faixa1 ){
            vlrImposto = 0.01 * faixaINSS.aliquota1 * valor;
        } else
            if ( valor > faixaINSS.faixa1 && valor < faixaINSS.faixa2 ){
                vlrImposto = 0.01 * faixaINSS.aliquota2 * valor;
            } else
                if ( valor > faixaINSS.faixa2 && valor < faixaINSS.faixa3 ){
                    vlrImposto = 0.01 * faixaINSS.aliquota3 * valor;
                }

        return vlrImposto;
    }
}