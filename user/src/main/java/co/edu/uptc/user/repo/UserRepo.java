package co.edu.uptc.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
