package businessLayer.service;

import java.util.List;

import businessLayer.model.Show;
import businessLayer.model.Ticket;
import businessLayer.model.User;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.TicketDto;

public interface ITicketService {

	
	List<Ticket> findAll();

	Ticket findById(int id);
	
	 public String allToString();
	
	public List<Ticket> findAllForShow(int id);

    boolean create(Ticket ticket);
    
    void update(Ticket ticket, int id);
    
    void delete(Ticket ticket);
}
