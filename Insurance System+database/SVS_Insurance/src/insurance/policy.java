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
 * @author dharmishtha
 */
class policy {

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
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	void addPolicy(String ptitle, String pbody, String ptype, String cdate, String ctime) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "INSERT INTO policy(title,discription,policy_type,cdate,ctime)VALUES('" + ptitle + "','" + pbody
				+ "','" + ptype + "','" + cdate + "','" + ctime + "')";
		try {
			st.executeUpdate(query);

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	void deletePolicy(String pid) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "DELETE FROM  users_policy WHERE  policy_id='" + pid + "'";
		String query2 = "DELETE FROM  policy WHERE  policy_id='" + pid + "'";

		//
		try {
			st.executeUpdate(query);
			st.executeUpdate(query2);
			//

		} catch (SQLException ex) {

			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	List viewpolicies() {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy_id,title,policy_type,discription,policy_id,policy_id FROM policy ";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));
				policyList.add(rs.getString(3));
				policyList.add(rs.getString(4));
				policyList.add(rs.getString(5));
				policyList.add(rs.getString(6));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	List vieweditpolicie(int pid) {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy_id,title,discription FROM policy WHERE policy_id='" + pid + "'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));
				policyList.add(rs.getString(3));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	void updatePolicy(String pid, String ptitle, String pbody, String ptype, String cdate, String ctime) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "UPDATE policy SET title='" + ptitle + "',discription='" + pbody + "',policy_type='" + ptype
				+ "',cdate='" + cdate + "',ctime='" + ctime + "' WHERE  policy_id='" + pid + "'";

		//
		try {
			st.executeUpdate(query);

			//

		} catch (SQLException ex) {

			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	List viewuserpolicyDetails(String uid) {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy.policy_id,title FROM policy INNER JOIN users_policy ON policy.policy_id=users_policy.policy_id WHERE user_id='"
				+ uid + "'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	List viewpropolicies() {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy_id,title FROM policy WHERE policy_type='property'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	List viewlifepolicies() {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy_id,title FROM policy WHERE policy_type='life'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	List viewmotopolicies() {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy_id,title FROM policy WHERE policy_type='motor'";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	void adduserlifePolicy(String uid, String pid, String cdate, String ctime) {
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "INSERT INTO users_policy(user_id,policy_id,cdate,ctime)VALUES('" + uid + "'," + pid + ",'"
				+ cdate + "','" + ctime + "')";
		try {
			st.executeUpdate(query);

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	List searchPolicy(int pid) {
		List policyList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = "SELECT policy_id,title,policy_type,discription,policy_id,policy_id FROM policy WHERE policy_id='"
				+ pid + "' ";
		try {

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				policyList.add(rs.getString(1));
				policyList.add(rs.getString(2));
				policyList.add(rs.getString(3));
				policyList.add(rs.getString(4));
				policyList.add(rs.getString(5));
				policyList.add(rs.getString(6));

			}

		} catch (SQLException ex) {
			Logger.getLogger(policy.class.getName()).log(Level.SEVERE, null, ex);
		}

		return policyList;
	}

	List totalPolicy() {
		List userList = new ArrayList();
		try {
			connectTodb();
		} catch (SQLException ex) {
			Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query = " SELECT COUNT(policy_id) FROM policy";
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
