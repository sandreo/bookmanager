package san.bm.com.dto;

import san.bm.com.model.Profession;

public class ProfessionDTO {
    private long id;
    private String professionName;

    public Profession ConvertToProfession() {
        Profession entity = new Profession();
        entity.setId(id);
        entity.setProfessionName(professionName);
        return entity;
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
}
