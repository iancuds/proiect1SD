package businessLayer.service;

import businessLayer.model.User;
import dataAccessLayer.dbModel.UserDto;

public interface ICashierService {

	void dbMap(UserDto dbuser, User user, boolean b);

}
