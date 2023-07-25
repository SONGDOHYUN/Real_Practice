package Practice_1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 1. JDBC[Java Database Connectivity]
 * -> 자바 프로그램과 DB 사이의 연결을 제공함
 * 
 *  
 *  1-1. 구성요소
 * - DriverClass
 * -> DB와 연결 제공하는 클래스
 * 
 * - JDBC API: DB 연결 관리하고 SQL 실행하기 위한 인터페이스와 클래스를 제공함
 * 예) Connection, Statement, PreparedStatement, Resultset 등의 클래스/인터페이스가 있음
 * 
 * - JDBC URL: DB에 접근하기 위한 URL
 * 
 * 
 * 2. JDBC 실행 순서
 * 
 * 1) JDBC 드라이버 로드
 * -> Class.forname(): 사용하여 드라이버 로드
 * 
 * 2) DB 연결
 * -> DriverManager.getConnection(): URL, User, Password 정보로 DB 연결
 * -> JDBC URL, 사용자 이름, 비밀번호 등의 연결 정보를 얻음
 * 
 * 3) SQL 쿼리 실행
 * -> Connection 객체 생성-> Statement, PreparedStatement[SQL 쿼리를 실행하는 객체] 사용하여 SQL CRUD 실행
 * 
 * 4) 결과 반환: select 쿼리일 시 사용함
 * -> ResultSet 객체 생성-> 결과 반환함
 * 
 * 5) 연결 해제
 * -> ResultSet, StateMent, Connection의 연결을 명시적으로 해제함
 * 
 * 
 * 3. DTO, DAO
 * 
 * 3-1. DTO [Data Transfer Object] : 데이터 전달!!하기 위한 객체들의 정보 모음
 * -> DB의 테이블 구조와 일치하는 형태로 생성됨
 * -> 멤버필드, 접근 메소드(getter, setter) 등이 구성요소임
 * 
 * 3-2. DAO [Data Access Object] : !!DB나 외부 저장소에 접근!!할 수 있는 객체
 * -> DB와 연결, CRUD를 사용해서 SQL 쿼리 실행함
 * -> 기본적인 DB관련 CRUD[Create, Read, Update, Delete] 관련 메소드가 생성됨 -> 비즈니스와 기본적인 DB 로직을 분리하려고  
 * -> 예) create(), selectById() 등등
 * 
 * 3-3. Service 클래스 : 여러가지 비즈니스 메소드를 생성함
 * -> 비즈니스 메소드: 기본적인 CRUD가 아닌 입금, 출금 등등 필요한 메소드를 창조하는 클래스임
 * 
 * 
 * 4. DAO DataSource, 연결 코드 묶기 : 
 * ###순서: Properties 파일(key-value로 저장됨: 예: user=jdeveloper30 )만들어야 함!
 *      -> DataSource Class 생성 후 Properties 객체 사용하기 위해 생성(properties 파일에 저장된 key-value값 불러오려고) 
 *      -> getReSourceAsStream() 사용해서 파일 가져온 뒤 InputStream 타입 변수에 넣음
 *         예) InputStream propertiesInput=DataSource.class.getResourceAsStream("/jdbc.properties");
 *      -> Properties 객체에 load() 메소드 사용하여 InputStream으로 받은 파일 로드해주면 됨
 *         예) properties.load(propertiesInput);
 *       
 * -> DAO에서 CRUD 메소드 실행할 때 마다 DB 정보(driverClass, url, user, password) 매번 입력하고 연결해야했음
 * -> 예) 
 * 		//DB 정보
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		//DB 연결
		[Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);]
		->여기까지를 public Connection getConnection(){
			Class.forName(driverClass);
			Connection con=DriverClass.getConnection(url, user, password);
			return con;
		} 라는 공통 메소드로 만들어버림
		
		[여기는 PreparedStatement를 쓸수도 있어서 굳이 공통 코드로 묶진 않았음]
		Statement stmt=con.createStatement();
		int rowCount=stmt.executeUpdate(insertSQL);
		
 * -> 따라서 공통되는 코드들은 DataSource Class를 하나 만들어서 다 넣어버림
 * 
 * 5. Statement[상위]-PreparedStatement[하위] 인터페이스: 둘다 SQL 쿼리를 실행하기 위해 Connection 객체에 연결을 제공하는 인터페이스임
 * <<차이점>>
 * -> 실행될때마다 SQL문을 받거나 미리 컴파일된 SQL문을 받느냐의 차이
 * -> SQL문을 인자로 받는 시점이 다름
 * 
 * - Statement: 실행될때마다 SQL 쿼리가 생성되고 컴파일됩니다.
 * 예) String SQL="select ~";
 *    Connection con=DriverClass.getConnection(url, user, password);
 *    Statement stmt=con.createStatement();
 *    ResultSet rs=stmt.executeupdate(SQL); -> execute할때 SQL쿼리를 인자로 넣음
 * 
 * - PreparedStatement: 
 * ★★★★★CRUD 메소드 문 실행할때마다 DB정보 로딩했었음
 * 	      ->PreparedStatement 사용하면 DB정보 한번만 로딩하면 됨★★★★★
 *          
 * -> 미리 컴파일 된 SQL문을 실행함
 * -> ?(파라미터)를 사용해서 외부에서 인자를 받을 수 있음: select * from ?, select ?,? from address
 * 
 * 예) String SQL="select ~";
 *    Connection con=DriverClass.getConnection(url, user, password);
 *    PreparedStatement psmt=con.prepareStatement(SQL); -> preparedStatement(); 실행할 때 인자로 SQL문 넣음
 * 	  -> 연결객체에 SQL문 쿼리를 실행하기 위한 preparedstatement()를 실행할 때 아예 쿼리까지 담아버림
 *    -> 그 다음에 쿼리 세팅함
 *    psmt.setInt(그 칼럼의 인덱스, 그 인덱스의 value, 그 인덱스에 넣으려는 value의 값을 담은 변수의 이름);
 *    psmt.setString(그 칼럼의 인덱스 순서, 그 인덱스의 value);
 *    예) 
	 *    int empno=9001;
		  --9001 delete--
		  pstmt1.setInt(1, empno);
 *    
 *    -> 쿼리 세팅한 뒤 execute 실행
 *    psmt.executeQuery();
 * 
 * 6.  DAO 작성 방법
 * 
 *  0) 테이블설계(create drop) 					-->address_table_create_drop.sql 파일생성

	1) sql문작성(insert,update,delete,select)	-->addresss_insert_update_delete_select.sql 파일생성
	
	2) Dto(VO)클래스작성
	
	3) Dao클래스작성
	 	- 테이블에 insert,delete,update,findByPk,selectAll 단위메쏘드만들기
	    - 단위메쏘드(인자 반환타입정의)생성
	    
	4) <<< 반드시 테스트 되어야합니다.>>>
		public class AddressDaoTestMain{
			public static void main(String[] args){
			  AdderessDao adderssDao=new AdderessDao();
			  adderssDao.insert();
			} 
		}    
 * 
 * 
 * 7. Service 작성 방법: 기본적인 CRUD(DAO) 말고 다른 비즈니스 로직 작성, 외부에서 직접 접근하는 클래스
 * 추가 설명))
 * 
 *   *DAO가(-CRUD통해서-DB연결했었음)
	 * Service-DAO: 서비스는 DAO에 접근해서 DAO 도움을 받아 DB에 접근하고자 함
	 * 따라서 Service 구체화된 비즈니스 CRUD나 메소드가 있는거임 
 * 
 * 
 *  1) AddressService.java 클래스 생성 
	★★★★★★★★★★★★★★★★★★★★★★★★★
	2) AddressDao객체를 멤버필드로 선언
	
	★★★★★★★★★★★★ !!!!!!!!!중요!!!!!!!!!! ★★★★★★★★★★★★★
	3) AddressService 클래스 기본 생성자에서 AddressDao 객체 생성할 수 있게 함
	->AddressService 클래스의 객체 생성 시 동시에 AddressDao의 객체도 생성되어 AddressDao 클래스의 필드 모두 사용할 수 있게!!
	★★★★★★★★★★★★ !!!!!!!!!중요!!!!!!!!!! ★★★★★★★★★★★★★
	
	4) 클라이언트 요구사항 분석 시 도출된 단위 업무 당 한개의 메쏘드 생성
	5) AddressService클래스 메쏘드 기술(인자 ,반환타입)
	6) 메쏘드 구현
 */
public class JDBC {

}
