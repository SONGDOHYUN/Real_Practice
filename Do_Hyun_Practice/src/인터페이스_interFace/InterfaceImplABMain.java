package 인터페이스_interFace;

public class InterfaceImplABMain {

	public static void main(String[] args) {
		System.out.println("--interfaceABImpl--");
		
		//인터페이스는 생성자 없어서 객체 생성 못함->인터페이스를 implement하는 클래스를 통해서 객체 생성 가능
		InterfaceImplAB implAB1=new InterfaceImplAB();
		implAB1.method1();
		implAB1.method3();
		
		System.out.println("--interfaceA--");
		//인터페이스 다형성- 업캐스팅
		
		InterfaceA interfaceA=new InterfaceImplAB();
		interfaceA.method1(); //InterfaceA 인터페이스의 필드만 쓸 수 있음->오버라이딩 된 메소드는 자식꺼로 실행됨
		
		//인터페이스 다형성- 다운캐스팅
		if(interfaceA instanceof InterfaceImplAB) {
			System.out.println("다운 캐스팅이 가능합니다.");
		}else System.out.println("다운 캐스팅을 할 수 없습니다.");
		
		InterfaceImplAB implAB2 =(InterfaceImplAB)interfaceA;
		implAB2.method1();
		implAB2.method4();
		System.out.println();
		
		System.out.println("--InterfaceA<--->InterfaceB--");
		//조참자객
		InterfaceA interA=new InterfaceImplAB(); //InterfaceA 필드만 사용 가능
		InterfaceB interB=new InterfaceImplAB(); //InterfaceB 필드만 사용 가능
		System.out.println("형변환 전 interA의 주소값: "+interA);
		System.out.println("형변환 전 interB의 주소값: "+interB);
		
		//오버라이딩 된 메소드 실행됨
		interA.method1();
		interB.method3();
		
		//인터페이스끼리 형변환
		interB=(InterfaceB) interA; 
		//interA의 객체를 InterfaceB의 타입으로 형변환하여 InterfaceB의 필드를 사용하겠다는 뜻
		
		/*
		 * ★★★★★★★★★★★★★★★★★★!!헷갈렸던 부분!!★★★★★★★★★★★★★★★★★★
		 * 
		 * interB=(InterfaceB) interA; 코드를 통해 
		   interA가 InterfaceB 타입으로 형변환되면서 interB 변수는 interA를 참조하게 됨. 
		   이로 인해 interB는 InterfaceB의 메소드와 필드에 접근할 수 있게 됨!
  		   
  		   큰원리: 기본적으로 인터페이스 타입으로 참조하는 변수는 해당 인터페이스에 선언된 메소드와 필드만 접근 가능함 
  		         따라서 interA는 InterfaceA 타입으로 선언된 변수이므로 
  		         InterfaceA에 선언된 메소드와 필드에만 접근 가능했음. 
  		         그러나 interB는 InterfaceB 타입으로 형변환된 변수이므로 
  		         InterfaceB에 선언된 메소드와 필드에도 접근할 수 있음.

				 즉, interB를 통해 InterfaceB의 필드를 사용할 수 있는데, 
				 형변환을 통해 interA를 InterfaceB로 다루고, 
				 해당 인터페이스에 정의된 메소드와 필드에 접근할 수 있게 함으로써 
				 interA의 기능을 확장하는 것임!!!!!!!!!!!
		 */
		
		System.out.println("형변환 후 interA의 주소값: "+interA);
		System.out.println("형변환 후 interB의 주소값: "+interB); //주소값 interA 객체의 주소로 바뀐 거 확인함
		
		//이건 가능함! 주체인 ★★★★★interB가 InterfaceA에 접근 가능한지를 봐야함★★★★★
		interA.method1();
		//interB.method1(); ->이건 안됨: interB(주체)로 InterfaceA의 method1()을 쓰려면 interB를 InterfaceA타입으로 형변환해야함
		((InterfaceA)interB).method1();
		//아니면 그냥 밑에처럼 써도 됨!
		interA.method1();
		
		
		
	}

}
