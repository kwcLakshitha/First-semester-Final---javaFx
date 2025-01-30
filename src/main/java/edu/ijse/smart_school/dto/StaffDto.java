package edu.ijse.smart_school.dto;

public class StaffDto {
    private String memberId;
    private String name;
    private String address;
    private String position;
    private String hire_date;
    private String phone;
    private String email;

    public StaffDto(String memberId, String name, String address, String position, String hire_date, String phone, String email) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.position = position;
        this.hire_date = hire_date;
        this.phone = phone;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
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

