package co.edu.uptc.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.catalogo.dto.FoodItemDTO;
import co.edu.uptc.catalogo.service.FoodItemService;

@RestController
@RequestMapping("/foodcatalogue")
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    @PostMapping("/add")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO itemAdded = foodItemService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(itemAdded, HttpStatus.CREATED);
    }


    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<FoodItemDTO>> getFoodItemsByRestaurantId(
            @PathVariable Long restaurantId) {
        
        List<FoodItemDTO> foodItems = foodItemService.findFoodItemsByRestaurant(restaurantId);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }
}