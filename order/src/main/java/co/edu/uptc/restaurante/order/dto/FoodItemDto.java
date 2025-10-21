package co.edu.uptc.restaurante.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDto {
    private Long id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Number price;
    private Long restaurantId;
    private Integer quantity;
}
