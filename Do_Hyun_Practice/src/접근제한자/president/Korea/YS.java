package 접근제한자.president.Korea;

import 접근제한자.president.America.Trump;

public class YS {
	//고유 멤버필드
	public int member1;
	protected int member2;
	int member3;
	private int member4;
	
	//기본 생성자
	protected YS() {
	}
	
	//고유메소드
	public void method1() {
		System.out.println("YS.method1()");
	}
	protected void method2() {
		System.out.println("YS.method2()");
	}
	void method3() {
		System.out.println("YS.method3()"); 
	}
	private void method4() {
		System.out.println("YS.method4()");
	}
	
	public void access() {
		DJ dj=new DJ();
		dj.member3=3; //member4는 접근이 private이라 안됨
		dj.method3(); //method4는 접근이 private이라 안됨
		
		Trump trump=new Trump();
		trump.member1=1; //public이라서 이것만 가능함
		
	}
	
	
}
