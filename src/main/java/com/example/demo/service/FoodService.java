package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Dish;
import com.example.demo.models.Restaurant;
import com.example.demo.models.User;

@Service
public interface FoodService {
	public User addUser(User user);
	public void deleteUser(User user);
	public User getUser(String mob);

	public Restaurant addRestaurant(Restaurant rest);
	public void deleteRestaurant(Restaurant rest);
	public Restaurant getRestaurant(String mob);
	public Restaurant getRestaurantByName(String name);
	public List<Restaurant> getRestaurantByArea(String area);
	
	public void addDish(Dish dish);
	public List<Dish> searchDish(String dishName);
	
	
	
	public String loginUser(String[] credentials);
	public String loginRest(String[] credentials);
	
	
	
	
}
