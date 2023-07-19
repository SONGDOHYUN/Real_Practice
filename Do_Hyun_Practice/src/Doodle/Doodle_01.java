package Doodle;

import java.util.Arrays;
/*
 * 1. 메인 메소드: 
 * - 자바는 application이 실행되면 제일 먼저 main을 실행한다.
 * - public이라 어느 객체든 접근 가능함
 * - static이라 자바가 컴파일 되는 순간 정의됨
 * - void라서 리턴값이 없음
 * 
 * 2. 향상된 for문
 * -> 전제는 배열, 여러 원소를 포함한 자료형일 때 사용됨
 * -> for(자료 타입 변수이름 : 배열이름){
 * }
 * ->##예시
 * String[] array={"1-1","2-2","3-3","4-4"};
 * -> for(String obj: array){
 *  	sysout(obj);
 * }
 * -> array라는 이름을 가진 배열의 항목을 array라는 배열의 개수만큼 
 *    처음부터 하나씩 obj에 담아서 실행하겠다~는 의미임
 * -> 출력결과(세로로 출력됨): 1-1 2-2 3-3 4-4
 * 
 */
public class Doodle_01 {

	public static void main(String[] args) {
		int[]a=new int[3]; //일단 갯수는 3개인데 아무것도 안채움->디폴트 값 들어감
		int[]b=new int[5];
		
		for(int i:a){
			System.out.println(i); //a={0,0,0}
		}
		
		for(int i=0; i<a.length;i++) {
			a[i]=i;  //a={0,1,2}
		}
		System.out.println(Arrays.toString(a));
		System.arraycopy(a, 1, b, 1, 2);
		System.out.println(Arrays.toString(b)); 
		//-> a인덱스 1번부터 2개 요소 복사한 뒤 배열 b의 인덱스 1번 자리부터 채움
	}

}
