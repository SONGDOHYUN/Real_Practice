package Practice_1;
/*
 * 1. 변수의 종류
 * 1-1. 지역변수
 * -> 함수(메소드)안에 선언하며 함수 밖에서는 사용할 수 없음(그 지역을 벗어나면 쓸 수 없음)
 * -> A지역변수와 B지역변수의 이름이 같아도 각각 다른 변수로 인식함
 * ##예시
 * public class ScopeEx {
	int a = 25; // 멤버 변수

	public void f1() {
		int a = 10; // f1 지역
		System.out.println(a);
	}
	public void f2() {
		int a = 15; // f2 지역
		System.out.println(a);
	}
	public static void main(String[] args) {
		ScopeEx sc1 = new ScopeEx();
		sc1.f1(); // f1 지역변수 a
		sc1.f2(); // f2 지역변수 a
		int a = 20;
		System.out.println(a); // main 함수 지역변수 a
		System.out.println(sc1.a); // 멤버 변수 a
	}
}
 * 1-2. 멤버변수
 * -> 객체 생성 시 사용할 수 있음
 * 
 * 1-3. static 변수
 * -> 객체 생성안해도 사용 가능함
 * -> 클래스 영역에서 선언됨 : static 붙이면 공통으로 모두 쓸 수 있는 변수 혹은 메소드가 됨
 * -> 클래스를 메모리에 로드했을 때부터 생성됨
 * 
 * 1-3-1. static method
 * -> 정적 메소드에서는 정적 메소드나 정적 변수만 사용할 수 있음
 * -> 멤버 변수 사용할 수 없음: 왜냐면 얘네는 객체를 사용해야만 쓸 
 * 수 있으니까 당연히 정적(객체 안만듬)안에서는 쓸 수 없지
 * -> 객체 생성하기 전에는 this도 사용 못함(자기 자신 참조니까)
 * -> 멤버 변수/메소드 사용하려면 객체 생성하고 호출할 수 있음
 * 
 * 2. 싱글톤이란?
 * -> 하나의 클래스에 단 하나의 객체만 만들게 할 경우 사용함
 * -> 그리고 그렇게 만들어진 객체를 프로그램 어디서나 접근하여 사용할 수 있게 함
 * -> 이유: 원래 A라는 클래스를 생성하면 다른 B, C 클래스에서 A에 접근하려면 getter, setter를 사용하여 접근, 정보 수정함
 * -> 이럴 경우 다른 클래스에서 각자 객체를 만들게되면 B나 C 클래스에서의 A 클래스에 대한 정보 동기화/관리가 어려워짐
 * -> 따라서 싱글톤 쓰는 거임 : 정보를 보관하고 공유하는 A 클래스에 한번의 메모리만 할당하고 그 메모리를 객체로 관리하기 위함
 * 2-1. 싱글톤 만드는 방법
 * -> private 생성자(){}-> 기본 생성자를 private으로 만들어서 외부에서 생성 못하게 함
 * -> getInstance(){}사용-> 얘를 통해서만 생성 가능: 내부적으로 인스턴스 생성 없으면 생성하고 기존에 생성된 값이 존재하면 기존값 리턴함
 * -> 인스턴스를 생성하기 위한 메소드와 변수는 모두 Static이어야함-> 그래야 외부/내부 모든 클래스 다 공유할 수 있기 때문임
 * 
 * ##예시##
 * public class A {
	//전역 객체변수로 사용하기 위해 static 객체변수로 생성
	static A instance;
	
	//생성자를 priavte로 만들어 접근을 막는다
	private A(){}
	
	//getInstance 메소드를 통해 한번만 생성된 객체를 가져온다.
	public static A: 대부분 클래스 이름으로 한다 getInstance(){
		if(instance == null){ //최초 한번만 new 연산자를 통하여 메모리에 할당한다.
			instance = new A();
		}		
		return instance;
	}
}
 * 
 * public class B {
	public B() {}
    }
 * 
 * public class Main {

	public static void main(String[] args) {
    
   // getInstance() 메소드를 이용하여 변수를 달리하여, 3개의 객체를 불러옴
		A a1 = A.getInstance();
		A a2 = A.getInstance();
		A a3 = A.getInstance(); 

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3); ->단 하나의 객체를 a1, a2, a3가 가져가고 있어서 주소값 출력시 세개 다 같게 나옴

		// 일반적으로 new 생성자를 이용하는 방법을 사용하여, 3개의 객체를 불러옴
		B b1 = new B();
		B b2 = new B();
		B b3 = new B();

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		-> b1, b2, b3 세개 다 다른 주소값을 가짐

	}
}
 * 2-3. synchronized
 * -> 멀티스레드 환경에서 공유하는 데이터가 동기화 되어 있지 않으면 data의 안정성 보장 못함
 * -> 이럴 때 synchronized 사용하여 현재 데이터 사용하는 스레드 제외하고 나머지는 데이터에 접근 못하게 함
 * 
 * 
 * 3. 접근제한자란?
 * -> 즉 private로 정보 은닉하고 public으로 사용자나 프로그램 사이의 인터페이스를 구축함
 * -> 클래스 외부에서의 직접적인 접근을 허용하지 않는 멤버를 설정하여 정보 은닉을 구체화할 수 있음
 * 
 * 3-1. private: 외부로 공개 안되며 같은 클래스만 접근 허용 [P-D-P-P]
 * -> 해당 객체의 public 메소드를 통해서만 접근할 수 있음!!(인터페이스 역할: 다른 클래스 작성 기본틀 제공 및 다른 클래스 사이의 중간 매개 역할 하는 추상클래스)을 한다고 볼 수 있음
 * 3-2. default: 같은 패키지일 때 접근 가능 [같-패]
 * 3-3. protected: 같은 패키지, 다른 패키지 자식까지 접근 가능 [다-패-자]
 *      -> !!!!!!부모 클래스!!!!!!의 필드에 protected 적어놓으면
 *         그 클래스를 extends하는 자식 클래스에서 사용 가능 
 *         이때 자식클래스 in 같은 패키지, 다른 패키지 가능함
 *      
 *      
 * 3-4. public: 외부로 공개되며 해당 객체를 사용하면 어디서나 접근가능함
 * 
 * 3-5. 강사님의 접근제한자 추가 설명
 *  * 클래스의 접근을 제한하는 제한자
 * 		1. 클래스의 접근제한
 * 			    A. public  : 외부모든 클래스(객체)에서 접근가능
 * 			    C.(default): 같은패키지에있는 클래스(객체)에서 접근가능	
 * 						     다른패키지에있는 클래스(객체)에서 접근불가능					
 * 
 *      2. 클래스의 멤버(필드,메쏘드,생성자)의 접근제한
 *      3. 접근제한자(public,protected,(default),private) 
 *      	A.public    : 외부모든 클래스(객체)에서 접근가능
 *          B.protected : 같은패키지에있는 모든클래스(객체) 에서접근가능
 *                        다른패키지에있는 모든클래스(객체) 에서접근불가능
 *                        다른패키지에있는 상속관계에있는 자식클래스에서접근가능
 
 *          C.(default) : 같은패키지에있는 모든클래스(객체) 에서접근가능
 *          			  다른패키지에있는 모든클래스(객체) 에서접근불가능
 * 			D.private   : 외부모든 클래스(객체)에서 접근 불가능
 * 
 * 
 * 
 * 4. Getter와 Setter란?
 * -> 자바에서는 데이터(DB 등등)를 외부에서 접근하는 것 꺼려함 : 맘대로 바꾸면 무결성 깨지니까
 * -> 따라서 메소드로 데이터 변경하는 걸 선호함-> 데이터는 공개 안하고 메소드만 공개해서 메소드를 통해 데이터에 접근하도록 함
 * -> 그래서 클래스 선언시 멤버변수(멤버필드)를 private 선언해서 외부로부터 보호하고-> 그 멤버필드에 대한 Getter & Setter method 작성해서 필드값을 안전하게 변경 & 사용하는 게 좋음
 * 
 * 4-1. Getter & Setter 선언 방식
 * 4-1-1. Getter: 데이터 읽어옴
 * -> public+리턴타입+메소드이름[get+멤버필드이름(FieldName):대문자로 시작, boolean 타입이면 is로 시작하는게 관례임]
 * -> 리턴값: 필드값/이름(FieldName)
 * 
 * 4-1-2. Setter: 데이터 수정함(선언된 멤버필드 값을 수정할 때 사용)
 * -> public+void+메소드이름[set+멤버필드이름](매개변수: 필드타입)
 * ##예시
 * private 타입 fieldName;
 * 
  //Getter
 * public 타입 getFieldName(){
 * 	return 타입+fieldName;
 * }
  //Setter
 * public void setFieldName(타입 fieldName){
 * 	this.fieldName=fieldName;
 * }
 * 
 * ##예시
 * 
 * public class Car {
	
	
	private String name; //클래스에서만 접근가능한 멤버변수(객체를 사용해야만 사용할 수 있는) 선언
	private int doorCount;
	
	public String getName() { //데이터 가져와야하니까(읽어야하니까) 해당 멤버필드 리턴하게 작성
		return name;
	}
	
	public void setName(String name) { //데이터 변경해야하니까 해당 데이터 매개변수로 갖고 매개변수 대입하는 식 있게 작성
		this.name=name;
	}
	
	public int getDoorCount() {
		return doorCount;
	}
	
	public void setDoorCount(int doorCount) {
		this.doorCount=doorCount;
	}
	
	private Car(String name,int doorCount){ 
		setName(name);
		setDoorCount(doorCount); //생성시 데이터 초기화하게끔(데이터 변경) setter 사용함
	}

	
	
	public static void main(String[] args) {
		Car car=new Car("자동차1", 4); //setter를 통해 car 객체에 자동차1, 4라는 값이 저장됨->출력코드는 없어서 출력 안됨
		System.out.println(car); // 주소값출력
		car.getName(); //name값 가져오고(getter) 반환만 하는거라 출력은 안됨
		System.out.println(car.getName()); //자동차 1 출력됨
		System.out.println("자동차 이름:"+car.getName()); //자동차1 출력됨
		System.out.println("문의 개수:"+car.getDoorCount());//4 출력됨
	}

}
 * 
 * 
 * 5. final : 바뀌지 않는 값
 * -> 주로 static(메모리 한번만 로딩되어 모든 접근자가 동일하게 공유가능)이랑 같이 붙여서 씀
 * -> final+class-> 상속 못받음
 * -> final+method-> 상속받았을때 오버라이딩(재정의)못함
 * -> final+변수=값; -> 그대로 값이 고정되어 변하지 않음(객체 상태가 바뀌어도 해당 변수는 안바뀜)
 * 
 * 6. static이란?
 * -> 접근 제한자로 멤버필드나 멤버메소드 앞에 붙음(객체들이 공유하는 공통 멤버필드, 멤버메소드가 됨)
 * -> 공통적으로 적용되므로 따로 객체를 생성할 필요없이 사용가능
 * -> 형식: public static int i / public static void print(){}
 * 
 * 
 * 7. if문
 * 
 * 7-1. if-do-while 문
 * 
 * -> if (condition)
	    do {
	        // 작업 수행
	    } while (false);
	    
 * -> if 조건이 true면 do 실행 후 while이 false면 if문 빠져나옴, while이 true면 do-while 계속 실행됨
 * 
 * 7-2. if-finally 문
 * 
 * -> if (condition) {
    // 조건이 참인 경우에 수행되는 작업
		} finally {
		    // 항상 수행되어야 하는 작업
		}
 * 
 * 
 */

