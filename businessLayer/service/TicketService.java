package businessLayer.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLayer.model.Show;
import businessLayer.model.Ticket;
import businessLayer.model.Ticket;
import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.TicketDto;
import dataAccessLayer.repository.ITicketRepository;
import dataAccessLayer.repository.ITicketRepository;
import dataAccessLayer.repository.TicketRepSQL;
import dataAccessLayer.repository.TicketRepSQL;

public class TicketService implements ITicketService {

	private final ITicketRepository repository;
	
public TicketService(){
		
		this.repository = new TicketRepSQL(new DBConnection());
	}

@Override
public List<Ticket> findAll() {
	List<TicketDto> list = repository.findAll();
	List<Ticket> result = new ArrayList<Ticket>();
        for (TicketDto t:list) {
           
        	Ticket ticket = new Ticket();
        	dbMap(t,ticket,false);
            result.add(ticket);
        }
        return result;
}

@Override
public Ticket findById(int id) {
	Ticket ticket =  new Ticket();
	
	
	try {
		TicketDto dbticket = repository.findById(id);
        dbMap(dbticket,ticket,false);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ticket;
}

public Ticket findByShowId(int id) {
	Ticket ticket =  new Ticket();
	
	
	try {
		TicketDto dbticket = repository.findByShowId(id);
        dbMap(dbticket,ticket,false);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ticket;
}

@Override
public boolean create(Ticket ticket) {
	TicketDto dbticket = new TicketDto();
	dbMap(dbticket,ticket,true);
	repository.create(dbticket);
	return true;
}

@Override
public void update(Ticket ticket, int id) {
	TicketDto dbticket = new TicketDto();
	dbMap(dbticket,ticket,true);
	repository.update(dbticket, ticket.getIdticket());
}

@Override
public void delete(Ticket ticket) {
	TicketDto dbticket = new TicketDto();
	dbMap(dbticket,ticket,true);
	repository.delete(dbticket);
	
}




void dbMap(TicketDto dbticket, Ticket ticket, boolean way)
{
	/*
    private int idticket;
	private float price;
	private int row;
	private int col;
	private int idshow;*/
	if(way == false) {
		ticket.setIdticket(dbticket.getIdticket());
		ticket.setPrice(dbticket.getPrice());
    	
		ticket.setRow(dbticket.getRow());
    	
		ticket.setCol(dbticket.getCol());
		ticket.setIdshow(dbticket.getIdshow());
		
		
	}
	else {
		
		dbticket.setIdticket(ticket.getIdticket());
		dbticket.setPrice(ticket.getPrice());
    	
		dbticket.setRow(ticket.getRow());
    	
		dbticket.setCol(ticket.getCol());
		dbticket.setIdshow(ticket.getIdshow());
		
	}
	
}

public List<Ticket> findAllForShow(int id)
{
	
	List<TicketDto> list = repository.findAllForShow(id);
	List<Ticket> result = new ArrayList<Ticket>();
        for (TicketDto t:list) {
           
        	Ticket ticket = new Ticket();
        	dbMap(t,ticket,false);
            result.add(ticket);
        }
        return result;
	
	}

public String allToString()
{
	List<TicketDto> dtotickets = repository.findAll();
	String result = repository.printAll(dtotickets);
	return result;

}

}
