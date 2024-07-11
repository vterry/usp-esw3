package br.com.pecepoli.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "HOTEIS")
@PrimaryKeyJoinColumn(name = "ID")
public class Hospedagem extends ItemPacote {

    @Column(name="NOME")
    private String nomeHotel;

    @Column(name = "ENDERECO")
    private String endereco;

    public String getNomeHotel() { return nomeHotel; }

    public void setNomeHotel(String nomeHotel) { this.nomeHotel = nomeHotel; }

    public String getEndereco() {  return endereco;  }

    public void setEndereco(String endereco) { this.endereco = endereco;  }


    @Override
    public String toString() {
        return "Hospedagem{" +
                "preco=" + getPreco() + '\'' +
                "nomeHotel='" + nomeHotel + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
