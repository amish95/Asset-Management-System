package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
