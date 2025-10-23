package co.edu.uptc.catalogo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.catalogo.dto.FoodItemDTO;
import co.edu.uptc.catalogo.entity.FoodItem;
import co.edu.uptc.catalogo.mapper.FoodItemMapper;
import co.edu.uptc.catalogo.repo.FoodItemRepo;

@Service
public class FoodItemService {

    @Autowired
    FoodItemRepo foodItemRepo;

    public List<FoodItemDTO> findFoodItemsByRestaurant(Long restaurantId) {
        List<FoodItem> foodItems = foodItemRepo.findByRestaurantId(restaurantId);
        
        return foodItems.stream()
                .map(FoodItemMapper.INSTANCE::toFoodItemDTO)
                .collect(Collectors.toList());
    }

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = FoodItemMapper.INSTANCE.toFoodItem(foodItemDTO);
        
        FoodItem savedFoodItem = foodItemRepo.save(foodItem);
        
        return FoodItemMapper.INSTANCE.toFoodItemDTO(savedFoodItem);
    }

    public FoodItemDTO fetchFoodItemById(Long id) {
    FoodItem foodItem = foodItemRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Food item not found with ID: " + id));
    return FoodItemMapper.INSTANCE.toFoodItemDTO(foodItem);
}
}