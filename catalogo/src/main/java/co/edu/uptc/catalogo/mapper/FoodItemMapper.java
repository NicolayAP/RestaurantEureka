package co.edu.uptc.catalogo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uptc.catalogo.dto.FoodItemDTO;
import co.edu.uptc.catalogo.entity.FoodItem;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem toFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO toFoodItemDTO(FoodItem foodItem);
}