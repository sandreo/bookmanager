package san.bm.com.service;

import san.bm.com.dto.UserDTO;
import san.bm.com.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void addBookToUser(long userId, long bookId);
    void updateUser(User user);
    void removeUser(long id);
    UserDTO getUserById(long id);
    List<UserDTO> listUsers();
}
