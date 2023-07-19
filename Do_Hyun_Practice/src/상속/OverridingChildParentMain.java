package 상속;
class OverridingParent{
	//멤버 메소드
	public void method1() {
		System.out.println("OverridingParent.method1()");
	}
	
	public void method2() {
		System.out.println("OverridingParent.method2()");
	}
}



class OverridingChild extends OverridingParent{
	//고유 메소드
	public void method3() {
		System.out.println("OverridingChild.method3()");
	}
	
	@Override
	public void method1() {
		//super.method1();
		System.out.println("child가 오버라이딩하여 출력하는 코드입니다.");
	}
}


public class OverridingChildParentMain {

	public static void main(String[] args) {
		OverridingParent parent=new OverridingParent();
		OverridingChild child=new OverridingChild();
		parent.method1();
		child.method1();
		child.method3();
		
		
		
		
		
	}

}
