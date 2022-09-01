package data;

import entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee insert (Employee employee);
    public Employee getById(int id);


    public Employee getManagerStatus(int id);

    List<Employee> getAllEmployees();
}
