package JDBC;

public class AddressDao1TestMain {

	public static void main(String[] args) throws Exception{
		//DAO 잘 되는지 확인
		//Test하려면 객체 생성해서 그 클래스의 필드 잘 돌아가는지 확인하면 됨
		
		//일단 객체 생성->그래야 필드 사용 가능
		AddressDao1 dao1=new AddressDao1();
		System.out.println("1. insert");
		dao1.insert();
		System.out.println("2. update");
		dao1.update();
		System.out.println("3. selectAll");
		dao1.findAll();
		
		
	}

}
