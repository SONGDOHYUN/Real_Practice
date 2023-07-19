package 예외;

import java.net.Socket;

public class NoRuntimeExceptionCatchMain1 {

	public static void main(String[] args) {
		
		System.out.println("--NoRuntimeException을 발생시키겠습니다--");
		try {
			Socket socket1=new Socket("www.daum.net", 89);
			Class.forName(null);
			
			
		} catch (Exception e) {
			
			
			
			
		}
		
	}

}
