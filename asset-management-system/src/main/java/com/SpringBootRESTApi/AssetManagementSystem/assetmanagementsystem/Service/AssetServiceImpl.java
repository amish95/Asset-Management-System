package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Asset;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository.AssetRepository;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.exception.AssetAlreadyAssignedException;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.exception.AssetNotFoundException;


@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;

	@Override
	public Asset createAsset(Asset asset) {
		return assetRepository.save(asset);
	}

	@Override
    public Asset updateAsset(Asset asset) {
    	try { Optional<Asset> assetDb = this.assetRepository.findById(asset.getId());

        if(assetDb.isPresent()) {
            Asset assetUpdate = assetDb.get();
            assetUpdate.setId(asset.getId());
            assetUpdate.setAssetName(asset.getAssetName());
            assetUpdate.setPurchaseDate(asset.getPurchaseDate());
            assetUpdate.setConditionNotes(asset.getConditionNotes());
            assetUpdate.setCategories(asset.getCategories());
            assetUpdate.setAssignmentStatus(asset.getAssignmentStatus());

            assetRepository.save(assetUpdate);}}
    	catch (AssetAlreadyAssignedException e) {e.getStackTrace();}
        
            return asset;
    }

	@Override
	public List<Asset> getAllAsset() {
		return assetRepository.findAll();
	}

	@Override
	public List<Asset> getAssetByName(String assetName) {
		return assetRepository.findByAssetName(assetName);
		
		 
	}

	@Override
	public void deleteAsset(int id) {
		try {
			Optional<Asset> assetDb = this.assetRepository.findById(id);

			if (assetDb.isPresent()) {
				this.assetRepository.delete(assetDb.get());
			}
		} catch (AssetNotFoundException nfe) {
			nfe.printStackTrace();

		}
	}

}
