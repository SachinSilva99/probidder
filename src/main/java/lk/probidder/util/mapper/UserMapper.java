package lk.probidder.util.mapper;

import lk.probidder.dto.UserDTO;
import lk.probidder.dto.response.UserResponseDTO;
import lk.probidder.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

/*
Author : Sachin Silva
*/
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);

    UserResponseDTO toUserResponseDto(User user);

    List<UserResponseDTO> toUserResponseDtos(List<User> userList);
}
