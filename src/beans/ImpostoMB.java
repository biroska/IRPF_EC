package beans;

import Calculos.Genericos;
import Calculos.IR;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import modelos.Pagamentos;
import modelos.Salario;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.chart.PieChartModel;

import uteis.Constantes;

@ManagedBean(name = "impostoMB")
@ViewScoped
public class ImpostoMB implements Serializable {

    private ArrayList<Double> brutoFECAP = new ArrayList<Double>(14);
    private ArrayList<Double> brutoResource = new ArrayList<Double>(14);
    private ArrayList<String> meses = new ArrayList<String>();
    
    private Double totalBrutoFECAP;
    private Double totalImpsFECAP;
    private Double totalOutrosFECAP;
    private Double totalLiquidoFECAP;
    
    private Double totalBrutoResource;
    private Double totalImpsResource;
    private Double totalOutrosResource;
    private Double totalLiquidoResource;
    
    private Double totalBrutoConsolidacao;
    private Double totalImpsConsolidacao;
    private Double totalOutrosConsolidacao;
    private Double totalLiquidoConsolidacao;
    
    private Double impostoPagar;
    
    private PieChartModel grafico = new PieChartModel();

    private Pagamentos pagto;
    private Pagamentos pagtoFECAP;
    private boolean exibeGrafico;

    public ImpostoMB() {
        
        exibeGrafico = false;
        System.out.println("Construtor ImpostoMB... " + exibeGrafico);

        pagto = new Pagamentos(Constantes.empresas.Resource);
        pagtoFECAP = new Pagamentos(Constantes.empresas.FECAP);
        
        totalizarValores();
    }
    
    private void totalizarValores(){
        System.out.println("totalizarValores " + exibeGrafico);
        totalBrutoResource = Genericos.totalizaItem(pagto.getValores(), Constantes.composicaoSalarial.BRUTO);
        totalImpsResource = Genericos.totalizaItem(pagto.getValores(), Constantes.composicaoSalarial.IMPOSTO);
        totalOutrosResource = Genericos.totalizaItem(pagto.getValores(), Constantes.composicaoSalarial.OUTROS);
        totalLiquidoResource = Genericos.totalizaItem(pagto.getValores(), Constantes.composicaoSalarial.LIQUIDO);
        
        totalBrutoFECAP = Genericos.totalizaItem(pagtoFECAP.getValores(), Constantes.composicaoSalarial.BRUTO);
        totalImpsFECAP = Genericos.totalizaItem(pagtoFECAP.getValores(), Constantes.composicaoSalarial.IMPOSTO);
        totalOutrosFECAP = Genericos.totalizaItem(pagtoFECAP.getValores(), Constantes.composicaoSalarial.OUTROS);
        totalLiquidoFECAP = Genericos.totalizaItem(pagtoFECAP.getValores(), Constantes.composicaoSalarial.LIQUIDO);
        
        totalBrutoConsolidacao = totalBrutoResource + totalBrutoFECAP;
        totalImpsConsolidacao = totalImpsResource + totalImpsFECAP;
        totalOutrosConsolidacao = totalOutrosResource + totalOutrosFECAP;
        totalLiquidoConsolidacao = totalLiquidoResource + totalLiquidoFECAP;
        
        impostoPagar = IR.calculo( totalLiquidoConsolidacao, totalImpsConsolidacao);
    }
        
    public void montaGrafico(ActionEvent event){
        exibeGrafico = true;
        
        String empresa = (String)event.getComponent().getAttributes().get("empresa");
        
    	System.out.println("ImpostoMB.montaGrafico(): " + exibeGrafico + " - " + empresa);
        Salario sal = new Salario();
        if ( Constantes.empresas.FECAP.equalsIgnoreCase(empresa) ){
            sal = new Salario( totalBrutoFECAP, totalImpsFECAP, totalOutrosFECAP, totalLiquidoFECAP );
        } else
             if ( Constantes.empresas.Resource.equalsIgnoreCase(empresa) ){
            sal = new Salario( totalBrutoResource, totalImpsResource, totalOutrosResource, totalLiquidoResource );
            } else
                 if ( Constantes.empresas.Consolidacao.equalsIgnoreCase(empresa) ){
                    sal = new Salario( totalBrutoConsolidacao, totalImpsConsolidacao, totalOutrosConsolidacao, totalLiquidoConsolidacao );
            }
        
    	montaGrafico( sal );
    }
    
    public void fecharDialog( CloseEvent event){
        exibeGrafico = false;
    	System.out.println("ImpostoMB.fecharDialog(): " + exibeGrafico );
    }
    
