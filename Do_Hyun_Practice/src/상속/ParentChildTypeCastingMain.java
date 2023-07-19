package 상속;

class Parent4{
	public void method1() {
		System.out.println("부모클래스 고유 method1 입니다");
	}
	
	public void method2() {
		System.out.println("부모클래스 고유 method2 입니다");
	}
	
	public void method3() {
		System.out.println("부모클래스 고유 method3 입니다");
	}
	
}


class Child4 extends Parent4{
	public void childMethod1() {
		System.out.println("자식클래스 고유 childMethod1 입니다");
	}
	
	public void childMethod2() {
		System.out.println("자식클래스 고유 childMethod2 입니다");
	}
	
	@Override
	public void method1() {
		System.out.println("부모클래스 method1()을 자식클래스에서 오버라이딩 했습니다");
	}
}


public class ParentChildTypeCastingMain {

	public static void main(String[] args) {
		System.out.println("--Child 클래스에 대해 알아봅시다--");
		Child4 child1= new Child4();
		//-> Child4 타입의 child1 변수에(Child4 클래스의 객체 주소를 저장할 수 있음) 
		//   new Child4()에서 객체를 생성했고 그 주소값을 child1 변수에 담았다!라는 뜻
		//   이렇게 되면 child1을 Child4의 객체라고 봐도 되고 객체를 참조한다(해당 객체의 주소값을 참조하는 변수라고 인식해도 됨)고 봐도 됨  
		child1.method2();
		child1.method1();
		child1.childMethod1();
		System.out.println();
		
		System.out.println("--업캐스팅을 해봅시다--");
		Parent4 parent1=new Child4();
		parent1.method1();
		
		//parent1.childMethod1(); ->업캐스팅 돼서 못씀
		//((Child4)parent1).childMethod1();->이렇게 하면 쓸 수 있음: 이게 곧 다운 캐스팅임
		
		System.out.println();
		
		System.out.println("--다운캐스팅을 해봅시다 + instance of 연산자 사용--");
		if(parent1 instanceof Child4) {
			System.out.println("다운캐스팅해도 됩니다.");
		}else System.out.println("다운캐스팅 못합니다.");
		
		Child4 child2=(Child4)parent1;
		child2.childMethod1();
		child2.method3();
		child2.method1();
	}

}
