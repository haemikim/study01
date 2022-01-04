package org.iht.dbTest;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/dbtest?serverTimezone=Asia/Seoul";
	private static final String USER="root";
	private static final String PW="1234";
	
	/*
	 * 테스트와 관련된 이노베이션(@)
	 * @RunWith
	 * @ContextConfiuration
	 * @Test
	 * */	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con=DriverManager.getConnection(URL,USER,PW)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
 