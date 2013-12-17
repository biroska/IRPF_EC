package modelos;

import Calculos.FGTS;
import Calculos.INSS;
import Calculos.IRRF;

import java.util.ArrayList;

import uteis.Constantes;
import uteis.Constantes.empresas;
import uteis.Constantes.salarios;

public class Pagamentos {

    public Pagamentos(String empresa) {

        Double vlrBruto = null;
        Double vlrINSSaux = null;
        
        valores = new ArrayList<Salario>(14);
        
        for (int i = 0; i <= 13; i++) {
            valores.add( new Salario() );
        }

        this.valores.get(0).setMes("Janeiro");
        this.valores.get(1).setMes("Fevereiro");
        this.valores.get(2).setMes("Março");
        this.valores.get(3).setMes("Abril");
        this.valores.get(4).setMes("Maio");
        this.valores.get(5).setMes("Junho");
        this.valores.get(6).setMes("Julho");
        this.valores.get(7).setMes("Agosto");
        this.valores.get(8).setMes("Setembro");
        this.valores.get(9).setMes("Outubro");
        this.valores.get(10).setMes("Novembro");
        this.valores.get(11).setMes("Dezembro");
        this.valores.get(12).setMes("13º");
        this.valores.get(13).setMes("Férias");

        if (empresas.FECAP.equalsIgnoreCase(empresa)) {
            vlrBruto = salarios.salarioFECAP;

        } else if (empresas.Resource.equalsIgnoreCase(empresa)) {
            vlrBruto = salarios.salarioResource;
        }

        for (int i = 0; i <= 13; i++) {
        	vlrINSSaux = 0.0;
        	this.valores.get(i).setBruto(vlrBruto );
        	
            if (empresas.FECAP.equalsIgnoreCase(empresa)) {
            	
             	if ( i == 0 ||i == 1 ){
             		this.valores.get(i).setBruto( salarios.zero );
            	} else if ( i == 2){
            		this.valores.get(i).setBruto( salarios.salarioFECAPParcial );
            	}
            	
            	this.valores.get(i).setOutros( Constantes.outros.planoDentalFECAP);
         	   
            	if ( this.valores.get(i).getBruto() == 0.0  ){
             		this.valores.get(i).setOutros( Constantes.zero );
             	}

             } else if (empresas.Resource.equalsIgnoreCase(empresa)) {
            	 
             	if ( i == 0 ||i == 1 ){
             		this.valores.get(i).setBruto( salarios.zero );
            	} else if ( i == 2){
            		this.valores.get(i).setBruto( salarios.salarioResourceParcial );
            	}
            	
             	this.valores.get(i).setOutros( Constantes.outros.contribuicaoResource );
             	
             	if ( this.valores.get(i).getBruto() == 0.0  ){
             		this.valores.get(i).setOutros( Constantes.zero );
             	}
             }
        	
        	if ( i == 13){ // Férias
        		this.valores.get(i).setBruto( this.valores.get(i).getBruto() + this.valores.get(i).getBruto()/3);
        		this.valores.get(i).setOutros( Constantes.outros.descFeriasFECAP );
        	}
            
            vlrINSSaux = INSS.calculo(this.valores.get(i).getBruto());
            
            this.valores.get(i).setImposto( vlrINSSaux +
// O FGTS não é descontado do empregado     FGTS.calculo( this.valores.get(i).getBruto() ) +
            								IRRF.calculo(this.valores.get(i).getBruto() -vlrINSSaux ) );
            
            this.valores.get(i).setLiquido(   this.valores.get(i).getBruto() 
                                            - this.valores.get(i).getImposto()
                                            - this.valores.get(i).getOutros() );
        }

    }
    private ArrayList<Salario> valores;
    private String teste = "Raios";

    public ArrayList<Salario> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Salario> valores) {
        this.valores = valores;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
}