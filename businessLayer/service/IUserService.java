package businessLayer.service;

import java.util.List;

import businessLayer.model.User;
import dataAccessLayer.dbModel.UserDto;

public interface IUserService {

	
	public void dbMap(UserDto dbuser, User user, boolean way);
	
	public List<User> findAll();
	
	public User logIn(User user, String username, String password);
	
	public String encryptPassword(String password);
	
	public void exportToCSV();
}
