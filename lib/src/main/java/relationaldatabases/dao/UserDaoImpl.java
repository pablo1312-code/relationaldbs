package relationaldatabases.dao;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.util.List;



import relationaldbs.model.*;



/**

 * 

 * @author alex

 * 10 abr 2026

 */

public class UserDaoImpl implements UserDao{

	

	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";



    // "jdbc:postgresql://192.168.1.170.5432/sample?ssl=true";



    private static String username = "postgres";



    private static String password = "Admin";



	@Override

	public boolean insert(User user) {

		String insertSQL = "insert into users(name, password, isVIP, balance)" + "values(?, ?, ?, ?)";

		Connection conn = DriverManager.getConnection(postgresqlURL, username, password);

		PreparedStatement ps = conn.prepareStatement(insertSQL);



		return false;

	}



	@Override

	public boolean delete(long id) {

		// TODO Auto-generated method stub

		return false;

	}



	@Override

	public void update(User user) {

		// TODO Auto-generated method stub

		

	}



	@Override

	public User find(long id) {

		// TODO Auto-generated method stub

		return null;

	}



	@Override

	public User findByEmail(String emal) {

		// TODO Auto-generated method stub

		return null;

	}



	@Override

	public List<User> findAll() {

		// TODO Auto-generated method stub

		return null;

	}

	



}