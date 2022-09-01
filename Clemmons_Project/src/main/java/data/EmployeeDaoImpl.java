package data;

import entity.Employee;
import entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

// this class is going to interact with the person table:
public class EmployeeDaoImpl implements EmployeeDao{

    Connection connection;

    public EmployeeDaoImpl() {
        // we're using the same exact connection factory as our pet dao class because
        // it's the same database
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public Employee insert(Employee employee) {
        Logger logger = LoggerFactory.getLogger("Pet Dao Impl");
        String sql = "insert into employees values(default, ?, ?, ?);";
        try {
            // preparing our statement and indicating that we want the generated id:
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setBoolean(1, employee.getManagerStatus());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getPassword());


            int count = preparedStatement.executeUpdate();

            if (count == 1) {
                logger.info("Person added successfully");
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            employee.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            logger.warn("Something went wrong with the insert");
            return null;
        }
        return employee;
    }


    @Override
    public Employee getById(int id) {
        Logger logger = LoggerFactory.getLogger("Employee Dao Impl");
        String sql = "select * from employees where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                boolean managerStatus = resultSet.getBoolean("managerStatus");

                return new Employee(idDb, managerStatus, name, password);
            }
            else {
                logger.warn("Employee might not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("SQL Exception occurred");
        }
        return null;
    }

    @Override
    public Employee getManagerStatus(int id) {
        String sql = "select * from employees where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Now that we've prepared the statement, we just want to execute it:
            // Result set is going to store the return value of the query:
            ResultSet resultSet = preparedStatement.executeQuery();

            // make sure we actually got a value from the query:
            if(resultSet.next()) {
                // parse out and extract the data
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                boolean managerStatus = resultSet.getBoolean("managerStatus");

                // use the data to create a pet object
                return new Employee(idDb, managerStatus, name,password);
                // return the pet object
            }
            else {
                System.out.println("something went wrong when trying to query for the pet, pet might not exist");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to retrieve data.");
            e.printStackTrace();

        }
        // if we reach the end of this method, return null
        return null;



    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }


}
