package san.bm.com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import san.bm.com.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void addBook(Book book) {
        EntityManager manager = this.entityManagerFactory.createEntityManager();
        manager.persist(book);
        logger.info("Book saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        EntityManager manager = this.entityManagerFactory.createEntityManager();
        manager.merge(book);
        logger.info("Book update. Book details: " + book);
    }

    @Override
    public void removeBook(long id) {
        EntityManager manager = this.entityManagerFactory.createEntityManager();
        Book book = manager.find(Book.class, id);
        if (book != null) {
            manager.remove(book);
            logger.info("Book removed. Book details: " + book);
        }
    }

    @Override
    public Book getBookById(long id) {
        EntityManager manager = this.entityManagerFactory.createEntityManager();
        Book book = manager.find(Book.class, id);
        logger.info("Book loaded. Book details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        EntityManager manager = this.entityManagerFactory.createEntityManager();
        List<Book> bookList = manager.createQuery("from Book", Book.class).getResultList();
        for (Book book : bookList) {
            logger.info("Book list: " + book);
        }
        return bookList;
    }
}
