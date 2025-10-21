package co.edu.uptc.restaurante.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFE {
    private List<FoodItemDto> foodItemList;
    private Long userId;
    private RestaurantDto restaurant;
}
