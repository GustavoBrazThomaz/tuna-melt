package com.study.tunamelt.dto.menuItem;

import com.study.tunamelt.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record UpdateMenuItemDTO(
        @NotNull(message = "O id é obrigatório")
        UUID id,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 512, message = "A descrição não pode passar de 512 caractéres")
        String description,

        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser positivo")
        BigDecimal price,

        boolean available,
        boolean vegan,

        @NotNull(message = "A categoria é obrigatória")
        Category category
) {
}
