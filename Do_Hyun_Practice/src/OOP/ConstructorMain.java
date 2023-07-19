package OOP;

public class ConstructorMain {

	public static void main(String[] args) {
		Constructor con1= new Constructor();
		System.out.println("---기본 생성자 사용 시작---");
		con1.print();
		System.out.println("---기본 생성자 사용 끝---");
		
		Constructor con2=new Constructor(3, 4);
		System.out.println("-------오버로딩 생성자 사용 시작------");
		con2.print();
		System.out.println("-------오버로딩 생성자 사용 끝------");
	}

}
