package com.study.tunamelt.repository;

import com.study.tunamelt.entity.MenuItem;
import com.study.tunamelt.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {

    List<MenuItem> findAllByAvailable(boolean available);
    List<MenuItem> findAllByVeganAndAvailable(boolean vegan, boolean available);
    List<MenuItem> findByCategory(Category category);
}
