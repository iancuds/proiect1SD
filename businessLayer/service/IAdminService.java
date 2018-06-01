package businessLayer.service;

import java.sql.SQLException;
import java.util.List;

import businessLayer.model.*;
import dataAccessLayer.dbModel.UserDto;

public interface IAdminService {

	
	List<User> findAll();

    User findById(int id);

    
    void update(User user, int id);
    
    void delete(User user);

	boolean create(User user, int admin);
	
	User findByUsername(String username) throws SQLException;

	void dbMap(UserDto dbuser, Admin user, boolean b);

	
}
