package san.bm.com.dao;

import san.bm.com.model.Book;
import java.util.List;

public interface BookDao {
    Book addBook(Book book);
    Book updateBook(Book book);
    void removeBook(long id);
    Book getBookById(long id);
    List<Book> listBooks();
}