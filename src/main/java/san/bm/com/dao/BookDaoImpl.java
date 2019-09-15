package san.bm.com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import san.bm.com.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book addBook(Book book) {
        Book b = em.merge(book);
        logger.info("Book saved. Book details: " + book);
        return b;
    }

    @Override
    public Book updateBook(Book book) {
        Book b = em.merge(book);
        logger.info("Book update. Book details: " + book);
        return b;
    }

    @Override
    public void removeBook(long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
            logger.info("Book removed. Book details: " + book);
        }
    }

    @Override
    public Book getBookById(long id) {
        Book book = em.find(Book.class, id);
        logger.info("Book loaded. Book details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        List<Book> bookList = em.createQuery("from Book", Book.class).getResultList();
        for (Book book : bookList) {
            logger.info("Book list: " + book);
        }
        return bookList;
    }
}