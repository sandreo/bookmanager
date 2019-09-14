package san.bm.com.dto;

import san.bm.com.model.Address;

public class AddressDTO {
    private long id;
    private String addressName;

    public Address ConvertToAddress() {
        Address entity = new Address();
        entity.setId(id);
        entity.setAddressName(addressName);
        return entity;
    }

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
}
