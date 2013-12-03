package Calculos;

import uteis.Constantes.*;

public class IRRF {

    public static Double calculo(Double valor) {

        Double vlrImposto = null;

        if (valor <=  ValoresIRRF.faixa1) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota1 * valor;
        } else if (valor > ValoresIRRF.faixa1 && valor < ValoresIRRF.faixa2) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota2 * valor;
        } else if (valor > ValoresIRRF.faixa2 && valor < ValoresIRRF.faixa3) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota3 * valor;
        } else if (valor > ValoresIRRF.faixa3 && valor < ValoresIRRF.faixa4) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota4 * valor;
        } else if (valor > ValoresIRRF.faixa4) {
            vlrImposto = 0.01 * ValoresIRRF.aliquota5 * valor;
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