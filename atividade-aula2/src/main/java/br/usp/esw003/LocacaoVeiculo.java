package br.usp.esw003;

public class LocacaoVeiculo extends ItemPacote{
    private String marca = "";
    private String modelo = "";

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
