package 내부클래스;

public class OuterClass {
	//멤버필드
	public int outer_member_field=8888;
	
	//멤버 메소드
	public void outer_member_method() {
		System.out.println("OuterClass의 고유 메소드입니다");
	}
	
	//외부 클래스에서 내부 클래스 접근 메소드 만듬-> 객체 생성해서
	public void outer_inner_class_user() {
		InnerClass ic=new InnerClass();
		ic.inner_member_field=1111;
		ic.inner_member_method();
		System.out.println("ic의 주소값은: "+ic);
		System.out.println("ic의 멤버필드 값은: "+ic.inner_member_field);
	}
	
	
	//중첩 클래스 만들기: public 붙임
	public class InnerClass{
		//멤버필드
		public int inner_member_field=3333;
		//멤버 메소드
		public void inner_member_method() {
			System.out.println("OuterClass의 중첩 클래스인 InnerClass의 고유 메소드입니다");
		}
		
		//내부 클래스에서 외부 클래스에 접근->이때는 굳이 객체 안만들어도 됨: 포함관계니깐
		public void inner_outer_user() {
			System.out.println(InnerClass.this);
			System.out.println(OuterClass.this);
			outer_member_field=2222;
			outer_member_method();
		}
		
		
		
	}
	
	
	
	
	
	
	
}

//이런식으로 한 자바 파일에 독립적인 외부 클래스 2개 만들 수 있었음, main 클래스는 public 붙은 클래스
class OuterClass1{
	class InnerClass2{
		
	}
}