package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.model.chart.PieChartModel; 

@ManagedBean(name = "testeMB" )
@RequestScoped
public class testeMB {

    private PieChartModel grafico;
    private boolean exibeGraf;
    
//    @Size(min=2,max=5)
    private String usuario;
    
    public testeMB() {
        
        grafico = new PieChartModel();  
  
        grafico.set("Liquido", 725);  
        grafico.set("Impostos", 302);  
        grafico.set("Demais descontos", 421); 
        
        exibeGraf = false;
    }

    public void teste( ActionEvent e ){
        exibeGraf = true;
        System.out.println("TESTE ================================== " + exibeGraf );
    }
    
    public void exibirGrafico( ){
        exibeGraf = true;
        System.out.println("TESTE 2 =============================" + exibeGraf );
    }
    
    public PieChartModel getGrafico() {
        return grafico;
    }

    public void setGrafico(PieChartModel grafico) {
        this.grafico = grafico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isExibeGraf() {
        return exibeGraf;
    }

    public void setExibeGraf(boolean exibeGraf) {
        this.exibeGraf = exibeGraf;
    }

}