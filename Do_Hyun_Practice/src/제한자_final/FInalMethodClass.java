package 제한자_final;

public class FInalMethodClass {
	//고유메소드
	public void method1() {
		System.out.println("고유한 method1()입니다");
	}
	
	//고유 final 메소드->상속 시 오버라이딩 안됨, class 자체가 final일때는 상속도 안됨!
	public final void method2() {
		System.out.println("고유한 final method2()입니다->상속 시 오버라이딩 안됩니다");
	}
	
}
