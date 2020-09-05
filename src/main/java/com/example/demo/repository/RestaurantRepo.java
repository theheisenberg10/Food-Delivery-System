package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Restaurant;




@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{

	public Restaurant findByName(String name);

	public List<Restaurant> findByArea(String area);

	

}
