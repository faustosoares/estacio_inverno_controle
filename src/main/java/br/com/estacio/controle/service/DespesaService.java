package br.com.estacio.controle.service;

import br.com.estacio.controle.dto.DespesaDto;
import br.com.estacio.controle.dto.DespesaFormDto;
import br.com.estacio.controle.model.Despesa;
import br.com.estacio.controle.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {
    @Autowired
    private DespesaRepository repository;
    public List<DespesaDto> listar(){
        List<Despesa> despesas = repository.findAll();

        return DespesaDto.converter(despesas);
    }

    public DespesaDto cadastrar(DespesaFormDto form){
        Despesa despesa = form.converter();

        repository.save(despesa);
        return new DespesaDto(despesa);
    }

    public DespesaDto buscarPorId(Long id) {
        Optional<Despesa> despesa = repository.findById(id);
        return new DespesaDto(despesa.get());
    }
}
