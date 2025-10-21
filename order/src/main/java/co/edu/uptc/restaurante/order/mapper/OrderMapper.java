package co.edu.uptc.restaurante.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uptc.restaurante.order.dto.OrderDTO;
import co.edu.uptc.restaurante.order.entity.Order;
@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order); 
}
