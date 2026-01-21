package com.samtech_.spring_eshop_demo.mapper;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import com.samtech_.spring_eshop_demo.dto.ModelDTO;
import com.samtech_.spring_eshop_demo.entity.BrandEntity;
import com.samtech_.spring_eshop_demo.entity.ModelEntity;
import com.samtech_.spring_eshop_demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    private final BrandService brandService;

    @Autowired
    public ModelMapper(BrandService brandService) {
        this.brandService = brandService;
    }

    public ModelEntity map(ModelDTO dto) {
        ModelEntity entity = new ModelEntity();
        entity.setName(dto.getName());

        // Fetch managed BrandEntity from DB
        BrandDTO brandDTO = brandService.findById(dto.getBrandId());
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(brandDTO.getId());
        brandEntity.setName(brandDTO.getName());

        entity.setBrand(brandEntity);

        return entity;
    }

    public ModelDTO map(ModelEntity entity) {
        ModelDTO dto = new ModelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBrandId(entity.getBrand().getId());
        return dto;
    }
}
