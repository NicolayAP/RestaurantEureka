package co.edu.uptc.restaurante.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.edu.uptc.restaurante.order.dto.FoodItemDto;
import co.edu.uptc.restaurante.order.dto.OrderDTO;
import co.edu.uptc.restaurante.order.dto.OrderDTOFromFE;
import co.edu.uptc.restaurante.order.dto.UserDto;
import co.edu.uptc.restaurante.order.entity.Order;
import co.edu.uptc.restaurante.order.mapper.OrderMapper;
import co.edu.uptc.restaurante.order.repo.OrderRepo;

@Service
public class OrderService {


@Autowired
private OrderRepo orderRepo;

@Autowired
private SequenceGenerator sequenceGenerator;

@Autowired
private RestTemplate restTemplate;

public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails) {
    // Generar ID de orden
    Long newOrderId = sequenceGenerator.genereateNextOrderId();

    // Obtener datos del usuario desde USER-SERVICE
    UserDto userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());

    // Obtener datos completos de los ítems desde CATALOGUE-SERVICE
    List<FoodItemDto> completeFoodItems = orderDetails.getFoodItemList().stream()
            .map(item -> fetchFoodItemDetails(item.getId()))
            .collect(Collectors.toList());

    Order orderToBeSaved = new Order(newOrderId, completeFoodItems, orderDetails.getRestaurant(), userDto);
    orderRepo.save(orderToBeSaved);

    return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
}

private UserDto fetchUserDetailsFromUserId(Long userId) {
    return restTemplate.getForObject(
            "http://USER-SERVICE/user/fetchUserById/" + userId,
            UserDto.class);
}

private FoodItemDto fetchFoodItemDetails(Long itemId) {
    return restTemplate.getForObject(
            "http://CATALOGUE-SERVICE/foodcatalogue/fetchFoodItemById/" + itemId,
            FoodItemDto.class);
}


}
