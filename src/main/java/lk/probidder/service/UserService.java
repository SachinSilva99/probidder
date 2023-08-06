package lk.probidder.service;

import lk.probidder.entity.User;

/*
Author : Sachin Silva
*/
public interface UserService {

    User getUserById(Long id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    User createUser(User user);

    void deleteUser(Long id);
}
