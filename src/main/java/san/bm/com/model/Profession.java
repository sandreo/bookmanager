package san.bm.com.model;

import san.bm.com.dto.ProfessionDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "professions")
public class Profession {
    @Id
    @Column(name = "PROFESSION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PROFESSION_NAME")
    private String professionName;

    @OneToMany(mappedBy = "profession")
    private Set<User> users;

    public ProfessionDTO ConvertToProfessionDTO() {
        ProfessionDTO dto = new ProfessionDTO();
        dto.setId(id);
        dto.setProfessionName(professionName);
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
