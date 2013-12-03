package Calculos;

import java.util.ArrayList;
import modelos.Salario;
import uteis.Constantes.composicaoSalarial;

public class Genericos {

    public static Double totalizaItem(ArrayList<Salario> salario, int tipo) {

        Double total = 0D;

        for (Salario sal : salario) {
            
            if (tipo == composicaoSalarial.BRUTO ){
                total = total + sal.getBruto();
            } else
                if(tipo == composicaoSalarial.IMPOSTO ){
                    total += sal.getImposto();
                } else
                    if(tipo == composicaoSalarial.OUTROS ){
                        total += sal.getOutros();
                    }else
                        if(tipo == composicaoSalarial.LIQUIDO ){
                            total += sal.getLiquido();
                        }
//            switch (tipo) {
//                case composicaoSalarial.BRUTO:
//                    total = total + sal.getBruto();
//                    
//                    System.out.println("   " + total );
//
//                case composicaoSalarial.IMPOSTO:
//                    total += sal.getImposto();
//
//                case composicaoSalarial.OUTROS:
//                    total += sal.getOutros();
//
//                case composicaoSalarial.LIQUIDO:
//                    total += sal.getLiquido();
//            }
        }
        return total;
    }
}
