package br.com.pecepoli.demo.domain;

import java.time.LocalDate;

public class Contratacao {
    private final double valor;
    private final LocalDate dataContratacao;

    private final Cliente cliente;

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
