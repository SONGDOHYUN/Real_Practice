package JDBC;
/*
 * 매번 String __SQL="";하기 귀찮아서 SQL문만 모아놓은 파일 따로 만듬
 * 
 * 규칙))
 * - public static(공통으로 사용 가능) final(상수화-변경불가) String 대문자변수이름="";
 * 
 */
public class AddressFinalSQL {

	//public static final String 대문자="";
	
	public static final String ADDRESS_INSERT
	="insert into address values(address_no_seq.nextval,?,?,?)";
	public static final String ADDRESS_UPDATE
	="update address set name=?, phone=?, address=? where no=?";
	public static final String ADDRESS_DELETE
	="delete from address where no=?";
	public static final String ADDRESS_SELECT_BY_NO
	="select no, name, phone, address from address where no=?";
	public static final String ADDRESS_SELECT_ALL
	="select no, name, phone, address from address";
	
	
	
}
