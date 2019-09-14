package san.bm.com.dto;

import san.bm.com.model.Book;

public class BookDTO {
    private long id;
    private String bookTitle;
    private String bookAuthor;
    private int price;

    public Book ConvertToBook() {
        Book entity = new Book();
        entity.setId(id);
        entity.setBookTitle(bookTitle);
        entity.setBookAuthor(bookAuthor);
        entity.setPrice(price);
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
