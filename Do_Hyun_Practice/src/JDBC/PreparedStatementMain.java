package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class PreparedStatementMain{

	public static void main(String[] args) throws Exception{
		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user="jdeveloper30";
		String password="jdeveloper30";
		
		//SQL문
		String deleteSQL="delete from emp where no=?";
		
		//DB 연결
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		
		//Prestatement
		PreparedStatement pstmt=con.prepareStatement(deleteSQL);
		
		//delete
		int empNo=1;
		
		//setting
		pstmt.setInt(1, empNo);
		int rowCount=pstmt.executeUpdate();
		System.out.println("delete 후: "+rowCount);
		
		//연결 닫기
		pstmt.close();
		con.close();
		
		System.out.println("insert");
		String insertSQL="insert into emp values(?,?,?,?)";
		PreparedStatement pstmt2=con.prepareStatement(insertSQL);
		
		/**********************9001 insert********************/
		empNo=9001;
		String ename="JUNG";
		String job="MANAGER";
		int mgr=7369;
		Date hiredate=new Date();
		double sal=3000.34;
		int comm=30;
		int deptno=40;
		
		pstmt2.setInt(1, empNo);
		pstmt2.setString(2, job);
		pstmt2.setString(3, job);
		pstmt2.setDate(5, (java.sql.Date) new Date(hiredate.getDate()));
		
		int rowCount2=pstmt.executeUpdate();
		System.out.println("insert 후: "+rowCount2);
		
		
		
		
		
		
		
		
		
		
		
	}

}
