package com.account.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.account.vo.AccountVOO;

public class LoginDB {

	private static ResultSet rs;

	public LoginDB() {
		super();
	}

	public static AccountVOO getLoginInfo(String userName, String passwd) throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		AccountVOO accVO = null;

		try {

			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM test.login WHERE username = ? AND password = ?");
			pStmt.setString(1, userName);
			pStmt.setString(2, passwd);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				accVO = new AccountVOO(rs.getString(1), rs.getString(2));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
			pStmt.close();
			dbConn.close();
		}
		return accVO;
	}

	// Add Login Details to Databse
	public static void addLoginInfo(String userName, String passwd) throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		try {

			System.out.println("Inside Login DB : " + userName + "  " + passwd);
			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement("INSERT INTO login (username, password) VALUES (?, ?)");
			pStmt.setString(1, userName);
			pStmt.setString(2, passwd);
			rowsInserted = pStmt.executeUpdate();

			System.out.println("In DB : " + rowsInserted);
			if (rowsInserted != 1) {
				throw new Exception("Error in inserting data in Login Table.");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			pStmt.close();
			dbConn.close();
		}
	}

}
