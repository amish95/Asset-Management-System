package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Category;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {

		return ResponseEntity.ok().body(this.categoryService.createCategory(category));
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
		category.setId(id);
		return ResponseEntity.ok().body(this.categoryService.updateCategory(category));
	}

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategory() {
		return ResponseEntity.ok().body(categoryService.getAllCategory());
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		return ResponseEntity.ok().body(categoryService.getCategoryById(id));
	}

	@DeleteMapping("/category/{id}")
	public HttpStatus deleteCategory(@PathVariable int id) {
		this.categoryService.deleteCategory(id);
		return HttpStatus.OK;
	}

}
