package dataAccessLayer.repository;

import java.sql.SQLException;
import java.util.List;

import businessLayer.model.Show;
import dataAccessLayer.dbModel.ShowDto;


public interface IShowRepository {


    List<ShowDto> findAll();

    ShowDto findById(int id) throws SQLException;
    
    public ShowDto findByTitle(String name);

    boolean create(ShowDto show) ;

    void update(ShowDto show, int id);
    
    void delete(ShowDto show);
    
	
}
