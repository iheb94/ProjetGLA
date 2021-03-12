package fr.snapfood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Picture {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	private String small;
	private String big;
	@ManyToOne(optional = false)
	@JsonIgnore
	
	private Product products;
	public Picture(Integer id, String small, String big, Product products) {
		super();
		this.id = id;
		this.small = small;
		this.big = big;
		this.products = products;
	}
	public Picture() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
		this.big = big;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", small=" + small + ", big=" + big + ", products=" + products + "]";
	}
	
	

}
