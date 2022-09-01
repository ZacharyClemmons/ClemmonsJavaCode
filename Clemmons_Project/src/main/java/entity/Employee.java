package entity;

import data.EmployeeDao;

public class Employee {
    private int id;
    private String name;
    private String password;
    private boolean managerStatus;

//default constructor

    public Employee()
    {

    }
    public Employee(int id, boolean managerStatus, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.managerStatus=managerStatus;
    }

    public Employee (boolean managerStatus, String name, String password) {
        this.name = name;
        this.password = password;
        this.managerStatus=managerStatus;
    }









    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(boolean managerStatus) {
        this.managerStatus = managerStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", managerStatus='" + managerStatus + '\''+
                '}';
    }
}
