package modelos;

import Calculos.FGTS;
import Calculos.INSS;
import Calculos.IRRF;

import java.util.ArrayList;

import uteis.Constantes;
import uteis.Constantes.empresas;
import uteis.Constantes.outros;
import uteis.Constantes.salarios;

public class Pagamentos {

    public Pagamentos(String empresa, boolean DA) {

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
        
        if ( empresas.direitoAutoral.equalsIgnoreCase(empresa) ){
        	this.valores.get(0).setBruto(salarios.zero );
        	this.valores.get(1).setBruto(salarios.zero );
        	this.valores.get(2).setBruto( 860.04 );
        	this.valores.get(3).setBruto( 3342.81 );
        	this.valores.get(4).setBruto( 3721.66 );
        	this.valores.get(5).setBruto( 1522.08 );
        	this.valores.get(6).setBruto( 1183.93 );
        	this.valores.get(7).setBruto( 2777.81 );
        	this.valores.get(8).setBruto( 2196.73 );
        	this.valores.get(9).setBruto( 1145.71 );
        	this.valores.get(10).setBruto( 1376.37 );
        	this.valores.get(11).setBruto( 1369.26 );
        	this.valores.get(12).setBruto( salarios.zero );
        	this.valores.get(13).setBruto( salarios.zero );
        	
        } else
        	if ( empresas.FECAP.equalsIgnoreCase(empresa) ){
        		this.valores.get(0).setBruto(salarios.zero );
            	this.valores.get(1).setBruto(salarios.zero );
            	this.valores.get(2).setBruto(salarios.salarioFECAPParcial);
            	this.valores.get(3).setBruto(salarios.salarioFECAP);
            	this.valores.get(4).setBruto(salarios.salarioFECAP);
            	this.valores.get(5).setBruto(salarios.salarioFECAP);
            	this.valores.get(6).setBruto(salarios.salarioFECAP);
            	this.valores.get(7).setBruto(salarios.salarioFECAP);
            	this.valores.get(8).setBruto(salarios.salarioFECAP);
            	this.valores.get(9).setBruto(salarios.salarioFECAP);
            	this.valores.get(10).setBruto(salarios.salarioFECAP);
            	this.valores.get(11).setBruto(salarios.salarioFECAP);
            	this.valores.get(12).setBruto(salarios.salarioFECAP);
            	this.valores.get(13).setBruto(salarios.salarioFECAP + ( salarios.salarioFECAP / 3 ) );
            	
            } else
            	if ( empresas.Resource.equalsIgnoreCase(empresa) ){
            		this.valores.get(0).setBruto(salarios.zero );
                	this.valores.get(1).setBruto(salarios.zero );
                	this.valores.get(2).setBruto(salarios.salarioResourceParcial );
                	this.valores.get(3).setBruto(salarios.salarioResource );
                	this.valores.get(4).setBruto(salarios.salarioResource );
                	this.valores.get(5).setBruto(salarios.salarioResource );
                	this.valores.get(6).setBruto(salarios.salarioResource );
                	this.valores.get(7).setBruto(salarios.salarioResource );
                	this.valores.get(8).setBruto(salarios.salarioResource );
                	this.valores.get(9).setBruto(salarios.salarioResource );
                	this.valores.get(10).setBruto(salarios.salarioResource );
                	this.valores.get(11).setBruto(salarios.salarioResource );
                	this.valores.get(12).setBruto(salarios.salarioResource );
                	this.valores.get(13).setBruto(salarios.zero );	
            	}
        
        
        
        for (int i = 0; i <= 13; i++) {
        	
        	this.valores.get(i).setOutros( salarios.zero );
        	this.valores.get(i).setImposto( salarios.zero );
        	this.valores.get(i).setLiquido( salarios.zero );
        	vlrINSSaux = 0.0D;
        	
        	if ( this.valores.get(i).getBruto() != 0 ){
        		
        		if ( empresas.Resource.equalsIgnoreCase( empresa ) ){
        			if  ( i == 2 ){
        				this.valores.get(i).setOutros( outros.contribuicaoResourceParcial );
        			} else {
        				this.valores.get(i).setOutros( outros.contribuicaoResource );
        			}
        		} else
        			if( empresas.FECAP.equalsIgnoreCase( empresa ) ){
    					this.valores.get(i).setOutros( outros.planoDentalFECAP );
    					if ( i == 13 ){
    						this.valores.get(i).setOutros(outros.descFeriasFECAP);
    					}
        		}
	        		
        		if ( !DA ){
        			vlrINSSaux = INSS.calculo(this.valores.get(i).getBruto());
        		}
	            
	            this.valores.get(i).setImposto( vlrINSSaux +
        		// O FGTS não é descontado do empregado     FGTS.calculo( this.valores.get(i).getBruto() ) +
	            								IRRF.calculo(this.valores.get(i).getBruto() -vlrINSSaux ) );
	            
	            this.valores.get(i).setLiquido(   this.valores.get(i).getBruto() 
	                                            - this.valores.get(i).getImposto()
	                                            - this.valores.get(i).getOutros() );
	        }
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