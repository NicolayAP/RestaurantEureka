package co.edu.uptc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.user.dto.UserDTO;
import co.edu.uptc.user.entity.User;
import co.edu.uptc.user.mapper.UserMapper;
import co.edu.uptc.user.repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDTO addUser(UserDTO userDto) {
        User user = UserMapper.INSTANCE.mapUserDTOToUser(userDto);
        User saved = userRepo.save(user);
        return UserMapper.INSTANCE.mapUserToUserDTO(saved);
    }

    public UserDTO fetchUserById(Long userId) {
        Optional<User> op = userRepo.findById(userId);
        if (op.isEmpty()) {
            return null; // o lanzar excepción custom; en OrderService checan null? (ellos esperan objeto)
        }
        return UserMapper.INSTANCE.mapUserToUserDTO(op.get());
    }
}
