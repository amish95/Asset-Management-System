package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Asset;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository.AssetRepository;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository.CategoryRepository;

@SpringBootTest
class AssetManagementSystemApplicationTests {

	@Autowired
	private AssetRepository assetRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void assertCreatedOrNot() {

		List<Asset> asset = this.assetRepository.findAll();

		assertEquals(1, asset.size());
	}

	@Test
	void categoryCreatedOrNot() {

		List<Category> category = this.categoryRepository.findAll();

		assertEquals(1, category.size());
	}

	@Test
	void getAllAssetShouldReturnAllAssets() {
		Optional<List<Asset>> asset = Optional.of(assetRepository.findAll());
		assertTrue(asset.isPresent());
	}

	@Test
	void getAllCategoryShouldReturnAllCategories() {
		Optional<Category> category = categoryRepository.findAll();
		assertTrue(category.isPresent());
	}

	@Test
	void getAssetByNameShouldReturnTheAsset() {
		Optional<Asset> assetName = assetRepository.findByAssetName(assetName);
		assertTrue(assetName.isPresent());
	}

	@Test
	void getAssetByIdShouldReturnTheId() {
		Optional<Category> categoryName = categoryRepository.findByCategoryId(categoryName);
		assertTrue(categoryName.isPresent());
	}

	@Test
	void saveShouldUpdatexEistingAsset() {

		Asset existingAsset = new Asset();
		existingAsset.setId(3);
		existingAsset.setAssetName("Laptop");

		Optional<Asset> assetDb = this.assetRepository.findById(existingAsset.getId());

		assertNotNull(assetDb);
		assertEquals("Laptop", assetDb);
	}

	@Test
	void saveShouldUpdatexEistingCategory() {

		Asset existingCategory = new Category();
		existingCategory.setId(3);
		existingCategory.setCategoryName("Elcetronics");

		Optional<Category> categoryDb = this.categoryRepository.findById(category.getId());

		assertNotNull(updatedcategory);
		assertEquals("Electronics", updatedCategory.getCategoryName());
	}

	@Test
	void deleteByIdShouldDeleteAsset() {

		Optional<Asset> asset = this.assetRepository.findById(2);

		assertFalse(asset.isPresent());
	}

	@Test
	void deleteByIdShouldDeleteCategory() {

		Optional<Category> category = this.categoryRepository.findById(2);

		assertFalse(category.isPresent());
	}

}
