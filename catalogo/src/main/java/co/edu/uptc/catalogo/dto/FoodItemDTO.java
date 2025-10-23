package co.edu.uptc.catalogo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private Long id;
    private String itemName;
    private String itemDescription;

    @JsonProperty("isVeg")
    private boolean isVeg;
    
    private Double price;
    private Long restaurantId;
    private Integer quantity;
}