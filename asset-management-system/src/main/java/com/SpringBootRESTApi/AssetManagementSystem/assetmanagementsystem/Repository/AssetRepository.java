package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    List<Asset> findByAssetName(String assetName);
}
