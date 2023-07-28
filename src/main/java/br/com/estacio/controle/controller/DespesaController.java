package br.com.estacio.controle.controller;

import br.com.estacio.controle.dto.DespesaDto;
import br.com.estacio.controle.dto.DespesaFormDto;
import br.com.estacio.controle.service.DespesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity<List<DespesaDto>> listar(){
        List<DespesaDto> despesas = service.listar();

        return ResponseEntity.ok(despesas);
    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity cadastrar(@RequestBody @Valid DespesaFormDto form,  UriComponentsBuilder uriBuilder){
        DespesaDto despesaDto = service.cadastrar(form);

        var uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesaDto.getId()).toUri();

        return ResponseEntity.created(uri).body(despesaDto);
    }

    @GetMapping("/{id}")
    public DespesaDto buscar(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    //TODO criar remover

    //TODO criar alterar
}
