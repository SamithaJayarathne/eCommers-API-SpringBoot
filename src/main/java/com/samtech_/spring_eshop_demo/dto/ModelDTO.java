package com.samtech_.spring_eshop_demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelDTO {

    @JsonProperty("model_id")
    private Integer id;

    @JsonProperty("model_name")
    @NotBlank(message = "Model name must not be null")
    @Size(min = 3, max = 45, message = "Model name must be between 3 - 45 characters long")
    private String name;

    @JsonProperty("brand_id")
    @NotNull(message = "Brand id is required for a model")
    @Min(value = 0, message = "Invalid brand id")
    private Integer brandId;
}
