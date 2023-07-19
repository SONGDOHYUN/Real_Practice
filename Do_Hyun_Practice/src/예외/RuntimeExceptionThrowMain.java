package 예외;

public class RuntimeExceptionThrowMain {

	public static void main(String[] args) throws NullPointerException, ArrayIndexOutOfBoundsException{
		//main 메소드 실행 시 발생할 수 있는 예외를 말함
		try {
			String str=null;
			int length=str.length();
			System.out.println(length);
		} catch (Exception e) {
			System.out.println("오류 경로와 메세지를 알려드리겠습니다");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//main 실행했을 때 오류 난다고 명시했으니까 try-catch로 오류 잡아준다.
		
		
	}

}
