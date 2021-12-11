package model;

import java.sql.*;
import java.util.*;

public class DataBase {
    private List<Employee> employees;
    private Connection con;

    public DataBase() {employees = new LinkedList<Employee>(); }

    private void addEmployee(Employee person){
        employees.add(person);
    }

    public List<Employee> getEmployees() {return Collections.unmodifiableList(employees);}

    public void connect() throws SQLException{
        if (con != null) return;

        try {
            Class.forName("org.sqlite.JDBC");
        } catch  (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:sqlite:db/stuff.db";
        con = DriverManager.getConnection(url);
    }

    public void disconnect(){
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void count() throws  SQLException{
        String sql = "SELECT count(*) from employee";
        PreparedStatement sqlStmt = con.prepareStatement(sql);
        ResultSet checkResult = sqlStmt.executeQuery();

        checkResult.next();
        int count = checkResult.getInt(1);

        System.out.println("Count for person is " + count + ".");
        sqlStmt.close();
    }

    public void addEmployeeToDatabase(Employee employee) {
        String name = employee.getName();
        int age = employee.getAge();
        String phone = employee.getPhone();
        String gender = employee.getGender();
        String position = employee.getPosition();
        String department = employee.gerDepartment();

        String sql = "Insert into employee(name, department, age, phone, position, gender) values ('"+name+"'," +
                "'"+department+"','"+age+"','"+phone+"','"+position+"','"+gender+"')";
        System.out.println("SQL = " + sql);

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getFromDatabase();
    }

    public void getFromDatabase() {
        employees.clear();

        String sql = "SELECT * from employee";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()){
                Employee temp = new Employee(set.getString("name"), set.getString("department"),
                        set.getInt("age"), set.getString("phone"), set.getString("position"),
                        set.getString("gender"));

                addEmployee(temp);

            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
