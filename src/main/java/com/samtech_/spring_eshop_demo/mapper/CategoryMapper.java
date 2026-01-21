package com.samtech_.spring_eshop_demo.mapper;

import com.samtech_.spring_eshop_demo.dto.CategoryDTO;
import com.samtech_.spring_eshop_demo.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity map(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();

        entity.setName(dto.getName());

        return entity;
    }

    public static CategoryDTO map(CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

}
