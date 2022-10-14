package com.example.sacolaapi.model;

import com.example.sacolaapi.model.dto.ProdutoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double valorUnitario;
    @Builder.Default
    private boolean disponivel = true;
    @ManyToOne
    @JsonIgnore
    private Restaurante restaurante;

    public Produto(ProdutoDto obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.valorUnitario = obj.getValorUnitario();
        this.disponivel = obj.isDisponivel();
        this.restaurante = obj.getRestaurante();
    }


}
