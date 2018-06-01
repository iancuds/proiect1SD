package dataAccessLayer.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.ShowDto;



public class ShowRepSQL implements IShowRepository {
	
	
private final DBConnection dbconnection;
	
	public ShowRepSQL (DBConnection connection)
	{
		this.dbconnection = connection;
	}

	@Override
	public List<ShowDto> findAll() {
		
		Connection connection = dbconnection.getConnection();
		
		List<ShowDto> shows = new ArrayList<ShowDto>();
		try{
			
			Statement st = connection.createStatement();
			String sql = "select * from `nationalthdb`.`show`" ;
			ResultSet rs = st.executeQuery(sql);
		//	rs.next();
		//	shows.add(getFromRs(rs));
			while(rs.next())
			{
				shows.add(getFromRs(rs));
				//System.out.println(getFromRs(rs).toString());
			}
		}
		catch (SQLException e) {
            e.printStackTrace();
        }

        return shows;
	}

	@Override
	public ShowDto findById(int id) {
		ShowDto show = null;
		Connection connection = dbconnection.getConnection();
		String str= "SELECT * FROM `show` WHERE idshow = '" + id + "'";
		
		Statement smt;
		try {
			smt = connection.createStatement();
		
		ResultSet rs = smt.executeQuery(str);
		rs.next();
		
		show = getFromRs(rs);

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public boolean create(ShowDto show) {
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			String str = "insert into `nationalthdb`.`show` (title, distribution, date, genre, notickets) values ('"+ show.getTitle()+ "', '" + show.getDistribution()+"', '"+ show.getDate()+"', '" +show.getGenre()+"', '" +show.getNotickets()+ "')";
		    
			smt = conn.createStatement();
			smt.execute(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	@Override
	public void update(ShowDto show, int id) {
		show.setIdshow(id);
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		
		
		String str = "UPDATE `show` SET title = '" + show.getTitle() +"', distribution = '"+ show.getDistribution()+ "', date = '"+show.getDate()+"', genre ='" +show.getGenre() + "', notickets = '" + show.getNotickets() +  "' WHERE idshow = '" +id+"'";
		
		try {
			smt.executeUpdate(str);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
	}

	@Override
	public void delete(ShowDto show) {
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		
		
		String str="DELETE FROM `show` WHERE idshow = '" +show.getIdshow()+"'";
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

	
	
	private ShowDto getFromRs(ResultSet rs)
	{
		
		
		ShowDto show =  new ShowDto();
		 try {
			show.setIdshow(rs.getInt("idshow"));
			show.setTitle(rs.getString("title"));
			show.setDistribution(rs.getString("distribution"));
			show.setDate(rs.getString("date"));
			show.setGenre(rs.getString("genre"));
			show.setNotickets(rs.getInt("notickets"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	        
	        return show;
		
	}
	
	public String printAll(List<ShowDto> l)
	{
		String s="";
		String newLine = System.getProperty("line.separator");

		int i=0;
		while(i<l.size() )
		{
			s=s+l.get(i).toString()+newLine;
			i++;
		}
		return s;
	}

	@Override
	public ShowDto findByTitle(String name) {
		ShowDto show = null;
		
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		
		
		String str="SELECT * FROM `show` WHERE title = '" +name+"'";
		try {
			ResultSet rs = smt.executeQuery(str);
			rs.next();
			
			show = getFromRs(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return show;
	}
	
}
