package Practice_1;

import 제한자_final.Product;

/*
 * 1. 추상클래스란? : 하나 이상의 추상 메소드가 있는(정의되어있는) 클래스 -> public abstract className{}
 * -> public + abstract + class/void + 클래스이름/메소드이름
 * -> 실체 클래스의 공통적인 부분들을 추출해 어느정도 규격만 잡아놓은 클래스라고 보면 됨
 * -> 추상적인 데이터를 갖고 있는 클래스
 * -> 객체 생성 안됨 : 아직 메소드와 내용이 추상적이라서
 * 
 * 1-1. 추상 클래스 사용 방법: 자식이 상속 받게 하면 됨->그러면 추상 메소드 재정의(오버라이딩) 한 뒤 객체 생성할 수 있음
 * 
 *   ex> public abstract class Test{
         	//추상메쏘드();
         	public abstract int print(int i);
         	//구현된메쏘드();
         	public void test(){
         	}
         }
         	
 * 1-2. 추상클래스에서 업캐스팅(조참자객)이 될까? 부모 클래스는 객체를 생성 못한다며
 * -> 업캐스팅은 자식 객체를 부모타입 변수가 참조한 뒤 부모 타입으로 형변환해서 부모 클래스만 사용할 수 있는것임
 * -> 애초에 업캐스팅을 하려면 자식 클래스에서 객체를 생성할 수 있어야하는데 
 *    추상 부모 클래스를 상속받은 자식 클래스는 부모클래스의 추상 메소드를 ★★★★★무조건, 반드시 온전하게 재정의(오버라이딩)해야함★★★★★
 *    그러면 업캐스팅 큰 원리 중 부모 클래스만 접근 가능하더라도 오버라이딩 된 자식클래스의 메소드가 있으면 해당 메소드가 출력된다고 했다.
 *    따라서 부모 클래스에서 추상 메소드는 결국 자식 클래스에서 온전하고 또 결과적으로 온전한 메소드가 출력되므로 업캐스팅이 가능한 것이다. 
 * 
 * 
 * 2. 추상 문법
 * -> abstract+ 클래스명/메소드명
 * -> 상속 해서 재정의 무조건!!! 해줘야 사용 가능함!!
 * 
 * 2-1. 추상 메소드
 * -> 메소드의 선언부만 있고 구현부는 없음 ->오버라이딩 문법이랑 비슷: 선언부는 그대로 가져오고 구현부는 하고 싶으면 수정함
 * -> 이유: 추상 클래스를 상속받는 자식 클래스의 주제?에 따라서 상속받는 메소드의 내용이 달라지기 때문
 * -> 부모클래스(추상클래스)에서는 선언부만 작성하고 자식 클래스에서 구현부 작성하게 함
 * -> public abstract void draw();
 * -> {}도 안적는다.
 * 
 * 2-2. 추상 클래스
 * -> 하나 이상의 추상 메소드를 포함하는 클래스
 * 
 * 2-3. 추상클래스 생성자
 * -> 추상클래스의 생성자로는 해당 추상 클래스 객체 못만든다 -> 생각해봐라. 아직 정의되지 않은 추상메소드가 있는데 어떻게 객체를 만드냐!
 * -> 따라서 상속받는 자식 클래스에서!!! 추상메소드 재정의 후 인스턴스화/객체 생성을 한다!!!
 * -> 그래도 추상클래스 생성자는 super를 통해 호출할 순 있다.
 * 
 * 
 * 3. 추상클래스의 사용
 * 3-1. 공통멤버의 통합으로 중복 제거
 * 
 * package Doodle;

public class Doodle_02 {

	public static void main(String[] args) {
		Unit[] group=new Unit[3];
		group[0]=new Marine();
		group[1]=new Tank();
		group[2]=new DropShip();
		
		for(Unit u:group) {
			u.move(100, 200); // 출력 시 걸어서 이동, 굴러서 이동, 날아서 이동 나옴
			
		}
		
	}

}
	
	abstract class Unit {
	    int x, y;
	    abstract void move(int x, int y); // 지정된 위치로 이동
	    void stop() {} // 현재 위치에 정지
	}
	
	class Marine extends Unit{
	    void move(int x, int y) {
	        System.out.println("걸어서 이동");
	    }
	    void stimPack() {} // 고유 능력 스팀팩 사용
	}
	
	class Tank extends Unit{
	    void move(int x, int y) {
	        System.out.println("굴러서 이동");
	    }
	    void siegeMode() {} // 고유 능력 시즈 모드 사용
	}
	
	class DropShip extends Unit{
	    void move(int x, int y) {
	        System.out.println("날아서 이동");
	    }
	    void loadUnload() {} // 고유 능력 탑승 사용
	}

 * 
 * 4. 제한자 Final : final 붙일 때 대문자+snake 표기법으로 쓰는게 관례임 : final int PORT_NUMBER;
 * -> 클래스앞에 붙을 경우 상속안됨
 * -> 주로 static(메모리 한번만 로딩되어 모든 접근자가 동일하게 공유가능)이랑 같이 붙여서 씀
 * 
 * -> final+class-> 클래스 자체에 final 붙으면 상속 자체를 못 받음
 *    ex) public final class Test{}
 *    
 * -> final+method-> 상속받았을 때!! 오버라이딩(재정의)못함
 *    ex) public final void method1(){};
 * 
 * -> final+변수=값; -> 그대로 값이 고정되어 변하지 않음(상수화됨: 객체 상태가 바뀌어도 해당 변수는 안바뀜)
 * 	  ex) public final int number=80; -> 상수화되어 변하지 않는 값이 됨
 * 
 * ★★★★★★★★헷갈렸던 것★★★★★★★★★★★
 * -> 객체 생성시에도 final을 붙일 수 있다
 *    ex) public static final Product product1=new Product(1, "상품1");
		  -> Product 클래스의 객체를 생성하여 product1 변수에 최초 1회만!!! 할당한 후에는 다른 값을 할당하거나 변경할 수 없음.
		  	 getter, setter를 통해 객체의 필드는 변경 가능하지만
		  	 product1로 참조가 고정된 객체에 다른 객체를 할당할 수 없음
		  	 ->예시) product1=new Product(no,name);
		  	 
		  -> 또한 public이라서 외부에서 접근 가능하고
		  -> 정적 변수(static variable)로 선언되어 클래스 수준에서 접근 가능하고(객체 생성안해도 값 사용 가능), 
		     모든 인스턴스들이 동일한 값을 참조할 수 있음    
		  
		  
 * 5. static이란?
 * -> 접근 제한자로 멤버필드나 멤버메소드 앞에 붙음(객체들이 공유하는 공통 멤버필드, 멤버메소드가 됨)
 * -> 공통적으로 적용되므로 따로 객체를 생성할 필요없이 사용가능
 * -> 형식: public static int i / public static void print(){}
 * 
 */


public class  Abstract_Final {

	public static void main(String[] args) {
		//Animal animal= new Animal();
		//추상클래스는 바로 인스턴스 객체 만들 수 없다
		Dog5 dog= new Dog5("강아지",2);
		System.out.println(dog.name);
		
	}

}

 abstract class Animal5{
	
	String name;
	
	Animal5(){
		System.out.println("부모클래스의 기본 생성자입니다.");
	}
	
	public Animal5(String name, int age) {
		this.name=name;
		System.out.println(name+age);
	}
	void sort() {
		System.out.println("추상클래스입니다.");
	}
	
}


class Dog5 extends Animal5{
	public Dog5(String name, int age) {
		super("부모강아지",1); //자식 생성자내에서 super()를 통해 부모 생성자 호출이 가능함
		this.name=name;
		System.out.println(name+age);
	}
	
	void sort() {
		System.out.println("추상클래스를 재정의했습니다.");
		
	}
}













