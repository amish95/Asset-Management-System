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

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.Asset;
import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Service.AssetService;

@RestController
public class AssetController {

	@Autowired
	private AssetService assetService;

	@PostMapping("/asset")
	public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
		return ResponseEntity.ok().body(this.assetService.createAsset(asset));
	}

	@PutMapping("/asset/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable int id, @RequestBody Asset asset) {
		asset.setId(id);
		return ResponseEntity.ok().body(this.assetService.updateAsset(asset));
	}

	@GetMapping("/asset")
	public ResponseEntity<List<Asset>> getAllAsset() {
		return ResponseEntity.ok().body(this.assetService.getAllAsset());
	}

	@GetMapping("/asset/{assetName}")
	public ResponseEntity<List<Asset>> getAssetByName(@PathVariable String assetName) {
		return ResponseEntity.ok().body(this.assetService.getAssetByName(assetName));
	}

	@DeleteMapping("/asset/{id}")
	public HttpStatus deleteAsset(@PathVariable int id) {
		this.assetService.deleteAsset(id);
		return HttpStatus.OK;
	}

}
