package san.bm.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import san.bm.com.dto.BookDTO;
import san.bm.com.model.Book;
import san.bm.com.service.BookService;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> listBooks() {
        return bookService.listBooks();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO addBook(@RequestBody Book book) {
            return bookService.addBook(book);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeBook(@PathVariable("id") long id) {
        bookService.removeBook(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO editBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO bookData(@PathVariable("id") long id) {
        return bookService.getBookById(id);
    }
}