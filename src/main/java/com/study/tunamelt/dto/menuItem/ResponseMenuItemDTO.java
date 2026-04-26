package com.study.tunamelt.dto.menuItem;

import com.study.tunamelt.enums.Category;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ResponseMenuItemDTO(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        boolean available,
        boolean vegan,
        Category category
) {
}
