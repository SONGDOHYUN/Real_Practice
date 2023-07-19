package 상속;

public class ParentChild12Main {

	public static void main(String[] args) {
		
		System.out.println("--Child1--");
		Child1 child11=new Child1();
		
		//원래 Child1의 멤버필드
		child11.member3=3333;
		child11.member4=4444;
		
		//상속받은 Parent 클래스 사용
		child11.member1=1212;
		child11.method1();
		
		//상속받은 Child2 클래스 사용
		child11.member5=5252;
		child11.method5();
		
		
		System.out.println("--Child2--");
		Child2 child22=new Child2();
		
		//원래 Child2의 멤버필드, 멤버 메소드
		child22.member5=3333;
		child22.method5();
		
		//상속받은 Parent 클래스 사용
		child22.method1();
		child22.method2();
		child22.member1=1111;
		
		
	}

}
