package 예외;

import java.io.IOException;

public class _First {
	private _Second second;
	
	//기본 생성자
	public void _First() {
		second=new _Second();
		//_First클래스의 객체 생성 시 _Second의 객채도 생성되어 second라는 변수에 주소값이 할당됨
		//second의 객체 값은 null값임
	}
	
	//고유메소드
	public void method1() throws NullPointerException, IOException{
		System.out.println("First.method1()실행");
		second.method2();
		System.out.println("First.method1()반환");
		return;
	}
	
	
}
