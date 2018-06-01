package businessLayer.service;

import java.util.List;

import businessLayer.model.Show;
import businessLayer.model.Ticket;

public interface IShowService {

	List<Show> findAll();

	Show findById(int id);
	
	public Show findByTitle(String name);

    boolean create(Show show);
    
    void update(Show show, int id);
    
    void delete(Show show);
    

    
    public List<String> allToString(List<Show> lst);
}
