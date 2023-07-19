package Practice_1;
/*
 * 1. 상속이란? [class 자손 extends:extends from이라고 생각해ㅎ 부모]
 * -> 자식이 부모를 선택해서 물려받음: 기존클래스를 재사용해서 새로운 클래스 작성하는 것
 * -> 하위/서브클래스: 자식(상속받음), 상위/슈퍼클래스: 부모(상속해줌)
 * 
 * 2. 상속의 특징? --->자식만 부모 것(멤버필드, 메소드 등등) 사용할 수 있음: 등골 빼먹는거임...ㅎ
 *-> child1 extends child2, child2 extends parent(조부모) 인 경우 child1은 조부모 메소드, 변수 사용 가능
 *-> 근데 (조)부모가 자식 변수, 메소드 사용은 안됨...각박해
 *-> 생성자와 초기화블록, private(다른패키지라면 default 접근제한자 있으면 이것도 상속안됨) 붙은 것들은 상속 안됨->변수와 메소드만 상속됨(오버라이딩해서 재사용 가능함)
 *-> 단일상속만 가능: class child extends parent1,parent2() 안됨
 *-> 상속 횟수 제한 없음: 자식 여러명이어도 됨
 * class Parent{}
 * class child1 extends Parent{}, class child2 extends Parent{} 가능
 * -> 다단계 상속 가능: 형제자매 네트워킹 가능
 * class child1 extends Parent{}, class child2 extends child1{} 가능 
 * -> 모든 클래스는 Object 클래스의 자식임
 * -> 자식 클래스가 활용범위가 더 넓으므로 자식 클래스로 인스턴스를 생성하는 것이 효율적임
 * 
 * 3. super란? [자기자신 참조인 this와 비슷함]
 * -> 자식클래스에서 부모클래스를 가리키는 키워드
 * -> 부모클래스에 선언된 멤버변수와 같은 이름의 멤버변수를 자식클래스에서 중복해서 정의 가능하고 super로 구분 가능함
 * -> this와 마찬가지로 참조 개념이기 때문에 객체 만들고 사용 가능
 * 
 * 3-1. super()란?
 * -> 부모클래스의 생성자 함수를 호출하는 것을 말함-> 부모 클래스의 생성자를 호출하는 것은 부모 클래스의 필드나 메서드를 초기화하기 위함임
 * -> 자식이 객체 생성하면 부모 생성자+멤버 등 다 가져오게 됨
 * -> 따라서 부모 클래스를 초기화 하려면 자식 클래스 생성자에서 부모클래스 생성자까지 호출해야함
 * -> 자식클래스의 생성자 함수에 기본적으로 super()를 호출해야함
 * -> 근데 부모 클래스에 기본 생성자 없으면 super() 자동 추가해주지만 매개변수 있는 생성자 있으면 부모클래스에 따로 기본 생성자를 명시적으로 써야한다.
 * 예시)))
 * //생성자 오버로딩 -> 1. 이렇게 하거나
	public AcademyGansa(int no, String name, String suject) {
		super(no,name);
		System.out.println("고유 과목은: "+this.subject);
	}
	
	/* 2. 이렇게 직접 부모 클래스 생성자의 파라미터 끌고 와서 직접 쓰면서 정의할수도 있음
	public AcademyGansa(int no, String name, String subject) {
		//상속받아서 no, name 멤버필드 쓸 수 있으니까 this.멤버필드라고 써도 됨
		this.no=no;
		this.name=name;
		this.subject = subject;
	}
 * 
 * 
 * 4. 오버라이딩이란?
 * -> 부모로부터 상속받은 메소드, 변수를 재정의/변경/수정하는 것
 * -> 부모로부터 상속받은 메소드, 변수 꼭 항상 오버라이딩해야하는 것은 아니고(수정하고 싶을때만 수정해도 되고) !!그냥 그대로 써도 됨!!
 * 
 * 4-1. 오버라이딩 조건이란?
 * -> 선언부가 일치해야함: 이름, 매개변수, 반환타입이 같아야함. 즉 선언부 그대로 따오고 구현부만 변경하는 것
 * -> 그럼 접근제한자는? 바로 뒤에 나옴
 * -> 접근제한자는 변경 가능하지만 부모보다 접근 범위가 같거나 or 넓어야함
 * -> 부모가 protected였다면 자식은 protected나 public 써야함
 * -> static을 인스턴스로, 인스턴스를 static으로 변경할 수 없음
 * -> final 붙은 클래스는 상속 못받고 final 붙은 메소드는 재정의/오버라이딩 못함
 * 
 * 5. 강사님 추가 설명
 * 상속(클래스의 관계):
 * 	부모클래스(객체)의 멤버들을 자식클래스(객체)가 물려받는것
 * 
 *  5-1. 상속을 사용하는이유--> 기존에 만들어놓은 클래스의 재사용,
 * 						 	  확장을위해사용한다.
 *  5-2. 자바에서는 단일상속만이 가능하다(부모클래스가 한개만가능) 
 *  5-3. 부모클래스(super)와 자식클래스(sub)가존재한다.
 *  5-4. 자바에서 제공되어지는 모든 클래스들은 Object 라고하는
 *     최상위 클래스로부터 상속되어진다.
 *  5-5. 사용자정의 클래스들도 Object 클래스라는 최상위클래스를
 *     상속  받아야한다. 
 * 
 * 5-6.  - 클래스 생성자 첫번째 라인에서는 부모 클래스의 생성자가 반드시 호출되어야합니다 [super();]
		 - 부모클래스 생성자 호출을 생략할 경우에는 부모클래스의 기본생성자가 자동으로 호출된다. 
		 - 매개변수를 가진 부모의 생성자를 호출할수있다.(명시적으로 호출코드를 기술하여야한다.)
 *
 * ★★★중요★★★ 6. 부모와 자식간의 형변환>>>>>>>> 
 * "조참자객->조상은 자식 객체 참조가능->업캐스팅임
 *         : 자식 객체 참조했지만 결국 조상 타입으로 형이 변환되기 때문에 
 *           자식 클래스의 멤버필드, 멤버 메소드는 사용 못하고 조상 클래스의 멤버 필드, 멤버 메소드만 사용 가능함
 *           자식 클래스 고유의 필드, 메소드 사용하려면 다시 다운 캐스팅 하면 됨
 *			 "           
 *			->[Polymorphism다형성_형변환.java] 클래스 읽어보기
 *
 */

