package br.com.pecepoli.demo.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CONTRATACOES")
public class Contratacao {

    @Id
    @Column(name = "ID")
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(generator = "ulid_generator")
    private UUID id;

    @Column(name = "VALOR")
    private final double valor;


    @Column(name = "DATA_CONTRACAO")
    private final LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private final Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "PACOTE_ID")
    private final Pacote pacote;

    Contratacao(Cliente cliente, Pacote pacote) {
        this.cliente = cliente;
        this.pacote = pacote;
        this.dataContratacao = LocalDate.now();
        this.valor = pacote.getValor();
    }

    public double getValor() { return valor; }

    public LocalDate getDataContratacao() { return dataContratacao; }

    public Cliente getCliente() { return cliente; }

    public Pacote getPacote() { return pacote; }
}
