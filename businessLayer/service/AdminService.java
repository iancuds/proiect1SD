package businessLayer.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLayer.model.Admin;
import businessLayer.model.Cashier;
import businessLayer.model.User;
import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.UserDto;
import dataAccessLayer.repository.IUserRepository;
import dataAccessLayer.repository.UserRepSQL;

public class AdminService implements IAdminService {

	
	private final IUserRepository repository;
	

	
	public AdminService()
	{
		this.repository = new UserRepSQL(new DBConnection());
	}

	
	

	@Override
	public User findById(int id) {
		Admin user =  new Admin();
	
    	
		try {
			UserDto dbuser = repository.findById(id);
            dbMap(dbuser,user,false);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean create(User user, int admin) {
		
		UserDto dbuser = new UserDto();
		if(admin == 1) user.setAdmin(true);
		else user.setAdmin(false);
		dbMap(dbuser,(Admin)user,true);
		
		dbuser.setAdmin(true);
		repository.create(dbuser, admin);
		return true;
	}

	@Override
	public void update(User user, int id) {
		
		UserDto dbuser = new UserDto();
		dbMap(dbuser,(Admin)user,true);
		repository.update(dbuser, user.getIduser());
	}

	@Override
	public void delete(User user) {
		UserDto dbuser = new UserDto();
		dbMap(dbuser,(Admin)user,true);
		repository.delete(dbuser);
		
	}
	
	public void dbMap(UserDto dbuser, Admin user, boolean way)
	{
		if(way == false) {
			user.setIduser(dbuser.getIduser());
			user.setAddress(dbuser.getAddress());
        	user.setAdmin(dbuser.isAdmin());
        	user.setDob(dbuser.getDob());
        	user.setFirstname(dbuser.getFirstname());
        	user.setLastname(dbuser.getLastname());
        	user.setPhone(dbuser.getPhone());
        	user.setPasswd(dbuser.getPasswd());
        	user.setUsername(dbuser.getUsername());
		}
		else {
			
			dbuser.setIduser(user.getIduser());
			dbuser.setAddress(user.getAddress());
        	dbuser.setAdmin(user.isAdmin());
        	dbuser.setDob(user.getDob());
        	dbuser.setFirstname(user.getFirstname());
        	dbuser.setLastname(user.getLastname());
        	dbuser.setPhone(user.getPhone());
        	dbuser.setPasswd(user.getPasswd());
        	dbuser.setUsername(user.getUsername());
			
		}
		
	}

	@Override
	public User findByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
      User user =  new User();
	
    	
		UserDto dbuser = repository.getByUsername(username);
		dbMap(dbuser,(Admin)user,false);
		
		return user;
	}




	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
