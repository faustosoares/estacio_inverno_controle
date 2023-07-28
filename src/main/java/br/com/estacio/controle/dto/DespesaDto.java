package br.com.estacio.controle.dto;

import br.com.estacio.controle.model.Despesa;

import java.util.List;

public class DespesaDto {
    private Long id;
    private String descricao;
    private Double valor;

    public DespesaDto(){
        super();
    }

    public DespesaDto(Despesa despesa){
        this.id = despesa.getId();
        this.descricao = despesa.getDescricao();
        this.valor = despesa.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public static List<DespesaDto> converter(List<Despesa> despesas) {
        return despesas.stream().map(DespesaDto::new).toList();
    }
}
