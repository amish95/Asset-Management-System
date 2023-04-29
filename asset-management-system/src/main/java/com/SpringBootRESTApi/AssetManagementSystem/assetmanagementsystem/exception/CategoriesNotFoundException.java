package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.exception;

import java.text.MessageFormat;

public class CategoriesNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public CategoriesNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }

}
