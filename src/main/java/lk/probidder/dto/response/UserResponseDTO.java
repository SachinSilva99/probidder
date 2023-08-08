package lk.probidder.dto.response;

import lk.probidder.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private LocalDate dob;
}
