package san.bm.com.dao;

import san.bm.com.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User book);
    void updateUser(User book);
    void removeUser(long id);
    User getUserById(long id);
    List<User> listUsers();
}
