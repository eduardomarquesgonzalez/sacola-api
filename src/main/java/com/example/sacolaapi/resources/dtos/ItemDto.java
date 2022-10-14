package com.example.sacolaapi.resources.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class ItemDto {

    private Long produtoId;
    private int quantidade;
    private Long idSacola;
}
