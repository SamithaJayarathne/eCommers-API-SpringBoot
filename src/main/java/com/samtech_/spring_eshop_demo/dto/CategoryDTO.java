package com.samtech_.spring_eshop_demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Category data transfer object")
public class CategoryDTO {

    @Schema(description = "Unique ID of the category", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @NotBlank(message = "Category name must not be blank")
    @Size(min = 3, max = 45, message = "Category name must be between 3 and 45 characters")
    @JsonProperty("name")
    @Schema(description = "Name of the category", example = "Laptops", required = true)
    private String name;
}
