package com.samtech_.spring_eshop_demo.service;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import com.samtech_.spring_eshop_demo.dto.ModelDTO;

import java.util.List;

public interface ModelService {

    public List<ModelDTO> getAllModels();

    public ModelDTO saveModel(ModelDTO dto);

    public ModelDTO findById(int id);
}
