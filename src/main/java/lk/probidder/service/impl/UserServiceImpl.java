package lk.probidder.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.probidder.dto.UserDTO;
import lk.probidder.entity.User;
import lk.probidder.repo.UserRepo;
import lk.probidder.service.UserService;
import lk.probidder.service.exception.DuplicateException;
import lk.probidder.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
Author : Sachin Silva
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDTO getUserById(Long id) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return userMapper.toUserDto(byId.get());
        }
        throw new ClassNotFoundException(id + "customer Not Found ");
    }

    @Override
    public UserDTO getUserByUsername(String username) throws EntityNotFoundException {
        Optional<User> byId = userRepository.findByUsername(username);
        if (byId.isPresent()) {
            return userMapper.toUserDto(byId.get());
        }
        throw new EntityNotFoundException(username + "customer Not Found ");
    }

    @Override
    public UserDTO getUserByEmail(String email) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findByEmail(email);
        if (byId.isPresent()) {
            return userMapper.toUserDto(byId.get());
        }
        throw new ClassNotFoundException(email + "customer Not Found ");
    }

    @Override
    public String createUser(UserDTO urd) throws DuplicateException {
        Optional<User> byId = userRepository.findById(urd.getId());
        if (byId.isPresent()) {
            throw new DuplicateException();
        }
        return userRepository.save(userMapper.toUser(urd)).getId() + " saved";
    }

    @Override
    public void deleteUser(Long id) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ClassNotFoundException();
        }
        userRepository.deleteById(id);
    }
}
