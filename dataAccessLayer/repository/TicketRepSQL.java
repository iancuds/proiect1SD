package dataAccessLayer.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.TicketDto;
import dataAccessLayer.dbModel.TicketDto;

public class TicketRepSQL implements ITicketRepository{

	
private final DBConnection dbconnection;
	
	public TicketRepSQL (DBConnection connection)
	{
		this.dbconnection = connection;
	}

	
	@Override
	public List<TicketDto> findAll() {
		
       Connection connection = dbconnection.getConnection();
		
		List<TicketDto> tickets = new ArrayList<TicketDto>();
		try{
			
			Statement st = connection.createStatement();
			String sql = "select * from `nationalthdb`.`ticket`" ;
			ResultSet rs = st.executeQuery(sql);
		//	rs.next();
		//	tickets.add(getFromRs(rs));
			while(rs.next())
			{
				tickets.add(getFromRs(rs));
				//System.out.println(getFromRs(rs).toString());
			}
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
		return tickets;
	}
	
	
	public List<TicketDto> findAllForShow(int id) {
		
	       Connection connection = dbconnection.getConnection();
			
			List<TicketDto> tickets = new ArrayList<TicketDto>();
			try{
				
				Statement st = connection.createStatement();
				String sql = "select * from `nationalthdb`.`ticket` where idshow = '" + id +"'" ;
				ResultSet rs = st.executeQuery(sql);
			//	rs.next();
			//	tickets.add(getFromRs(rs));
				while(rs.next())
				{
					tickets.add(getFromRs(rs));
					//System.out.println(getFromRs(rs).toString());
				}
			}
			catch (SQLException e) {
	            e.printStackTrace();
	        }
			return tickets;
		}

	@Override
	public TicketDto findById(int id) throws SQLException {
		TicketDto ticket = null;
		Connection connection = dbconnection.getConnection();
		String str= "SELECT * FROM `ticket` WHERE idticket = '" + id + "'";
		
		Statement smt;
		try {
			smt = connection.createStatement();
		
		ResultSet rs = smt.executeQuery(str);
		rs.next();
		
		ticket = getFromRs(rs);

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticket;
	}
	
	public TicketDto findByShowId(int id) throws SQLException {
		TicketDto ticket = null;
		Connection connection = dbconnection.getConnection();
		String str= "SELECT *  FROM (SELECT *  FROM ticket   WHERE idticket IN (SELECT MIN(idticket) FROM ticket GROUP BY idshow)) AS T	WHERE idshow = '"+id+"'";
		
		Statement smt;
		try {
			smt = connection.createStatement();
		
		ResultSet rs = smt.executeQuery(str);
		rs.next();
		
		ticket = getFromRs(rs);

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public boolean create(TicketDto ticket) {
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			String str = "insert into `nationalthdb`.`ticket` (price, row, col, idshow) values ('"+ ticket.getPrice()+ "', '" + ticket.getRow()+"', '"+ ticket.getCol()+"', '" +ticket.getIdshow()+ "')";
		    
			smt = conn.createStatement();
			smt.execute(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	@Override
	public void update(TicketDto ticket, int id) {
		ticket.setIdticket(id);
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		
		
		String str = "UPDATE `ticket` SET price = '" + ticket.getPrice() +"', row = '"+ ticket.getRow()+ "', col = '"+ticket.getCol()+"', idshow ='" + ticket.getIdshow()+  "' WHERE idticket = '" +id+"'";
		
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
	public void delete(TicketDto ticket) {
		Connection conn = dbconnection.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();
		
		
		String str="DELETE FROM `ticket` WHERE idticket = '" +ticket.getIdticket()+"'";
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

	
	private TicketDto getFromRs(ResultSet rs)
	{
		
		
		TicketDto ticket =  new TicketDto();
		 try {
			 
			
			//if((rs.next()) )
			{
			//rs.beforeFirst();
			ticket.setIdticket(rs.getInt("idticket"));
			ticket.setPrice(rs.getFloat("price"));
			ticket.setRow(rs.getInt("row"));
			ticket.setCol(rs.getInt("col"));
			ticket.setIdshow(rs.getInt("idshow"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	        
	        return ticket;
		
	}
	
	public String printAll(List<TicketDto> l)
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


	
	
}
