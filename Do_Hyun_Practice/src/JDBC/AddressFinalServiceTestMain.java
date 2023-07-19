package JDBC;

import java.util.List;

public class AddressFinalServiceTestMain {

	public static void main(String[] args) throws Exception{
		//Service를 사용하기 위한 객체 생성
		AddressFinalService service=new AddressFinalService();
		//Service 객체 생성하자마자 생성된 AddressFinalDao 객체 가져옴
		//->AddressFinalDao 필드 사용 가능
		System.out.println(">>insert>>");
		Address writeAddress=new Address(0, "추가서비스이름", "추가서비스번호", "추가서비스주소");
		int writeCount=service.Write(writeAddress);
		System.out.println("insert된 행의 수: "+writeCount);
		System.out.println("insert된 행의 정보: "+service.Write(writeAddress));
		
		System.out.println(">>update>>");
		Address updateAddress=new Address(2, "수정서비스이름", "수정서비스번호", "수정서비스주소");
		int modifyAddress=service.modify(updateAddress);
		System.out.println("update된 행의 수: "+modifyAddress);
		
		System.out.println(">>delete>>");
		int deleteCount=service.delete(3);
		System.out.println("delete된 행의 수: "+deleteCount);
		
		System.out.println(">>NO로 address 1개 검색>>");
		Address findByPkAdddress=service.addressDetail(1);
		System.out.println("1번 주소록: "+findByPkAdddress);
		
		System.out.println(">>address 전체 출력>>");
		List<Address>addressList=service.list();
		System.out.println("전체 주소록: "+addressList);
		
		
	}

}
