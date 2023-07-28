package br.com.estacio.controle.dto;

import br.com.estacio.controle.model.Despesa;
import br.com.estacio.controle.repository.DespesaRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class DespesaFormDto {

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String descricao;

    @NotNull
    private Double valor;

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

    public Despesa converter() {
        return new Despesa(descricao, valor);
    }

    public Despesa atualizar(Long id, DespesaRepository despesaRepository) {
        Despesa despesa = despesaRepository.getReferenceById(id);
        despesa.setDescricao(this.descricao);
        despesa.setValor(this.valor);

        return despesa;
    }

    @Override
    public String toString() {
        return "DespesaFormDto{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
