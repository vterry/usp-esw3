package br.com.pecepoli.demo.repository;


import br.com.pecepoli.demo.domain.Pacote;

import java.util.List;

public interface PacoteRepository {
    List<Pacote> obterTodos();
}
