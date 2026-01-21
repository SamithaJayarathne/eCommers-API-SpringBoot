package com.samtech_.spring_eshop_demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private int id;

    @NotBlank(message = "Category name must not be blank")
    @Size(min = 3, max = 45, message = "Category name must be between 3 and 45 characters")
    @JsonProperty("name")
    private String name;

}
