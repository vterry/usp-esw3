package br.usp.esw003;

public class Pacote {
    private Localidade localidade = null;
    private ItemPacote itemPacote = null;

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public ItemPacote getItemPacote() {
        return itemPacote;
    }

    public void setItemPacote(ItemPacote itemPacote) {
        this.itemPacote = itemPacote;
    }
}
