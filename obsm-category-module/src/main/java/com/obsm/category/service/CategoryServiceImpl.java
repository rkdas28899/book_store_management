package com.obsm.category.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.obsm.category.exception.CategoryNotFound;
import com.obsm.category.model.Category;
import com.obsm.category.payload.CategoryUpdateRequest;


public interface CategoryServiceImpl {
	public ResponseEntity<Category> addCategory(Category category);
	public ResponseEntity deleteCategory(long categoryId) throws CategoryNotFound;
	public ResponseEntity<Category> updateCategory(CategoryUpdateRequest categoryUpdateRequest, long categoryId) throws CategoryNotFound;
	public ResponseEntity<Category> getCategory(long categoryId) throws CategoryNotFound;
	public ResponseEntity<List<Category>> getAllCategory();
}
