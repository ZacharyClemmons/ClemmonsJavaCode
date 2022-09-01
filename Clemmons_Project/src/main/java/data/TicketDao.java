package data;


import entity.Ticket;

import java.util.List;


public interface TicketDao {

 public Ticket insert(Ticket ticket);


 public Ticket getById(int id);
 public List<Ticket> getAllTickets();


 public Ticket update(Ticket ticket);


 public boolean delete(int id);
 public Ticket getTicketStatus(int id);
 public Ticket updateTicketStatus(Ticket ticket);

 public boolean assign(int employeeId, int ticketId);

 public List<Ticket> getAssignedTickets(int employeeId);

 List<Ticket> getTicketsByPending(String descriptionz);
}
