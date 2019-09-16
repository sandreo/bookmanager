package san.bm.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import san.bm.com.dto.UserDTO;
import san.bm.com.model.User;
import san.bm.com.service.UserService;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> listUsers() {
        return userService.listUsers();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO editUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO userData(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @PutMapping(path = "/{id}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO addBookToUser(@PathVariable("id") long id, @RequestParam("bookId") long bookId) {
        return userService.addBookToUser(id, bookId);
    }
}