    private void montaGrafico( Salario sal ){
    	System.out.println("ImpostoMB.montaGrafico(): " + exibeGrafico );
        
        grafico.set(Constantes.composicaoSalarial.DESC_IMPOSTO, sal.getImposto() );
        grafico.set(Constantes.composicaoSalarial.DESC_OUTROS, sal.getOutros() );
        grafico.set(Constantes.composicaoSalarial.DESC_LIQUIDO, sal.getLiquido() );
    }

    public ArrayList<Double> getBrutoFECAP() {
        return brutoFECAP;
    }

    public void setBrutoFECAP(ArrayList<Double> brutoFECAP) {
        this.brutoFECAP = brutoFECAP;
    }

    public ArrayList<Double> getBrutoResource() {
        return brutoResource;
    }

    public void setBrutoResource(ArrayList<Double> brutoResource) {
        this.brutoResource = brutoResource;
    }

    public ArrayList<String> getMeses() {
        return meses;
    }

    public void setMeses(ArrayList<String> meses) {
        this.meses = meses;
    }

    public Pagamentos getPagto() {
        return pagto;
    }

    public void setPagto(Pagamentos pagto) {
        this.pagto = pagto;
    }

    public Double getTotalBrutoFECAP() {
        return totalBrutoFECAP;
    }

    public void setTotalBrutoFECAP(Double totalBrutoFECAP) {
        this.totalBrutoFECAP = totalBrutoFECAP;
    }

    public Double getTotalImpsFECAP() {
        return totalImpsFECAP;
    }

    public void setTotalImpsFECAP(Double totalImpsFECAP) {
        this.totalImpsFECAP = totalImpsFECAP;
    }

    public Double getTotalBrutoResource() {
        return totalBrutoResource;
    }

    public void setTotalBrutoResource(Double totalBrutoResource) {
        this.totalBrutoResource = totalBrutoResource;
    }

    public Double getTotalImpsResource() {
        return totalImpsResource;
    }

    public void setTotalImpsResource(Double totalImpsResource) {
        this.totalImpsResource = totalImpsResource;
    }

    public PieChartModel getGrafico() {
        return grafico;
    }

    public void setGrafico(PieChartModel grafico) {
        this.grafico = grafico;
    }

    public Double getTotalOutrosResource() {
        return totalOutrosResource;
    }

    public void setTotalOutrosResource(Double totalOutrosResource) {
        this.totalOutrosResource = totalOutrosResource;
    }

    public Double getTotalLiquidoResource() {
        return totalLiquidoResource;
    }

    public void setTotalLiquidoResource(Double totalLiquidoResource) {
        this.totalLiquidoResource = totalLiquidoResource;
    }

    public boolean isExibeGrafico() {
        return exibeGrafico;
    }

    public void setExibeGrafico(boolean exibeGrafico) {
        this.exibeGrafico = exibeGrafico;
    }

    public Double getTotalOutrosFECAP() {
        return totalOutrosFECAP;
    }

    public void setTotalOutrosFECAP(Double totalOutrosFECAP) {
        this.totalOutrosFECAP = totalOutrosFECAP;
    }

    public Double getTotalLiquidoFECAP() {
        return totalLiquidoFECAP;
    }

    public void setTotalLiquidoFECAP(Double totalLiquidoFECAP) {
        this.totalLiquidoFECAP = totalLiquidoFECAP;
    }

    public Pagamentos getPagtoFECAP() {
        return pagtoFECAP;
    }

    public void setPagtoFECAP(Pagamentos pagtoFECAP) {
        this.pagtoFECAP = pagtoFECAP;
    }   

    public Double getTotalBrutoConsolidacao() {
        return totalBrutoConsolidacao;
    }

    public void setTotalBrutoConsolidacao(Double totalBrutoConsolidacao) {
        this.totalBrutoConsolidacao = totalBrutoConsolidacao;
    }

    public Double getTotalImpsConsolidacao() {
        return totalImpsConsolidacao;
    }

    public void setTotalImpsConsolidacao(Double totalImpsConsolidacao) {
        this.totalImpsConsolidacao = totalImpsConsolidacao;
    }

    public Double getTotalOutrosConsolidacao() {
        return totalOutrosConsolidacao;
    }

    public void setTotalOutrosConsolidacao(Double totalOutrosConsolidacao) {
        this.totalOutrosConsolidacao = totalOutrosConsolidacao;
    }

    public Double getTotalLiquidoConsolidacao() {
        return totalLiquidoConsolidacao;
    }

    public void setTotalLiquidoConsolidacao(Double totalLiquidoConsolidacao) {
        this.totalLiquidoConsolidacao = totalLiquidoConsolidacao;
    }

	public Double getImpostoPagar() {
		return impostoPagar;
	}

	public void setImpostoPagar(Double impostoPagar) {
		this.impostoPagar = impostoPagar;
	}
}