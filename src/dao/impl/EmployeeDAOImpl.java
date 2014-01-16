package dao.impl;

import dao.EmployeeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import resources.JDBCUtil;

/**
 * @author tombisnis@yahoo.com
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    
    public EmployeeDAOImpl(){
        connection = JDBCUtil.getConnection();
    }
    
    @Override
    public void save(Employee employee) throws SQLException {         
        statement = connection.createStatement();                        
        statement.executeUpdate("insert into employee values('"+employee.getId()+"','"+employee.getName()+"','"+employee.getAddress()+"')");
    }

    @Override
    public void saveOrUpdate(Employee employee) throws SQLException {
        statement = connection.createStatement();                        
        statement.executeUpdate("update employee set id='"+employee.getId()+"', name='"+employee.getName()+"', address='"+employee.getAddress()+"' where id='"+employee.getId()+"'");
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        statement = connection.createStatement();                        
        statement.executeUpdate("delete from employee where id='"+employee.getId()+"'");
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException{
        
        List<Employee> list = new ArrayList<Employee>();
                             
        statement = connection.createStatement();                        
        resultSet = statement.executeQuery("select * from employee");
        
        while(resultSet.next()){
            Employee e = new Employee();
            e .setId(resultSet.getString("id"));
            e .setName(resultSet.getString("name"));
            e .setAddress(resultSet.getString("address"));
            
            list.add(e);
        }
        
        return list;
    }
}