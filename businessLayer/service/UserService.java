package businessLayer.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import businessLayer.model.Admin;
import businessLayer.model.Cashier;
import businessLayer.model.Ticket;
import businessLayer.model.User;
import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.UserDto;
import dataAccessLayer.repository.ITicketRepository;
import dataAccessLayer.repository.IUserRepository;
import dataAccessLayer.repository.UserRepSQL;


public class UserService implements IUserService {

	private final IUserRepository repository;
	private final IAdminService adminService;
	private final ICashierService cashierService;
	private final ITicketService  ts;
	private IFileFactory ff = new FileFactory();
	
	public  UserService()
	{
		repository=new UserRepSQL(new DBConnection());
		adminService= new AdminService();
		cashierService= new CashierService();
		ts = new TicketService();
	}
	
	public List<User> findAll() {
		List<UserDto> list = repository.findAll();
		List<User> result = new ArrayList<User>();
	        for (UserDto t:list) {
	           
	        	User user = new User();
	        	dbMap(t,user,false);
	            result.add(user);
	        }
	        return result;
	}
	
	public User logIn(User user, String username, String password)
	{	UserDto dbuser = repository.getByUsername(username);
	    System.out.println(dbuser);
		if(dbuser != null){
		System.out.println(dbuser);
		String encpass = encryptPassword(password);
		if(dbuser.getPasswd().equals(encpass))
                {System.out.println("is equal");
                	if(dbuser.isAdmin())
                	{System.out.println("is admin");
                		user=new Admin();
                		adminService.dbMap(dbuser,(Admin)user, false);
                		System.out.println(user);
                	}
                	else {
                		
                		user=new Cashier();
                		cashierService.dbMap(dbuser, user, false);
                		//System.out.println(user);
                	}
                	return user;
                }
		} else {System.out.println("user is null");}
		return user;
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
	public String encryptPassword(String password) {
		String encpass = password;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			
			   md.update(password.getBytes());
	            //Get the hash's bytes
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            encpass = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encpass;
	}

	@Override
	public void exportToCSV() {
		
		String s = ts.allToString();
		ff.makeFile();
		
		
	}
	
}
