package kr.or.ddit.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory factory;
	
	static {
		String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
		try {
			InputStream input = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static SqlSession getSession( ) {
		return factory.openSession();
	}
}