public class Variable_01 {
	int a=10; //멤버변수: 객체 생성 시에만 사용할 수 있음
	public static int b; //static변수(클래스 변수): 객체 생성안해도 사용 가능함->모든 변수들이 공유할 수 있음
	public static final int c=50;
	
	
	public void method1() {
		b++;
	}
	public static String method2() {
		return "정적 메소드입니다";
		//method1(); 정적 메소드안에서 클래스/멤버 변수/메소드 사용할 수 없음
	}
	
	public static void main(String[] args) { //이것도 static이 붙었으니 정적 메소드: 모두 공용으로 사용할 수 있는 메소드임
		int a=20;
		Variable_01 variable_01=new Variable_01();
		Variable_01 variable_02=new Variable_01();
		//System.out.println(a); // main 함수의 지역변수 값 출력됨: 20
		//System.out.println(variable_01.a); //variable_01 클래스의 멤버 변수 사용한 것: 10
		
		//method1(); -> 마찬가지로 main 메소드도 static이라서 클래스 메소드 사용 못함
		variable_01.method1(); //그렇지만 객체 만들면 사용 가능함
		System.out.println(variable_01.b); //1->원래 b는 0이었지만 b++돼서 1됨-> 이 값은 static int 값이므로 이제 모든 메소드에서 사용할 수 있는 b의 값은 1부터임
		variable_02.method1();
		System.out.println(variable_02.b); //2->b가 1에서 b++됨-> 따라서 b=2가 출력됨
		
		String a1=method2(); //static이라서 객체 안만들어도 사용가능함
		String a2=variable_01.method2(); //물론 객체 만들어도 사용가능함
		String a3= variable_01.method2();
		System.out.println(a1+","+a2+","+a3);
		
		//variable_01.c=60; 객체 만들고 변경하려해도 final 붙어서 변경 못함
		
	}

}
