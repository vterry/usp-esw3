package br.com.pecepoli.demo.repository;


import br.com.pecepoli.demo.domain.Hospedagem;
import br.com.pecepoli.demo.domain.ItemPacote;
import br.com.pecepoli.demo.domain.LocacaoVeiculo;
import br.com.pecepoli.demo.domain.Localidade;
import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.domain.TransladoAereo;
import com.github.javafaker.Faker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
@ConditionalOnProperty(
    name = "repository.type",
    havingValue = "dummy",
    matchIfMissing = true
)
public class DummyPacoteRepository implements PacoteRepository {
    private final Random random = new Random();

    private final Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));

    public List<Pacote> obterTodos() {
        int numeroPacotes = random.nextInt(200);
        List<Pacote> pacotes = new ArrayList<>();
        for (int i=0; i<numeroPacotes; i++) {
            pacotes.add(criarPacoteDummy());
        }
        return pacotes;
    }

    private Pacote criarPacoteDummy() {
        Pacote pacote = new Pacote();
        pacote.setDescricao(faker.lorem().paragraph());
        pacote.setLocalidade(criarLocalidadeDummy());
        
        pacote.addItem(criarHotelDummy());
        pacote.addItem(criarTransladoAereo());
        pacote.addItem(criarLocacaoVeiculo());
        
        return pacote;
    }

    private ItemPacote criarLocacaoVeiculo() {
        LocacaoVeiculo locacaoVeiculo = new LocacaoVeiculo();
        locacaoVeiculo.setMarca(faker.company().name());
        locacaoVeiculo.setModelo(faker.company().name());
        locacaoVeiculo.setPreco(faker.number().randomDouble(2, 100, 1000));
        return locacaoVeiculo;
    }

    private ItemPacote criarHotelDummy() {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setEndereco(faker.address().fullAddress());
        hospedagem.setNomeHotel(faker.company().name());
        hospedagem.setPreco(faker.number().randomDouble(2, 100, 1000));
        return hospedagem;
    }

    private ItemPacote criarTransladoAereo() {
        TransladoAereo transladoAereo = new TransladoAereo();
        transladoAereo.setCompaniaAerea(faker.company().name());
        transladoAereo.setNumeroVoo(faker.commerce().promotionCode());
        transladoAereo.setPreco(faker.number().randomDouble(2, 100, 1000));
        return transladoAereo;
    }

    private Localidade criarLocalidadeDummy() {
        Localidade localidade = new Localidade();
        localidade.setDescricao(faker.address().cityName());
        return localidade;
    }
}
