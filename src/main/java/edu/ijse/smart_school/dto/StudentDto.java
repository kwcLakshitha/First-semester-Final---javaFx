package edu.ijse.smart_school.dto;

public class StudentDto {
    private String studentId;
    private String name;
    private String category;
    private String dateOfBirth;
    private String school;
    private String address;
    private String phone;
    private String email;

    public StudentDto() {

    }

    public StudentDto(String studentId, String name, String category, String dateOfBirth, String school, String address, String phone, String email) {
        this.studentId = studentId;
        this.name = name;
        this.category = category;
        this.dateOfBirth = dateOfBirth;
        this.school = school;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
