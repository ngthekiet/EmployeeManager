package vn.com.employeemanager.model;

import java.sql.Date;

public class Employee {
    private String id;
    private String name;
    private boolean male;
    private Date birthDay;
    private String address;
    private String phone;
    private String department;
    private String title;
    private long wageRange;

    public Employee(String id, String name, boolean male, Date birthDay, String address, String phone, String department, String title, long wageRange) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.department = department;
        this.title = title;
        this.wageRange = wageRange;
    }

    public Employee() {

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

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getWageRange() {
        return wageRange;
    }

    public void setWageRange(long wageRange) {
        this.wageRange = wageRange;
    }
}
