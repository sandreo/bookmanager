package san.bm.com.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ADDRESS_NAME")
    private String addressName;

    @OneToOne(mappedBy = "address")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
