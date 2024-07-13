package br.com.pecepoli.demo.utils;

import br.com.pecepoli.demo.domain.Hospedagem;
import br.com.pecepoli.demo.domain.ItemPacote;
import br.com.pecepoli.demo.domain.LocacaoVeiculo;
import br.com.pecepoli.demo.domain.Localidade;
import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.domain.TransladoAereo;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class FakerFacade {

    private final Faker faker = new Faker(Locale.forLanguageTag("pt-BR"), new Random(19800227125959l));

    public Pacote pacoteDummy() {
        return pacoteDummy(localidadeDummy());
    }

    public Pacote pacoteDummy(Localidade localidade) {
        Pacote pacote = new Pacote();
        pacote.setDescricao(faker.lorem().paragraph());
        pacote.setLocalidade(localidade);

        pacote.addItem(hotelDummy());
        pacote.addItem(transladoAereo());
        pacote.addItem(locacaoVeiculo());

        return pacote;
    }

    public ItemPacote locacaoVeiculo() {
        LocacaoVeiculo locacaoVeiculo = new LocacaoVeiculo();
        locacaoVeiculo.setMarca(faker.company().name());
        locacaoVeiculo.setModelo(faker.company().name());
        locacaoVeiculo.setPreco(faker.number().randomDouble(2, 100, 1000));
        return locacaoVeiculo;
    }

    public ItemPacote hotelDummy() {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setEndereco(faker.address().fullAddress());
        hospedagem.setNomeHotel(faker.company().name());
        hospedagem.setPreco(faker.number().randomDouble(2, 100, 1000));
        return hospedagem;
    }

    public ItemPacote transladoAereo() {
        TransladoAereo transladoAereo = new TransladoAereo();
        transladoAereo.setCompanhiaAerea(faker.company().name());
        transladoAereo.setNumeroVoo(faker.commerce().promotionCode());
        transladoAereo.setPreco(faker.number().randomDouble(2, 100, 1000));
        return transladoAereo;
    }

    public Localidade localidadeDummy() {
        Localidade localidade = new Localidade();
        localidade.setDescricao(faker.address().cityName());
        localidade.setEstado(faker.address().state());
        return localidade;
    }

}
