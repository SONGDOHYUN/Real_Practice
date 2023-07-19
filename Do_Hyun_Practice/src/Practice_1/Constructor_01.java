package Practice_1;
/*
 * 1. 생성자란? [호출방법: 클래스();]
 * -> 클래스 이름과 동일한 메소드로 객체 생성 시 초기화 역할함(객체 생성할 때 딱 한번만 호출+제일 먼저 실행됨)
 * -> 리턴 타입 없음/ 상속 안됨
 * -> 파라미터랑 개수를 다르게 해서 여러개 정의할 수 있음 ->이렇게 여러개 생성자 만드는게 "오버로딩"임
 * 
 * 2. 오버로딩이란?
 * -> 생성자를 두개 이상 구현하는 것
 * -> 파라미터 타입과 개수를 다르게 해서 여러개 정의할 수 있음
 * -> 오버로딩하면 기본생성자는 제공되지 않음 -->>기본 생성자 코드를 명시하는 습관 갖는 게 좋다.
 * 
 * 2-1. 오버로딩 규칙?
 * - 메소드의 이름이 같음
 * - 메소드의 인자 숫자가 다름
 * - 메소드의 인자 타입이 다름
 * - 메소드의 리턴타입, 접근제한자는 상관 없음
 * 
 * 3. this란? ###주의###--this랑 this()는 다른거임!
 * 
 * 3-1. this: 객체(인스턴스) 자기 자신/자기 참조를 의미함
 * -> 주로 (클래스 필드 변수 이름 == 메소드, 생성자의 매개변수 이름)이 동일할 때 인스턴스 필드임을 명확히 하기 위해 사용함
 * -> static에서는 this 사용 못함-> 참조/객체 생성 안되니까 당연
 * public class Car {
	String name;
	String gearType;
	int doorCount;
	
	Car(String name, String gearType){
		this.name=name;  name=name;이라고 쓰면 되는데 헷갈리니까 class Car의 멤버필드 중 name이라는 변수에 String name이라는 매개변수를 대입하겠다~라는 뜻
		this.gearType=gearType;
		(인스턴스 변수=매개변수)
		System.out.println(name+gearType);
	}
	
	public static void main(String[] args) {
		Car car=new Car("자동차","자동");
		//여기서 f11 누르면 "자동자차동" 출력됨
	}

}
 * 
 * 3-2. this(): 같은 클래스의 다른 생성자[오버로딩 시]를 호출할 때 사용됨
 * 
 * 
 * public class Car {
	String name;
	String gearType;
	int doorCount;
	
	Car(String name, String gearType){
		this.name=name;
		this.gearType=gearType;
		System.out.println(name+","+gearType);
	}
	
	Car(String name,String gearType, int doorCount){
		this.name=name;
		this.gearType=gearType;
		this.doorCount=doorCount;
		System.out.println(name+","+gearType+","+doorCount);
	}
	
	Car(String name){
		this(name,"수동");
		//인자 2개니까 파라미터 2개인 생성자로 대입돼서 결과 출력됨
	}
	
	Car(String gearType, int doorCount){
		this("자동차2",gearType,doorCount);
		//인자 개수 3개니까 파라미터 3개인 생성자로 대입돼서 결과 출력됨
	}
	
	Car(){
		this("자동차3","자동",1);
		//인자 3개니까 파라미터 3개인 생성자로 대입돼서 결과 출력됨
	}
	
	public static void main(String[] args) {
		Car car=new Car("자동차2");
		System.out.println(car);
		->자동차2, 수동 찍히고 car의 객체 주소 찍힌다.
		
	}

}
 * 
 * 4. 초기화
 * -> 생성자를 사용해서 초기화
 * -> 초기화 블록 사용: static block, instance block
 * 4-1. static block (이렇게 선언함:"static block{}")
 * -> 클래스 로딩될 때 딱 한번만 호출됨, 객체 생성안해도 호출돼서+생성되기전에 호출돼서 인스턴스 멤버에는 접근못함  
 * -> 클래스 로딩 후 스태틱 블록 먼저 호출되고 그 다음 호출된 작업 수행함
 * 
 * 
 * 
 * 
 */

public class Constructor_01 {
	int intConstructor=1;
	String stringConstructor="문자열입니다.";
	boolean booleanConstructor;
	
	static int x; //기본값 0임
	
	//static 초기화 블록
	static {
		method2();
		x++;
		System.out.println("x의 값:"+x);
	}
	
	
	public void method1() {
		System.out.println("method1을 출력했습니다.");
	}
	//static method
	public static void method2() {
		System.out.println("method2를 출력했습니다.");
	}
	
	Constructor_01() {
		intConstructor=2;
		stringConstructor="파라미터없는 생성자의 문자열입니다.";
		booleanConstructor=false;
		System.out.println("int 값:"+intConstructor+", string값:"+stringConstructor);
	}
	
	Constructor_01(int c,String d) {
		intConstructor=3;
		stringConstructor="d의 값은 어디있을까요";
		booleanConstructor=true;
		System.out.println("intConstructor의 값:"+intConstructor+",stringConstructor:"+stringConstructor);
		System.out.println("int 값:"+c+", string값:"+d);
	}	//따로 파라미터 c 값을 받을 변수는 저장 안해놨는데도 출력이 된다..!
	
	
	
	public static void main(String[] args) {
		int a=100;
		String b="string 값이 있는 생성자를 호출해보겠습니다.";
		Constructor_01 constructor_01=new Constructor_01(a,b);
		System.out.println(constructor_01);
		System.out.println(x); 
		method2(); //method2만 출력됨
				
	}

}
