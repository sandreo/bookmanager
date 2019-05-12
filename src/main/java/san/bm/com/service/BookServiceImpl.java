package san.bm.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import san.bm.com.dao.BookDao;
import san.bm.com.model.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(long id) {
        bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookById(long id) {
        return bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}
