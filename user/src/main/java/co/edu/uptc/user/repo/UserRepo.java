package co.edu.uptc.user.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.user.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {
}
