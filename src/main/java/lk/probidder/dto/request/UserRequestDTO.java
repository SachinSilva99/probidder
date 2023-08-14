package lk.probidder.dto.request;

import lk.probidder.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private List<RoleType> roleTypes;
    private LocalDate dob;
}
