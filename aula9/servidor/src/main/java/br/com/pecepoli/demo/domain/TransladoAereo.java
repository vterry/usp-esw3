package br.com.pecepoli.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "VOOS")
@PrimaryKeyJoinColumn(name = "ID")
public class TransladoAereo extends ItemPacote {
    @Column(name = "COMPANHIA_AREA")
    private String companhiaAerea;

    @Column(name = "NUMERO_VOO")
    private String numeroVoo;

    public String getCompanhiaAerea() { return companhiaAerea; }

    public void setCompanhiaAerea(String companhiaAerea) { this.companhiaAerea = companhiaAerea; }

    public String getNumeroVoo() {  return numeroVoo;  }

    public void setNumeroVoo(String numeroVoo) { this.numeroVoo = numeroVoo;  }

    @Override
    public String toString() {
        return "TransladoAereo{" +
                "preco=" + getPreco() + '\'' +
                "companiaAerea='" + companhiaAerea + '\'' +
                ", numeroVoo='" + numeroVoo + '\'' +
                '}';
    }
}
