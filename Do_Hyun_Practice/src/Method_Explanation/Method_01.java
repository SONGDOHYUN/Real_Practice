package Method_Explanation;

import java.util.Arrays;
import java.util.Date;


public class Method_01 {

	public static void main(String[] args) {
		
		/*
		 * 1. toString();
		 * -> 객체가!! 가지고 있는 정보나 값들을 문자열로 만들어서 리턴하는 메소드
		 */
		int[] scores= {1,2,3,4,5};
		int[] newScores=scores; //newScores에 scores 참조값이 복사됨
		System.out.println(scores); //주소값이 나옴
		System.out.println(scores[1]); //1번째 인덱스 값인 "2"가 나옴
		System.out.println(scores.toString());//scores의 주소값을 문자열로 출력해라 라는 뜻
		System.out.println(Arrays.toString(scores));//이래야 scores에 들어있는 배열값들이 나옴
		System.out.println(Arrays.toString(newScores));
		
		//각 배열의 값들을 변경할 때
		scores[1]=3; //인덱스 1번 값인 "2"->"3"으로 변경함
		System.out.println(Arrays.toString(scores));
		
		
		Date d= new Date(); //날짜 객체 생성해서 d에 담음
		System.out.println(d.toString()); // 현재 날짜 출력
		System.out.println(d); // 현재 날짜 출력-->주소값은 어떻게 출력??
	}

}
