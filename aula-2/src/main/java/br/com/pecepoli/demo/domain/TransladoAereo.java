package br.com.pecepoli.demo.domain;

public class TransladoAereo extends ItemPacote {
    private String companiaAerea;

    private String numeroVoo;

    public String getCompaniaAerea() { return companiaAerea; }

    public void setCompaniaAerea(String companiaAerea) { this.companiaAerea = companiaAerea; }

    public String getNumeroVoo() {  return numeroVoo;  }

    public void setNumeroVoo(String numeroVoo) { this.numeroVoo = numeroVoo;  }

    @Override
    public String toString() {
        return "TransladoAereo{" +
                "preco=" + getPreco() + '\'' +
                "companiaAerea='" + companiaAerea + '\'' +
                ", numeroVoo='" + numeroVoo + '\'' +
                '}';
    }
}
