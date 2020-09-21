package com.obsm.category.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obsm.category.exception.CategoryNotFound;
import com.obsm.category.model.Category;
import com.obsm.category.payload.CategoryUpdateRequest;
import com.obsm.category.service.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryServiceImpl service;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addController(@RequestBody Category category){
		return (service.addCategory(category));
	}

	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity deleteController(@PathVariable long categoryId) throws CategoryNotFound {
		return service.deleteCategory(categoryId);
	}

	@PutMapping("/updateCategory/{categoryId}")
	public ResponseEntity<Category> updateController(@RequestBody CategoryUpdateRequest categoryUpdateRequest, @PathVariable long orderId) throws CategoryNotFound {
		return service.updateCategory(categoryUpdateRequest, orderId);
	}

	@GetMapping("getCategory/{categoryId}")
	public ResponseEntity<Category> getController(@PathVariable long orderId) throws CategoryNotFound {
		return service.getCategory(orderId);
	}

	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Category>> getAllController() {
		return service.getAllCategory();
	}
}