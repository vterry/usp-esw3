package br.usp.esw003;

public class TransladoAereo extends ItemPacote{
    private String companhiaArea = "";
    private int numeroVoo = 0;

    public TransladoAereo criar(float preco, String companhiaArea, int numeroVoo){
        TransladoAereo translado = new TransladoAereo();
        translado.setPreco(preco);
        translado.companhiaArea = companhiaArea;
        translado.numeroVoo = numeroVoo;
        return translado;
    }

}
