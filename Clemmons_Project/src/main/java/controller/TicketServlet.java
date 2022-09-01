package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Employee;
import entity.Ticket;
import service.EmployeeService;
import service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class TicketServlet extends HttpServlet{
    // type out doGet, and you should get a shortcut for the get method:
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();

        ObjectMapper mapper = new ObjectMapper();
        Ticket ticket=null;

        try {
            ticket = mapper.readValue(req.getReader(), Ticket.class);
        }catch(Exception e)
        {
            e.printStackTrace();
            resp.sendError(400, "Invalid Ticket format");

        }

        int ownerId = ticket.getOwner_id();
        String description = ticket.getDescription();

        List<Ticket> tickets =ticketService.getTicketsByPending(description);

        for(Ticket ticket1: tickets)
        {
            out.println(ticket1);
        }
    }












    // localhost:8080/pets?user=rory&password=123
    // the safer way to do this is adding information to the body


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();
        // the object mapper will convert JSON (the body of the request) to Java entity (Pet class)
        ObjectMapper mapper = new ObjectMapper();

        // we need a way to take the JSON body and convert it to a Java object:
        Ticket ticket;

        // do some error handling to check for bad requests/invalid data:
        // passing in the request reader and the designated class:
        try {
            ticket = mapper.readValue(req.getReader(), Ticket.class);

        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(400, "Invalid ticket format");
            // return from the method
            return;
        }

        // pet should have id after it's inserted:
        ticket = ticketService.insert(ticket);
        out.println(ticket);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();
        // the object mapper will convert JSON (the body of the request) to Java entity (Pet class)
        ObjectMapper mapper = new ObjectMapper();

        // we need a way to take the JSON body and convert it to a Java object:
        Ticket ticket;

        // do some error handling to check for bad requests/invalid data:
        // passing in the request reader and the designated class:
        try {
            ticket = mapper.readValue(req.getReader(), Ticket.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(400, "Invalid ticket updating");
            // return from the method
            return;
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketService ticketService = new TicketService();
        PrintWriter out = resp.getWriter();

        String pathInfo = req.getPathInfo();
        if(pathInfo == null) {
            resp.sendError(400, "Must include id");
            return;
        }

        String id = pathInfo.substring(1);
        int idInteger = Integer.parseInt(id);

        boolean success = ticketService.deleteTicket(idInteger);
        if(success) {
            out.write("Deletion successful!");
        }
        else {
            resp.sendError(400, "Deletion unsuccessful, perhaps id doesn't exist?");
        }
    }
}

