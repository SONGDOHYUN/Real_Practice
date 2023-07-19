package 접근제한자.president.Korea;

public class DJ {
	
	//고유 멤버필드
	public int member1;
	protected int member2;
	int member3;
	private int member4;
	
	//고유 메소드
	public void method1() {
		System.out.println("DJ.method1()");
	}
	protected void method2() {
		System.out.println("DJ.method2()");
	}
	void method3() {
		System.out.println("DJ.method3()");
	}
	private void method4() {
		System.out.println("DJ.method4()");
	}

	
}
