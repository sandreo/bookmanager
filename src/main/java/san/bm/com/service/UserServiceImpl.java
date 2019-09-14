package san.bm.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import san.bm.com.dao.BookDao;
import san.bm.com.dao.UserDao;
import san.bm.com.dto.UserDTO;
import san.bm.com.model.Book;
import san.bm.com.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    private BookDao bookDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void addBookToUser(long userId, long bookId) {
        Book book = bookDao.getBookById(bookId);
        User user = userDao.getUserById(userId);
        user.getBooks().add(book);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public UserDTO getUserById(long id) {
        return userDao.getUserById(id).ConvertToUserDTO();
    }

    @Override
    public List<UserDTO> listUsers() {
        List<User> list = userDao.listUsers();
        List<UserDTO> userDTO = new ArrayList<>();
        for (User user : list) {
            userDTO.add(user.ConvertToUserDTO());
        }
        return userDTO;
    }
}
