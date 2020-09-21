package com.obsm.category.exception;

public class CategoryNotFound extends RuntimeException {
	public CategoryNotFound(String error){
        super(error);
    }
}
