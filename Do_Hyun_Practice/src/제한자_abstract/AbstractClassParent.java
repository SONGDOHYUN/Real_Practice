package 제한자_abstract;

public abstract class AbstractClassParent {
	//추상메소드-> 구현부를 위한 "{}"도 안씀
	public abstract void abstractMethod1();
	
	//일반 메소드
	public void method2() {
		System.out.println("부모 클래스의 구성된(concrete)고유 메소드 입니다.");
	}
}
