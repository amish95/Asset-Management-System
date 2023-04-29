package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.exception;

import java.text.MessageFormat;

public class AssetNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public AssetNotFoundException(final Long id){
        super(MessageFormat.format("Could not find item with id: {0}", id));
    }
}
