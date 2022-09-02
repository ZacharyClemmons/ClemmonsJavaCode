package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.ConnectionFactory;
import data.EmployeeDao;
import entity.Employee;
import entity.Ticket;
import service.EmployeeService;
import service.TicketService;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

    // register and login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();
        ObjectMapper mapper = new ObjectMapper();
        Employee employee;
        try {
            employee = mapper.readValue(req.getReader(), Employee.class);
        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid employee format");
            return;
        }

        String authType = req.getParameter("auth");

        boolean managerStatus1;

        if(authType.equals("login")) {
            employee = employeeService.login(employee.getId(),employee.getPassword(), String.valueOf(employee.getManagerStatus()));
            //check for manager
        }
        else if (authType.equals("register"))
        {
            employee = employeeService.register(employee);
        }
        if(employee == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }

        out.println(employee.getName());

        req.getSession().setAttribute("id", employee.getId());

        int mint;
        mint=(Integer) req.getSession().getAttribute("id");
        Employee employ = new Employee();
        employ= employeeService.getManagerStatus(mint);
        out.println(employ);
        if (employ.getManagerStatus()==true)
        {
            out.println("Currently logged user is a manager");
        }
        else if (employ.getManagerStatus()==false)
        {
            out.println("Currently logged user is NOT a manager");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();

        // try to get the person id from the session:
        int employeeId;
        try {
            employeeId = (Integer) req.getSession().getAttribute("id");
        } catch (Exception e) {
            resp.sendError(401, "Must be logged in to view assigned tickets");
            return;
        }
        List<Employee> employees = employeeService.getAllEmployees(employeeId);

        for(Employee employee: employees) {
            out.println(employee);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();
        TicketService ticketService = new TicketService();

        int employeeId;
        int ticketId;
        try {
            employeeId = (Integer) req.getSession().getAttribute("id");

        } catch (Exception e) {
            resp.sendError(401, "Must be logged in to assign tickets.");
            return;
        }

        try {
            ticketId = Integer.parseInt(req.getParameter("ticketId"));
            String approval = req.getParameter("approval");

        } catch (Exception e) {
            resp.sendError(400, "Must include ticket id.");
            return;
        }



        try {
            int mint;
            Employee employ = new Employee();
            mint=(Integer) req.getSession().getAttribute("id");
            employ= employeeService.getManagerStatus(employeeId);
            out.println(employ);
            ticketId = Integer.parseInt(req.getParameter("ticketId"));
            String approval = req.getParameter("approval");
            Ticket tickyApprove = new Ticket("Approved", true, true,ticketId);
            Ticket tickyDeny = new Ticket("Denied", false, true, ticketId );

            Ticket ticketProcessCheck= new Ticket();

            out.println(ticketProcessCheck);


            if (employ.getManagerStatus()== true&& approval.equals("Approved")&&ticketProcessCheck.getProcessed()==false){

                employeeService.assign(employeeId, ticketId);
                ticketService.updateTicket(tickyApprove);
                out.println("Ticket has been approved, you may no longer edit after processing");

            }
            else if (employ.getManagerStatus()==false || approval.equals("Denied")&&ticketProcessCheck.getProcessed()==false)
            {
                out.println("Manager status is false or ticket has been denied");
                ticketService.updateTicket(tickyDeny);


            }
        } catch (Exception e){
                e.printStackTrace();
                resp.sendError(400, "Make sure ticket id exists! Managers access only! Tickets cannot be edited after processing");
                return;

        }
        out.println("Ticket assigned successfully!");
    }
}
