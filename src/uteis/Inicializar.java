/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.util.ArrayList;
import uteis.Constantes.*;

public class Inicializar {
    
    public static ArrayList<Double> salario( ArrayList<Double> a, String empresa ){
        
        if ( empresas.FECAP.equalsIgnoreCase( empresa ) ){        
            for ( int i = 1; i<= 14; i++ ){
                a.add( salarios.salarioFECAP );
            }
        } else if ( empresas.Resource.equalsIgnoreCase(empresa) ){
            for ( int i = 1; i<= 14; i++ ){
                a.add( salarios.salarioResource );
            }
        }

        return a;
    }
}