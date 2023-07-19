package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * select쿼리+ PreparedStatement
 * 항상 쿼리 실행 후!! RS에 담던가 rowCount로 받아서 출력했음
 */
public class ResultSetMain {

	public static void main(String[] args) throws Exception {
		//DB 정보
		DataSource dataSource=new DataSource(); //DB 정보 로드됨
		
		//select all
		String SelectAllSQL="select no, name, price from product";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt1=con.prepareStatement(SelectAllSQL);
		ResultSet rs=pstmt1.executeQuery();
		
		//이미 select 문 들어가서 시행 중> 이제 rs 돌리기: get타입(컬럼 인덱스,"컬럼이름", 객체);
		if(rs.next()) {
			do {
				int no=rs.getInt("no");
				String name=rs.getString("name");
				double price=rs.getDouble("price");
			}while(rs.next());
		}else {
			System.out.println("해당되는 칼럼 없음");
		}
		rs.close();
		dataSource.close(con);
		
		
	}

}
