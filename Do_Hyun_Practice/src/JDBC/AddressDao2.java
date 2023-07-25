package JDBC;
/*
 * CRUD() 메소드에 파라미터 사용->main에서 각 정보 입력
 */
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * DTO: 멤버필드, getter, setter 있음
 * DAO: DB 연결, 기본적인 CRUD 생성
 */
public class AddressDao2 {
	//기본 생성자
	public AddressDao2() {

	}
	
	//insert-> 파라미터 사용 : pk는 파라미터로 넣는 거 아님-> 자동으로 들어가니까, 내가 직접 넣을거 아니니까
	public void insert(String name, String phone, String address) throws Exception {
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//insert 쿼리
		String insertSQL="insert into address values"
				+ "(address_no_seq.nextval,'"+name+"','"+phone+"','"+address+"')";
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(insertSQL);
		System.out.println("insert 후 변경된 행렬 수: "+rowCount);
		
		//연결 닫기
		stmt.close();
		con.close();
		
	}
	
	//SelectAll-> 파라미터 사용안해도 됨: 따로 파라미터 변수로 둬서 특정한 거 찾을 필요 없이 다 찾기 때문임
	public void findAll() {
		
		
		//selectAll 쿼리
		String selectAllSQL="select no, name,phone,address from address";
		
	}
	
	//SelectByPk->파라미터 사용
	public void findByNo(int no) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//selectByPk 쿼리->조건문의 변수를 파라미터로 사용
		String selectByPkSQL="select no, name, phone, address from address where no="+no;
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		
		//쿼리를 시행할 Statement 객체 생성
		Statement stmt=con.createStatement();
		//쿼리 실행 후 집합으로 받기-> ResultSet
		ResultSet rs=stmt.executeQuery(selectByPkSQL);
		
		//rs 출력
		if(rs.next()) {
			do {
				int no1=rs.getInt("no");
				String name1=rs.getString("name");
				String phone1=rs.getString("phone");
				String address1=rs.getString("address");
			}while(rs.next());
			//true 반환-> 존재하면 do-while 무한히 실행
			//false 반환-> 존재안하면 while문 빠져나옴
		}else {
			System.out.println("존재하는 주소록이 없습니다.");
		}
		
		//연결 닫기
		rs.close();
		stmt.close();
		con.close();
	}

}
