package com.example.sacolaapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class Endereco {

    private String cep;
    private String complemento;
}
