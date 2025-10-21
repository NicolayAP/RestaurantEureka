package co.edu.uptc.restaurante.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String userPassword;
    private String address;
    private String city;
}
