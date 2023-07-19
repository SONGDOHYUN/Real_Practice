package JDBC;

import java.util.List;

public class AddressFinalDaoTestMain {

	public static void main(String[] args) throws Exception{
		//테스트하기 위한(필드 사용하기 위한) 객체 생성
		AddressFinalDao dao=new AddressFinalDao();
		
		System.out.println(">>insert>>");
		Address newAddress=new Address(0, "추가이름", "추가번호", "추가주소");
		int insertCount=dao.insert(newAddress);
		System.out.println("insert된 행 개수: "+insertCount);
		System.out.println("insert된 행의 이름: "+newAddress.getName());
		
		System.out.println(">>update>>");
		Address updateAddress=new Address(2, "변경이름", "변경번호", "변경주소");
		int updateCount=dao.update(updateAddress);
		System.out.println("update된 행 개수: "+updateCount);
		
		System.out.println(">>반환타입 없는 update>>");
		dao.update2(updateAddress);
		
		System.out.println(">>delete>>");
		int deleteCount=dao.delete(3);
		System.out.println("delete된 행 개수: "+deleteCount);
		
		System.out.println(">>select by No>>");
		
		//★★★★★★★★★★no로 찾았을 때 해당되는 거 없을 수도 있으니까 if 조건문 사용하기★★★★★★★★★★★
		
		Address findByPkAddress=dao.findByNo(2);
		if(findByPkAddress !=null) {
			System.out.println("2번인 address 정보: "+findByPkAddress);
		}else {
			System.out.println("해당되는 address가 없습니다");
		}
		
		System.out.println(">>select All>>");
		List<Address> list=dao.findAll();
		System.out.println("모든 address: "+list);
	}

}
