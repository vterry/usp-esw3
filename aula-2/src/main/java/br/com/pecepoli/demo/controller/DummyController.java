package br.com.pecepoli.demo.controller;

import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DummyController {

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET, path = "/pacotes")
    public List<Pacote> listPacotesResquest(){
        return dummyService.listarPacotes();
    }

}
