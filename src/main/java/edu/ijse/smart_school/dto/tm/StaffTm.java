package edu.ijse.smart_school.dto.tm;

public class StaffTm {

    private String id;
    private String name;
    private String position;

    public StaffTm(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public StaffTm(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
