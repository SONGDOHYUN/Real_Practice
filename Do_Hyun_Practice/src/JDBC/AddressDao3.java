package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * CRUD() 메소드 파라미터에 객체 대입->main에서 생성자 사용하여 정보 입력
 */
public class AddressDao3 {
	
	//기본 생성자
	public AddressDao3() {
	}
	
	//insert문-> 파라미터로 객체 생성
	public void insert(Address insertAddress) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//insert 쿼리
		String insertSQL="insert into address values("
				+ "address_no_seq.nextval,"
				+ ""+insertAddress.getName()+","
				+ ""+insertAddress.getPhone()+","
				+ ""+insertAddress.getAddress()+")";
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(insertSQL);
		System.out.println("insert후 삽입된 행의 개수: "+rowCount);
		
		//연결 닫기
		stmt.close();
		con.close();
	}
	
	//update 쿼리-> 파라미터로 객체 사용
	public void update(Address updateAddress) throws Exception{
		
		//DB정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//update 쿼리
		String updateSQL="update address set name='', "
				+ "phone='"+updateAddress.getPhone()+"', "
				+ "address='"+updateAddress.getAddress()+"' "
				+ "where no="+updateAddress.getNo();
		
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(updateSQL);
		System.out.println("update 후 "+rowCount);
		
		//연결 닫기
		stmt.close();
		con.close();
	}
	
	//selectByPK
	public void FindByNo(int no) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//selectByPk SQL
		String selectByNoSQL="select no, name, phone, address "
				+ "from address where no="+no;
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectByNoSQL);
		
		//출력
		if(rs.next()) {
			do {
				int no2=rs.getInt("no");
				String name2=rs.getString("name");
				String phone2=rs.getString("phone");
				String address2=rs.getString("address");
			}while(rs.next());
		}else {
			System.out.println("해당되는 주소록 없음");
		}
		
		//연결 닫기
		rs.close();
		stmt.close();
		con.close();
	}
	
}
