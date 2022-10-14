package com.example.sacolaapi.resources;

import com.example.sacolaapi.model.Item;
import com.example.sacolaapi.model.Sacola;
import com.example.sacolaapi.resources.dtos.ItemDto;
import com.example.sacolaapi.services.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {

    private final SacolaService sacolaService;

    @GetMapping("/{id}")
    public ResponseEntity<Sacola> verSacola(@PathVariable Long id) {
       Sacola obj = sacolaService.verSacola(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Sacola>> findAll() {
        List<Sacola> list = sacolaService.verSacolas();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
        return sacolaService.incluirItemSacola(itemDto);
    }

    @PatchMapping("/fechar-sacola/{id}")
    public Sacola fecharSacola(@PathVariable Long id, @RequestParam int formaPagamento){
        return sacolaService.fecharSacola(id, formaPagamento);
    }
}
