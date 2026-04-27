package com.study.tunamelt.service;

import com.study.tunamelt.dto.menuItem.CreateMenuItemDTO;
import com.study.tunamelt.dto.menuItem.ResponseMenuItemDTO;
import com.study.tunamelt.dto.menuItem.UpdateMenuItemDTO;
import com.study.tunamelt.entity.MenuItem;
import com.study.tunamelt.mapper.MenuItemMapper;
import com.study.tunamelt.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public List<ResponseMenuItemDTO> findAll(){
        List<MenuItem> response = menuItemRepository.findAllByAvailable(true);
        return response.stream().map(MenuItemMapper::entityToDTO).toList();
    }

    public ResponseMenuItemDTO create(CreateMenuItemDTO dto){
        MenuItem entity = MenuItemMapper.createMenuItemToEntity(dto);
        MenuItem saved = menuItemRepository.save(entity);
        return MenuItemMapper.entityToDTO(saved);
    }

    public ResponseMenuItemDTO update(UpdateMenuItemDTO dto){
        MenuItem entity = MenuItemMapper.updateMenuItemToEntity(dto);
        MenuItem saved = menuItemRepository.save(entity);
        return MenuItemMapper.entityToDTO(saved);
    }

    public void delete(UUID id){
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum item não foi encontrado"));

        menuItemRepository.delete(menuItem);
    }
}
