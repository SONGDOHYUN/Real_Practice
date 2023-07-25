package JDBC;

import java.util.List;

public class AddressDao4TestMain {

	public static void main(String[] args) throws Exception {
		//test 하기 위한 객체 생성
		AddressDao4 dao4=new AddressDao4();
	
		System.out.println("1. insert");
		Address insertAddress=new Address(0, "추가이름", "추가번호", "추가주소");
		int insertCount=dao4.insert(insertAddress);
		System.out.println("insert된 행의 수: "+insertCount);
		
		System.out.println("2. update");
		Address updateAddress=new Address(1, "변경이름", "변경번호", "변경주소");
		int updateCount=dao4.update(updateAddress);
		System.out.println("update된 행의 수: "+updateCount);
		
		System.out.println("3.delete");
		int deleteCount=dao4.delete(1);
		System.out.println("delete된 행의 수: "+deleteCount);
		
		System.out.println("4. select By No");
		Address findByNoAddress=null;
		findByNoAddress=dao4.findByNo(2);
		if(findByNoAddress != null) {
			System.out.println("선택된 행의 정보: "+findByNoAddress);
		}else {
			System.out.println("해당되는 주소가 없습니다");
		}
		//or
		System.out.println("no=5인 행 정보 출력: "+dao4.findByNo(5));
		
		System.out.println("5. selectAll");
		List<Address> addressList=dao4.findAll();
		System.out.println("모든 리스트 출력: "+addressList);
		
	}

}
