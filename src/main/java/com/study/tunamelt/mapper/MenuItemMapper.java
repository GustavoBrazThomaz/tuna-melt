package com.study.tunamelt.mapper;

import com.study.tunamelt.dto.menuItem.CreateMenuItemDTO;
import com.study.tunamelt.dto.menuItem.ResponseMenuItemDTO;
import com.study.tunamelt.dto.menuItem.UpdateMenuItemDTO;
import com.study.tunamelt.entity.MenuItem;

public class MenuItemMapper {
    public static MenuItem createMenuItemToEntity(CreateMenuItemDTO dto) {
        return MenuItem.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .category(dto.category())
                .available(true)
                .vegan(false)
                .build();
    }

    public static MenuItem updateMenuItemToEntity(UpdateMenuItemDTO dto){
        return MenuItem.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .category(dto.category())
                .available(true)
                .vegan(false)
                .build();
    }

    public static ResponseMenuItemDTO entityToDTO(MenuItem entity) {
        return ResponseMenuItemDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .available(entity.isAvailable())
                .vegan(entity.isVegan())
                .category(entity.getCategory())
                .build();
    }
}
