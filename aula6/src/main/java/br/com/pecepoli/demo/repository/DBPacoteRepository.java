package br.com.pecepoli.demo.repository;

import br.com.pecepoli.demo.domain.Pacote;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@ConditionalOnProperty(
    name = "repository.type",
    havingValue = "db",
    matchIfMissing = false
)
public class DBPacoteRepository implements PacoteRepository {
    @Override
    public List<Pacote> obterTodos() {
        throw new UnsupportedOperationException();
    }
}
