package fr.snapfood.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	private String description;
	private String details;
	private double price;
	@OneToMany(mappedBy = "products")
	private Set<Picture> pictures = new HashSet <> ();
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private Category categories;
	public Product() {
		super();
	}
	public Product(Integer id, String name, double salePrice, int discount, String shortDetails, String stock,
			String brand, Boolean newPro, Boolean sale, String tags, String description, String details, double price,
			Set<Picture> pictures, Category categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.details = details;
		this.price = price;
		this.pictures = pictures;
		this.categories = categories;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	public Category getCategories() {
		return categories;
	}
	public void setCategories(Category categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", details=" + details
				+ ", price=" + price + ", pictures=" + pictures + ", categories=" + categories + "]";
	}
	

}
