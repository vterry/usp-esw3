package br.com.pecepoli.demo.service;

import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.repository.DummyPacoteRepository;
import br.com.pecepoli.demo.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyService {

    @Autowired
    private PacoteRepository dummyPacoteRepository;

    public List<Pacote> listarPacotes(){
        return dummyPacoteRepository.obterTodos();
    }

}
