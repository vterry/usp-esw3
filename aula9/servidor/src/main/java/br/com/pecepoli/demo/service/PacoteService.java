package br.com.pecepoli.demo.service;

import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.repository.PacoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacoteService {
    private final PacoteRepository repository;

    public PacoteService(PacoteRepository repository) {
        this.repository = repository;
    }

    public Page<Pacote> obterPacotes(String criteria, Pageable pageable) {
        Page<UUID> ids = findIds(criteria, pageable);
        List<Pacote> pacotes = this.repository.findAllById(ids.toSet());
        return new PageImpl<>(pacotes, ids.getPageable(), ids.getTotalElements());
    }

    private Page<UUID> findIds(String criteria, Pageable pageable) {
        if (criteria == null) {
            return this.repository.findIds(pageable);
        } else {
            return this.repository.findIds("%" + criteria + "%", pageable);
        }
    }

    public Optional<Pacote> obterPacote(UUID id) {
        return this.repository.findById(id);
    }
}
