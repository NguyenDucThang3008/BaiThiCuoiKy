package com.ktck124.lop124ltdd04.nhom03.Services;

import com.ktck124.lop124ltdd04.nhom03.DTO.CategoriesDTO;
import com.ktck124.lop124ltdd04.nhom03.Models.Categories;

import java.util.List;

public interface ICategoriesService {
    Categories createCategory(CategoriesDTO categoryDTO);
    Categories getCategoryById(long id);
    List<Categories> getAllCategories();
    Categories updateCategory(long id, CategoriesDTO categoryDTO);
    void deleteCategory(long id);
}

