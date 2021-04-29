package com.qa.utiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configProperties {
	
	
	public static void readPropertiesFile() throws IOException{
		
		FileInputStream fis= new FileInputStream(".\\externalfile\\config.properties");
		Properties config= new Properties();
		config.load(fis);
		System.out.println(config.get("browser"));
		
	}
	
	/*public static void main(String[] args) throws IOException {
		readPropertiesFile();
	}*/

}
