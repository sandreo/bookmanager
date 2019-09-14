package san.bm.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import san.bm.com.dao.BookDao;
import san.bm.com.dto.BookDTO;
import san.bm.com.dto.UserDTO;
import san.bm.com.model.Book;
import san.bm.com.model.User;

import java.util.ArrayList;
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
    public BookDTO getBookById(long id) {

        return bookDao.getBookById(id).ConvertToBookDTO();
    }

    @Override
    public List<BookDTO> listBooks() {
        List<Book> list = bookDao.listBooks();
        List<BookDTO> bookDTO = new ArrayList<>();
        for (Book book : list)
            bookDTO.add(book.ConvertToBookDTO());
        return bookDTO;
    }
}
