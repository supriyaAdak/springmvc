package com.bridgeit.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bridgeit.springmvc.dao.UserDao;
import com.bridgeit.springmvc.dao.UserDaoImpl;
import com.bridgeit.springmvc.service.IuserService;
import com.bridgeit.springmvc.service.UserServiceimpl;

@Configuration
@ComponentScan(basePackages="com.bridgeit.springmvc")
@EnableWebMvc
public class configuration extends WebMvcConfigurerAdapter{
	 
	
	
	    

	     
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	 
	    @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/myusers");
	        dataSource.setUsername("root");
	        dataSource.setPassword("test");
	         
	        return dataSource;
	    }
	     
	    @Bean
	    public UserDao getUserDao() {
	        return new UserDaoImpl(getDataSource());
	    }
	    @Bean
	    public IuserService getUserservice() {
	        return new UserServiceimpl(getDataSource());
	    }
	}


