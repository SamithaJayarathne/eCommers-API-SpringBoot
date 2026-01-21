package com.samtech_.spring_eshop_demo.controller;

import com.samtech_.spring_eshop_demo.dto.ModelDTO;
import com.samtech_.spring_eshop_demo.response.APIResponse;
import com.samtech_.spring_eshop_demo.service.ModelService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/eshop/model")
public class ModelController {

    @Autowired
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<ModelDTO>> saveModel(@Valid @RequestBody ModelDTO dto){
        log.info("Model dto received: {}", dto);
        ModelDTO savedDTO = modelService.saveModel(dto);
        log.info("Model saved. Ready to send response");

        APIResponse<ModelDTO> response = new APIResponse<ModelDTO>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "New Model: " + savedDTO.getName() + " saved successfully",
                true,
                savedDTO
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ModelDTO>>> getModels(){
        final List<ModelDTO> allModels = modelService.getAllModels();
        log.info("Model list fetched. Ready to send the response");

        APIResponse<List<ModelDTO>> response = new APIResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "All models fetched",
                true,
                allModels
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{modelId}")
    public ResponseEntity<APIResponse<ModelDTO>> findModelById(@PathVariable Integer modelId){
        ModelDTO modelDTO = modelService.findById(modelId);
        APIResponse<ModelDTO> response = new APIResponse<ModelDTO>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Model found: " + modelDTO.getName(),
                true,
                modelDTO
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
