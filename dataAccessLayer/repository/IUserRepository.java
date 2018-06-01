package dataAccessLayer.repository;

import dataAccessLayer.dbModel.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {

    List<UserDto> findAll();

    UserDto findById(int id) throws SQLException;

    
    void delete(UserDto user);
    
    UserDto getByUsername(String username);

	void update(UserDto user, int id);

	boolean create(UserDto user, int admin);
	

    
}