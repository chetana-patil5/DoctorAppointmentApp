package com.app.doctor.s_apointment.beans;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Category")
public class Category {
//	category_id
//	category_specialization
//	category_description
//	category_image
//	category_image_path
	
	@Id
	private int category_id;
    private String category_specialization;
    private String category_description;
    private String category_image;
    private String category_image_path;
    
	public Category() {
		super();
	}

	public Category(int category_id, String category_specialization, String category_description, String category_image,
			String category_image_path) {
		super();
		this.category_id = category_id;
		this.category_specialization = category_specialization;
		this.category_description = category_description;
		this.category_image = category_image;
		this.category_image_path = category_image_path;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_specialization() {
		return category_specialization;
	}

	public void setCategory_specialization(String category_specialization) {
		this.category_specialization = category_specialization;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public String getCategory_image() {
		return category_image;
	}

	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	public String getCategory_image_path() {
		return category_image_path;
	}

	public void setCategory_image_path(String category_image_path) {
		this.category_image_path = category_image_path;
	}
}
