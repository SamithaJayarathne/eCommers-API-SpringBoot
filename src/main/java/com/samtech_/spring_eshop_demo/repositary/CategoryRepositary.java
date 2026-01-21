package com.samtech_.spring_eshop_demo.repositary;

import com.samtech_.spring_eshop_demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositary extends JpaRepository<CategoryEntity, Integer> {
}
