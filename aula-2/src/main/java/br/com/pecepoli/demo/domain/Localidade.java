package br.com.pecepoli.demo.domain;

public class Localidade {
    private String descricao;

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) {this.descricao = descricao; }

    @Override
    public String toString() {
        return "Localidade{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
