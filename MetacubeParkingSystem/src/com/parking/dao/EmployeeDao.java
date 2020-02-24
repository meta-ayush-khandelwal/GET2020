package com.parking.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.employee.databaseConnection.DbConnection;
import com.parking.pojo.Employee;
import com.parking.pojo.Vehicle;

public class EmployeeDao {
	private static Connection connection = DbConnection.getConnection();

	public static boolean check(String email, String password) {
		try {	
			String sql="SELECT * FROM employee WHERE Email=? and Password=?";
			PreparedStatement statement = connection.prepareCall(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int saveEmployeeDetails(Employee employee){
		int status = 0;
		int emailAlreadyExist = 0;
		try
		{
			Statement statement = connection.createStatement();
			String Email = employee.getEmail();
			String strQuery = "SELECT COUNT(*) FROM employee where Email='"+Email+"'";
			ResultSet resultSet = statement.executeQuery(strQuery);
			while(resultSet.next())
			{
				emailAlreadyExist = resultSet.getInt(1);
			}
			if (emailAlreadyExist == 0) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO employee(empId,fullName,email,gender,contact,password,organization) VALUES(empId,?,?,?,?,?,?)");
                preparedStatement.setString(1, employee.getFullName());
                preparedStatement.setString(3, employee.getGender());
                preparedStatement.setString(2, employee.getEmail());
                preparedStatement.setString(4, employee.getContact());
                preparedStatement.setString(6, employee.getOrganization());
                preparedStatement.setString(5, employee.getPassword());
                System.out.println(employee.getContact());
                status = preparedStatement.executeUpdate();
            }
			else if(emailAlreadyExist > 0){
				status = 2;
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return status;
	}

	public static void saveVehicleDetails(Vehicle vehicle) {
	    try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO vehicle(vehicleId,vehicleName,vehicleType,vehicleNumber,empId,identification,passType,price) VALUES(vehicleId,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, vehicle.getVehicleName());
            preparedStatement.setString(2, vehicle.getVehicleType());
            preparedStatement.setString(3, vehicle.getVehicleNum());
            preparedStatement.setInt(4, vehicle.getEmpId());
            preparedStatement.setString(5, vehicle.getVehicleIdentity());
            preparedStatement.setString(6, vehicle.getPassType());
            preparedStatement.setInt(7, vehicle.getPrice());
            preparedStatement.executeUpdate();
        }
		catch(Exception e)	{
			e.printStackTrace();
		}
	}

	public static int getEmployeeId(String Email) {
		int employeeId = 0;
		try
		{
			String query = "SELECT * FROM employee WHERE Email=?";
			PreparedStatement preparedStatement = connection.prepareCall(query); 
			preparedStatement.setString(1,Email); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) { 
				employeeId = resultSet.getInt("empId");
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return employeeId;
	}

	public static int getVehicleId(int employeeId) {
		int vehicleId = 0;
		try
		{
			String query = "SELECT * FROM vehicle WHERE empId=?";
			PreparedStatement preparedStatement = connection.prepareCall(query); 
			preparedStatement.setInt(1, employeeId); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) { 
				vehicleId = resultSet.getInt("vehicleId");
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return vehicleId;
	}

	public static ArrayList<Employee> getFriends(int empId){
		ArrayList<Employee> friendsList = new ArrayList<>();
		try
		{
			String query = "SELECT * FROM employee WHERE organization = (SELECT organization FROM employee WHERE empId = ?)";
			PreparedStatement preparedStatement = connection.prepareCall(query); 
			preparedStatement.setInt(1, empId); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) { 
				Employee friend = new Employee();
				friend.setEmpId(resultSet.getInt("empId"));
				friend.setFullName(resultSet.getString("fullName"));
				friend.setEmail(resultSet.getString("email"));
				friend.setGender(resultSet.getString("gender"));
				friend.setContact(resultSet.getString("contact"));
				friend.setOrganization(resultSet.getString("organization"));
				if(empId != friend.getEmpId()){
					friendsList.add(friend);
				}
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return friendsList;
	}

	public static Employee getEmployeeDetails(int empId) {
		Employee employee = new Employee();
		try
		{
			String query = "SELECT * FROM employee WHERE empId=?";
			PreparedStatement preparedStatement = connection.prepareCall(query); 
			preparedStatement.setInt(1, empId); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) { 
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setFullName(resultSet.getString("fullName"));
				employee.setEmail(resultSet.getString("email"));
				employee.setGender(resultSet.getString("gender"));
				employee.setContact(resultSet.getString("contact"));
				employee.setOrganization(resultSet.getString("organization"));
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return employee;
	}

	public static void editEmployeeDetails(Employee employee) {
		try
		{
			Connection conn = DbConnection.getConnection();
			int empId = employee.getEmpId();
			String fullName = employee.getFullName();
			String gender = employee.getGender();
			String contact = employee.getContact();
			String organization = employee.getOrganization();
			String query="update employee set fullName=?,gender=?,contact=?,organization=? where empId=?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,fullName);
			st.setString(2,gender);
			st.setString(3,contact);
			st.setString(4,organization);
			st.setInt(5,empId);
			st.executeUpdate(); 
		}
		catch(Exception e)	{
			e.printStackTrace();
		}

	} 
}
