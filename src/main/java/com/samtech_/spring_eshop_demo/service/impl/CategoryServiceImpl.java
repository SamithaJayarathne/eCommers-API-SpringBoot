package com.samtech_.spring_eshop_demo.service.impl;

import com.samtech_.spring_eshop_demo.dto.CategoryDTO;
import com.samtech_.spring_eshop_demo.entity.CategoryEntity;
import com.samtech_.spring_eshop_demo.mapper.CategoryMapper;
import com.samtech_.spring_eshop_demo.repositary.CategoryRepository;
import com.samtech_.spring_eshop_demo.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${spring.datasource.url}")
    private String datasource;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(final CategoryDTO dto) {

        log.info("Saving a new category");

        if(dto==null) {
            log.error("Failed to save category: input DTO is null");
            throw new IllegalArgumentException("Category data must not be null");
        }

        log.debug("CategoryDTO received: {}", dto);
        final CategoryEntity mappedEntity = CategoryMapper.map(dto);
        final CategoryEntity savedEntity = categoryRepository.save(mappedEntity);
        log.info("Category saved with ID: {} at data-source: {}",savedEntity.getId(),this.datasource);

        return CategoryMapper.map(savedEntity);
    }

    @Override
    public List<CategoryDTO> getCategories() {
        log.info("Fetching category data..");

        final List<CategoryDTO> list = categoryRepository
                .findAll()
                .stream()
                .map(CategoryMapper::map)
                .toList();
        log.info("Category data fetched: {}", list);

        return  list;
    }

}
