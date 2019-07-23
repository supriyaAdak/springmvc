package com.bridgeit.springmvc.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bridgeit.springmvc.dao.UserDao;
import com.bridgeit.springmvc.dto.Userdto;
import com.bridgeit.springmvc.model.User;

public class UserServiceimpl implements IuserService {
	@Autowired
	DataSource datasource;
	 @Autowired
	  private UserDao dao;
	
	 private JdbcTemplate jdbcTemplate;

    public UserServiceimpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public void register(Userdto user) 
	{
		
	     dao.getfromdto(user);
		
		System.out.println("in service");
		
		System.out.println(user);
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
		
	}
	

}
