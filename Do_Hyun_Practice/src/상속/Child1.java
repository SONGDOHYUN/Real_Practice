package 상속;

public class Child1 extends Child2{ 
	//Child1은 Child2를 상속받기 떄문에 부모의 멤버필드, 메소드(오버라이딩 해서) 사용가능함 
	//Child1은 Child2, Parent 클래스 모두 사용 가능함
	
	//멤버필드
	public int member3;
	public int member4;
	
	//멤버메소드
	public void method3() { //선언부
		System.out.println("Child1.method3()을 출력합니다."); //구현부
	}
	
	public void method4() {
		System.out.println("Child1.method4()를 출력합니다.");
	}
	
}
