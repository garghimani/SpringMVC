package com.account.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.account.vo.PersonalInfoVOO;

public class PersonalInfoDB {

	public PersonalInfoDB() {
		super();
	}

	public static PersonalInfoVOO getPersonalInfo(String firstName) throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		PersonalInfoVOO personalVO = null;

		try {

			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM personaldetails WHERE firstname = ?");
			pStmt.setString(1, firstName);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				personalVO = new PersonalInfoVOO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
		return personalVO;
	}
	
	public static void addPersonalInfo(String firstname, String middlename, String lastname, String gender)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = DBConnection.getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO personaldetails(firstname,middlename,lastname,gender) VALUES (?, ?, ?,?)");
		pStmt.setString(1, firstname);
		pStmt.setString(2, middlename);
		pStmt.setString(3, lastname);
		pStmt.setString(4, gender);
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}
	     }catch (SQLException sqle) {
		     System.out.println(sqle.getErrorCode());
		     System.out.println(sqle.getMessage());
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}
	
	public static void updatePersonalInfo(PersonalInfoVOO personalVOO)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = DBConnection.getConnection();
		pStmt = dbConn.prepareStatement("UPDATE personaldetails SET lastname=?, middlename = ? where firstname = ?");

		pStmt.setString(1, personalVOO.getLastName());
		pStmt.setString(2, personalVOO.getMiddleName());
		pStmt.setString(3, personalVOO.getFirstName());
		
   		rowsUpdated = pStmt.executeUpdate();

   		System.out.println(rowsUpdated);
		if (rowsUpdated != 1) {
			throw new Exception("Error in updating the row");
  		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static void deletePersonalInfo(String firstname) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = DBConnection.getConnection();
		pStmt = dbConn.prepareStatement("DELETE FROM personaldetails WHERE firstname = ?");
		pStmt.setString(1, firstname);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted != 1) {
			throw new Exception("Error in delete the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static void main(String[] args) {
		try{
		System.out.println("Personal Info DB");
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
