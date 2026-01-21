package com.samtech_.spring_eshop_demo.service;

import com.samtech_.spring_eshop_demo.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    /**
     * saves a new category
     *
     * @return created categoryDTO
     * @Param new categoryDTO
     */
    public CategoryDTO save(CategoryDTO dto);


    /**
     * get all the categories in db
     * @return a list of CategoryDTO
     * */
    public List<CategoryDTO> getCategories();

}
