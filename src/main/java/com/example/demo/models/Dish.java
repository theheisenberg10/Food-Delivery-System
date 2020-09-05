package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Dish {
	
	@Id
	@GeneratedValue
	@Column(name="Dish_id",length = 10, unique = true, nullable = false)
	private int id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private float price;
	
	@Column(length = 50)
	private String cuisine;
	@Column(length = 10)
	private int popularity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Rest_id", nullable = false)
    private Restaurant restaurant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	@JsonIgnore
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	@JsonIgnore
	public void setRestaurant(Restaurant newRest)
	{
		this.restaurant=newRest;
	}
	
	
	
	public int getRestaurantId()
	{
		return restaurant.getId();
		
	}
	public String getRestaurantName()
	{
		return restaurant.getName();	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuisine == null) ? 0 : cuisine.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + popularity;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (cuisine == null) {
			if (other.cuisine != null)
				return false;
		} else if (!cuisine.equals(other.cuisine))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (popularity != other.popularity)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price + ", cuisine=" + cuisine + ", popularity="
				+ popularity + ", restaurant=" + restaurant + "]";
	}
	public Dish(int id, String name, float price, String cuisine, int popularity, Restaurant restaurant) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cuisine = cuisine;
		this.popularity = popularity;
		this.restaurant = restaurant;
	}
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
