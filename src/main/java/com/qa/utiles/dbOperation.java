package com.qa.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import javax.print.attribute.HashAttributeSet;

public class dbOperation {
	
	protected static Connection connection= null;
	protected static Statement stmt= null;
	protected static PreparedStatement prestmt= null;
	protected static LinkedHashMap<String, String> hm;
	protected static ResultSet rs=null;
	protected static ResultSetMetaData rsmd=null;
	protected static Object[][] obj;
	static LinkedHashMap<Integer, LinkedHashMap<String , String>> map;
	public static Connection connectionsetup(){
		
		try {
			String url= "jdbc:mysql://localhost:3306/automationdb";
			 String cred=System.getProperty("user");
			connection=	DriverManager.getConnection(url,cred,cred);
			
		} catch (SQLException e) {
			System.out.println("Error in connection"+e);
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	public static Statement createstatement(){
		try {
			 stmt=connectionsetup().createStatement();
			//System.out.println("statement created");
		}
		
		catch (SQLException e) {
			System.out.println("Error in statement"+e);
			e.printStackTrace();
		}
		
		return stmt;
		
	}
	
	public static PreparedStatement preparedstatement(String query){
		
		try {
			 prestmt=connection.prepareStatement(query);
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prestmt;
		
	}
	
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> executequery(String sql){
	
		
		try {
			rs=createstatement().executeQuery(sql);
			rsmd=rs.getMetaData();
			int col=rsmd.getColumnCount();
			int rw=rs.getRow();
			//System.out.println("column count"+col);
			map=new LinkedHashMap<Integer, LinkedHashMap<String , String>>();
			int row=1;
			Object[][] obj =new Object[rw][1];
			while(rs.next()){
				hm= new LinkedHashMap<String, String>();
				for(int i=1; i<=col;i++){
					
					hm.put(rsmd.getColumnName(i), rs.getString(i));
					
				}
				
				map.put(row, hm);
				row=row+1;
			}
			
			return map;
		} 
		
		catch (SQLException e) {
			System.out.println("Error in executequery"+e);
			e.printStackTrace();
			
		}
		return map;
	}
	
    public static void executeupdates(String query){
    	
    	try {
			 prestmt=connection.prepareStatement(query);
			 prestmt.executeUpdate();
			 System.out.println("Execute update");
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	
		
	}
    
 public static void executeinsert(String query, int n){
    	
	 try {
		 prestmt=connection.prepareStatement(query);
		 
			 prestmt.execute();
			 
	
		
		 System.out.println("Execute Insert");
	}
	
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	
		
	}
    
    
   /* public static void main(String[] args) {
		
    	connectionsetup();
    	LinkedHashMap<Integer, LinkedHashMap<String, String>> lhm= new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
    lhm=executequery("SELECT * FROM automationdb.fdcalculator");
    System.out.println(lhm.size());
    for(int i=1;i<=lhm.size();i++){
    	 System.out.println(lhm.get(i).get("principal"));
    }
   
    	
	}*/
	

}
