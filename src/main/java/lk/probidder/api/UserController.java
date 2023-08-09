package lk.probidder.api;

import lk.probidder.dto.UserDTO;
import lk.probidder.dto.request.UserRequestDTO;
import lk.probidder.dto.response.UserResponseDTO;
import lk.probidder.entity.User;
import lk.probidder.service.UserService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/*
Author : Sachin Silva
*/
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        UserResponseDTO user = null;
        try {
            user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<String> save(@RequestBody UserRequestDTO userRequestDTO) {
        System.out.println(userRequestDTO);
        String user = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(user);
    }
}
