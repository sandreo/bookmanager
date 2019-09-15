package san.bm.com.service;

import san.bm.com.dto.UserDTO;
import san.bm.com.model.User;

import java.util.List;

public interface UserService {
    UserDTO addUser(User user);
    UserDTO addBookToUser(long userId, long bookId);
    UserDTO updateUser(User user);
    void removeUser(long id);
    UserDTO getUserById(long id);
    List<UserDTO> listUsers();
}
