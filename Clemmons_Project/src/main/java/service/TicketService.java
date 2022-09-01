package service;

import data.DaoFactory;
import data.TicketDao;
import data.TicketDaoImpl;
import entity.Ticket;

import java.util.List;

public class TicketService {
    public Ticket insert(Ticket ticket) {
        System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.insert(ticket);
    }

    public Ticket getById(int id) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getById(id);
    }
    public Ticket getByTicketStatus(int id)
    {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getTicketStatus(id);
    }
    public List<Ticket> getTicketsByPending(String descriptionz) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getTicketsByPending(descriptionz);
    }

    public Ticket updateTicket(Ticket ticket) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.update(ticket);
    }


    public boolean deleteTicket(int id) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.delete(id);
    }


}
