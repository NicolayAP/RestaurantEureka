package com.edu.uptc.restaurantlisting.controller;

import com.edu.uptc.restaurantlisting.dto.RestaurantDTO;
import com.edu.uptc.restaurantlisting.service.RestaurantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    
    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO savedRestaurantAdded = restaurantService.addRestaurant(restaurantDTO);
        return new ResponseEntity<>(savedRestaurantAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Long id) {
        return restaurantService.fetchRestaurantById(id);
    }
    
}
