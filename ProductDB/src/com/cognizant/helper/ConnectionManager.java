package com.cognizant.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager {
@Autowired
private DataSource datasource;
private static Connection connection=null;
public java.sql.Connection openConnection(){
	try{
		Class.forName(datasource.getDriver());
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		connection=DriverManager.getConnection(datasource.getUrl(),datasource.getUsername(),datasource.getPassword());
	}catch(SQLException e){
		e.printStackTrace();
	}
	return connection;
}
public void closeConnection(){
	try{
		connection.close();
		
	}catch(SQLException e){
		e.printStackTrace();
	}
}
}
