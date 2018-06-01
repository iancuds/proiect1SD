import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import businessLayer.model.User;
import businessLayer.service.AdminService;
import businessLayer.service.IAdminService;
import businessLayer.service.IUserService;
import businessLayer.service.UserService;
import dataAccessLayer.*;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.TicketDto;
import dataAccessLayer.dbModel.UserDto;
import dataAccessLayer.repository.ShowRepSQL;
import dataAccessLayer.repository.TicketRepSQL;
import dataAccessLayer.repository.UserRepSQL;


public class Test {

	
	public Test()
	{}
	
	public static void main(String[] args) 
	{
		
		DBConnection conn = new DBConnection();
		IUserService us = new UserService();
	    IAdminService as = new AdminService();
		
	
	
	 
	/* UserDto userup = new UserDto();
	 
		
		userup.setFirstname("admin");
		userup.setLastname("admin");
		userup.setAddress("Romania");
		userup.setDob("28061996");
		userup.setPhone("0740000000");
		String password = us.encryptPassword("admin");
		userup.setPasswd(password);
		
		User user = new User();
		us.dbMap(userup, user, false);
		
		as.create(user, 1);
		
		*/
		
		
	   // ur.update(userup,3);
	 
	//	user.setIduser(4);
		//user.setIduser(4);
	//	ur.delete(user);
		
	// System.out.println(user);
	// System.out.println(user1);
	 
	/* 
	 //find all
	 ShowDto show = new ShowDto();
	 ShowRepSQL sr = new ShowRepSQL(conn); 
	 List<ShowDto> shows = new ArrayList<ShowDto>();
	 
	 TicketDto tk=new TicketDto();
	 TicketRepSQL tr = new TicketRepSQL(conn);
	 List<TicketDto> tickets = new ArrayList<TicketDto>();
	 
	 //shows=sr.findAll();
	 
	// String prall =sr.printAll(shows);
	// System.out.println(prall );
	 
	 tickets=tr.findAll();
	 String prall=tr.printAll(tickets);
	// System.out.println(prall);
	 
	 //find by id
	// show = sr.findById(2);
	// System.out.println(show.toString());
	 try {
		tk = tr.findById(3);
	//	System.out.println(tk.toString());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //create
	// show.setDate("01022018");
	// sr.create(show);
	 TicketDto tk1 = new TicketDto();
	 TicketDto tkbyshow = new TicketDto();
	 
	 try {
		tkbyshow=tr.findByShowId(2);
		System.out.println(tkbyshow);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 try {
		tk1=tr.findById(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 tk1.setCol(7);
	 tk1.setIdshow(3);
	 //tr.create(tk1);
	 
	 //update
	// show.setDate("05022018");
	 //sr.update(show, 4);
	 
	 //tk.setPrice((float)29.99);
	 //tr.update(tk, 2);
	
	//delete
	 //show.setIdshow(4);
	 //sr.delete(show);
	 
	
	 tr.delete(tk1);
	*/
	}
	
	
}

