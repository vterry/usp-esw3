package br.com.pecepoli.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEICULOS")
@PrimaryKeyJoinColumn(name = "ID")
public class LocacaoVeiculo extends ItemPacote {
    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() {  return modelo;  }

    public void setModelo(String modelo) { this.modelo = modelo;  }

    @Override
    public String toString() {
        return "LocacaoVeiculo{" +
                "preco=" + getPreco() + '\'' +

                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
