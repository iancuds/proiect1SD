package dataAccessLayer.repository;
import dataAccessLayer.dbModel.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//com.mysql.jdbc.Statement;

import dataAccessLayer.DBConnection;

public class UserRepSQL implements IUserRepository {

	private final DBConnection dbconnection;
	
	public UserRepSQL (DBConnection connection)
	{
		this.dbconnection = connection;
	}
	@Override
	public List<UserDto> findAll() {
		
		Connection connection = dbconnection.getConnection();
		
		List<UserDto> users = new ArrayList<UserDto>();
		try{
			
			Statement st = connection.createStatement();
			String sql = "select * from nationalthdb.`user`" ;
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			users.add(getFromRs(rs));
			while(rs.next())
			{
				users.add(getFromRs(rs));
			}
		}
		catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
		
	
	}
    @Override
	public UserDto findById(int id) throws SQLException{
    	
    	
    	
		Connection connection = dbconnection.getConnection();
		String str= "SELECT * FROM `user` WHERE iduser ='" + id + "'";;
		
		Statement smt = connection.createStatement();
		ResultSet rs = smt.executeQuery(str);
		rs.next();
		UserDto user = null;
		user = getFromRs(rs);

	return user;
	
    }

	@Override
	public boolean create(UserDto user, int admin) {
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			String str = "insert into `nationalthdb`.`user` (admin, firstname, lastname, address, phone, dob, passwd, username) values ('0', '"+ user.getFirstname()+ "', '" + user.getLastname()+"', '"+ user.getAddress()+"', '" +user.getPhone()+"', '" +user.getDob()+"', '"+user.getPasswd()+"', '"+ user.getUsername()+"')";
		    
			smt = conn.createStatement();
			smt.execute(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	@Override
	public void update(UserDto user, int id) {
		user.setIduser(id);
		int admin;
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		if(user.isAdmin())  admin=1;
		else admin=0;
		
		String str = "UPDATE `user` SET admin = '" + admin +"', "+"firstname = '"+ user.getFirstname()+ "', lastname = '"+user.getLastname()+"', address = '" + user.getAddress() + "', phone = '" + user.getPhone()+"', dob = '" +user.getDob()+ "', passwd = '" + user.getPasswd() +"', username= '"+user.getUsername()+  "' WHERE iduser = '" +user.getIduser()+"'";
		
		try {
			smt.executeUpdate(str);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
	}

	

/*	private <T extends Object>T getFromRs(ResultSet rs)
	{
		UserDto user = (UserDto) new UserDto();
	        
	        return (T)user;
		
	}
	
	*/
	private UserDto getFromRs(ResultSet rs)
	{
		UserDto user =  new UserDto();
		 try {
			user.setIduser(rs.getInt("iduser"));
			user.setAddress(rs.getString("address"));
			user.setUsername(rs.getString("username"));
			if(rs.getInt("admin") == 1)
			user.setAdmin(true);
			else user.setAdmin(false);
			
			user.setDob(rs.getString("dob"));
			
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setPhone(rs.getString("phone"));
			user.setPasswd(rs.getString("passwd"));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	        
	        return user;
		
	}
	@Override
	public void delete(UserDto user) {
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		
		
		String str="DELETE FROM `user` WHERE iduser = '" +user.getIduser()+"'";
		try {
			smt.execute(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	@Override
	public UserDto getByUsername(String username) {
		// TODO Auto-generated method stub
		
		UserDto user = null;
		Connection connection = dbconnection.getConnection();
		String str= "SELECT * FROM `user` WHERE username ='" + username + "'";
		
		Statement smt;
		try {
			smt = connection.createStatement();
		
		ResultSet rs = smt.executeQuery(str);
		rs.next();
		
		user = getFromRs(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return user;
	}
	
	
	
	
	
}
