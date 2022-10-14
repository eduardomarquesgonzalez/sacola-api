package com.example.sacolaapi.model.dto;

import com.example.sacolaapi.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProdutoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Double valorUnitario;
    private boolean disponivel = true;
    private Restaurante restaurante;

    public ProdutoDto(ProdutoDto obj){
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.valorUnitario = obj.getValorUnitario();
        this.disponivel = obj.isDisponivel();
        this.restaurante = obj.getRestaurante();
    }
}
