package san.bm.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import san.bm.com.model.Book;
import san.bm.com.service.BookService;
import java.util.List;

@RestController
@RequestMapping(value = "books")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> addBook(@RequestBody Book book) {
            bookService.addBook(book);
        return bookService.listBooks();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> removeBook(@PathVariable("id") long id) {
        bookService.removeBook(id);
        return bookService.listBooks();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> editBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return bookService.listBooks();
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book bookData(@PathVariable("id") long id, Model model) {
        return bookService.getBookById(id);
    }
}
