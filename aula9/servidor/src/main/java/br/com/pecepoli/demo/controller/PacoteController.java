package br.com.pecepoli.demo.controller;


import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.repository.PacoteRepository;
import br.com.pecepoli.demo.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PacoteController {
    @Autowired
    private PacoteRepository repository;

    private final PacoteService pacoteService;

    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pacotes")
    public ResponseEntity<List<Pacote>> obterTodos(@RequestParam(name = "q", required = false) String criteria, Pageable pageable) {
        Page<Pacote> pacotes = this.pacoteService.obterPacotes(criteria, pageable);
        return ResponseEntity.ok()
                             .header("Access-Control-Allow-Headers", "*")
                             .header("X-Total-Count", String.valueOf(pacotes.getTotalElements()))
                             .body(pacotes.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pacotes/{id}")
    public ResponseEntity<Pacote> obter(@PathVariable("id") UUID id) {
        Optional<Pacote> pacote = this.pacoteService.obterPacote(id);
        return pacote.map(x -> ResponseEntity.ok(x))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
