package JDBC;
/*
 * 객체에 객체를 담는거임
 */
public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		//객체 생성
		AddressDao3 dao3=new AddressDao3();
		System.out.println("1. insert");
		//파라미터에 들어갈 객체를 따로 생성해서 정보를 입력하고 그걸 메소드의 파라미터로 넣는다
		
		//no는 0으로 둔다-> 자동 sequence로 입력되니까
		Address insertAddress=new Address(0, "추가이름1", "추가번호1", "추가주소1");
		System.out.println(insertAddress.getAddress());
		dao3.insert(insertAddress);
		
		System.out.println("2. update");
		Address updateAddress=new Address(2, "변경이름", "변경번호", "변경주소");
		dao3.update(updateAddress);
		
		System.out.println("3. find by no");
		dao3.FindByNo(2);
		
		
		
	}

}
