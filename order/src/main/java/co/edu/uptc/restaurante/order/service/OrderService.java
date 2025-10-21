package co.edu.uptc.restaurante.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

import co.edu.uptc.restaurante.order.dto.OrderDTO;
import co.edu.uptc.restaurante.order.dto.OrderDTOFromFE;
import co.edu.uptc.restaurante.order.dto.UserDto;
import co.edu.uptc.restaurante.order.entity.Order;
import co.edu.uptc.restaurante.order.mapper.OrderMapper;
import co.edu.uptc.restaurante.order.repo.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails){
        Long newOrderId = sequenceGenerator.genereateNextOrderId();
        UserDto userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSave = 
            new Order(newOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDto);
        orderRepo.save(orderToBeSave);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSave);
    }

    private UserDto fetchUserDetailsFromUserId(Long userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDto.class);
    }
}