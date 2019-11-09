package connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

import connection.User;
import connection.DBConnection;
public class GetInfo {
	public void addUser(User u) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "insert into userreg value(?,?,?,?,?,?)";
		PreparedStatement U;
		try {
			U = (PreparedStatement) con.prepareStatement(sql);
			U.setInt(1, u.getId());
			U.setString(2, u.getUserName());			
			U.setString(3, u.getPassWord());
			U.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public ResultSet checkUser(String userName) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		ResultSet rs = null;
		String sql = "select * from userreg where userName=?";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,userName);
			rs = ps.executeQuery();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	public static boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from userreg where userName='" + userName
				+ "' and Password='" + passWord + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				System.out.println("true");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("false");

		return false;
	}
	public User getUser(int ID) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from user where id = '"+ID+"'";
		PreparedStatement u;
		User c = new User();
		try {
			u = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = u.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("User_ID");
				String UserName = rs.getString("User_Name");	
				String PassWord = rs.getString("Password");
				c = new User(userId, UserName, PassWord);
				System.out.printf("%-10s %-20s %-20s %-20s \n",userId, UserName, PassWord);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return c;
	}
	public User getUserName(String Name) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from user where userName = '"+Name+"'";
		PreparedStatement u;
		User c = new User();
		try {
			u = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = u.executeQuery();
			while (rs.next()) {
				int User_ID = rs.getInt("User_ID");
				String User_Name = rs.getString("User_Name");
				String Password = rs.getString("Password");
				c = new User(User_ID, User_Name, Password);
				System.out.printf("%-10s %-20s %-20s %-20s \n",User_ID, User_Name, Password);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return c;
		
	}

	public void updateUser(User c) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "update user set userName = ?, passWord = ? where id = ?";
		PreparedStatement u;
		try {
			u = (PreparedStatement) con.prepareStatement(sql);
			u.setString(1, c.getUserName());
			u.setString(2, c.getPassWord());
			u.setInt(3, c.getId());
			u.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void delUser(int ID) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "DELETE FROM userreg WHERE id = '"+ID+"'";
		PreparedStatement u;
		try {
			u = (PreparedStatement) con.prepareStatement(sql);
			u.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
