package lk.probidder.api;

import jakarta.persistence.EntityNotFoundException;
import lk.probidder.dto.request.UserRequestDTO;
import lk.probidder.dto.response.UserResponseDTO;
import lk.probidder.service.UserService;
import lk.probidder.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<StandardResponse> getUser(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(
                    new StandardResponse(
                            200,
                            id.toString(),
                            userService.getUserById(id)
                    ), HttpStatus.CREATED
            );
        } catch (ClassNotFoundException e) {
            //  e.printStackTrace();
        }
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        id+" not found",
                        null
                ), HttpStatus.NOT_FOUND
        );

    }

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<StandardResponse> save(@RequestBody UserRequestDTO userRequestDTO) {
        String userIdSavedMsg = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        userIdSavedMsg,
                        null
                ), HttpStatus.CREATED
        );
    }
}
