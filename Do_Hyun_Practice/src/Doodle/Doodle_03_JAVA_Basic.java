package Doodle;

public class Doodle_03_JAVA_Basic {
	//1. Gugudan
	public static void main(String[] args) {
		/*
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.printf("%d*%d=%-2d ",j,i,i*j);
				//-2d는 [1_]이렇게 원래 값을 왼쪽으로 몰아넣고 2자리로 만든다는 뜻임
				//2d는 [_1]이렇게 원래 값을 오른쪽으로 몰아넣고 2자리로 만든다는 뜻임
				//%5.1f
				 * -> 출력될 숫자와 소수점을 포함해서 총 다섯자리로 출력해라 라는 뜻임
				 * -> 0.1은 소수점 이하 첫째자리까지 반올림해라 라는 뜻임
			}
			System.out.println();
		}
		*/
		
		//2. Nested
		/*
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("★[%d,%d]",i,j);
			}
			System.out.println(); //다음 줄에 출력
			//System.out.println("\n");//한 줄 띄움
		}
		*/
		/*
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("★");
			}
			System.out.println();
		}
		*/
		/*
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i==j) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		*/
		/*
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i>j) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		*/
		/*
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i<j) {
					System.out.print("");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i>j) {
					System.out.print("");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		*/
		
		//3.ForTest
		/*
		System.out.println("--while--");
		int k=0;
		while(k<10) {
			System.out.println("k="+k);
			k++;
		}
		*/
		/*
		System.out.println("--for i감소--");
		for(int i=10; i>0;i--) {
			System.out.println("i="+i);
		}
		*/
		/*
		System.out.println(">>홀수만 출력[1-100]");
		for(int i=1;i<100;i++) {
			if(i%2==1) {
				System.out.println("홀수:"+i);
			}
		}
		*/
		/*
		System.out.println(">>짝수만 출력[1-100]+continue 문 사용");
		//continue문->현재 반복을 중단!!!하고 다음 반복을 실행하는데 사용됨
		for(int i=1;i<=100;i++) {
			if(i%2==1) {
				continue; //i가 홀수면 이 반복 건너뛰고 for문으로 들어가서 짝수 데려오고 sysout출력함
			}
			System.out.println("짝수:"+i);
		}
		*/
		/*
		System.out.println("--4의 배수 출력[1-100]--+continue문 사용해보기");
		for(int i=1;i<=100;i++) {
			if(i%4!=0) {
				continue;
			}
			System.out.println("4의 배수:"+i);
		}
		*/
		/*
		System.out.println("--3과4의 공배수[1-100]--");
		for(int i=1;i<=100;i++) {
			if(i%3==0 && i%4==0) {
				System.out.println("3,4의 공배수->"+i);
			}
		}
		*/
		/*
		System.out.println("--3과 4의 최소공배수[1-100]--");
		for(int i=1;i<=100;i++) {
			if(i%3==0 && i%4==0) {
				System.out.println("최소공배수:"+i);
				break; //처음것만 나오고 최종으로 돌아감
			}
		}
		System.out.println("--홀수와 짝수의 합[1-100]--");
		//새로운 변수에 담는다는 생각하기
		int evenTot=0;
		int oddTot=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				evenTot+=i; //eventTot=evenTot+i;
			}else if(i%2==1) {
				oddTot+=i;
			}
		}
		System.out.println("짝수합:"+evenTot);
		System.out.println("홀수합:"+oddTot);
		*/
		/*
		System.out.println("--문자출력--");
		for(char c='a';c<='z';c++) {
			System.out.print(c);
			if(c=='z') {
				continue;// z의 반복 중단하고 for문 끝까지 갔다가(출력은 안하고->그래서 쉼표 안찍히는거임) for문 새롭게 들어옴
			}
			System.out.print(",");
			
			 // 5개씩 문자 찍고 줄바꾸기
			 
		}
		System.out.println();
		System.out.println("--5개씩 찍기--");
		for(char c='A';c<='Z';c++) {
			System.out.print(c);
//			if(c%5==0) {
//				System.out.println();
//			} 이렇게 하면 A만 따로 출력됨->A의 유니코드가 65여서임->따라서 A만 따로 처리해줘야함
			//A부터 시작하여 나머지 1부터 카운트하기 위한 작업임!!!!
			//A=65, B=66, C=67, D=68, E=69, F=70 
			if((c-'A'+1)%5==0) {
				System.out.println();
			}else
			System.out.print(",");
		}
		*/
		/*
		System.out.println("--평점계산--");
		int kor=89;
		char score='F';
		if(kor>=90 && kor<=100) {
			score='A';
		}else score='B';
		System.out.printf("score: %c%n",score);
		*/
		
		/*
		System.out.println("--점수의 유효성 체크--");
		int kor=-91;
		char score='X';
		if(kor>=0 && kor<=100) { //유효성 체크하려고
			if(kor>=90) {
				score='A';
			}else if(kor>=80) {
				score='B';
			}else if(kor>=70) {
				score='C';
			}else if(kor>=60) {
				score='D';
			}else { //0-59점 밑으로는 다 학점 F임
				score='F';
			}
			System.out.printf("학점:%c%n",score);
		}else {
			//큰 if(점수는 0-100사이라고 위에 정해놨는데 그게 아닐 시 밑의 코드가 출력됨)
			System.out.printf("%d는 유효한 점수가 아닙니다.",kor);
		}
		*/
		/*
		System.out.println("점수의 유효성 체크");
		int kor=-90;
		if(kor<0 || kor>100) {
			System.out.println(kor+"는 유효한 점수가 아닙니다.");
		}else System.out.println(kor+"는 유효한 점수입니다.");
		*/
		
		/*
		System.out.println("--윤년 여부 출력--");
		int year=2000;
		String msg="";
		if((year%4==0 && year%100!=0) ||year%400==0) {
			msg="윤년";		
		}else {
			msg="평년"; 
		}
		System.out.printf("%d년도는 \t%s입니다\n", year, msg);
		//sysout ""안에 \t하면 탭되고 \n하면 줄바꿈 됨
		
		char c='x';
		if(c>='A' && c<='Z') {
			System.out.printf("%c는 알파벳 대문자입니다.%n",c);
		}else {
			System.out.printf("%c는 알파벳 대문자가 아닙니다.%n",c);
		}
		 c='9';
		 if(c>='0' && c<='9') {
			 System.out.printf("%c는 숫자형태를 가진 한개의 문자입니다.",c);
		 }
		*/
		/*
		String id="0hoco";
		char c=id.charAt(0);
		//문자 하나만 뽑아올때는 charAt 쓰기
		//indexOf->id.indexOf('C')->0출력 
		if((c>='a' && c<='z') || (c>='A' && c<='Z')) {
			System.out.printf("%s는 유효한 아이디 입니다.",id);
		}else {
			System.out.printf("%s는 유효한 아이디가 아닙니다.",id);
			
		}
		*/
		/*
		System.out.println("--연산자--");
		int a=10;
		int b=3;
		int result=0;
		double dResult=(double)a/b; //소수점 살리려면!
		//a/b는 나눗셈의 몫을 계산하고 반환함, a%b는 a를 b로 나눈 나머지 값을 반환함
		//10/3->3 or double일 때 3.333...(17자리에서 반올림?), 10%3->1
		System.out.println("a/b:"+a/b);
		System.out.println("a/b:"+dResult);
		System.out.println("a%b:"+a%b);
		*/
		/*
		System.out.println("--문자 연산--");
		char ca='A';
		char cz='Z';
		int numOfAlphabet=cz-ca+1;
		System.out.println("알파벳 대문자 개수:"+numOfAlphabet);
		char c='a';
		System.out.println(c);
		int i=c+1;
		char i2 =(char)i;
		System.out.println(i); //b=98
		System.out.println(i2); //b=98
		*/
		System.out.println("--논리 연산자--");
		int kor=-66;
		int eng=77;
		//boolean 이렇게도 정의할 수 있구나 알아두기
		boolean condition1=kor>=0;
		boolean condition2=kor<=100;
		boolean isValidScore=condition1 && condition2;
		//두개 다 만족할 때 true 반환함, 만족 못하면 false 반환함
		
//		if(condition1 && condition2) {
//			System.out.printf("%d는 유효한 점수 입니다.",kor);
//		}
		//System.out.printf("%d는 %b입니다.",kor,isValidScore);
		/*
		System.out.println("--한글 여부 확인--");
		char c='아';
		boolean isHangul=(c>='가' && c<='힣');
		//char의 한글 범위는 가~힣 까지임
		System.out.println("c가 한글인가요? "+isHangul);
		*/
		
		/*
		 * i++와 ++i의 차이
		   -> i++는 i값을 먼저 반환하고!! 그 다음에 1 증가함
		   -> ++i는 1을 먼저 증가 시키고!!! 그 다음에 i값을 반환함
		   따라서 i=5;
		        j=5;
		   sysout(i++); 5출력하고 스택에 i=6 저장
		   sysout(i); 이때 6 출력됨
		   sysout(++j); 6출력됨
		 */
		System.out.println("--switch문--");
		int level=5;
		switch (level) {
		case 1: 
			System.out.println("초보");
			break;
		case 2:
			System.out.println("중수");
			break;
		case 3:
			System.out.println("고수");
			break;
		default:
			System.out.println("시작 레벨은 0 입니다.");
		}
		
		
		
	}
}
