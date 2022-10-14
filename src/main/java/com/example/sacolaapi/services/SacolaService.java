package com.example.sacolaapi.services;

import com.example.sacolaapi.model.Item;
import com.example.sacolaapi.model.Sacola;
import com.example.sacolaapi.resources.dtos.ItemDto;

import java.util.List;

public interface SacolaService {
    List<Sacola> verSacolas();
    Item incluirItemSacola(ItemDto itemDto);
    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaPagamento);
}
