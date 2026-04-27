package com.study.tunamelt.controller;

import com.study.tunamelt.dto.menuItem.CreateMenuItemDTO;
import com.study.tunamelt.dto.menuItem.ResponseMenuItemDTO;
import com.study.tunamelt.dto.menuItem.UpdateMenuItemDTO;
import com.study.tunamelt.entity.MenuItem;
import com.study.tunamelt.repository.MenuItemRepository;
import com.study.tunamelt.service.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menuItems")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @GetMapping
    public List<ResponseMenuItemDTO> findAll(){
        return menuItemService.findAll();
    }

    @PostMapping
    public ResponseMenuItemDTO create(@RequestBody @Valid CreateMenuItemDTO menuItem){
        return menuItemService.create(menuItem);
    }

    @PutMapping
    public ResponseMenuItemDTO update(@RequestBody @Valid UpdateMenuItemDTO menuItem){
        return menuItemService.update(menuItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        menuItemService.delete(id);
    }
}
