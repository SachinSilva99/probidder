package lk.probidder.dto.request;

import lk.probidder.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
}
