package co.edu.uptc.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uptc.user.dto.UserDTO;
import co.edu.uptc.user.entity.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
