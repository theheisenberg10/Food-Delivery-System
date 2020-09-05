package com.example.demo.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.TotalController;
import com.example.demo.service.FoodServiceImpl;

@Entity

public class FoodCart {
	@Id
	@GeneratedValue
	@Column(name="cart_id",length = 10, unique = true, nullable = false)
	private int cart_id;
	
	
	@ElementCollection
	private Map<Integer,Integer> mp=new HashMap<Integer, Integer>();               //Dish_id -> Quantity
	
	@Column(name="coupon_code")
	private String coupon_code="";
	
	@Column(name="bill_amount")
	private double bill_amount;
	
	
	
	@OneToOne
	private User user;



	public int getCart_id() {
		return cart_id;
	}



	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}



	public Map<Integer, Integer> getMp() {
		return mp;
	}



	public void setMp(Map<Integer, Integer> mp) {
		this.mp = mp;
	}



	public String getCoupon_code() {
		return coupon_code;
	}



	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}



	public double getBill_amount() {
		return bill_amount;
	}



	public void setBill_amount(double bill_amount) {
		this.bill_amount = bill_amount;
	}



	public User getUser() {
		return null;
	}



	public void setUser(User user) {
		this.user = user;
	}



	
	
	
	
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bill_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cart_id;
		result = prime * result + ((coupon_code == null) ? 0 : coupon_code.hashCode());
		result = prime * result + ((mp == null) ? 0 : mp.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		FoodCart other = (FoodCart) obj;
		if (Double.doubleToLongBits(bill_amount) != Double.doubleToLongBits(other.bill_amount))
			return false;
		if (cart_id != other.cart_id)
			return false;
		if (coupon_code == null) {
			if (other.coupon_code != null)
				return false;
		} else if (!coupon_code.equals(other.coupon_code))
			return false;
		if (mp == null) {
			if (other.mp != null)
				return false;
		} else if (!mp.equals(other.mp))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FoodCart [cart_id=" + cart_id + ", mp=" + mp + ", coupon_code=" + coupon_code + ", bill_amount="
				+ bill_amount + ", user=" + user + "]";
	}



	public FoodCart(int cart_id, Map<Integer, Integer> mp, String coupon_code, double bill_amount, User user) {
		super();
		this.cart_id = cart_id;
		this.mp = mp;
		this.coupon_code = coupon_code;
		this.bill_amount = bill_amount;
		this.user = user;
	}



	public FoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
