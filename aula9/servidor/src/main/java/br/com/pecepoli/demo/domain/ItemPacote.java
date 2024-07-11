package br.com.pecepoli.demo.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "ITEMS_PACOTE", indexes = @Index(columnList = "PACOTE_ID"))
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Hospedagem.class, name = "hotel"),
    @JsonSubTypes.Type(value = LocacaoVeiculo.class, name = "veiculo"),
    @JsonSubTypes.Type(value = TransladoAereo.class, name = "voo"),
})
public abstract class ItemPacote {

    @Id
    @Column(name = "ID")
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(generator = "ulid_generator")
    private UUID id;

    @Column(name = "PRECO")
    private double preco;

    public void setPreco(double preco) { this.preco = preco; }

    public double getPreco() { return this.preco; }
}
