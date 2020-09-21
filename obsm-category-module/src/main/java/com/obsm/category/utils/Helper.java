package com.obsm.category.utils;

import com.obsm.category.model.Category;
import com.obsm.category.payload.CategoryUpdateRequest;

public class Helper {
	public static void copyCategoryDetails(Category category, CategoryUpdateRequest categoryRequest) {
        if (categoryRequest.getCategoryName() != null)
        	category.setCategoryName(categoryRequest.getCategoryName());
        if (categoryRequest.getListOfBooks() != null)
        	category.setListOfBooks(categoryRequest.getListOfBooks());
    }
}
