package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue
	@Column(name="Rest_id",length = 10, unique = true, nullable = false)
	private int id;
	@Column(length = 20)
	private String pass;
	@Column(length = 20,unique = true , nullable = false)
	private String name;
	@Column(length = 20)
	private String area;
	@Column(length = 50)
	private String type;
	@Column
	private int foodies;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(targetEntity = Dish.class)
	private List<Dish> items;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int id, String pass, String name, String area, String type, int foodies, List<Dish> items) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.area = area;
		this.type = type;
		this.foodies = foodies;
		this.items = items;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", pass=" + pass + ", name=" + name + ", area=" + area + ", type=" + type
				+ ", foodies=" + foodies + ", items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + foodies;
		result = prime * result + id;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (foodies != other.foodies)
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFoodies() {
		return foodies;
	}

	public void setFoodies(int foodies) {
		this.foodies = foodies;
	}

	public List<Dish> getItems() {
		return items;
	}

	public void setItems(List<Dish> items) {
		this.items = items;
	}

	
	
	
	
	
	
	
}
