package com.samtech_.spring_eshop_demo.controller;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import com.samtech_.spring_eshop_demo.response.APIResponse;
import com.samtech_.spring_eshop_demo.service.BrandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/eshop/brand")
@Validated
public class BrandController {

    @Autowired
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<BrandDTO>> saveBrand(@Valid @RequestBody BrandDTO dto){
        BrandDTO savedDTO = brandService.saveBrand(dto);
        log.info("Brand saved. Ready to send response");

        APIResponse<BrandDTO> response = new APIResponse<BrandDTO>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "New Brand: " + savedDTO.getName() + " saved successfully",
                true,
                savedDTO
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<BrandDTO>>> getBrands(){
        final List<BrandDTO> allBrands = brandService.getAllBrands();
        log.info("Brand list fetched. Ready to send the response");

        APIResponse<List<BrandDTO>> response = new APIResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "All brands fetched",
                true,
                allBrands
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<APIResponse<BrandDTO>> findBrandById(@PathVariable Integer brandId){
        BrandDTO brandDTO = brandService.findById(brandId);
        APIResponse<BrandDTO> response = new APIResponse<BrandDTO>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Brand found: " + brandDTO.getName(),
                true,
                brandDTO
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
