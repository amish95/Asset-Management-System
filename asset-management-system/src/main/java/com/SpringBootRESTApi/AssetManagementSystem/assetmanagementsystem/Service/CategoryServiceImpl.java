package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Category;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository.CategoryRepository;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.exception.CategoriesNotFoundException;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		try {
			Optional<Category> categoryDb = this.categoryRepository.findById(category.getId());

			if (categoryDb.isPresent()) {
				Category categoryUpdate = categoryDb.get();
				categoryUpdate.setId(category.getId());
				categoryUpdate.setCategoryName(category.getCategoryName());
				categoryUpdate.setDescription(category.getDescription());
				categoryRepository.save(categoryUpdate);
				return categoryUpdate;
			}
		} catch (CategoriesNotFoundException nfe) {
			nfe.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		try {
			Optional<Category> categoryDb = this.categoryRepository.findById(id);

			if (categoryDb.isPresent()) {
				return categoryDb.get();
			}
		} catch (CategoriesNotFoundException nfe) {
			nfe.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteCategory(int id) {
		try {
			Optional<Category> categoryDb = this.categoryRepository.findById(id);

			if (categoryDb.isPresent()) {
				this.categoryRepository.delete(categoryDb.get());
			}
		} catch (CategoriesNotFoundException nfe) {
			nfe.printStackTrace();
		}
	}

}
