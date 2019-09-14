package san.bm.com.model;

import san.bm.com.dto.UserDTO;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PROFESSION_ID")
    private Profession profession;

    @ManyToMany
    @JoinTable(name = "users_books", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"))
    private Set<Book> books;

    public UserDTO ConvertToUserDTO() {
        UserDTO dto = new  UserDTO();
        dto.setId(id);
        dto.setUserName(userName);
        if (address != null) {
            dto.setAddressName(address.getAddressName());
        }
        if (profession != null) {
            dto.setProfessionName(profession.getProfessionName());
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