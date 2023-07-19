package 접근제한자.president.America;

import 접근제한자.president.Korea.YS;

public class Trump extends YS{
	//고유 멤버필드-> 접근제한자[P-D-P-P] 사용
	public int member1;
	protected int member2;
	int member3; //default는 생략 가능
	private int member4;
	
	//고유 메소드
	public void method1() {
		System.out.println("접근제한자 publid method1() 입니다.");
	}
	
	protected void method2() {
		System.out.println("접근제한자 protected method2() 입니다."); //같패, 다패자까지 가능
	}
	
	void method3() {
		System.out.println("접근제한자 default method3() 입니다."); //같은 패키지에서만 가능
	}
	
	private void method4() {
		System.out.println("접근제한자 private method4() 입니다."); //같은 클래스에서만 가능
	}
	
	public void access() {
	}
	
}
