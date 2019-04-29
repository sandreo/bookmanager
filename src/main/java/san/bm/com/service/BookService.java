package san.bm.com.service;

import san.bm.com.model.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    void removeBook(long id);
    Book getBookById(long id);
    List<Book> listBooks();
}
