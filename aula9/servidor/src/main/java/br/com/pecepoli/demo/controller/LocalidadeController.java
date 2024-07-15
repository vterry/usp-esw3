package br.com.pecepoli.demo.controller;

import br.com.pecepoli.demo.domain.Localidade;
import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.repository.LocalidadeRepository;
import br.com.pecepoli.demo.repository.PacoteRepository;
import br.com.pecepoli.demo.service.LocalidadeService;
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
public class LocalidadeController {

    @Autowired
    private LocalidadeRepository repository;

    private final LocalidadeService localidadeService;

    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    // Novo endpoint para /localidades
    @RequestMapping(method = RequestMethod.GET, value = "/localidades")
    public ResponseEntity<List<Localidade>> obterTodasLocalidades(@RequestParam(name = "q", required = false) String criteria, Pageable pageable) {
        Page<Localidade> localidade = this.localidadeService.obterLocalidades(criteria, pageable);
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Headers", "*")
                .header("X-Total-Count", String.valueOf(localidade.getTotalElements()))
                .body(localidade.toList());
    }

}
