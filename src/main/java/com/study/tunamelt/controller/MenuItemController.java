package com.study.tunamelt.controller;

import com.study.tunamelt.entity.MenuItem;
import com.study.tunamelt.repository.MenuItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plates")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemRepository menuItemRepository;

    @GetMapping("/teste")
    public void teste(){
        throw new RuntimeException("error");
    }

    @GetMapping
    public List<MenuItem> findAll(){
        return menuItemRepository.findAllByAvailable(true);
    }

    @PostMapping
    public MenuItem create(@RequestBody @Valid MenuItem menuItem){

        return menuItemRepository.save(menuItem);
    }

    @PutMapping
    public MenuItem update(@RequestBody MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){

        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado"));

        menuItemRepository.delete(menuItem);
    }
}
