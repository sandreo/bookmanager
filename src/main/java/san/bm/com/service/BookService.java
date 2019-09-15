package san.bm.com.service;

import san.bm.com.dto.BookDTO;
import san.bm.com.dto.UserDTO;
import san.bm.com.model.Book;
import java.util.List;

public interface BookService {
    BookDTO addBook(Book book);
    BookDTO updateBook(Book book);
    void removeBook(long id);
    BookDTO getBookById(long id);
    List<BookDTO> listBooks();
}