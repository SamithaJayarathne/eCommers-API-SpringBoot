package com.samtech_.spring_eshop_demo.service;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import com.samtech_.spring_eshop_demo.entity.BrandEntity;

import java.util.List;

public interface BrandService {

    public List<BrandDTO> getAllBrands();

    public BrandDTO saveBrand(BrandDTO dto);

    public BrandDTO findById(int id);

}
