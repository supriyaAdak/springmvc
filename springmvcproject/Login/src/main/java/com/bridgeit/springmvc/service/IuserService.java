package com.bridgeit.springmvc.service;

import com.bridgeit.springmvc.dto.Userdto;
import com.bridgeit.springmvc.model.User;

public interface IuserService {
	//void register(User user);

	void register(Userdto user);
}
