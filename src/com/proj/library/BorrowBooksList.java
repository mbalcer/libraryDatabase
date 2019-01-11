package com.proj.library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BorrowBooksList {
	
	public ArrayList<BorrowBooks> select(String month) {
		ArrayList<BorrowBooks> data = new ArrayList<>();
		
		Connection connect = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select dataczas_wypozyczenia, count(*) as ile from wypozyczenie\r\n" + 
					"where dataczas_wypozyczenia like '"+month+"%'\r\n" + 
					"group by dataczas_wypozyczenia;";
			connect = SQLConnection.DbConnector();
			preparedStmt = connect.prepareStatement(query);

			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				Date dateBorrow = rs.getDate("dataczas_wypozyczenia");
				Integer count = rs.getInt("ile");
				
				BorrowBooks row = new BorrowBooks(dateBorrow, count);
				data.add(row);
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				preparedStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return data;
	}
}
