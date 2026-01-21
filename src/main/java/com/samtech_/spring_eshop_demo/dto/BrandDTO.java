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
public class BrandDTO {

    @JsonProperty("brand_id")
    private Integer id;

    @JsonProperty("brand_name")
    @NotBlank(message = "Brand name must not be empty")
    @Size(min = 3, max = 45, message = "Brand name must be between 3 - 45 characters long")
    private String name;
}
