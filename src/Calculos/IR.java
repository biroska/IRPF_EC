package Calculos;

import uteis.Constantes.*;

public class IR {

    public static Double calculo(Double liquido, Double imposto) {

        Double vlrImposto = null;
        Double percAliquota = null;
        Double vlrDeducao = null;
        Double descDependente = null;
        
        if (liquido <=  faixaDeducoesIRPF.faixa1) {
        	percAliquota = faixaDeducoesIRPF.aliquota1;
        	vlrDeducao = faixaDeducoesIRPF.deducoes1;
        	descDependente = faixaDeducoesIRPF.descDependente1;
        	
        } else if (liquido > faixaDeducoesIRPF.faixa1 && liquido <= faixaDeducoesIRPF.faixa2) {
        	percAliquota = faixaDeducoesIRPF.aliquota2;
        	vlrDeducao = faixaDeducoesIRPF.deducoes2;
        	descDependente = faixaDeducoesIRPF.descDependente2;
        	
        } else if (liquido > faixaDeducoesIRPF.faixa2 && liquido <= faixaDeducoesIRPF.faixa3) {
        	percAliquota = faixaDeducoesIRPF.aliquota3;
        	vlrDeducao = faixaDeducoesIRPF.deducoes3;
        	descDependente = faixaDeducoesIRPF.descDependente2;
        	
        } else if (liquido > faixaDeducoesIRPF.faixa3 && liquido <= faixaDeducoesIRPF.faixa4) {
        	percAliquota = faixaDeducoesIRPF.aliquota4;
        	vlrDeducao = faixaDeducoesIRPF.deducoes4;
        	descDependente = faixaDeducoesIRPF.descDependente2;
        	
        } else if (liquido > faixaDeducoesIRPF.faixa4 ){
        	percAliquota = faixaDeducoesIRPF.aliquota5;
        	vlrDeducao = faixaDeducoesIRPF.deducoes5;
        	descDependente = faixaDeducoesIRPF.descDependente2;
        }
        
        vlrImposto =  ( liquido * percAliquota / 100 ) - vlrDeducao - imposto;

        return vlrImposto;
    }
}