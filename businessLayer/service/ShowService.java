package businessLayer.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLayer.model.Show;
import businessLayer.model.Show;
import dataAccessLayer.DBConnection;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.dbModel.TicketDto;
import dataAccessLayer.dbModel.UserDto;
import dataAccessLayer.dbModel.ShowDto;
import dataAccessLayer.repository.IShowRepository;
import dataAccessLayer.repository.ITicketRepository;
import dataAccessLayer.repository.IShowRepository;
import dataAccessLayer.repository.ShowRepSQL;
import dataAccessLayer.repository.TicketRepSQL;

public class ShowService implements IShowService {

	private final IShowRepository repository;
	private DBConnection connection;
	public ShowService(){
		connection=new DBConnection();
		this.repository = new ShowRepSQL(connection);
	}

	@Override
	public List<Show> findAll() {
		List<ShowDto> list = repository.findAll();
		List<Show> result = new ArrayList<Show>();
	        for (ShowDto t:list) {
	           
	        	Show show = new Show();
	        	dbMap(t,show,false);
	            result.add(show);
	        }
	        return result;
	}

	@Override
	public Show findById(int id) {
    Show show =  new Show();
	
    	
		try {
			ShowDto dbshow = repository.findById(id);
            dbMap(dbshow,show,false);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return show;
	}

	@Override
	public boolean create(Show show) {
		ShowDto dbshow = new ShowDto();
		dbMap(dbshow,show,true);
		repository.create(dbshow);
		return true;
	}

	@Override
	public void update(Show show, int id) {
		ShowDto dbshow = new ShowDto();
		dbMap(dbshow,show,true);
		repository.update(dbshow, show.getIdshow());
		
	}

	@Override
	public void delete(Show show) {

		ShowDto dbshow = new ShowDto();
		dbMap(dbshow,show,true);
		repository.update(dbshow, show.getIdshow());
		
	}
	
	
	
	
	void dbMap(ShowDto dbshow, Show show, boolean way)
	{
		/*
    private int idshow;
	private String title;
	private String distribution;
	private String date;
	private String genre;
	private int notickets;*/
		if(way == false) {
			show.setIdshow(dbshow.getIdshow());
			show.setTitle(dbshow.getTitle());
        	
			show.setDistribution(dbshow.getDistribution());
        	
			show.setDate(dbshow.getDate());
			show.setGenre(dbshow.getGenre());
			show.setNotickets(dbshow.getNotickets());
			
		}
		else {
			
			dbshow.setIdshow(show.getIdshow());
			dbshow.setTitle(show.getTitle());
        	
			dbshow.setDistribution(show.getDistribution());
        	
			dbshow.setDate(show.getDate());
			dbshow.setGenre(show.getGenre());
			dbshow.setNotickets(show.getNotickets());
			
		}
		
	}
	
	public Show findByTitle(String name)
	{
		Show show = new Show();
		ShowDto dbshow = repository.findByTitle(name);
		dbMap(dbshow, show, false);
		return show;
		
	}
	
	public List<String> allToString(List<Show> lst)
	{
		
		
		List<String> result = null;
		for (Show t:lst) {
	           
            result.add(t.toString());
        }
		return result;
	}

}
