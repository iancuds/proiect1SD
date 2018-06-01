package dataAccessLayer.repository;

import java.sql.SQLException;
import java.util.List;

import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.TicketDto;

public interface ITicketRepository {

	

    List<TicketDto> findAll();
    
   
    
    public List<TicketDto> findAllForShow(int id);

    TicketDto findById(int id) throws SQLException;

    public TicketDto findByShowId(int id) throws SQLException;
    
    boolean create(TicketDto ticket) ;

    void update(TicketDto ticket, int id);
    
    void delete(TicketDto ticket);
    
    public String printAll(List<TicketDto> l);
    
	
}


