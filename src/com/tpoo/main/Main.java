package com.tpoo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/clase_20170717?user=root");

//			PreparedStatement stmt01 = conn.prepareStatement("INSERT INTO USUARIO(ID, NOMBRE) VALUES(?, ?);");		
//			
//			stmt01.setInt(1, 8);
//			stmt01.setString(2, "INSERT 4");
//			stmt01.execute();
//			
//			stmt01.setInt(1, 9);
//			stmt01.setString(2, "INSERT 5");
//			stmt01.execute();
//			
//			PreparedStatement stmt02 = conn.prepareStatement("UPDATE USUARIO SET NOMBRE='UPDATE' WHERE ID=?");
//			stmt02.setInt(1, 4);
//			stmt02.execute();
			
			Statement stmt03 = conn.createStatement();
			ResultSet rs = stmt03.executeQuery("SELECT ID, NOMBRE FROM USUARIO;");
			
			if(rs != null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " - " + rs.getString(2));
				}
			}
			
			conn.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
