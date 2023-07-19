package Practice_1;

import 내부클래스.OuterClass;
import 내부클래스.OuterClass.InnerClass;

/*
 * 1. 내부 클래스(Nested class) : 클래스 안에 또 다른 클래스가 정의되어 있는 것을 말함
 * -> 사용 이유:  Nested class는 외부 클래스에 의존적인 관계를 갖거나, 
 *             외부 클래스 내에서만 사용되는 특정한 기능을 구현하기 위해 사용됨
 * - 외부 클래스에서 내부 클래스 객체 생성해서 내부 클래스에 접근할 수 있음
 * - 내부 클래스에서 외부 클래스 객체 생성에서 외부 클래스에 접근할 수 있음            
 *  
 *  예) 내부클래스에 접근하기 위해 객체 생성하려면
 *  	System.out.println(">>>>>InnerClass에 접근>>>>>");
		OuterClass.InnerClass ic=new OuterClass().new InnerClass(); 
 *             
 *             
 *             
 * 1-1. 내부 클래스 종류
 * cf) 외부 클래스(Outer Class): 다른 클래스에 의해 감싸지거나 포함되지 않는 독립적인 클래스임
 * 
 * - Static Nested Class: 정적으로 선언된 중첩 클래스임
 * 						  외부 클래스의 인스턴스와 독립적으로 존재함. 
 *                        외부 클래스의 인스턴스 생성 없이도 사용할 수 있습니다. 
 *                        정적 중첩 클래스는 외부 클래스의 멤버에 접근할 수 없으며, 
 *                        일반적으로 외부 클래스와 강한 결합 관계를 가지지 않는 
 *                        독립적인 기능을 구현할 때 사용됩니다.  
 * 
 * - Inner Class: 인스턴스 변수로 선언된 중첩 클래스임 
 *  			  외부 클래스의 인스턴스와 밀접한 관계를 가집니다. 
 *  			  Inner class는 외부 클래스의 멤버에 직접 접근할 수 있으며, 
 *  			  외부 클래스의 모든 멤버와 메서드에 접근할 수 있습니다. 
 *  			  Inner class는 외부 클래스의 인스턴스를 생성한 후에만 사용할 수 있습니다. 
 *  			  Inner class는 외부 클래스의 멤버 변수나 메서드에 접근하여 조작하거나, 
 *  			  특정 기능을 구현하는 데 사용됩니다.
 * 
 * 2. 익명클래스: 
 * -> 객체 생성하여 일회용으로 한번만 사용되고 버려지는 클래스임
 * 
 * -> ★★★★따로 extends, implements 안쓰고 
 *         클래스나 인터페이스를 직접 상속하거나 구현한 뒤에 메서드를 재정의할 수 있음★★★★
 *         
 * -> !!클래스 정의 및 객체 생성을 한번에 함!!-> 따로 클래스 만들고 객체 생성하면서 클래스 정의, 재정의 다 함
 * -> 부모 클래스 자원을 일회성으로 재정의하여 사용하기 위한 용도임
 * -> 익명 클래스는 이름이 없기 떄문에 생성자 가질 필요 없고 못가짐
 * 
 * 예)
 * 
 * 			ParentFirstConcreteClass childConcreteClass=new ParentFirstConcreteClass() {
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentFirstConcreteClass를 상속받는 "
						+ "이름없는로칼 내부클래스에서 재정의한 local_inner_outer_access()");
			}
			
		};
 * 
 * 따로 ParentFirstConcreteClass 파일 만든 뒤에 위 코드 진행한거임)
 
 * 	public class ParentFirstConcreteClass {
		public void local_inner_outer_access() {
		System.out.println("ParentFirstConcreteClass.local_inner_outer_access()");
	}
}

 * 
 * 
 * 
 * 3. 익명클래스 문법
 * -> 클래스 상속이나 인터페이스 구현을 해야함
 * -> 상속일때: 조상클래스명 변수=new 조상클래스명(){};
 * -> implement일때: 인터페이스명 변수 = new 인터페이스명(){};
 * 
 * 4. 익명클래스 특징
 * -> 오버라이딩한 메소드만 사용가능하고 새로 정의된 메소드는 외부에서 사용 못함
 * 
 * 5. 람다식이란?
 * -> 함수를 하나의 식으로 표현한 것
 * -> 함수를 하나의 식으로 표현하면 메소드 이름이 필요없기 때문에 익명함수의 한 종류라고 볼 수 있음
 * ->##예시))
 * public String hello(){return "Hello World";}
 * =>>(매개변수)->{실행문}
 * 람다식으로 바꾸면 () -> "Hello World"; 이렇게 됨
 * 
 * -> 인터페이스로만 만들 수 있음
 * -> 하나의 추상메소드만 선언되어 있는 인터페이스만 가능함(default 메소드는 제외)
 * 
 * 
 */
class Animal{
	public String bark() {
		return "동물클래스입니다.";
	}
}

public class InnerClass_NestedClass {

	public static void main(String[] args) {
		Animal dog=new Animal() { //익명클래스: Animal 클래스 상속의 경우
			@Override
			public String bark() { //익명 클래스인 경우 오버라이딩만 가능하고 새로운 메소드 정의 못함
				System.out.println("개클래스입니다.");
				return "개클래스입니다";
			}
			
			public void run() {
				System.out.println("새로 정의된 메소드는 사용 못합니다.");
			}
			
		
			
		};
			dog.bark();//오버라이딩한 메소드라 사용 가능
			//dog.run();-> 오버라이딩 아닌 새로 정의된 메소드는 외부에서 호출못함
			//->이유: 상속관계인데 부모 class에는 run이라는 메소드가 없어서임 
	}

}



