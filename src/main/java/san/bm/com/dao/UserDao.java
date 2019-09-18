package san.bm.com.dao;

import san.bm.com.model.User;
import java.util.List;

public interface UserDao {
    User addUser(User user);
    User updateUser(User user);
    void removeUser(long id);
    User getUserById(long id);
    List<User> listUsers();
}