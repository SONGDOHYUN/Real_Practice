package Practice_1;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		//변수 선언
		int a;
		int b;
		//int a, b;-> 이것도 같은거임
		//변수 초기화
		a=25;
		b=20;
		System.out.println("a :"+a+" b :"+b);
		
		//두 변수의 값 교환하기
		int x= 10;
		int y= 20;
		int temp;
		temp=x; //temp=10
		x=y; //x=20
		y=temp; //y=10
		//System.out.println("x: "+x+" y:"+y+" temp:"+temp);
		
		//상수 선언=한번 값 입력하면 변환할 수 없음, 상수 값은 대문자로 하는게 관례임...
		final int NUMBER=20;
		
		//리터럴: 그냥 값 그 자체->위의 식에선 20이라는 값을 의미함
		//접미사: f,d 붙이는데 double이 기본형이라서 숫자 뒤에 따로 f없으면 double 값임
		//float pi=3.14;  이렇게 하면 에러임
		float pi=3.14f;
		char c=' '; // 공백 인정
		
		/*덧셈 연산자는 왼쪽->오른쪽 방향으로 연산을 시행함, 결합 순서에 따라 결과가 달라질 수 있음
		System.out.println("7"+"7"+""); // 77
		System.out.println(7+7+"");// 14
		*/
		
		//printf()는 지시자(specifier)를 사용하여 변수를 여러가지 형식으로 변환하여 출력함
		//지시자는 값을 어떻게 출력할 것인지를 지정해주는 역할을 함 ->printf("큰따옴표 안에 %d,%b,%c,%s하고+(줄바꿈하려면 %n도 넣어줌)",뒤에 해당 리러털, 변수 넣어주기)
		System.out.printf("year=%d",14);
		int age=20;
		System.out.printf("age=%d", age);
		System.out.printf("age=%d year=%d", 20,14);
		System.out.println();
		System.out.printf("age=%d%n year=%d%n", 20,14); //줄바꿈 추가: %n: 출력 후 줄바꿈을 한다는 뜻
		boolean isTrue=true;
		System.out.printf("사실입니까? %b%n", isTrue);
		int finger=10;
		System.out.println("-----------------");
		System.out.printf("finger: [%5d]%n", finger); //5자리로 만듬 + 빈공간 공백+ 오른쪽 정렬-> 출력 시: [_ _ _ 10]
		System.out.printf("finger: [%-5d]", finger); //5자리로 만듬 + 빈공간 공백+ 왼쪽 정렬 -> 출력 시: [10_ _ _]
		System.out.printf("finger: [%05d]%n", finger); //5자리로 만들때 빈공간에 0으로 채움 + 오른쪽 정렬-> 출력 시: [00010]
		//소수점 출력
		double num=3.141592;
		System.out.printf("%.2f",num); //소수점 아래 2자리까지만 반올림하여! 출력
		
		int binum=0b10; //정수임
		//정수를 2진 문자열로 변환해줌
		System.out.printf("binum: %s%n",Integer.toBinaryString(binum));
		
		//화면에서 입력받기
		/*
		Scanner scanner=new Scanner(System.in);
		System.out.println("두자리의 정수를 입력해주세요");
		String input= scanner.nextLine();
		int num=Integer.parseInt(input);
		System.out.println(input);
		*/
		char tab='\t';
		System.out.println(tab);
		
		//형변환
		double d=35.7;
		int score=(int)d;
		System.out.println("score: "+score+"\n");
		System.out.printf("score: %d",score);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
