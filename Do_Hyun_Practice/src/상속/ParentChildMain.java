package 상속;

class Parent1 extends Object{
	private int member1;
	private int member2;
	
	//기본 생성자
	public Parent1() {
		super();
		System.out.println("1. Object() 기본생성자");
		System.out.println("2. Parent1() 기본생성자");
	}

	//생성자 오버라이딩
	public Parent1(int member1, int member2) {
		super();
		this.member1 = member1;
		this.member2 = member2;
		System.out.println("1. public Object() 생성자 호출");
		System.out.println("2. public Parent1(int member1, int member2)생성자 호출");
	}
	
	public void method1() {
		System.out.println("Parent1.고유 method1()");
	}
	
	public void method2() {
		System.out.println("Parent1.고유 method2()");
	}
	
	public void print() {
		System.out.println(this.member1+"\t"+this.member2);
	}
	
	//getter, setter
	public int getMember1() {
		return member1;
	}

	public void setMember1(int member1) {
		this.member1 = member1;
	}

	public int getMember2() {
		return member2;
	}

	public void setMember2(int member2) {
		this.member2 = member2;
	}
	
}

class Child3 extends Parent1{
	private int member3;
	
	public Child3() {
		super();
		System.out.println("Child3.기본생성자()");
	}
	
	public Child3(int member1, int member2, int member3) {
		super(member1, member2);
		this.member3=member3;
		System.out.println("public Child3(int member1,int member2,int member3)생성자호출");
	}
	
	public void method3() {
		System.out.println("Child3.고유 method3()");
	}
	
	@Override
	public void method1() {
		super.method1();
		System.out.println("Child3에서 Parent1.method1()재정의함");
	}
	
	@Override
	public void print() {
		super.print(); 
		//->이건 필요없으면 지워도 됨->재정의할때는 선언부만 같으면 되고 구현부는 맘대로 변경 가능함
		System.out.println("Child3에서 Parent.print()재정의함: "+this.member3);
	}
	
	//getter, setter
	public int getMember3() {
		return member3;
	}

	public void setMember3(int member3) {
		this.member3 = member3;
	}
	
	
}

public class ParentChildMain {
	public static void main(String[] args) {
		System.out.println("--Parent 시작해보겠습니다--");
		Parent1 pt1=new Parent1(); //기본생성자로 초기화
		System.out.println("pt1.member1: "+pt1.getMember1()); //0
		Parent1 pt2=new Parent1(1, 2); //오버라이딩된 생성자로 초기화
		System.out.println("pt2.member1: "+pt2.getMember1()); //1
		System.out.println();
		
		System.out.println("--Child 시작해보겠습니다--");
		Child3 ch1=new Child3(); //기본 생성자 Object, Parent1, Child3 주르륵 뽑히는거 확인함
		System.out.println("ch1.member1: "+ch1.getMember1()); //0
		System.out.println("ch1.member3: "+ch1.getMember3()); //0
		
		Child3 ch2=new Child3(5, 6, 7); //오버라이딩된 생성자 순서대로 주르륵 뽑히는 거 확인함
		System.out.println("ch2.member1: "+ch2.getMember1()); //5
		System.out.println("ch2.member3: "+ch2.getMember3()); //7
		
		System.out.println("--오버라이딩된 메소드를 출력해보겠습니다--");
		ch1.print();
		ch2.print();
		
	}

}
