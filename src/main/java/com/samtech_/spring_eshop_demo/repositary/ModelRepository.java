package com.samtech_.spring_eshop_demo.repositary;

import com.samtech_.spring_eshop_demo.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
}
