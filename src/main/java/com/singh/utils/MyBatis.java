

package com.singh.utils;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
	private static String CONFIGURATION_FILE = "myBatisConfig.xml";
	private static SqlSessionFactory factory;
	
	public MyBatis() {}
	
	
	static{
		Reader reader = null;
		try {
		 reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
			} 
		catch (IOException e) {
			throw new RuntimeException(e.getMessage());
			}
		factory = new SqlSessionFactoryBuilder().build(reader);
		}

		public static SqlSessionFactory getSqlSessionFactory(){
		 return factory;
		}
	
}


