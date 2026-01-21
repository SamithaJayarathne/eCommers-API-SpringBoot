package com.samtech_.spring_eshop_demo.service.impl;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import com.samtech_.spring_eshop_demo.entity.BrandEntity;
import com.samtech_.spring_eshop_demo.mapper.BrandMapper;
import com.samtech_.spring_eshop_demo.repositary.BrandRepository;
import com.samtech_.spring_eshop_demo.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(BrandMapper::map)
                .toList();
    }

    @Override
    public BrandDTO saveBrand(BrandDTO dto) {
        if (dto == null) throw new IllegalArgumentException("Brand must not be empty");

        BrandEntity entity = BrandMapper.map(dto); // ID not set for new
        BrandEntity savedEntity = brandRepository.save(entity);

        return BrandMapper.map(savedEntity); // returned DTO now has generated ID
    }

    @Override
    public BrandDTO findById(int id) {
        BrandEntity brandEntity = brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found with ID: " + id));
        return BrandMapper.map(brandEntity);
    }
}
