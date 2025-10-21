package co.edu.uptc.restaurante.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import co.edu.uptc.restaurante.order.dto.FoodItemDto;
import co.edu.uptc.restaurante.order.dto.RestaurantDto;
import co.edu.uptc.restaurante.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
    private Long orderId;
    private List<FoodItemDto> foodItemsList;
    private RestaurantDto restaurant;
    private UserDto user;
    
}
