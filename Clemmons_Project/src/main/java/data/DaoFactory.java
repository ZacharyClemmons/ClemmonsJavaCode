package data;

public class DaoFactory {
    private static EmployeeDao employeeDao = null;
    private static TicketDao ticketDao =null;
    // don't have access to the constructor:
    private DaoFactory() {

    }

    public static EmployeeDao getEmployeeDao() {
        if (employeeDao == null) {
            System.out.println("This should only be called once (Employee Dao Creation)");
            // if we haven't created a pet dao yet, we do that here:
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;


    }
        public static TicketDao getTicketDao() {

            if (ticketDao == null) {
                System.out.println("This should only be called once (Ticket Dao Creation)");
                // if we haven't created a pet dao yet, we do that here:
                ticketDao = new TicketDaoImpl();
            }
            return ticketDao;

    }
}

