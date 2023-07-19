package JDBC;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception {
		//파라미터 가진 Dao2 테스트
		//객체 생성
		AddressDao2 dao2=new AddressDao2();
		System.out.println("1. insert");
		dao2.insert("추가이름", "추가폰번호", "추가주소");
		System.out.println("2. findAll");
		dao2.findAll();
		System.out.println("3. select By No=PK");
		dao2.findByNo(3);
	}

}
