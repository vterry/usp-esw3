package br.com.pecepoli.demo.config;

import br.com.pecepoli.demo.domain.Localidade;
import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.repository.PacoteRepository;
import br.com.pecepoli.demo.repository.LocalidadeRepository;
import br.com.pecepoli.demo.utils.FakerFacade;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabasePopulator {

    @Value("${numero.localidades:256}")
    private int numeroLocalidades;

    @Value("${numero.pacotes:1024}")
    private int numeroPacotes;

    @Autowired
    private FakerFacade fakerFacade;

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @PostConstruct
    @Transactional
    public void populateDatabase() {
        List<Localidade> localidades = this.populateLocalidades();
        this.populatePacotes(localidades);
    }

    private List<Pacote> populatePacotes(List<Localidade> localidades) {
        List<Pacote> pacotes = new ArrayList<>(numeroPacotes);
        for (int i=0; i<numeroPacotes; i++) {
            pacotes.add(fakerFacade.pacoteDummy(localidades.get(0)));
        }
        return this.pacoteRepository.saveAll(pacotes);
    }


    private List<Localidade> populateLocalidades() {
        List<Localidade> localidades = new ArrayList<>(numeroLocalidades);
        for (int i=0;i<numeroLocalidades; i++) {
            localidades.add(fakerFacade.localidadeDummy());
        }
        return this.localidadeRepository.saveAll(localidades);
    }


}
