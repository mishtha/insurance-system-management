/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lasitha G Gunasinghe
 */
class users {

	Connection con;
	Statement st;

	private void connectTodb() throws SQLException {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/insurance";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "root");
			st = con.createStatement();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	boolean auth(String uid, String pass) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT * FROM users WHERE user_id = '" + uid + "' AND password = '" + pass + "'";
		try {

			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				return true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}

	List userAuth(String uid, String pass) {
		List user = new ArrayList();
		String query = "SELECT user_id,user_type FROM users WHERE user_id = '" + uid + "' AND password = '" + pass
				+ "'";
		try {
			connectTodb();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				user.add(rs.getString(1));
				user.add(rs.getString(2));
			}
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception e) {

		}

		return user;
	}

	void addUser(String uid, String pass, String utype, String uname, String email, String add, int tel, String cdate,
			String ctime, double lat, double lng) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "INSERT INTO users(user_id,password,user_type,name,email,address,tel,cdate,ctime,lat,lon)VALUES('"
				+ uid + "','" + pass + "','" + utype + "','" + uname + "','" + email + "','" + add + "','" + tel + "','"
				+ cdate + "','" + ctime + "','" + lat + "','" + lng + "')";
		try {
			st.executeUpdate(query);

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);

		}

	}

	List viewUsers() {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT user_id,user_id,name,email,user_id,user_id FROM users ";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userList.add(rs.getString(1));
				userList.add(rs.getString(2));
				userList.add(rs.getString(3));
				userList.add(rs.getString(4));
				userList.add(rs.getString(5));
				userList.add(rs.getString(6));

			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userList;
	}

	void deleteUser(String uid) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "DELETE FROM  users_policy WHERE  user_id='" + uid + "'";
		String query2 = "DELETE FROM  users WHERE  user_id='" + uid + "'";

		//
		try {
			st.executeUpdate(query);
			st.executeUpdate(query2);
			//

		} catch (SQLException ex) {

			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	List vieweditUser(String uid) {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT user_id,password,user_type,name,email,address,tel FROM users WHERE user_id='" + uid
				+ "'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userList.add(rs.getString(1));
				userList.add(rs.getString(2));
				userList.add(rs.getString(3));
				userList.add(rs.getString(4));
				userList.add(rs.getString(5));
				userList.add(rs.getString(6));
				userList.add(rs.getString(7));

			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userList;
	}

	void updateUser(String uid, String pass, String utype, String uname, String email, String add, int tel,
			String cdate, String ctime, double lat, double lng) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "UPDATE users SET user_id='" + uid + "',password='" + pass + "',user_type='" + utype + "',name='"
				+ uname + "',email='" + email + "',address='" + add + "',tel='" + tel + "',cdate='" + cdate
				+ "',ctime='" + ctime + "',lat='" + lat + "',lon='" + lng + "' WHERE  user_id='" + uid + "'";

		//
		try {
			st.executeUpdate(query);

			//

		} catch (SQLException ex) {

			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	List viewuserDetails(String uid) {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT name,user_type,user_id,email,address,tel,cdate,ctime,lat,lon FROM users WHERE user_id='"
				+ uid + "' ";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userList.add(rs.getString(1));
				userList.add(rs.getString(2));
				userList.add(rs.getString(3));
				userList.add(rs.getString(4));
				userList.add(rs.getString(5));
				userList.add(rs.getString(6));
				userList.add(rs.getString(7));
				userList.add(rs.getString(8));
				userList.add(rs.getString(9));
				userList.add(rs.getString(10));

			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userList;
	}

	List searchUser(String uid) {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT user_id,user_id,name,email,user_id,user_id FROM users WHERE user_id='" + uid + "' ";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userList.add(rs.getString(1));
				userList.add(rs.getString(2));
				userList.add(rs.getString(3));
				userList.add(rs.getString(4));
				userList.add(rs.getString(5));
				userList.add(rs.getString(6));

			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userList;
	}

	List totalAgents() {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = " SELECT COUNT(user_id) FROM users WHERE user_type='Agent'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userList.add(rs.getString(1));

			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userList;
	}

	List totalClients() {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = " SELECT COUNT(user_id) FROM users WHERE user_type='Client'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userList.add(rs.getString(1));

			}

		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userList;
	}

}
