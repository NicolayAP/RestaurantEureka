package co.edu.uptc.restaurante.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.restaurante.order.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Long> {
    
}
