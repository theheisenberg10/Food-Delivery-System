package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
		
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Dish;
import com.example.demo.models.FoodCart;
import com.example.demo.models.Restaurant;
import com.example.demo.models.User;
import com.example.demo.service.FoodServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TotalController {
	
	@Autowired
	FoodServiceImpl fserv;
	
	
	@PostMapping(path="/login")
	public String login(@RequestBody String[] credentials)
	{	
		String role=credentials[2];
		if(role.equals("User"))
			return fserv.loginUser(credentials);
		else
			return fserv.loginRest(credentials);
		
		
	}
	
	@PostMapping(path="/createNewUser",consumes = "application/json")
	public User addUser(@RequestBody User user)
	{					
		return fserv.addUser(user);
	}
	
	@PostMapping(path="/deleteUser",consumes = "application/json")
	public void deleteUser(@RequestBody User user)
	{
		fserv.deleteUser(user);
	}
	
	@GetMapping(path="/getUser/{mob}")
	public User getUser(@PathVariable("mob") String mob)
	{
		
		return fserv.getUser(mob);
	}
	
	@GetMapping(path="getCartDetails/{mob}")
	public FoodCart getCartDetails(@PathVariable("mob") String mob)
	{
		return fserv.getCartDetails(mob);
	}
	
	@GetMapping(path="/getDishList/{id}")
	public List<Dish> getDishList(@PathVariable("id") int id)
	{
		return fserv.getDishList(id);
	}
	
	
	
	@PostMapping(path="/addRestaurant",consumes = "application/json")
	public Restaurant addRestaurant(@RequestBody Restaurant rest)
	{
		System.out.println(rest);
		return fserv.addRestaurant(rest);
	}
	
	@PostMapping(path="/deleteRestaurant",consumes = "application/json")
	public void deleteRestaurant(@RequestBody Restaurant rest)
	{
		fserv.deleteRestaurant(rest);
	}
	
	@GetMapping(path="/getRestaurant/{id}")
	public Restaurant getRestaurant(@PathVariable("id") int id)
	{
		return fserv.getRestaurant(id);
	}
	
	@GetMapping(path="/getAllRestaurants")
	public List<Restaurant> getAllRestaurants()
	{
		return fserv.getAllRest();
	}
	
	@GetMapping(path="/getRestaurantByName/{name}")
	public Restaurant getRestaurantByName(@PathVariable("name") String name)
	{
		return fserv.getRestaurantByName(name);
	}

	@GetMapping(path="/getRestaurantByArea/{area}")
	public List<Restaurant> getRestaurantByArea(@PathVariable("area") String area)
	{
		return fserv.getRestaurantByArea(area);
	}
	
	
	
	@PostMapping(path="/{Rname}/addDish",consumes="application/json")
	public Restaurant addDish(@PathVariable("Rname") String name,@RequestBody Dish dish)
	{		
		Restaurant rest=fserv.getRestaurantByName(name);
		
		dish.setRestaurant(rest);
		
		List<Dish> dishes=rest.getItems();
		dishes.add(dish);
		rest.setItems(dishes);
		fserv.addDish(dish);
		return fserv.addRestaurant(rest);
	}
	
	
	@GetMapping(path="/getDishByName/{dishName}")
	public List<Dish> searchDish(@PathVariable("dishName") String dishName)
	{
		return fserv.searchDish(dishName);
	}
	
	@GetMapping(path="/getDish/{dishId}")
	public Dish getDishById(@PathVariable("dishId") int dishId)
	{
		return fserv.getDishById(dishId);
	}
	
	@DeleteMapping(path="/{Rname}/deleteDish/{dishName}")
	public void deleteDish(@PathVariable("Rname") String Rname,@PathVariable("dishName") String dishName)
	{
		fserv.deleteDish(Rname,dishName);
	}
	
	
	
	
	
	@PostMapping(path="/{Umob}/addToCart/{dish_id}/{quantity}")
	public void addToCart(@PathVariable("Umob")String mob,@PathVariable("dish_id")int dish_id,@PathVariable("quantity")int quantity)
	{
		
		 fserv.addToCart(mob,dish_id,quantity);
	}

}
