package relationaldbs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author panblo
 * 4 feb 2026
 */
public class DBConnectionTest {

	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";
// "jdbc:postgresql://192.168.1.170.5432/sample?ssl=true";
	private static String username = "postgres";
	private static String password = "Admin";

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
			System.out.println("the address of the connection object is" + conn);

			createDatabase(conn);
			String dropTableSQL = "drop table if exists users";
			PreparedStatement ps = conn.prepareStatement(dropTableSQL);
			ps.executeUpdate();
			ps.close();
// table creation sql
			String createTableSQL = "create table if not exists users(" + "id integer not null,"
					+ "usenname VARCHAR(255), " + "psw VARCHAR(255)," + "isVIP boolean," + "balance numeric,"
					+ "PRIMARY KEY (id)" + ")";
			PreparedStatement ps1 = conn.prepareStatement(createTableSQL);
			ps1.executeUpdate();
			ps1.close();
// insert sql
			String insertSQL = "insert into users(id,usenname,psw, isVIP, balance) values ('19','Pablo',1243,true,224.5),('20','Jorge','121',false,234.9)";

			PreparedStatement ps11 = conn.prepareStatement(insertSQL);
			System.out.println(ps11.executeUpdate());
			ps11.close();
// delete sql

			selectByName(conn, "Manolo");

			deleteByName(conn, "Sandra");

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void selectByName(Connection conn, String name) throws SQLException {
// TODO Auto-generated method stub
		String selectSQL = "select * from users where usenname =" + name;
		PreparedStatement ps3 = conn.prepareStatement(selectSQL);
		System.out.println();
		ResultSet rs = ps3.executeQuery();

	}

	private static void deleteByName(Connection conn, String name) throws SQLException {
// TODO Auto-generated method stub
		String deleteSQL = "DELETE FROM users WHERE usenname = " + name;
// select psw, isVIP from users where username = 'Muñecos' ;
		PreparedStatement ps2 = conn.prepareStatement(deleteSQL);
		System.out.println(ps2.executeUpdate());
		ps2.close();
	}

	private static void createDatabase(Connection conn) {
// TODO Auto-generated method stub
		try {
			String dbCreationSQL = "CREATE DATABASE  ";
			PreparedStatement ps = conn.prepareStatement(dbCreationSQL);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
// TODO: handle exception
		}
	}
}
