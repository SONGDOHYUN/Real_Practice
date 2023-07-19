package Practice_1;

import java.util.Scanner;

/*
 * 1. Error란?
 * - compile-time-error: 컴파일(컴퓨터가 이해할 수 있게 0,1로 바꾸는 과정) 시 발생하는 에러
 * - logical error: 실행은 되지만 의도와는 다르게 동작함(버그)
 * - runtime error: 실행시에 발생하는 에러 -> error(심각), exception(미약, 수습가능)
 * 
 *  1-2. Exception 추가)) 런타임이면 throw로 처리 가능, 노런타임이면 직접 무조건 해결해야함!
 *  
 *  	  * Exception 종류
	   		1. RuntimeException    :throw구문으로 로 자동처리
	   		    ==>프로그래머의 실수로인한 Exception 
	   		    ex> NullPointerException,ArrayIndexOutOfBoundsException
	       
	        2. 비 RuntimeException :반드시 처리해야한다.
	        	==>프로그램과관계 없이 일어날 가능성이 있는 Exception
	  			ex> network,io,db,file
 * 
 * 		public static void main(String[] args) throws NullPointerException, ArrayIndexOutOfBoundsException{
		//main 메소드 실행 시 발생할 수 있는 예외를 말함
 * 
 * 
 * 
 * 2. 오류의 계층 관계(상속관계)
 * - Object(최상위 클래스)<-throwable클래스<-Error,Exception 클래스
 * 
 * 3. Throwable 클래스란?
 * - 오류나 예외에 대한 메세지!!를 담는 클래스
 * - getMessage(): 오류가 발생한 이유를 알려줌, printStackTrace(): 오류가 생긴 경로!!를 추적해줌 메소드가 이 클래스에 속해있음
 * 
 * 4. 자바에서 예외처리란?
 * - JVM에서 예외가 발생하면 예외클래스로 객체를 생성(예외객체!!!)->예외처리 코드에서 예외 객체를 사용하게 해줌
 * - getMessage(), printStackTrace()메소드도 예외 객체의 매소드를 가져와서 오류를 출력하는 것
 * 
 * 5. Exception이란? -> 예외 처리하는 법: try-catch하거나 throw/throws로 예외 던짐
 * 
 * 예시))
 * 
 *   ex1>>>> "try-catch"
	     public void method(){
		 	
		     try{ 
		     
		     	익셉션 발생예상코드;
		     	
			 }catch(Exception클래스 e){
			 	익셉션 발생예상코드에서 Exception이발생하면
			 	실행하게될코드;
			 	
			 	*e.printStackTrace();-> 오류가 발생한 경로를 추적해서 알려줌
			 	
			 	*sysout("오류 발생했습니다."+e.getmessage());
			 	-> getmessage()는 오류가 발생한 이유를 알려줌
			 	-> "Throwable 클래스의 고유 메소드"라서 직접 메세지를 설정할 순 없고 예외 객체 생성해서 설정할 수 있음
			 	
			 	
			 }finally{
			 	예외에 관계없이 무조건 실행되어야할 코드
		 }
 * 
 *   ex2>>> "Throws!!" -> 메서드 선언부에서 "throws Exception"으로 예외 던짐
		 			   -> 해당 메서드가 어떤 예외를 던질 수 있는지 명시함
		 			   -> ★★★헷갈렸던 부분★★★
		 			   -> 해당 메소드를 사용하는 쪽이 try-catch 코드로 예외 발생 시 해결 코드 써야함
		 			   
		 	public void method()throws Exception, IOException {
		 	
		 		익셉션 발생예상코드;
		 	
		 	}	
		 	
	 ex3>>> "Throw" ->억지로 예외를 발생시킬 때 사용함: 일반적으로 try-catch 구문에서 사용됨 	
 * 		
 * 			void divide(int dividend, int divisor) {
			    if (divisor == 0) {
			        throw new ArithmeticException("Divisor cannot be zero.");
			    }
			    int result = dividend / divisor;
			    System.out.println("Result: " + result);
			}
 * 			
 * 
 * - 자바에서 다루는 모든 예외 오류는 Exception 클래스에서 처리함
 * - 런타임 Exception(null, BufferOverflow, IndexOut 등등)와 
 * 	 컴파일 Exception(IOexception, filenotFound,ClassNotFound, DataFormat: 입력한 데이터 형식이 잘못됨 등등)로 종류가 나뉨
 *   얘네는 꼭 throw를 하거나 try-catch를 통해 예외처리를 해줘야함!! 빨간줄 뜸!!
 * - 자세한 예외 종류는 : 여기가서 확인하기
 * 	https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%90%EB%9F%ACError-%EC%99%80-%EC%98%88%EC%99%B8-%ED%81%B4%EB%9E%98%EC%8A%A4Exception-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC
 * 
 * 6. NullPointException이란?
 * - null객체에 접근해서 method를 호출할 경우 발생하는 에러
 * -> 객체가 없는데 객체를 사용하려 했으니 null이 뜬다.
 * -> ##예시)
 * 	String s = null;
	System.out.println(s.length()); //NullPointException
 * 
 * 7. NumberFormatException이란?
 * - 소수점으로 되어있는 문자열 데이터를 숫자타입으로 변환할 때 생기는 에러
 * - ##예시)
 * 	String stringNumber = "3.141592"; 문자열 타입의 소수점있는 실수
	int num = Integer.parseInt(stringNumber);
	->int를 double, Parsedouble로 바꿔줘야함
 * 
 * 8. classCastException이란?
 * -> 클래스간의 타입 변환이 잘못되었을 때 생기는 에러
 * -> 타입 변환은 클래스간 상속 관계 or 클래스-인터페이스간 구현 관계일때만 가능함
 * 
 * 9. IOException이란?
 * -> 입출력예외
 * 
 * 
 */
public class Exception {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("글씨를 써보자");
		String n=sc.nextLine();
		System.out.println(n);
		
	}

}
