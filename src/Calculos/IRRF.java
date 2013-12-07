package Calculos;

import uteis.Constantes.*;

public class IRRF {

    public static Double calculo(Double valor) {

        Double vlrImposto = null;

        if (valor <=  ValoresIRRF.faixa1) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota1 * valor -ValoresIRRF.deducaoIR1;
        } else if (valor > ValoresIRRF.faixa1 && valor < ValoresIRRF.faixa2) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota2 * valor -ValoresIRRF.deducaoIR2;
        } else if (valor > ValoresIRRF.faixa2 && valor < ValoresIRRF.faixa3) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota3 * valor -ValoresIRRF.deducaoIR3;
        } else if (valor > ValoresIRRF.faixa3 && valor < ValoresIRRF.faixa4) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota4 * valor -ValoresIRRF.deducaoIR4;
        } else if (valor > ValoresIRRF.faixa4) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota5 * valor -ValoresIRRF.deducaoIR5;
        }

        return vlrImposto;
    }

    public static Double deducao(Double valor) {

        Double vlrDeducao = null;

        if (valor <= 0.01 * ValoresIRRF.faixa1) {
            vlrDeducao = 0.01 * ValoresIRRF.deducaoIR1;
        } else if (valor > ValoresIRRF.faixa1 && valor < ValoresIRRF.faixa2) {
            vlrDeducao = 0.01 * ValoresIRRF.deducaoIR1;
        } else if (valor > ValoresIRRF.faixa2 && valor < ValoresIRRF.faixa3) {
            vlrDeducao = 0.01 * ValoresIRRF.deducaoIR1;
        } else if (valor > ValoresIRRF.faixa3 && valor < ValoresIRRF.faixa4) {
            vlrDeducao = 0.01 * ValoresIRRF.deducaoIR1;
        } else if (valor > ValoresIRRF.faixa4) {
            vlrDeducao = 0.01 * ValoresIRRF.deducaoIR1;
        }

        return vlrDeducao;
    }
}