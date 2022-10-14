package com.example.sacolaapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Produto produto; //um produto tem uma sacola
    private int quantidade;
    @ManyToOne // uma sacolatem varios produtos
    private Sacola sacola;
}
