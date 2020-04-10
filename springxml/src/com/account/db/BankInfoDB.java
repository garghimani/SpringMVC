package com.account.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.account.vo.BankInfoVOO;

public class BankInfoDB {

	public BankInfoDB() {
		// TODO Auto-generated constructor stub
	}

	public static BankInfoVOO getBankInfo(String firstName) throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		BankInfoVOO bankVO = null;

		try {

			dbConn = DBConnection.getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM bankdetails WHERE personid = ?");
			pStmt.setString(1, firstName);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				bankVO = new BankInfoVOO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
		return bankVO;
	}
	
	public static void addBankInfo(String bankname, String accountnumber, String ssn, String personId)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = DBConnection.getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO bankdetails(bankname,accountnumber,ssn,personid) VALUES (?, ?, ?, ?)");
		pStmt.setString(1, bankname);
		pStmt.setString(2, accountnumber);
		pStmt.setString(3, ssn);
		pStmt.setString(4, personId);
		
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
	
	public static void updateBankInfo(BankInfoVOO modifybankVOO)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = DBConnection.getConnection();
		pStmt = dbConn.prepareStatement("UPDATE bankdetails SET bankname=?,accountnumber=?,ssn=? where personid = ?");

		pStmt.setString(1, modifybankVOO.getBankName());
		pStmt.setString(2, modifybankVOO.getAccountNumber());
		pStmt.setString(3, modifybankVOO.getSsn());
		pStmt.setString(4, modifybankVOO.getPersonId());
		
   		rowsUpdated = pStmt.executeUpdate();

   		System.out.println(rowsUpdated);
		if (rowsUpdated < 1) {
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

	public static void deleteBankInfo(String firstname) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = DBConnection.getConnection();
		pStmt = dbConn.prepareStatement("DELETE FROM bankdetails WHERE personid = ?");
		pStmt.setString(1, firstname);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted < 1) {
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
		
			System.out.println("Inside Bank DB");
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
