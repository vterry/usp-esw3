package br.com.pecepoli.demo.domain;

public class Hospedagem extends ItemPacote {
    private String nomeHotel;

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
