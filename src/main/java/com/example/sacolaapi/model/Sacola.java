package com.example.sacolaapi.model;

import com.example.sacolaapi.model.enums.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false) // um cliente pode ter varias sacolas
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    private Double valorTotal;
    @Enumerated
    private FormaPagamento formaPagamento;
    private boolean fechada;
}
