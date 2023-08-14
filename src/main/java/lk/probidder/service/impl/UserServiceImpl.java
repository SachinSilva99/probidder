package lk.probidder.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.probidder.dto.UserDTO;
import lk.probidder.dto.request.UserRequestDTO;
import lk.probidder.dto.response.UserResponseDTO;
import lk.probidder.entity.User;
import lk.probidder.repo.UserRepo;
import lk.probidder.service.UserService;
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
    public UserResponseDTO getUserById(Long id) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return userMapper.toUserResponseDto(byId.get());
        }
        throw new ClassNotFoundException(id + "customer Not Found ");
    }

    @Override
    public UserResponseDTO getUserByUsername(String username) throws EntityNotFoundException {
        Optional<User> byId = userRepository.findByUsername(username);
        if (byId.isPresent()) {
            return userMapper.toUserResponseDto(byId.get());
        }
        throw new EntityNotFoundException(username + "customer Not Found ");
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findByEmail(email);
        if (byId.isPresent()) {
            return userMapper.toUserResponseDto(byId.get());
        }
        throw new ClassNotFoundException(email + "customer Not Found ");
    }

    @Override
    public String createUser(UserRequestDTO urd) {
      /*  UserDTO userDTO = new UserDTO(
                urd.getUsername(),
                urd.getEmail(),
                urd.getPassword(),
                urd.getPhoneNumber(),
                urd.getRoleType(),
                urd.getDob()
        );*/
        UserDTO userDTO = userMapper.userRequestDtoToUserDto(urd);
        return userRepository.save(userMapper.toUser(userDTO)).getId() + " saved";
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}
