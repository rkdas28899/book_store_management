package com.obsm.category.payload;

import java.util.List;

public class CategoryUpdateRequest {
		private String categoryName;
		private List<String> listOfBooks;
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public List<String> getListOfBooks() {
			return listOfBooks;
		}
		public void setListOfBooks(List<String> listOfBooks) {
			this.listOfBooks = listOfBooks;
		}
		@Override
		public String toString() {
			return "CategoryUpdateRequest [categoryId="+ ", categoryName=" + categoryName
					+ ", listOfBooks=" + listOfBooks + "]";
		}
		public CategoryUpdateRequest() {
			super();
		}
		

}
