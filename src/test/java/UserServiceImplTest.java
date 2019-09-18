import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import san.bm.com.dao.UserDao;
import san.bm.com.dto.UserDTO;
import san.bm.com.model.Address;
import san.bm.com.model.Book;
import san.bm.com.model.Profession;
import san.bm.com.model.User;
import san.bm.com.service.UserServiceImpl;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    private User user1;
    private User user2;

    @Before
    public void setUp() {
        Address address1 = new Address();
           address1.setId(1);
           address1.setAddressName("Brighton Beach Ave");
        Profession profession1 = new Profession();
           profession1.setId(1);
           profession1.setProfessionName("Web Developer");
        Address address2 = new Address();
           address2.setId(2);
           address2.setAddressName("Wall Street");
        Profession profession2 = new Profession();
           profession2.setId(2);
           profession2.setProfessionName("Engineer");
        Book book1 = new Book();
           book1.setId(1);
           book1.setBookTitle("White Fang");
           book1.setBookAuthor("Jack London");
           book1.setPrice(300);
        Book book2 = new Book();
           book2.setId(2);
           book2.setBookTitle("A Dog's Heart");
           book2.setBookAuthor("Mikhail Bulgakov");
           book2.setPrice(200);
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        user1 = new User();
        user1.setId(1);
        user1.setUserName("David");
        user1.setAddress(address1);
        user1.setProfession(profession1);
        user1.setBooks(books);
        user2 = new User();
        user2.setId(2);
        user2.setUserName("James");
        user2.setAddress(address2);
        user2.setProfession(profession2);
        user2.setBooks(books);
    }

    @Test
    public void testGetUserById() {
        Mockito.when(userDao.getUserById(1)).thenReturn(user1);
        UserDTO userDTO = userService.getUserById(1);
        Assert.assertEquals(1, userDTO.getId());
    }

    @Test
    public void testListUsers() {
        Mockito.when(userDao.listUsers()).thenReturn(Arrays.asList(user1, user2));
        List<UserDTO> users = userService.listUsers();
        Assert.assertEquals(2, users.size());
        Assert.assertEquals(1, users.get(0).getId());
        Assert.assertEquals(2, users.get(1).getId());
        Assert.assertEquals("David", users.get(0).getUserName());
        Assert.assertEquals("James", users.get(1).getUserName());
    }

    @Test
    public void testAddUser() {
        Mockito.when(userDao.addUser(user1)).thenReturn(user1);
        UserDTO userDTO = userService.addUser(user1);
        Assert.assertEquals(1, userDTO.getId());
        Assert.assertEquals("David", userDTO.getUserName());
    }
}