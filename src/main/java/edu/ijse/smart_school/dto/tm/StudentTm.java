package edu.ijse.smart_school.dto.tm;


public class StudentTm {
    private String id;
    private String name;
    private String categary;

    public StudentTm(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public StudentTm(String id, String name, String categary) {
        this.id = id;
        this.name = name;
        this.categary = categary;
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

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }
}
