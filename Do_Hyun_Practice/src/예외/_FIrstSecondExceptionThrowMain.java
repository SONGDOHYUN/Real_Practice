package 예외;

import java.io.IOException;

public class _FIrstSecondExceptionThrowMain {

	public static void main(String[] args) throws NullPointerException,IOException{
		System.out.println("1. main 흐름 start");
		_First first1=new _First(); // 객체생성
		try {
			first1.method1();
		} catch (Exception e) {
			System.out.println("----");
			System.out.println("--오류 경로를 알려드리겠습니다.--");
			e.printStackTrace();
			System.out.println("----");
			System.out.println("오류가 발생했습니다."+e.getMessage());
		}
		
		
		
		
	}

}
