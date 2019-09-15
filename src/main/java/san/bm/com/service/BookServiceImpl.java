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
    public BookDTO addBook(Book book) {
        return bookDao.addBook(book).ConvertToBookDTO();
    }

    @Override
    @Transactional
    public BookDTO updateBook(Book book) {
        return bookDao.updateBook(book).ConvertToBookDTO();
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