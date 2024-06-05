package br.com.pecepoli.demo.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;

    private final List<Contratacao> contratacoes = new ArrayList<>();

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public Contratacao contratar(Pacote pacote) {
        Contratacao contratacao = new Contratacao(this, pacote);
        this.contratacoes.add(contratacao);
        return contratacao;
    }
}
