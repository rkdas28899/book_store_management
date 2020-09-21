package com.obsm.category.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="category_info")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	@Column
	@NotNull
	private String categoryName;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> listOfBook;
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<String> getListOfBooks() {
		return listOfBook;
	}
	public void setListOfBooks(List<String> listOfBook) {
		this.listOfBook = listOfBook;
	}
	public Category() {

	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", listOfBooks=" + listOfBook
				+ "]";
	}
	
}
