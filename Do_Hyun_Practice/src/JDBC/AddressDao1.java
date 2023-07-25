package JDBC;
/*
 * 1. CRUD() 메소드에 인자없고-> SQL문에 직접 정보 입력
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * DTO에 멤버필드, getter, setter 입력
 * DAO에 DB 연결 코드, 기본적인 CRUD 실행->SQL문에 변수 없고 딱 넣은 것만 들어감
 */
public class AddressDao1 {
	
	//기본 생성자
	public AddressDao1() {
	}
	
	//insert
	public void insert() throws Exception{
		//DB 연결 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//insert 쿼리
		String insertSQL="insert into address values(address_no_seq.nextval,'김강산','123-4568','경기도 시흥시')";
		
		//DB랑 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt =con.createStatement();
		int rowCount=stmt.executeUpdate(insertSQL);
		System.out.println("insert된 행의 개수: "+rowCount);
		
		//연결 닫기
		stmt.close();
		con.close();
		
	}
	
	//update
	public void update() throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//update query
		String updateSQL="update address set name='제임스', phone='333-3333', address='바뀐 주소' where no=2";
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(updateSQL);
		System.out.println("update 후 변경된 행의 개수: "+rowCount);
		
		//연결 닫기
		stmt.close();
		con.close();
	}
		
		//selectAll 쿼리
		public void findAll() throws Exception{
			//DB 연결 정보
			String driverClass="oracle.jdbc.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			
			//Select 쿼리
			String selectALLSQL="select no, name, phone, addrress from address";
			
			//DB 연결
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(url,user, password);
			
			//SQL문 실행할 준비 완료
			Statement stmt=con.createStatement();
			
			//결과의 집합 반환=> ResultSet 사용: 각 정보를 set에 담아서 저장하기 위함
			ResultSet rs=stmt.executeQuery(selectALLSQL);
			
			//결과 돌면서 모두 출력함=> while 문 사용
			if(rs.next()) {
				
			do {
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				System.out.println(no+"\t"+name+"\t"+phone+"\t"+address);
			}while(rs.next());
				//있으면 계속 실행
			}else {
				System.out.println("조건에 만족하는 address 찾을 수 없음");
			}
			
			//연결 닫기
			rs.close();
			stmt.close();
			con.close();
			
		}
		
	}
	
