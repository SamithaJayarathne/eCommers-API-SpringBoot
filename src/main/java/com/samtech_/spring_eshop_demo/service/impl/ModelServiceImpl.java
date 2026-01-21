package com.samtech_.spring_eshop_demo.service.impl;

import com.samtech_.spring_eshop_demo.dto.ModelDTO;
import com.samtech_.spring_eshop_demo.entity.ModelEntity;
import com.samtech_.spring_eshop_demo.mapper.ModelMapper;
import com.samtech_.spring_eshop_demo.repositary.ModelRepository;
import com.samtech_.spring_eshop_demo.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelDTO> getAllModels() {
        return modelRepository.findAll()
                .stream()
                .map(modelMapper::map)
                .toList();
    }

    @Override
    public ModelDTO saveModel(ModelDTO dto) {
        if (dto == null) throw new IllegalArgumentException("Model must not be empty");

        ModelEntity entity = modelMapper.map(dto); // uses managed BrandEntity
        ModelEntity savedEntity = modelRepository.save(entity);

        return modelMapper.map(savedEntity);
    }

    @Override
    public ModelDTO findById(int id) {
        ModelEntity entity = modelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Model not found with ID: " + id));
        return modelMapper.map(entity);
    }
}
