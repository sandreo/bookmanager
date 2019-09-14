package san.bm.com.dto;

import san.bm.com.model.User;

public class UserDTO {
    private long id;
    private String userName;
    private String addressName;
    private String professionName;

    public User ConvertToUser() {
        User entity = new User();
        entity.setId(id);
        entity.setUserName(userName);
        return entity;
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

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }
}
