package lk.probidder.api;

import lk.probidder.dto.UserDTO;
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
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<StandardResponse> create(@RequestBody UserDTO userDTO) {

        String userIdSavedMsg = userService.createUser(userDTO);
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        userIdSavedMsg,
                        null
                ), HttpStatus.CREATED
        );
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
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        id + " not found",
                        null
                ), HttpStatus.NOT_FOUND
        );
    }


}
