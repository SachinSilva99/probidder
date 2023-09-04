package lk.probidder.util.mapper;

import lk.probidder.dto.UserDTO;
import lk.probidder.entity.User;
import org.mapstruct.Mapper;

/*
Author : Sachin Silva
*/
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);

    UserDTO toUserDto(User user);

}
