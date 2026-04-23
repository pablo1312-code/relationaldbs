package relationaldatabases.dao;

import java.security.Identity;

import java.util.List;

import relationaldbs.model.*;

/**
 * 
 * the interface that defines the functionalities to interact
 * 
 * with the database
 * 
 * @author pablo
 * 
 *         10 abr 2026
 * 
 */

public interface UserDao {

	/**
	 * 
	 * insert an user object to database
	 * 
	 * @param user
	 * 
	 * @return return true if inserted successfully, otherwise false
	 * 
	 */

	public boolean insert(User user);

	/**
	 * 
	 * delete an user by id
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 */

	public boolean delete(long id);

	public void update(User user);

	/**
	 * 
	 * find an user by his id
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 */

	public User find(long id);

	/**
	 * 
	 * find an user by his id
	 * 
	 * @param emal
	 * 
	 * @return
	 * 
	 */

	public User findByEmail(String emal);

	/**
	 * 
	 * retrieve all users
	 * 
	 * @return a list or users
	 * 
	 */

	public List<User> findAll();

}