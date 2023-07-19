package Practice_1;

import java.util.HashSet;

/* 0-1. Java lang 패키지란?
 * -> 기본으로 제공되는 패키지로 따로 import할 필요 없음
 * -> Object 클래스
 * -> Class 클래스: forname, getname, newinstance, getsuperclass, getfields
 * -> String 클래스: compareTo, indexOf, charAt,subString,replace, valueOf, equals, toString 등등
 * -> StringBuffer 클래스: 문자열 크기 수정, 조절하는 버퍼(임시저장공간)를 제공하는 클래스
 * 
 * 1. Wrapper 클래스란?
 * -> 참조형이 아닌 기본타입(int, char, boolean, double 등등)의 값을 객체로 만들어주는 클래스
 * -> 에) int->Integer 클래스
 * -> Wrapper 클래스로 포장된 객체의 값은 외부에서 변경할 수 없고 변경하려면 새로운 포장객체를 만들어야함
 * 
 * 1.1 박싱과 언박싱
 * -> 박싱: 기본타입-> 포장객체로 만드는 과정
 * -> Integer num= new Integer(17);
 * -> Integer num-17;
 * -> 언박싱: 포장객체-> 기본타입의 값을 얻어내는 과정
 * -> int n=num.intValue();
 * -> int n=num;
 * 
 * 1-2. Wrapper 클래스 문법
 * -> 박싱: Wrapper 클래스 생성
 * -> 클래스타입 변수명 = 클래스타입.valueOf(변수)
 * -> boolean b=true;
 * -> Boolean b1=Boolean.valueOf(b); //변수 b의 값을 b1이라는 Boolean 타입의 객체를 생성해 담는다
 * -> b1 값 출력하면 true 출력됨
 * 
 * ##박싱 시 헷갈리는 것 주의## parseInt(): 참조 vs valueOf(): 참조 vs intValue(): 기본;
 * -> Integer.parseInt() : 문자열을 int 값으로 변환함
 * -> valueOf(): int 값을 Integer 객체로!! 변환함
 * 
 * 예시))Integer number=new Integer(42); 객체 생성
 *      int value=number.intValue(); int 값으로 변환함
 *      String str=number.toString(); String(문자열)값으로 변환함
 *      Integer parsedNumber=Integer.parseInt("100"); 문자열인 "100"을 int로 변환하고 
 *      해당 값을 Integer 객체(참조 타입)로 포장하여 반환함
 * 
 * -> 언박싱: wrapper클래스의 값을 원시타입 변수에 넣어줌
 * -> 변수타입 변수 = 변수타입Value();
 * boolean b= true;
 * Boolean b1= Boolean.valueOf(b);
 * sysout(b1)-> "true" 출력 //박싱
 * 
 * 
 * 2. System 클래스란?
 * -> 운영체제 시스템과 관련된 기능을 제공하는 클래스
 * -> 모든 멤버가 static 이라서 별도의 인스턴스 객체 생성할 필요 없음
 * -> 입출력 관리, 환경변수 접근, 시스템 속성, 현재 시간확인, 객체복사 등에 사용됨
 * 
 * 3. Stream(데이터의 흐름) 클래스란?
 * -> 입출력장치를 프로그램과 연결해주는 역할
 * -> Java의 모든 입출력은 Stream을 통해 이루어짐
 * 
 * 4. Math 클래스란? 
 * -Math.random(): 0이상 1미만의 난수를 제공하는 메소드
 * 예)
 * 
 *		 System.out.println("--Integer Wrapper--");
		//Math.random()-> 0부터 1까지의(1 미포함) 난수 발생시킴 : 0이상 1미만
		 * 
		HashSet<Integer> intList=new HashSet<Integer>();
		System.out.println(">>>"+intList);
		
		while(intList.size()<6) { //size가 5이면 코드 진행돼서 총 6개 나옴, 사이즈 6되면 while문 벗어남
			intList.add((int)((Math.random()*45)+1))); //0이상~46미만(미포함) 까지의 난수 발생
			//요소 한개 더 추가됨
		}System.out.println(intList); //총 6개 나옴
 * 
 * 5. Runtime 클래스란?
 * 
 * 0-2.Java util 패키지란?
 * -> 자바 프로그램 조미료 역할을 함
 * -> 컬렉션 클래스들이 대부분을 차지하고 있음
 * -> Arrays, Calendar, Data,Objects,StringTokenizer, Random
 */

public class JavaLang_Wrapper {
	
	static boolean b= true;
	static String s="123123";
	
	public static void main(String[] args) {
		Boolean b1= Boolean.valueOf(b); //박싱: 객체 생성이니까 클래스타입씀
		boolean b2= Boolean.parseBoolean(s);
		int i1=Integer.parseInt(s);
		System.out.println(b1); //true
		System.out.println(b2); //false: s의 값이 true or false일때만 둘 중 하나 값 출력인데 해당 안되는 123123이니까 false 출력됨
		System.out.println(i1); //123123
		
		boolean b3=b1.booleanValue();
		System.out.println(b3); //true: 객체 아니고 값만!! 뺴내오는거니까 기본타입씀
		
		Integer parsedNumber = Integer.parseInt("100");
		System.out.println("parsedNumber: "+parsedNumber);
		
		//system 클래스
		System.out.println(System.currentTimeMillis()); //현재 ms 시간
		System.out.println(System.nanoTime()); //현재 ns 시간
		
		
	}

}
