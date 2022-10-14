package com.example.sacolaapi.services.impl;

import com.example.sacolaapi.model.Item;
import com.example.sacolaapi.model.Restaurante;
import com.example.sacolaapi.model.Sacola;
import com.example.sacolaapi.model.enums.FormaPagamento;
import com.example.sacolaapi.repository.ItemRepository;
import com.example.sacolaapi.repository.ProdutoRepository;
import com.example.sacolaapi.repository.SacolaRepository;
import com.example.sacolaapi.resources.dtos.ItemDto;
import com.example.sacolaapi.services.SacolaService;
import com.example.sacolaapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {

    private final ProdutoRepository produtoRepository;
    private final ItemRepository itemRepository;
    private final SacolaRepository sacolaRepository;

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Essa sacola não existe");
        });
    }
    @Override
    public List<Sacola> verSacolas() {
        return sacolaRepository.findAll();
    }
    @Override
    public Item incluirItemSacola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getIdSacola());
        if (sacola.isFechada()) {
            throw new ObjectNotFoundException("Esta sacola esta fechada");
        }
        Item itemParaSerInserido = Item.builder()
                .quantidade(itemDto.getQuantidade())
                .sacola(sacola)
                .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(() -> {
                    throw new ObjectNotFoundException("Esse produto não existe");
                })).build();

        List<Item> itensDaSacola = sacola.getItems();
        if (itensDaSacola.isEmpty()) {
            itensDaSacola.add(itemParaSerInserido);
        } else {
            Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();
            Restaurante restauranteDoItemParaAdicionar = itemParaSerInserido.getProduto().getRestaurante();

            if (restauranteAtual.equals(restauranteDoItemParaAdicionar)) {
                throw new ObjectNotFoundException("não é possivel adicionar produtos de " +
                        "restaurantes diferentes,feche a sacola ou esvazie");
            }
        }

        List<Double> valorDosItens = new ArrayList<>();
        for (Item itemDaSacola : itensDaSacola) {
            Double valorTotalItem = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
            valorDosItens.add(valorTotalItem);
        }

        double valorTotalSacola = valorDosItens
                .stream()
                .mapToDouble(valorTotaldeCadaItem -> valorTotaldeCadaItem)
                .sum();
        sacola.setValorTotal(valorTotalSacola);
        sacolaRepository.save(sacola);
        return itemParaSerInserido;
    }
    @Override
    public Sacola fecharSacola(Long id, int numeroFormaPagamento) {

        Sacola sacola = verSacola(id);
        if (sacola.getItems().isEmpty()){
            throw new RuntimeException("Inclua itens na sacola");
        }
        FormaPagamento formaPagamento = numeroFormaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);

        return sacolaRepository.save(sacola);
    }
}
