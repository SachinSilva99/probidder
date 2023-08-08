package lk.probidder.dto;

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
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private LocalDate dob;

    public UserDTO(String username, String email, String password, String phoneNumber, Role role, LocalDate  dob) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.dob = dob;
    }
}
