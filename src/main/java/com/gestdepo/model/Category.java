package com.gestdepo.model;

public class Category {
	
	private long categoryId;
	private long parentCategoryId;
	
	public Category() {
		this.categoryId = 0L;
		this.parentCategoryId = 0L;
	}
	
	public Category(long categoryId, long parentCategoryId) {
		this.categoryId = categoryId;
		this.parentCategoryId = parentCategoryId;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
}
