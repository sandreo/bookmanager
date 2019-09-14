package san.bm.com.dao;

import san.bm.com.model.Book;
import san.bm.com.model.User;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    void updateBook(Book book);
    void removeBook(long id);
    Book getBookById(long id);
    List<Book> listBooks();
}
