package Practice_1;
/*
 * 1. 인터페이스란? (추상 메소드+상수 필드로 이루어짐)
 * -> 다른 클래스를 작성할 때!! 기본이 되는 틀을 제공 및 다른 클래스 사이의 중간 매개 역할함
 * thd
 * 예시))
 * 
 * public interface ParentInterface {
    void parentMethod();
}

public interface ChildInterface extends ParentInterface {
    void childMethod();
}

public class MyClass implements ChildInterface {
    @Override
    public void parentMethod() {
        // ParentInterface의 메소드 구현
    }

    @Override
    public void childMethod() {
        // ChildInterface의 메소드 구현
    }
}
 * ★★★★★★★★★★★★헷갈렸던 부분★★★★★★★★★★★
 * 
 * 인터페이스끼리 extends로 상속 관계일 때 추상 메소드도 상속 받게 되는데, 이거는 나중에 인터페이스를 implements하는
 * 클래스에서 재정의 해도 됨
 * -> 즉, 상속받은 자식 인터페이스에선 굳이 재정의 안하고 
 *    그냥 또 해당 인터페이스의 고유 추상 메소드만 추가해도 됨
 * 	  대신 그 인터페이스를 implements한 클래스에서는!!! 추상 메소드를 반드시 모두!!! 재정의해야함
 * 
 * 
 * 
 * 특징))))
 * -> 인터페이스의 메소드는 기본적으로 !!추상 메소드!!임. 따라서 abstract써도 되고 안써도 됨
 * -> 인터페이스는 생성자가 없기 때문에 객체를 생성할 수 없음
 *    대신 인터페이스를 implement하는 클래스의 생성자를 통해 객체를 생성할 수 있음
 * -> 인터페이스도 "조참자객"헤서 다형성-업캐스팅, 다운캐스팅 할 수 있음
 * 	  이유) !!!!인터페이스도 implement 사용하여 클래스의 조상이 될 수 있기 때문에!!!!
 * 
 * -> 또한 !!!!!!인터페이스끼리 형변환도 자유자재로 가능함: 인터페이스와 인터페이스의 형변환은 단위가 같기 때문에!!!!! 
 *    int a=90;
 *    double b= (double)a; 이런식으로 해도 됨
 * ★★★★★★★★InterfaceImplABMain 클래스 꼭 보기!!!★★★★★★★★★★
 * 
 *  ** 클래스는 객체를 찍어낼 때(객체 생성 시) 틀을 제공함 
 * 
 * -> 추상클래스(추상메소드를 하나 이상 가지고 있는 클래스->자식 클래스에서 반드시 재정의 해줘야함)랑 비슷함
 * -> 필드 선언할 수 있지만 변수가 아닌 상수로만 정의 가능
 * -> public static final, public abstract 제어자는 생략이 가능함
 * -> 인터페이스 파일을 따로 만들어야함
 * -> 인터페이스를 상속 받았으면 자식 클래스에서 인터페이스의 추상 메소드를 구현해줘야함
 * 
 * 1-1-1. 클래스와 인터페이스의 차이 [사용 목적에 있어 차이가 있음]
 * -> 인터페이스는 클래스와 클래스간의 관계, 틀 제공
 *    클래스가 인터페이스를 상속받는다고 보면 됨
 *    <<야매>> 자식 클래스-(extends)->부모/조상 클래스-(implements)->인터페이스
 * 
 * -> 자식클래스는 여러개의 부모를 가질 수 없었음(단일 상속만 가능) 
 *    !!그러나 부모 클래스는 여러개의 인터페이스를 가질 수 있음 [class1 implement inter1, inter2]
 *    !!그리고 인터페이스끼리도 여러개의 인터페이스를 가질 수 있음 [inter extends inter1, inter2]
 * 
 * -> 즉, 클래스와 인터페이스는 사용 목적에 차이가 있음
 * 	  클래스 [상속, 확장]: 객체!!의 공통된 속성과 동작을 추상화하여 상속 관계를 구성하고, 이를 통해 코드 재사용과 다형성을 지원함
 *    인터페이스 [클래스에게 일관성 요구]: 클래스가 가져야 할 동작을 정의하고, 이를 구현하는 클래스들에게 일관된 동작을 요구함
 *    
 *    즉! 추상 클래스와 인터페이스는 모두 추상 메소드를 가질 수 있지만, 
 *       추상 클래스는 클래스의 일부 기능을 구현하고 상속을 통해 확장되는 것을 목적으로 하고, 
 *       인터페이스는 클래스들 간에 일관된 동작을 정의하고 객체 간의 상호작용을 지원하는 것을 목적으로 함
 * 
 * 
 * 1-1-2. 클래스와 인터페이스의 차이 [형태의 차이]
 * -> 클래스: 멤버필드, 멤버/추상 메소드, 생성자 등등!!
 *    인터페이스: 추상메소드 + 상수필드
 * 
 * 
 * 2. 인터페이스의 특징
 * -> 인터페이스도 따지고 보면 상속이지만 상속보단 "구현/기능 넓히기"의 뜻이 더 커서 implement쓴다.
 * -> 오버라이딩 시 부모보다 접근 범위(P-D-P-P)가 넓어야함
 * -> 인터페이스의 추상 메소드들은 public abstract가 생략되어 있으므로 자식 클래스에서
 *    구체적으로 구현 시 꼭 public을 써줘야함
 * -> 만약 클래스가 인터페이스의 추상 메서드 중 또 일부만 구현한다면 abstract 써줘서 추상 클래스를 써줘야함
 * -> ##예시
 * interface Animal {
    void walk();
    void run();
    void breed();
}

// Animal 인터페이스를 일부만 구현하는 포유류 추상 클래스
	abstract class Mammalia implements Animal {
    public void walk() { ... }
    public void run() { ... }
    // public abstract void breed(); 는 자식 클래스에서 구체적으로 구현하도록 일부로 구현하지 않음 (추상 메서드로 처리)
}

	class Lion extends Mammalia {
	    @Override
	    public void breed() { ... }
	}
 * 
 * 3. 다중상속
 * -> 클래스 상속은 다중상속이 안되지만 인터페이스는 다중 상속이 가능함
 * -> 인터페이스끼리 extends 를 통해 상속 여러개가 가능하다는 뜻
 * -> ##예시)
 *  interface A extends B,C{} -> 여기서 B,C는 인터페이스임, 인터페이스끼리 다중상속하면 그대로 추상 멤버들을 물려받음
 * -> ##헷갈리지 말기)
 * -> 클래스는 여러개의 인터페이스 사용!!가능함
 * -> class A implements B,C {} -> 여기서 B,C는 인터페이스임
 * 
 * 4. 인터페이스 상수필드 상속관계
 * -> 클래스의 상속일 경우 클래스 필드 멤버끼리 상속되어 덮어씌워지지만
 *    인터페이스의 필드는 모두 public static final이기에 서로 상속해도 독립적으로 운용됨
 *    
 *-> ##예시))
 *	interface Iflower {
    int ex = 10; // 각각 public static final
	}
	
	interface IPlant extends Iflower {
	    int ex = 20; // 각각 public static final
	}
	
	class Tulip implements IPlant {
	    int ex = 30; // 그냥 인스턴스 변수
	}
	
	public class Main {
		public static void main(String[] args) {
	        // 클래스 타입 객체로 ex 멤버에 접근하면, 클래스 인스턴스 변수로 접근
	        Tulip t =  new Tulip();
	        System.out.println(t.ex); // 30
	
	        // 인터페이스 타입 객체로 멤버에 접근하면, 인터페이스 static 상수로 접근
	        Iflower a = new Tulip();
	        System.out.println(a.ex); // 10 - 좋지않은 방법
	        System.out.println(Iflower.ex); // 10 - 클래스 static 처럼 '인터페이스.멤버' 로 접근
	
	        IPlant b = new Tulip();
	        System.out.println(b.ex); // 20 - 좋지않은 방법
	        System.out.println(IPlant.ex); // 20 - 클래스 static 처럼 '인터페이스.멤버' 로 접근
	    }
	}
 *    
 *    
 *    
 *    
 */



public class InterFace {

	public static void main(String[] args) {

	}


}
 class mouse extends Sport implements realInterface{
	int mouseClick;
	void click() {
		System.out.println("클릭했습니다");
	}
	@Override
	public void method3() {
		// TODO Auto-generated method stub //인터페이스 상속 받은 매소드들도 무조건 재정의해야함
		
	}
	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void method1() {
		// TODO Auto-generated method stub //추상화된 클래스 무조건 재정의해야하고
		
	}

}

abstract class Sport{
	int SportNum;
	String SportName;
	String SportName(String name) {
		this.SportName=name;
		return name;
	}
	abstract void method1();
	
	
}


