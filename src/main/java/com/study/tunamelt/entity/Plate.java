package com.study.tunamelt.entity;

import com.study.tunamelt.enums.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "plates")
public class Plate {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean available;

    @Column(nullable = false)
    private Boolean vegan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;
}
