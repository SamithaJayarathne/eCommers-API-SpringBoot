package com.samtech_.spring_eshop_demo.controller;

import com.samtech_.spring_eshop_demo.dto.CategoryDTO;
import com.samtech_.spring_eshop_demo.response.APIResponse;
import com.samtech_.spring_eshop_demo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/eshop/category")
@Tag(name = "Category Management", description = "APIs for managing categories")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created successfully",
                    content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(schema = @Schema(implementation = APIResponse.class)))
    })
    @PostMapping
    public ResponseEntity<APIResponse<CategoryDTO>> saveCategory(@Valid @RequestBody CategoryDTO dto) {
        CategoryDTO savedDTO = categoryService.save(dto);

        APIResponse<CategoryDTO> response = new APIResponse<>(
                LocalDateTime.now(),
                201,
                "Category saved successfully",
                true,
                savedDTO
        );

        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched categories successfully",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryDTO.class))))
    })
    @GetMapping
    public ResponseEntity<APIResponse<List<CategoryDTO>>> getCategories() {
        List<CategoryDTO> categories = categoryService.getCategories();

        APIResponse<List<CategoryDTO>> response = new APIResponse<>(
                LocalDateTime.now(),
                200,
                "Fetched categories successfully",
                true,
                categories
        );

        return ResponseEntity.ok(response);
    }
}
