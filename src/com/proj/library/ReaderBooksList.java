package com.proj.library;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReaderBooksList {
	public ArrayList<ReaderBooks> select(String firstName, String lastName) {
		ArrayList<ReaderBooks> data = new ArrayList<>();
		
		Connection connect = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select imie, nazwisko, miasto, ulica, nrdomu, nrmieszkania, tytul, DATEDIFF(dataczas_oddania, dataczas_wypozyczenia) as czas from czytelnik\r\n" + 
					"left join wypozyczenie on wypozyczenie.idczytelnika = czytelnik.idczytelnika\r\n" + 
					"left join egzemplarz on egzemplarz.kodegzemplarza = wypozyczenie.kodegzemplarza\r\n" + 
					"left join ksiazka on egzemplarz.isbn = ksiazka.isbn\r\n" + 
					"where imie = '"+firstName+"' AND nazwisko = '"+lastName+"'";
			connect = SQLConnection.DbConnector();
			preparedStmt = connect.prepareStatement(query);

			rs = preparedStmt.executeQuery();
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
