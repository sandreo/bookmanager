package san.bm.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import san.bm.com.dto.BookDTO;
import san.bm.com.dto.UserDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSION_ID")
    private Profession profession;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_books", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"))
    private Set<Book> books;

    public UserDTO ConvertToUserDTO() {
        UserDTO dto = new UserDTO();
        Set<BookDTO> bookDTOSet = new HashSet<>();
        for (Book book : books) {
            bookDTOSet.add(book.ConvertToBookDTO());
        }
        dto.setId(id);
        dto.setUserName(userName);
        if (address != null) {
            dto.setAddressName(address.getAddressName());
        }
        if (profession != null) {
            dto.setProfessionName(profession.getProfessionName());
        }
        if (books != null) {
            dto.setBooks(bookDTOSet);
        }
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}