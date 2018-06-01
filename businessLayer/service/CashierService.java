package businessLayer.service;

import businessLayer.model.Show;
import businessLayer.model.User;
import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.UserDto;
import dataAccessLayer.repository.IUserRepository;
import dataAccessLayer.repository.UserRepSQL;

public class CashierService implements ICashierService {
	
private final IUserRepository repository;
private ShowService showserv;
	
	public CashierService()
	{
		this.repository = new UserRepSQL(new DBConnection());
		showserv = new ShowService();
	}

	
	
	
	public void dbMap(UserDto dbuser, User user, boolean way)
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
			
		}
		
	}

}
