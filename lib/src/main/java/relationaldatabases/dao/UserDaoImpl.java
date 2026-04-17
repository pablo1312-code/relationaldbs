package relationaldatabases.dao;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



import relationaldbs.model.*;




/**

 * 

 * @author pablo

 * 10 abr 2026

 */

public class UserDaoImpl implements UserDao{

	

	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";



    // "jdbc:postgresql://192.168.1.170.5432/sample?ssl=true";



    private static String username = "postgres";



    private static String password = "admin" ;
    static String dropTableSQL = "drop table if exists users";
    static String createTableSQL = "create table if not exists users(id int auto_incremental,";



	public boolean insert(User user) {

		String insertSQL = "insert into users(name, password, isVIP, balance, age, email, gender, subscription, phonenumber)" + "values(?, ?, ?, ?,?,?,?, ?, ?)";
		
		/**
		 * create an object of connection to establish
		 *  a network connection with the database used in
		 *   our program
		 */
        try (Connection conn =
        		DriverManager.getConnection(postgresqlURL, username, password);
        /**
         * create an object of PreparedStatement which allows 
         * us to prepare, send and execute sqls 
         */
				PreparedStatement ps =
			conn.prepareStatement(insertSQL)) {
        	ps.setString(1, user.getName());
        	ps.setString(2, user.getPassword());
        	ps.setBoolean(3, user.isVIP());
        	ps.setDouble(4, user.getBalance());
        	((PreparedStatement) ps).setInt(5, user.getAge());
        	ps.setString(6, user.getEmail());
        	ps.setString(7, user.getGender());
        	ps.setString(8, user.getSubscription());
        	ps.setInt(9, user.getPhonenumber());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}



	public boolean delete(long id) {
		

		// TODO Auto-generated method stub

		return false;

	}



	public void update(User user) {

		// TODO Auto-generated method stub

		

	}



	public User find(long id) {

		// TODO Auto-generated method stub

		return null;

	}



	public User findByEmail(String emal) {

		// TODO Auto-generated method stub

		return null;

	}



	public List<User> findAll() {

		// TODO Auto-generated method stub

		return null;

	}

	



}