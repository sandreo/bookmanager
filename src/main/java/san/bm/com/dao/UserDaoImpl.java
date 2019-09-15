package san.bm.com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import san.bm.com.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public User addUser(User user) {
        User u = em.merge(user);
        logger.info("User saved. User details: " + user);
        return u;
    }

    @Override
    public User updateUser(User user) {
        User u = em.merge(user);
        logger.info("User update. User details: " + user);
        return u;
    }

    @Override
    public void removeUser(long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        logger.info("User removed. User details: " + user);
    }

    @Override
    public User getUserById(long id) {
        User user = em.find(User.class, id);
        logger.info("User loaded. User details: " + user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        List<User> userList = em.createQuery("from User", User.class).getResultList();
        for (User user : userList) {
            logger.info("User list" + user);
        }
        return userList;
    }
}
