package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * DTO: 필드, getter, setter
 * DAO: DB 연결, 기본적인 CRUD 메소드 작성
 * 서비스: 비즈니스 로직 실행
 * 
 * SQL문, DataSource클래스, properties 파일 따로 만들거임
 * preparedStatement 사용해서 DB연결 한번만 할거임
 * ->쿼리 미리 로딩하고 -> 각 조건에 맞게 세팅하고 -> 그 후에 select 문의 경우에는 ResultSet 돌리기 
 * 반환타입 다 다르게 할거임
 * 
 */
public class AddressFinalDao{
	//필드
	private DataSource dataSource;
	
	//기본 생성자->객체 생성할 때 DB정보도 로딩하기 위함
	public AddressFinalDao() throws Exception {
		this.dataSource=new DataSource();
	}
	
	//insert
	public int insert(Address insertAddress) throws Exception{

		Connection con=dataSource.getConnection();
		PreparedStatement pstmt1=con.prepareStatement(AddressFinalSQL.ADDRESS_INSERT);
		
		//setting: 인덱스 순서는 SQL문에 적힌 ? 순서임
		pstmt1.setString(1, insertAddress.getName());
		pstmt1.setString(2, insertAddress.getPhone());
		pstmt1.setString(3, insertAddress.getAddress());
		
		//쿼리 실행
		int rowCount1=pstmt1.executeUpdate();
		System.out.println("insert 후: "+rowCount1);
		
		//연결 닫기
		pstmt1.close();
		dataSource.close(con);
		
		//반환
		return rowCount1;
	}
	
	//update
	public int update(Address updateAddress) throws Exception{
		//DB 연결
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt2=con.prepareStatement(AddressFinalSQL.ADDRESS_UPDATE);
		
		//setting
		pstmt2.setString(1, updateAddress.getName());
		pstmt2.setString(2, updateAddress.getPhone());
		pstmt2.setString(3, updateAddress.getAddress());
		pstmt2.setInt(4, updateAddress.getNo());
		
		//쿼리 실행
		int rowCount2=pstmt2.executeUpdate();
		System.out.println("update 후: "+rowCount2);
		
		//연결 닫기
		pstmt2.close();
		dataSource.close(con);
		
		//반환
		return rowCount2;
	}
	

	//반환타입 없는 update메소드
	public void update2(Address updateAddress) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressFinalSQL.ADDRESS_UPDATE);
		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
	}
	
	
	//delete
	public int delete(int no) throws Exception{
		//DB 연결
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt3=con.prepareStatement(AddressFinalSQL.ADDRESS_DELETE);
		
		//setting
		pstmt3.setInt(1, no);
		
		//쿼리 실행
		int rowCount3=pstmt3.executeUpdate();
		
		//연결 닫기
		pstmt3.close();
		dataSource.close(con);
		
		//반환
		return rowCount3;
	}
	
	//select By No
	public Address findByNo(int no) throws Exception{
		
		//★★★★★담을 객체 선언★★★★★★
		Address findByNoAddress=null;
		
		//DB 연결
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt4=con.prepareStatement(AddressFinalSQL.ADDRESS_SELECT_BY_NO);
		
		//★★★★★setting 먼저!-> 그래야 몇번 찾는지 아니까★★★★★
		pstmt4.setInt(1, no);
		
		//쿼리 실행
		ResultSet rs=pstmt4.executeQuery();
		
		//돌리기->setInt한 것의 칼럼 정보들 (do로 뽑아서) 돌리고 새 객체 생성해서 변수에 담음
		if(rs.next()) {
			//do {
				int no1=rs.getInt("no");
				String name1=rs.getString("name");
				String phone1=rs.getString("phone");
				String address1=rs.getString("address");
				findByNoAddress=new Address(no1, name1, phone1, address1);
			//}while(rs.next());
		}else {
			System.out.println("해당되는 칼럼 없음");
		}
		
		//연결 닫기
		rs.close();
		pstmt4.close();
		dataSource.close(con);
		
		//반환
		return findByNoAddress;
	}
	
	//selectAll
	public List<Address> findAll() throws Exception{
		
		//리스트 선언: Address 타입의 객체들을 배열하여 리스트화 하겠다(리스트에 넣겠다, 리스트로 만들겠다)
		List<Address> findList=new ArrayList<Address>();
		
		//DB 연결
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt5=con.prepareStatement(AddressFinalSQL.ADDRESS_SELECT_ALL);
		
		//쿼리 실행
		ResultSet rs=pstmt5.executeQuery();
		
		//돌리기
		if(rs.next()) {
			do {
			int no2=rs.getInt("no");
			String name2=rs.getString("name");
			String phone2=rs.getString("phone");
			String address2=rs.getString("address");
			//객체에 하나하나 담아서 리스트에 객체들! 담기
			Address findAllAddress=new Address(no2, name2, phone2, address2);
			findList.add(findAllAddress);
			
			}while(rs.next());
		}else {
			System.out.println("해당되는 칼럼 없음");
		}
		//연결닫기
		rs.close();
		pstmt5.close();
		dataSource.close(con);
		
		//반환
		return findList;
	}
}
