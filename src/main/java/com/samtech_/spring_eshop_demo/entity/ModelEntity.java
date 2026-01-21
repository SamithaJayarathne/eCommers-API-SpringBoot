package com.samtech_.spring_eshop_demo.entity;

import com.samtech_.spring_eshop_demo.dto.BrandDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "model")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Model name must not be empty")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull(message = "Brand must not be null for a model")
    private BrandEntity brand;
}
