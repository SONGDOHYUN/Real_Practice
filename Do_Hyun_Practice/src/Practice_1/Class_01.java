package Practice_1;

import java.util.Arrays;

/*
 * 1. Class란?
 * -> 클래스는 객체라는 걸 만들기 위한 확장 가능한 템플릿임: 처음 설정 뿐 아니라 필요 시 변수/메소드를 추가할 수 있다는 뜻!
 * -> 변수와 메소드 구현에 대한 초기값을 제공함
 * -> 객체를 만들기 위한 설계도-> 클래스 = 속성+메소드
 * 
 * 2. 객체란?
 * -> 온라인 쇼핑에는 카트, 고객, 제품 객체가 있고 주문, 결제, 할인 등의 동작을 지원받는다.
 * -> 상태(데이터)와 동작(코드)부분이 있음
 * -> A 클래스에서 변수, 메소드를 정의하면 다음 메인 메소드나 다른 B 클래스에서
 *    A 클래스의 객체를 만들어야 A 클래스에 정의된 변수와 메소드를 사용할 수 있음
 *    
 * 3. 인스턴스란?
 * -> 클래스로 만들어진(메모리를 가지게 된) 객체
 * 
 * 4. 속성이란?[=property, 멤버변수, 특성(attribute),필드, 상태]
 * -> 객체의 상태 : 예를 들어 스마트폰의 크기, 길이, 색상 등
 * -> 클래스 내에 있는 변수임. 일반 변수는 해당 메소드/생성자에서만 사용되지만 얘는 객체가 소멸될 때까지 존재함
 * 
 * 5. 메소드란?[=클래스 함수, 멤버함수]
 * -> 클래스에 종속되어 객체 생성 후 특정 작업을 수행/행위를 구현하기 위한 명령문의 집합
 * -> 클래스에 종속되어 있기 떄문에 객체 생성 후에 사용할 수 있음
 * -> 접근제어자+반환타입+메소드 이름+매개변수 목록+구현부로 이루어져 있음
 * 
 * -> ##리턴 타입이 void 면 return 문 따로 입력할 필요 없다.
 * -> 리턴타입 없으면 객체.매소드();이렇게만 적어도 됨
 * -> 리턴타입 있으면 리턴값 받을 변수=객체.메소드();이렇게 해야함
 * 
 * ##예시##
 * -> 리턴타입 있을 때
 * public class Sample {
    String say() {
        return "Hi";
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        String a = sample.say();
        System.out.println(a);  // "Hi" 출력
    }
}   -> 메소드 리턴타입이 String이라서 그냥 sample.say();로 호출하면 안되고 따로 String a라는 변수 선언해서 담아야함
 * 
 * -> 리턴타입 없을 때 
 * public class Sample {
    void sum(int a, int b) {
        System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.sum(3, 4);
    }
}  -> 리턴 타입 없어서 그냥 sample.sum();만 해도 출력됨
 * 
 * -> ##매개변수와 인자
 * -> public int method1(int a, int b : 매개변수){
 *    return a+b; }
 * -> method1(3,5 :인자);
 * -> 매개변수(선언 시): 메소드 호출 시에 어떤 입력값이 들어올 지 값의 형태를 정해준다/실제 값 아니고 형태 제시 [int a, int b]
 * -> 인자(호출 시): 매개변수에 실제로 대입되는 변수/대입될 실제 값임 [3,5]
 * 
 * -> ##파라미터에 참조타입 있을 때
 * -> vartest 메소드는 다음과 같이 Test 클래스의 객체를 입력받아 해당 객체의 객체변수 a의 값을 1 증가시키도록 했다.
 * -> 이렇게 메소드가 객체를 전달 받으면 메소드 내 객체는 전달받은 객체 그 자체로 수행된다.
 * 
 * public class Test {

    int a;  // 객체변수 a

    public void vartest(Test test) {
        test.a++;
    }

    public static void main(String[] args) {
        Test myTest = new Test();
        myTest.a = 1;
        myTest.vartest(myTest);
        System.out.println(myTest.a);
    }
}

 * 
 * 6. 생성자란? [호출방법: 클래스();]
 * -> 클래스 이름과 동일한 메소드로 객체 생성 시 초기화 역할함(객체 생성할 떄 딱 한번만 호출+제일 먼저 실행됨)
 * -> 리턴 타입 없음/ 상속 안됨
 * -> 파라미터랑 개수를 다르게 해서 여러개 정의할 수 있음 ->이렇게 여러개 생성자 만드는게 "오버로딩"임
 * 
 * 7. package
 * -> 비슷한 성격의 자바 클래스 파일을 모아놓은 것
 * -> 같은 패키지에서는 import 없이 사용 가능함
 */

//Ex.1
public class Class_01 {
	public String student1;
	public String student2;
	public int student_no;
	public boolean student_exist;
	
	void study() {
		System.out.println("공부중");
		//method
	}
	
	public void calculate() {
		System.out.println("계산중");
	}	//method
	
//	public Class_01() {
//		//생성자 1임(기본생성자임): 객체 생성 시 초기화 역할함
//		student1="송도현";
//		System.out.println(student1);
//	}
	
	//생성자 따로 없으면 기본생성자 자동으로 만들어지지만 
	//생성자 따로 만들었으면 기본생성자 호출 시 자동으로 안만들어져서 에러남(따로 만들었으니 자동으로 기본 생성자를 만들 필요가 없지!)
	//이럴 땐 : 만든 생성자 파라미터에 인자 대입해야함
	
	public Class_01(int a) {
		student1="김경호";
		int student_no_constructor1=1;
		int student_no_constructor2=a;
		System.out.println(student_no_constructor1);
		System.out.println(student_no_constructor2);
		//생성자 2임
	}
	
	
	
	public static void main(String[] args) {
		
		//Ex.1
		Class_01 class_01=new Class_01(3); //객체 생성(인스턴스화) 및 생성자 호출
		System.out.println(class_01); //생성자 값+ 새 객체인 class_01의 주소값 호출됨
		class_01.calculate(); //생성자로 인해 초기화 되더라도 클래스 안에 있는 메소드 사용 가능함
		
		
		//class_01.student1="김김김";
		//class_01.student_no=1;
		//class_01.student_exist=true;
		
//		System.out.println("학생 이름: "+class_01.student1 +" "+ "학번: "+class_01.student_no);
//		System.out.println("학생은 존재합니까?" +class_01.student_exist);
//		System.out.println("지금 뭐해?");
//		class_01.study();
//		class_01.calculate();
		
		
	
	
	}
}
	
	
	
	
	
	
	
	