package 상속;

public class Child2 extends Parent{
	//Child2은 Parent를 상속받기 떄문에 부모의 멤버필드, 메소드(오버라이딩 해서) 사용가능함 
	
	
	//멤버필드
	public int member5;
	
	//멤버메소드
	public void method5() {
		System.out.println("Child2.method5()를 출력합니다.");
	}
	
}
