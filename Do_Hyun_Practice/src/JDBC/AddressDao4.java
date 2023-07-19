package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * ####기억해야할 정보####
 * - 객체를 파라미터로 사용함-> main에서 객체를 생성+정보 초기화하여 파라미터에 객체 집어넣어서 insert, update함
 * - 객체를 반환타입으로 사용함-> 특정 칼럼으로 select한 뒤 선택된 행의 정보를 객체에 담아서-> 객체를 반환함
 *                     -> main에서 그 메소드만 실행하면 객체타입으로 예쁘게 담겨서 정보 출력됨
 * 
 * 객체를 파라미터로 받아서-> main에서 객체에 객체를 담는 방식은 동일
 * 여기서 차이점은 
 * 각 메소드의 반환타입이 다르다는 것 : CRUD를 하면서 변화되는 행의 개수!!(int 타입)을 반환타입으로 하여 반환받음
 * findByPk(or 다른 칼럼)은 찾은 정보를 다 가져와야하기 때문에 객체에 담아서 객체를 반환함
 * findAll을 List<Address> 타입으로 받는다는 것
 */


public class AddressDao4 {
	//기본생성자
	public AddressDao4() {

	}
	
	//insert 반환 타입 void 아님
	public int insert(Address insertAddress) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//insertSQL
		String insertSQL="insert into address values(address_no_seq.nextval,"
				+ ""+insertAddress.getName()+","
				+ ""+insertAddress.getPhone()+","
				+ ""+insertAddress.getAddress()+")";
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(insertSQL);
		System.out.println("insert 후 행: "+rowCount);
		
		
		//연결 닫기
		stmt.close();
		con.close();
		
		//int 타입으로 반환하기
		return rowCount;
	}
	
	//update
	public int update(Address updateAddress) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//updateSQL
		String updateSQL="update address set name="+updateAddress.getName()+", "
									     + "phone="+updateAddress.getPhone()+", "
									     + "address="+updateAddress.getAddress()+" "
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
		
		//반환
		return rowCount;
	}
	
	//delete: no로 삭제함
	public int delete(int no) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//deleteSQL
		String deleteSQL="delete from address where no="+no;
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(deleteSQL);
		System.out.println("delete 후 "+rowCount);
		//연결 닫기
		stmt.close();
		con.close();
		
		//반환
		return rowCount;
	}
	
	//select By no: !!!!!!!!!!!!!!객체를 반환한다!!!!!!!!!!!!!!!
	//no로 뽑힌 그 객체의 정보를 다 가져오기 때문에 반환타입이 클래스타입이 되어야함
	public Address findByNo(int no) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//select by no 쿼리
		String selectByNoSQL="select no, name, phone, address where no="+no;
		
		//★★★★★반환타입 변수 null로 초기화하고 나중에 반환때 담으면 됨★★★★★
		Address findByNoAddress=null;
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();

		//Set으로 담기
		ResultSet rs=stmt.executeQuery(selectByNoSQL);
		
		//찾기 돌리기
		if(rs.next()) {
			do {
				int no3=rs.getInt("no");
				String name3=rs.getString("name");
				String phone3=rs.getString("phone");
				String address3=rs.getString("address");
				
				//★★★★★여기서 해당되는 정보들 새롭게 객체로 만들어서 Address타입 변수에 담기★★★★★
				findByNoAddress=new Address(no3, name3, phone3, address3);
				
			}while(rs.next());
		}else {
			System.out.println("해당되는 주소록이 없습니다");
		}
		
		//연결 닫기
		rs.close();
		stmt.close();
		con.close();
		
		//Address 타입 반환하기
		return findByNoAddress;
	}
	
	//selectAll->List 타입으로 반환함
	public List<Address> findAll() throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//selectAll 쿼리
		String selectAllSQL="select no, name, phone, address from address";
		
		//모든 정보 담을 List 타입 변수 설정
		//Address타입의 객체들의 배열을 생성하여 그들을 findList라는 리스트 타입에 저장하겠다.
		List<Address> findList=new ArrayList<Address>();
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectAllSQL);
		
		//돌리기
		if(rs.next()) {
			do {
				int no4=rs.getInt("no");
				String name4=rs.getString("name");
				String phone4=rs.getString("phone");
				String address4=rs.getString("address");
				
				//★★★★★List에 담으려면 객체화하여 담아야함★★★★★
				//칼럼 정보들을 담는 객체 생성-> 그 객체들을 list에 add하면 됨
				Address address=new Address(no4, name4, phone4, address4);
				findList.add(address);
				
			}while(rs.next());
		}else {
				System.out.println("해당되는 주소 없음");
			}
		
		//연결 닫기
		rs.close();
		stmt.close();
		con.close();
		
		//리스트 반환
		return findList;
		
	}

	
}
