package relationaldbs.test;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

public class DBConnectionTest {

// The direction of the database that we are going to connect

	private static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres?";

	private static String username = "postgres";

	private static String password = "admin";

	public static void main(String[] args) {

		try {

			// Obtain a object class "Connection" Which represents a connection with a

			// specific database

			Connection conn = DriverManager.getConnection(postgresqlURL, username, password);

			System.out.println("the address of the connection object is " + conn);

			// Create a new database

			// The following SQL statement is used to send the SQL statement to the database

			createDatabase(conn);

			try {

				// table creation sl

				String createTableSOL = "create table if not exists users(" + "id integer not null,"

						+ "usenname VARCHAR(255), " + "psw VARCHAR(255)," + "isVIP TINYINT(1)," + "balance FLOAT,"

						+ "PRIMARY KEY (id)" + ")";

				// insert sal

				String insertsol = "insert into users values (10, 'Manolo',"

						+ " 12343', 1, 234.3), (20, 'Alejandro', '123', 1, 234.3)";

				// delete sql

				String deleteSQL = "DELETE FROM users WHERE username = 'Alejandro'";

				// select psw, isVIP from users where username = 'posgres' ;

				String selectSQL = "select * from users where username = 'Manolo'";

			} catch (SQLException e) {

				e.printStackTrace();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	private static void createDatabase(Connection conn) {

		try {

			String dbCreationSQL = "CREATE DATABASE happylearning";

			// This one is for postgress sql

			// "CREATE DATABASE happylearning";

			PreparedStatement ps = conn.prepareStatement(dbCreationSQL);

			// ps.executeupdate() is used to execute SQL statements that change the database

			// such as CREATE, INSERT, UPDATE, DELETE statements

			ps.executeUpdate();

		} catch (Exception e) {

			// TODO: handle exception

		}

	}

}
