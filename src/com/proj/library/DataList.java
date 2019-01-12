package com.proj.library;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataList {
	private Connection connect = null;
	private PreparedStatement preparedStmt = null;
	
	private ResultSet connectDatabase(String query) {
		ResultSet rs = null;
		
		try {
			connect = SQLConnection.DbConnector();
			preparedStmt = connect.prepareStatement(query);

			rs = preparedStmt.executeQuery();
		} catch(SQLException e) {
			System.out.println(e);
		} 
		return rs;
	}
	
	private void closeConnect(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<BranchCity> selectBranchCity(String city) {
		ArrayList<BranchCity> data = new ArrayList<>();
		String query = "select * from filia\r\n" + 
				"inner join pracownik on pracownik.idfilii = filia.idfilii\r\n" + 
				"where filia.miasto = '"+city+"'";
		
		ResultSet rs = connectDatabase(query);
		try {
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
			closeConnect(rs);
		}
		
		return data;
	}
	
	public ArrayList<ReaderBooks> selectReaderBooks(String firstName, String lastName) {
		ArrayList<ReaderBooks> data = new ArrayList<>();
		String query = "select imie, nazwisko, miasto, ulica, nrdomu, nrmieszkania, tytul, DATEDIFF(dataczas_oddania, dataczas_wypozyczenia) as czas from czytelnik\r\n" + 
				"left join wypozyczenie on wypozyczenie.idczytelnika = czytelnik.idczytelnika\r\n" + 
				"left join egzemplarz on egzemplarz.kodegzemplarza = wypozyczenie.kodegzemplarza\r\n" + 
				"left join ksiazka on egzemplarz.isbn = ksiazka.isbn\r\n" + 
				"where imie = '"+firstName+"' AND nazwisko = '"+lastName+"'";
		
		ResultSet rs = connectDatabase(query);
		try {
			while(rs.next()) {
				String firstNameFromQuery = rs.getString("imie");
				String lastNameFromQuery = rs.getString("nazwisko");
				String city = rs.getString("miasto");
				String street = rs.getString("ulica");
				Integer nrHouse = rs.getInt("nrdomu");
				Integer nrFlat = rs.getInt("nrmieszkania");
				String title = rs.getString("tytul");
				Long time = rs.getLong("czas");
				
				ReaderBooks row = new ReaderBooks(firstNameFromQuery, lastNameFromQuery, city, street, nrHouse, nrFlat, title, time);
				data.add(row);
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			closeConnect(rs);
		}
		return data;
	}
	
	public ArrayList<BorrowBooks> selectBorrowBooks(String month) {
		ArrayList<BorrowBooks> data = new ArrayList<>();
		String query = "select dataczas_wypozyczenia, count(*) as ile from wypozyczenie\r\n" + 
				"where dataczas_wypozyczenia like '"+month+"%'\r\n" + 
				"group by dataczas_wypozyczenia;";
	
		ResultSet rs = connectDatabase(query);
		try {
			while(rs.next()) {
				Date dateBorrow = rs.getDate("dataczas_wypozyczenia");
				Integer count = rs.getInt("ile");
				
				BorrowBooks row = new BorrowBooks(dateBorrow, count);
				data.add(row);
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			closeConnect(rs);
		}
		
		return data;
	}
}
