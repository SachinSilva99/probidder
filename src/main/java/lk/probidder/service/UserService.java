package lk.probidder.service;

import jakarta.persistence.EntityNotFoundException;
import lk.probidder.dto.UserDTO;
import lk.probidder.service.exception.DuplicateException;

/*
Author : Sachin Silva
*/
public interface UserService {

    UserDTO getUserById(Long id) throws ClassNotFoundException;

    UserDTO getUserByUsername(String username) throws EntityNotFoundException;

    UserDTO getUserByEmail(String email) throws ClassNotFoundException;

    String createUser(UserDTO userRequestDTO) throws DuplicateException;

    void deleteUser(Long id) throws ClassNotFoundException;
}
