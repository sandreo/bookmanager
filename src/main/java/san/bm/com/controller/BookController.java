package san.bm.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import san.bm.com.model.Book;
import san.bm.com.service.BookService;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "books")
    public String listBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }

    @PostMapping(value = "/books/add")
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }
        return "redirect:/books";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable("id") long id) {
        this.bookService.removeBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "edit/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        return "bookdata";
    }
}
