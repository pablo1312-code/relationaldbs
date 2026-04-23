package relationaldbs.test;

import relationaldatabases.dao.UserDao;
import relationaldatabases.dao.UserDaoImpl;
import relationaldbs.model.User;

public class UserDaoTest {
	public static void main(String[] args) {
		
		//insert test
		UserDao userDao = new UserDaoImpl();
		userDao.insert(new User(0, null, null, 1, null, 0, null, null));
	}

}

