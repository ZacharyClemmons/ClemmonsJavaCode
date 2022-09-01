package service;

import data.DaoFactory;
import data.EmployeeDao;
import data.TicketDao;
import entity.Employee;
import entity.Ticket;
import javax.servlet.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public Employee register(Employee employee) {
        // we want to send back data from database
        // inserting this new person into the database:
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee1 = employeeDao.insert(employee);
        return employee1;
    }


    public Employee login(int id, String password, String managerStatus) {

        String managerStatus1;
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee = employeeDao.getById(id);

        if (password.equals(employee.getPassword())) {
            // if they match, we return the person
            return employee;
        }


        return null;
    }

public Employee getManagerStatus (int id)
{
    EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
    return employeeDao.getManagerStatus(id);
}


    public boolean assign(int employeeId, int ticketId) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.assign(employeeId, ticketId);
    }


    public List<Ticket> getAssignedTickets(int employeeId) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getAssignedTickets(employeeId);
    }
    public List<Employee> getAllEmployees(int userId)
    {
        EmployeeDao employeeDao= DaoFactory.getEmployeeDao();
        return employeeDao.getAllEmployees();
    }
}
