package br.usp.esw003;

import java.util.Date;
import java.util.List;

public class Contratacao {

    private float valor = 0;
    private Date dataContratacao = null;
    private List<Pacote> pacotes = null;

    public void realizarContratacao(float valor, Date dataContratacao,List<Pacote> pacotes){
        this.valor = valor;
        this.dataContratacao = dataContratacao;
        this.pacotes = pacotes;
    }

    public void adicionarPacotes(Pacote pacote){
        this.pacotes.add(pacote);
    }

    public void removerPacotes(Pacote pacote){
        this.pacotes.remove(pacote);
    }

}