public class Parent_01 {
	int a=10;
	/*
	public Parent_01() { //부모클래스 기본 생성자
		a=30;
	}
	*/
	Parent_01(boolean a){
		System.out.println(a);
	}
	void print1() {
		System.out.println("부모의 메소드");
	}
	
	public static void main(String[] args) {
		Child child= new Child();
		child.method1();
		System.out.println(child.a);//40
		child.print1(); //부모의 메소드를 재정의한 자식의 메소드 출력
		
	}
}
	class Child extends Parent_01{
		Child() {
			super(false); //그냥 super();는 안됨-> 기본 생성자가 주석처리되어있음
			//-> 따라서 boolean a를 매개변수로 갖는 부모클래스 생성자를 초기화 해야하기 때문에 super(false);을 써야함
			 a=40; //근데 만약 int떼고 a=40이라고 하면 a값에 40출력됨...왜지?
			//얘가 parent 에서 상속받으 int a= 10의 값을 재정의 하는 애임
			//child 생성자에서 a를 40으로 초기화했기때문에 child 객체를 생성하면 a의 값은 40이다.
		}

		int a= 20; //parent에게 상속받은 int a라는 변수와는 별개의 변수임
		
		public void method1() {
			System.out.println(a); //40
			System.out.println(this.a); //40
			System.out.println(super.a); //10
			
		}

		@Override
		void print1() {
			System.out.println("부모의 메소드를 재정의한 자식의 메소드");
		}
		
		
		
}
