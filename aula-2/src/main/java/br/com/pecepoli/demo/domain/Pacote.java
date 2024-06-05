package br.com.pecepoli.demo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pacote {

    private Localidade localidade;

    private String descricao;

    private final List<ItemPacote> items = new ArrayList<>();

    public Localidade getLocalidade() { return localidade; }

    public void setLocalidade(Localidade localidade) { this.localidade = localidade; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) {this.descricao = descricao; }

    public List<ItemPacote> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(ItemPacote item) {
        this.items.add(item);
    }

    public void removeItem(ItemPacote item) {
        this.items.remove(item);
    }

    public double getValor() {
        return getItems().stream()
                         .mapToDouble(x -> x.getPreco())
                         .sum();
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "localidade=" + localidade +
                ", descricao='" + descricao + '\'' +
                ", items=" + items +
                '}';
    }
}
