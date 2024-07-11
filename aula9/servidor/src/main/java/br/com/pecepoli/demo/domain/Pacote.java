package br.com.pecepoli.demo.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PACOTES")
public class Pacote {

    @Id
    @Column(name = "ID")
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(generator = "ulid_generator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "LOCALIDADE_ID")
    private Localidade localidade;

    @Column(name = "DESCRICAO", length = 1024)
    private String descricao;


    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PACOTE_ID", updatable = false, nullable = false)
    private final List<ItemPacote> items = new ArrayList<>();

    public UUID getId() { return id; }

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
