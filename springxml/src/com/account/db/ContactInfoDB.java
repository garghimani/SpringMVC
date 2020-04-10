package com.account.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.account.vo.ContactInfoVOO;

public class ContactInfoDB {

	public ContactInfoDB() {
		// TODO Auto-generated constructor stub
	}

	public static ContactInfoVOO getContactInfo(String firstName) throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ContactInfoVOO contactVO = null;

		try {

			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM contactdetails WHERE personid = ?");
			pStmt.setString(1, firstName);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				contactVO = new ContactInfoVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
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
		return contactVO;
	}

	public static void addContactInfo(String address, String city, String state, String country, String phone,
			String personId) throws Exception {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		System.out.println("Inside Conatct DB : " + personId);
		try {
			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement(
					"INSERT INTO contactdetails(address,city,state,country,phone,personid) VALUES (?, ?, ?, ?, ?, ?)");
			pStmt.setString(1, address);
			pStmt.setString(2, city);
			pStmt.setString(3, state);
			pStmt.setString(4, country);
			pStmt.setString(5, phone);
			pStmt.setString(6, personId);

			rowsInserted = pStmt.executeUpdate();

			System.out.println(rowsInserted);

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getErrorCode());
			System.out.println(sqle.getMessage());
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			pStmt.close();
			dbConn.close();
		}
		return;
	}

	public static void updateContactInfo(ContactInfoVOO contactVO) throws Exception {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsUpdated = 0;

		try {
			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement(
					"UPDATE contactdetails SET address=?,city=?,state=?,country=?,phone=? where personid = ?");

			pStmt.setString(1, contactVO.getAddress());
			pStmt.setString(2, contactVO.getCity());
			pStmt.setString(3, contactVO.getState());
			pStmt.setString(4, contactVO.getCountry());
			pStmt.setString(5, contactVO.getPhone());
			pStmt.setString(6, contactVO.getPersonID());

			rowsUpdated = pStmt.executeUpdate();

			System.out.println(rowsUpdated);
			if (rowsUpdated < 1) {
				throw new Exception("Error in updating the row");
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
		return;
	}

	public static void deleteContactInfo(String firstname) throws Exception {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsDeleted = 0;

		try {
			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement("DELETE FROM contactdetails WHERE personid = ?");
			pStmt.setString(1, firstname);

			rowsDeleted = pStmt.executeUpdate();

			if (rowsDeleted < 1) {
				throw new Exception("Error in delete the row");

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
		return;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Inside Contact Info DB");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
