package lk.probidder.service;

import jakarta.persistence.EntityNotFoundException;
import lk.probidder.dto.UserDTO;

/*
Author : Sachin Silva
*/
public interface UserService {

    UserDTO getUserById(Long id) throws ClassNotFoundException;

    UserDTO getUserByUsername(String username) throws EntityNotFoundException;

    UserDTO getUserByEmail(String email) throws ClassNotFoundException;

    String createUser(UserDTO userRequestDTO);

    void deleteUser(Long id);
}
