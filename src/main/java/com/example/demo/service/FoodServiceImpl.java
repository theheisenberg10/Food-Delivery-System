package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Dish;
import com.example.demo.models.FoodCart;
import com.example.demo.models.Restaurant;
import com.example.demo.models.User;
import com.example.demo.repository.CartRepo;
import com.example.demo.repository.DishRepo;
import com.example.demo.repository.RestaurantRepo;
import com.example.demo.repository.UserRepo;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	DishRepo dishrepo;
	
	@Autowired
	RestaurantRepo restrepo;
	
	@Autowired
	CartRepo cartrepo;

	public User addUser(User user) {
		
		return userrepo.save(user);
	}

	public void deleteUser(User user) {
		
		userrepo.delete(user);
	}

	public User getUser(String mob) {
		return userrepo.getOne(mob);
		
	}

	public Restaurant addRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		return restrepo.save(rest);
	}

	public void deleteRestaurant(Restaurant rest) {
		restrepo.delete(rest);
		
	}

	public Restaurant getRestaurant(int id) {
		// TODO Auto-generated method stub
		return restrepo.getOne(id);
	}
	
	public Restaurant getRestaurantByName(String name) {
		// TODO Auto-generated method stub
		return restrepo.findByName(name);
	}

	public String loginUser(String[] credentials) {
		String mob=credentials[0];
		String pass=credentials[1];
		User temp=userrepo.getOne(mob);
		if(temp!=null)
			if(temp.getPass().equals(pass))
				return "success";
			else
				return "wrong pass";
		else
			return "not found";
		
	}

	public String loginRest(String[] credentials) {
		String name=credentials[0];
		String pass=credentials[1];
		Restaurant temp=restrepo.findByName(name);
		if(temp!=null)
			if(temp.getPass().equals(pass))
				return "success";
			else
				return "wrong pass";
		else
			return "not found";
	}

	public void addDish(Dish dish) {
		dishrepo.save(dish);
		
	}

	public List<Restaurant> getRestaurantByArea(String area) {
		return restrepo.findByArea(area);
	}

	public List<Dish> searchDish(String dishName) {
		List<Dish> dishlist=new ArrayList<Dish>();
		
		List<Restaurant> restlist=restrepo.findAll();
		for(int i=0;i<restlist.size();i++)
		{
			List<Dish> dishes=restlist.get(i).getItems();
			for(int j=0;j<dishes.size();j++)
			{
				if(dishes.get(j).getName().equalsIgnoreCase(dishName))
					dishlist.add(dishes.get(j));
				
			}
		}
		if(dishlist.isEmpty())
			return null;
		return dishlist;
	}

	public Dish getDishById(int dishId) {
		return dishrepo.getOne(dishId);
	}

	@Override
	public Restaurant getRestaurant(String mob) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteDish(String Rname,String dishName) {
		Restaurant rest=restrepo.findByName(Rname);
		
		List<Dish> dishes = searchDish(dishName);
		for(int i=0;i<dishes.size();i++)
		{
			if(dishes.get(i).getName().equalsIgnoreCase(dishName))
			{
				rest.getItems().remove(dishes.get(i));
				dishrepo.delete(dishes.get(i));		
		
			}
		}
		restrepo.save(rest);
	}

	public void addToCart(String mob, int dish_id, int quantity) {
//		Dish dish=dishrepo.getOne(dish_id);
		
		
		
		User user=userrepo.getOne(mob);
		FoodCart cart=user.getCart();
		Map<Integer,Integer> mp=cart.getMp();
		mp.put(dish_id, quantity);
		
		for(Map.Entry<Integer, Integer> entry:mp.entrySet()) 
		{
			 System.out.println(entry.getKey()+"->"+entry.getValue()); 
		}
		cart.setMp(mp);
		user.setCart(cart);
		userrepo.save(user);
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public FoodCart getCartDetails(String mob) {
		
		User user=userrepo.getOne(mob);
		
		FoodCart newcart=calculateBill(user.getCart());  //old cart is passed, bill is calculated , saved to new cart
		
		user.setCart(newcart);
		userrepo.save(user);
		return cartrepo.save(newcart);
	}

	public FoodCart calculateBill(FoodCart cart)
	{
		double amount=0;
		System.out.println(cart);
		Iterator<Map.Entry<Integer, Integer>> itr=cart.getMp().entrySet().iterator();
		
		
		
		while(itr.hasNext())
		{
			Map.Entry<Integer, Integer> temp=itr.next();
			int dish_id=temp.getKey();
			int quantity=temp.getValue();
			
			amount=amount+getDishById(dish_id).getPrice()*quantity;
			
		}
		/*
		 * if(cart.getCoupon_code().equalsIgnoreCase("thelastdance50"))
		 * amount=amount*0.5; else
		 * if(cart.getCoupon_code().equalsIgnoreCase("twilight20")) amount=amount*0.8;
		 */
		
		
		cart.setBill_amount(amount);
		
		return cart;
	}

	public List<Restaurant> getAllRest() {
		return restrepo.findAll();
	}

	public List<Dish> getDishList(int id) {
		FoodCart cart=cartrepo.getOne(id);
		
		Map<Integer,Integer> temp=new HashMap<>();
		temp=cart.getMp();
		
		List<Dish> dishList=new ArrayList<Dish>();
		
		
		
		Iterator<Map.Entry<Integer, Integer>> itr = temp.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, Integer> entry = itr.next();
			dishList.add(dishrepo.getOne((entry.getKey())));
			
		}
		return dishList;
		
		
	}
	
	
	

}
