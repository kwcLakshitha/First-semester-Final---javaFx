package edu.ijse.smart_school.dto;

public class TeacherDto {
    private String teacher_id;
    private String name;
    private String address;
    private String nic;
    private String categary;
    private String hire_date;
    private String email;
    private String phone;

    public TeacherDto() {

    }

    public TeacherDto(String teacher_id, String name, String address, String nic, String categary, String hire_date, String email, String phone) {

        this.teacher_id = teacher_id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.categary = categary;
        this.hire_date = hire_date;
        this.email = email;
        this.phone = phone;

    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
