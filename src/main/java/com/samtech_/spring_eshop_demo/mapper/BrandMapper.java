package com.samtech_.spring_eshop_demo.mapper;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import com.samtech_.spring_eshop_demo.entity.BrandEntity;

public class BrandMapper {

    public static BrandEntity map(BrandDTO dto){
        BrandEntity entity = new BrandEntity();
        // DO NOT set ID here for new brands
        entity.setName(dto.getName());
        return entity;
    }

    public static BrandDTO map(BrandEntity entity){
        BrandDTO dto = new BrandDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
