package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 순서:
 * DriverClass(Class.forname())->DriverManager->Connection 객체로 SQL->Resultset->닫기
 * 
 * 
 * -SQL 쿼리 중 insert, update, delete 실행시 
 * -> stmt.executeUpdate(SQL); 사용
 * -> 실행 후 행의 갯수를 반환받아야하므로 int 타입의 변수를 사용함
 * 
 * -SQL 쿼리 중 Select 실행 시
 * -> stmt.executeQuery(SQL); 사용
 * -> select된 결과의 집합!!을 받아야하므로 ResulteSet 타입의 변수를 사용해서 받아야함 
 * 
 * 
 * 
 */
public class JDBCFlowMain {

	public static void main(String[] args) throws Exception{
		//DB 접속정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user="jdeveloper01";
		String password="jdeveloper01";
		
		//SQL
		String selectSql="select no, name, phone, address from address order by no";
		
		//1. DriverClass loading
		Class.forName(driverClass); //"driverClass"라고 정의된 클래스 주소를 로드함
		//System.out.println(driverClass);
		
		//2. Connection 객체 생성
		//DriverManager 클래스를 사용하여 연결하고 Connection con이라는 연결객체에 정보를 저장함
		Connection con=DriverManager.getConnection(url, user, password);
		System.out.println("Connection 객체 생성"+con);
		
		//3. Statement 객체[SQL 실행하는 객체] 생성
		Statement stmt =con.createStatement();
		//con 연결 객체에 SQL문을 실행하기 위
		//한 createStatement() 메소드를 실행하여 SQL 실행하기 위한 객체를 만들고 stmt 변수에 담음
		System.out.println("전송 객체 생성"+stmt);
		
		//4. SQL문 전송-> 메소드 실행한 뒤 그 결과값 ResultSet 타입으로 받아야함
		//ResultSet은 주로 Select문에서만 사용함, 나머지 update, delete, insert에서는 !!실행한 뒤의 행의 개수[int]!!로 받는다
		ResultSet rs =stmt.executeQuery(selectSql);
		System.out.println("SQL 실행값 ResultSet에 저장"+rs);
		
		//전체 출력
		while(rs.next()) { //객체가 존재하면(true) 진행, 객체가 존재안하면(false)면 중단
			int no=rs.getInt("no"); //"컬럼 이름"의 값을 int 타입으로 가져와서 int no라는 변수에 저장
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			System.out.println(name+"\t"+phone+"\t"+address);
			
		}
		
		//다 출력하고 연결 해제 명시적으로 함->렉 막으려고 : 끝에서부터 닫아줌
		rs.close();
		stmt.close();
		con.close();
		
		
		
		
		
		
		
		
		
	}

}
