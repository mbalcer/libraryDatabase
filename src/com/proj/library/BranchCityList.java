package com.proj.library;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchCityList {
	public ArrayList<BranchCity> select(String city) {
		ArrayList<BranchCity> data = new ArrayList<>();
		
		Connection connect = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from filia\r\n" + 
					"inner join pracownik on pracownik.idfilii = filia.idfilii\r\n" + 
					"where filia.miasto = '"+city+"'";
			connect = SQLConnection.DbConnector();
			preparedStmt = connect.prepareStatement(query);

			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				String nameBranch = rs.getString("nazwa");
				String cityFromQuery = rs.getString("filia.miasto");
				String street = rs.getString("filia.ulica");
				Integer numberHouse = rs.getInt("numer");
				String firstName = rs.getString("imie");
				String lastName = rs.getString("nazwisko");
				BigDecimal salary = rs.getBigDecimal("wynagrodzenie");
				
				BranchCity row = new BranchCity(nameBranch, cityFromQuery, street, numberHouse, firstName, lastName, salary);
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
