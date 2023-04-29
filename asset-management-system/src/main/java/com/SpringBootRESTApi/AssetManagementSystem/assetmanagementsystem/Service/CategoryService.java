package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Service;


import java.util.List;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(int id);
    void deleteCategory(int id);
}
