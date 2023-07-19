package 예외;

import java.io.IOException;
import java.net.Socket;

public class _Second {
	//고유 메소드
	public void method2() throws NullPointerException, IOException{
		System.out.println("Second클래스의 method2()를 실행합니다.");
		Socket socket1=new Socket("www.naver.com", 89);
		System.out.println(socket1);
		System.out.println("Second.method2() 반환함");
		return;
	}
	
}
