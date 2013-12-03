package modelos;

public class Salario {

    private String mes;
    private Double bruto;
    private Double imposto;
    private Double outros;
    private Double liquido;

    public Salario() {}
    
    public Salario(Double bruto, Double imposto, Double outros, Double liquido) {
        this.bruto = bruto;
        this.imposto = imposto;
        this.outros = outros;
        this.liquido = liquido;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public Double getOutros() {
        return outros;
    }

    public void setOutros(Double outros) {
        this.outros = outros;
    }

    public Double getLiquido() {
        return liquido;
    }

    public void setLiquido(Double liquido) {
        this.liquido = liquido;
    }
}