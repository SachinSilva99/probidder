package lk.probidder.service;

import jakarta.persistence.EntityNotFoundException;
import lk.probidder.dto.UserDTO;
import lk.probidder.dto.request.UserRequestDTO;
import lk.probidder.dto.response.UserResponseDTO;
import lk.probidder.entity.User;

/*
Author : Sachin Silva
*/
public interface UserService {

    UserResponseDTO getUserById(Long id) throws ClassNotFoundException;

    UserResponseDTO getUserByUsername(String username) throws EntityNotFoundException;

    UserResponseDTO getUserByEmail(String email) throws ClassNotFoundException;

    String createUser(UserRequestDTO userRequestDTO);

    void deleteUser(Long id);
}
