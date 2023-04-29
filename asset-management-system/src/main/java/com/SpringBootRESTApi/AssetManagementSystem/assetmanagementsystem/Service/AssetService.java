package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Service;


import java.util.List;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Asset;

public interface AssetService {
    Asset createAsset(Asset asset);
    Asset updateAsset(Asset asset);
    List<Asset> getAllAsset();
    List<Asset> getAssetByName(String assetName);
    void deleteAsset(int id);
}
