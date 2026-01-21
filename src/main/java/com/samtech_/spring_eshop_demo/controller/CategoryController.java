package com.samtech_.spring_eshop_demo.controller;

import com.samtech_.spring_eshop_demo.dto.CategoryDTO;
import com.samtech_.spring_eshop_demo.response.APIResponse;
import com.samtech_.spring_eshop_demo.service.CategoryService;
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
@RequestMapping(value = "/api/eshop/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<CategoryDTO>> saveCategory(@Valid @RequestBody CategoryDTO dto) {
        final CategoryDTO savedDTO = categoryService.save(dto);
        log.info("Create category...");

        APIResponse<CategoryDTO> response = new APIResponse<>(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Category saved successfully",
                true,
                savedDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<CategoryDTO>>> getCategories() {
        List<CategoryDTO> categories = categoryService.getCategories();

        APIResponse<List<CategoryDTO>> response = new APIResponse<>(
                LocalDateTime.now(),
                HttpStatus.FOUND.value(),
                "Fetched data for the response",
                true,
                categories
        );
        log.info("ready to response");
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
