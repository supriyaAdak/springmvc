package com.bridgeit.springmvc.dao;

import com.bridgeit.springmvc.dto.Userdto;
import com.bridgeit.springmvc.model.Login;
import com.bridgeit.springmvc.model.User;

public interface UserDao {
	//User getfromdto (User user);
	//void register(Userdto user);
	
	User validateUser(Login login);

	User getfromdto(Userdto user);

}
