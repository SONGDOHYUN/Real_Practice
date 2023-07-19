package JDBC;
/*
 * 공통되는 DB 정보, DB 연결 코드 하나로 정리하기
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource {
	//멤버필드
	private String driverClass;
	private String url;
	private String user;
	private String password;
	
	//기본 생성자
	public DataSource() throws Exception{
		//여기에 DB 정보 공통 코드 쓰기-> DataSource 객체 생성 시 DB 정보도 로드되게끔
		Properties properties=new Properties(); //Properties 클래스 사용 가능
		InputStream propertiesInput=DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(propertiesInput);
		
		this.driverClass=properties.getProperty("driverClass");
		this.url=properties.getProperty("url");
		this.user=properties.getProperty("user");
		this.password=properties.getProperty("password");
		
	}
	
	//DB 정보는 생성자에서 객체 만듬과 동시에 dat로드되게 만들었음
	//이제는 DB 연결 관련 메소드를 만들어야함->메소드 호출 시 시행되게
	public Connection getConnection() throws Exception{
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
		
	}
	
	//Connection close하는 메소드
	public void close(Connection con) throws Exception{
		con.close();
	}
	
	
}
