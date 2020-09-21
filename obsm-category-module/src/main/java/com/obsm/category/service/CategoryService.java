package com.obsm.category.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.obsm.category.exception.CategoryNotFound;
import com.obsm.category.model.Admin;
import com.obsm.category.model.Category;
import com.obsm.category.payload.CategoryUpdateRequest;
import com.obsm.category.repository.CategoryRepository;
import com.obsm.category.utils.Helper;


@Service
@Transactional

public class CategoryService implements CategoryServiceImpl{
	@Autowired
	CategoryRepository categoryRepository;

	public ResponseEntity deleteCategory(long categoryId) throws CategoryNotFound {
		try {
			Category deletedCategory = categoryRepository.getOne(categoryId);
			if (categoryRepository.existsById(categoryId)) {
				categoryRepository.delete(deletedCategory);
				return new ResponseEntity(HttpStatus.OK);
			} else throw new CategoryNotFound("Category is Null");
		}catch (CategoryNotFound categoryNotFound){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}catch(Exception exception){

			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Category> updateCategory(CategoryUpdateRequest categoryUpdateRequest, long categoryId) throws CategoryNotFound {
		try {
			Category updatedCategory = categoryRepository.getOne(categoryId);
			if (categoryRepository.existsById(categoryId)) {
				throw new CategoryNotFound("Category doesn't exists!");
			}
			Helper.copyCategoryDetails(updatedCategory, categoryUpdateRequest);
			return new ResponseEntity<>(categoryRepository.save(updatedCategory),HttpStatus.ACCEPTED);
		}catch(CategoryNotFound categoryNotFound){
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	 public ResponseEntity<Category> getCategory(long categoryId) throws CategoryNotFound {
		try {
			Category category = categoryRepository.getOne(categoryId);
			if(categoryRepository.existsById(categoryId))
				return new ResponseEntity<>(category, HttpStatus.FOUND);
			else throw new CategoryNotFound("No Category is available");
		}catch (CategoryNotFound categoryNotFound){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception exception){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Category>> getAllCategory() {
			return new ResponseEntity(categoryRepository.findAll(),HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Category> addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			if (category != null) {
				return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.CREATED);
			} else throw new CategoryNotFound("Not a valid request");
		}catch(CategoryNotFound categoryNotFound){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	

}
		


