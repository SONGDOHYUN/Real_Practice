package 인터페이스_interFace;
/*
 * -Extends: 클래스끼리의 상속일 때
 * -Implements: 클래스-인터페이스끼리의 상속일 때
 * ->큰 원리: 추상 클래스나 인터페이스(=추상 인터페이스)를 상속받을 땐 해당 클래스나 인터페이스의 모든 추상 메소드를 오버라이딩 해야함
 */

public class InterfaceImplAB extends Object implements InterfaceA, InterfaceB{
	//기본적으로 모든 클래스는 Object 클래스를 상속함
	//인터페이스는 여러개를 implement할 수 있음-> 다중 상속 가능함
	
	//기본 생성자
	public InterfaceImplAB() {
	}
	
	
	@Override
	public void method1() {
		System.out.println("interfaceA의 추상 method1()을 오버라이딩 합니다.");
	}
	
	@Override
	public void method2() {
		System.out.println("interfaceA의 추상 method2()를 오버라이딩 합니다.");
	}
	
	
	@Override
	public void method3() {
		System.out.println("interfaceB의 추상 method3()를 오버라이딩 합니다.");
	}

	@Override
	public void method4() {
		System.out.println("interfaceB의 추상 method3()을 오버라이딩 합니다.");
	}
	
	@Override
	public void method5() {
		
	}
	
	
}
