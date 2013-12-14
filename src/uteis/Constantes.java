package uteis;

import java.util.Arrays;
import java.util.List;

public class Constantes {

    public static class empresas {

        public empresas() {
        }
        public static final String FECAP = "FECAP";
        public static final String Resource = "Resource";
        public static final String Consolidacao = "Consolidacao";
    }

    public static class salarios {

        public salarios() {
        }
        public static final Double salarioFECAP = 2137.84D;
        public static final Double salarioResource = 1500D;
    }

    public static class outros {

        public static final Double planoDentalFECAP = 23.60D;
        public static final Double descFeriasFECAP = 22.92D;
        public static final Double contribuicaoResource = 16.9D;
    }

    public static class meses {

        meses() {
        }
        public static final List<String> meses = Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro", "13º", "Férias");
    }

    public static class faixaINSS {

        public static final Double faixa1 = 1247.70D;
        public static final Double faixa2 = 2079.50D;
        public static final Double faixa3 = 4159.00D;
        public static final Double aliquota1 = 8D;
        public static final Double aliquota2 = 9D;
        public static final Double aliquota3 = 11D;
    }

    public static class ValoresIRRF {

        public static final Double faixa1 = 1710.78D;
        public static final Double faixa2 = 2563.91D;
        public static final Double faixa3 = 3418.59D;
        public static final Double faixa4 = 4271.59D;
//        public static final Double faixa5 = 4159.00D;
        public static final Double aliquota1 = 0D;
        public static final Double aliquota2 = 7.5D;
        public static final Double aliquota3 = 15D;
        public static final Double aliquota4 = 22.5D;
        public static final Double aliquota5 = 27.5D;
        public static final Double deducaoIR1 = 0D;
        public static final Double deducaoIR2 = 128.31D;
        public static final Double deducaoIR3 = 320.60D;
        public static final Double deducaoIR4 = 577D;
        public static final Double deducaoIR5 = 790.58D;
    }
    
    public static class faixaDeducoesIRPF {

    	public static final Double faixa1 = 20529.36D;
        public static final Double faixa2 = 30766.92D;
        public static final Double faixa3 = 41023.08D;
        public static final Double faixa4 = 51259.08D;
        public static final Double faixa5 = 51259.08D;
        public static final Double aliquota1 = 0D;
        public static final Double aliquota2 = 7.5D;
        public static final Double aliquota3 = 15D;
        public static final Double aliquota4 = 22.5D;
        public static final Double aliquota5 = 27.5D;
        public static final Double deducoes1 = 0D;
        public static final Double deducoes2 = 1539.72D;
        public static final Double deducoes3  = 3847.20D;
        public static final Double deducoes4 = 6924.0D;
        public static final Double deducoes5 = 9486.96D;
        public static final Double descDependente1 = 0D;
        public static final Double descDependente2 = 2063.64D;
    }
    
 public static class composicaoSalarial {

        public composicaoSalarial() {}
        
        public static final String DESC_MES = "Mes";
        public static final String DESC_BRUTO = "Bruto";
        public static final String DESC_IMPOSTO = "Imposto";
        public static final String DESC_OUTROS = "Outros";
        public static final String DESC_LIQUIDO = "Liquido";
        
        public static final int MES = 0;
        public static final int BRUTO = 1;
        public static final int IMPOSTO = 2;
        public static final int OUTROS = 3;
        public static final int LIQUIDO = 4;
    }
 
 public static class aliquotaFGTS {

     public static final Double aliquota = 8.0D;
 }

}