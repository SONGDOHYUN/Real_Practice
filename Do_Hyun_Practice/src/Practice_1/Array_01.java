package Practice_1;

import java.util.Arrays;

import OOP.AccountArray;

public class Array_01 {

	public static void main(String[] args) {
		
		/*
		 * 배열 문법:
		 * -> 1. String[] names={"1", "2", "3"};
		 * -> 2. String[] names = new String[]{"Alice", "Bob", "Carol"}; 
		 * -> String 배열 생성 및 초기화
		 * 
		 * 배열에 객체 생성 문법:
		 * -> 배열 문법 1번 변형: 객체 하나하나씩 생성해서 담기
		 * 	AccountArray[] account= {
				new AccountArray(2222, "LEE", 56000, 0.9),
				new AccountArray(1111, "KIM", 58900, 1.3),
				new AccountArray(3333, "PARK", 90000, 3.3),
		};
		
		-> 아니면 배열 문법 2번 변형
		 accountMany.acc2 = new AccountArray[] {
			    new AccountArray(2, "주인2", 2000, 2.0),
			    new AccountArray(3, "주인3", 3000, 3.0),
			    new AccountArray(4, "주인4", 4000, 4.0)
			};
		
		 */
		
		
		/*
		 * 일반 for 문
		 * ->for(초기값;조건식;증감식->int i=0;i<5;i++)
		 * 향상된 for 문
		 * ->for(돌릴 배열의 변수타입+변수명:돌릴 배열명){
		 *   반복할 코드}
		 *   ->배열의 크기로 반복 횟수가 정해진다.
		 *   ->배열에 있는 모든 element 값들이 대입된다.
		 * 
		 */
	
		int[] arry1= {1,2,3,4,5};
		for(int i:arry1) {
			//System.out.println("배열 출력 결과: "+i);
			if(i!=arry1.length) {
				System.out.print(i+",");
			}else
			System.out.print(i);
		}
		System.out.println();
	/*
	 *  배열의 복사
	 *  $$주의$$))변수명=변수명하면 
	 *  같은 주소값을 참조하므로 한배열 값 변경 시 
	 *  다른 배열 값도 같아져서 안됨
	 *  
	 *  1. object.clone() in Object 클래스에서 제공
	 *  -> 새로운 !! 객체를 생성하고 복사함 ->주소값 다름
	 *  
	 *  2-0. 전체복사>> Arrays.copyOf(복사할 배열, 복사할 배열의 크기[length]), 
	 *  2-1. 부분복사>> Arrays.copyOfRange(복사할 배열, 복사시작인덱스, 복사 끝 인덱스) in Arrays 클래스에서 제공
	 *  -> 배열을 전체 또는 부분적으로 복사할 수 있음
	 *  -> copyOfRange는 복사시작 인덱스~복사 끝 인덱스지만 실제 출력값은 복사 끝 인덱스 -1한 값까지로만 나온다.
	 *  -> 지정 범위를 벗어나서 복사하려고 하면 default 값으로 0이 들어가게 된다.
	 *  
	 *  3. System.arraycopy(src, srcPos, dest, destPos, length);
			src - 원본 배열
			srcPos - 원본 배열의 복사 시작 위치
			dest - 복사할 배열
			destPost - 복사할 배열의 복사 시작 위치
			length - 복사할 요소의 개수
	 */
	
	int[] scores= {1,2,3,4,5};
	int[] newScores=scores; //newScores에 scores 참조값이 복사됨
	System.out.println(scores); //주소값이 나옴
	System.out.println(scores[1]); //1번째 인덱스 값인 "2"가 나옴
	System.out.println(scores.toString());//scores의 주소값을 문자열로 출력해라 라는 뜻
	System.out.println(Arrays.toString(scores));//이래야 scores에 들어있는 배열값들이 나옴
	System.out.println(Arrays.toString(newScores));
	
	//각 배열의 값들을 변경할 때->scores만 바꿨는데도 newScores 값도 변경됨(서로 같은 주소/참조값을 가지기 때문)
	scores[1]=3; //인덱스 1번 값인 "2"->"3"으로 변경함
	System.out.println(Arrays.toString(scores));
	System.out.println(Arrays.toString(newScores));
	
	//복사된 배열의 값 변경할 때
	newScores[1]=1111;
	System.out.println(Arrays.toString(newScores));
	System.out.println(Arrays.toString(scores));
	
	//object.clone();
	int[] score= {1,2,3,4,5};
	int[] cloneScore= score.clone(); // 새로운 객체가지고 배열값 복사됨(주소값 다름)
	cloneScore[0]=0; //값 변경해도 cloneScore 값만 변경됨
	System.out.println(Arrays.toString(cloneScore));
	System.out.println(Arrays.toString(score));
	
	//Arrays.copyOf(), copyOfRange()
	String[] score1= {"가","나","다"};
	String[] newScore1=Arrays.copyOf(score1, score1.length); //score1 배열 전체 복사
	String[] newScore2=Arrays.copyOf(score1, 2); //score1의 앞에서부터 2개의 element 부분 복사
	String[] newScore3=Arrays.copyOfRange(score1, 1, 3); //score1의 인덱스 중 1~2번까지의 값이 나온다.
	String[] newScore4=Arrays.copyOfRange(score1, 2, 5); //score1의 인덱스 2~4번까지의 값나오고 범위 초과 시 default값인 "0" or "null"이 배열에 담겨 나온다.
	System.out.println(Arrays.toString(newScore1));
	System.out.println(Arrays.toString(newScore2));
	System.out.println(Arrays.toString(newScore3));
	System.out.println(Arrays.toString(newScore4));
	
	//System.arraycopy()
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
	
	/*
	 * 다차원 배열
	 * 1. 2차원 배열: 1차원 배열을 요소로 가지는 배열
	 * ->타입[세로축][가로축] 배열이름 | 타입 배열이름[][] | 타입[]배열이름[]
	 */
	int[][]arr1=new int[2][3];
		/*
		 * arr1이 (0,0) (0,1) (0,2)
		 * 		 (1,0) (1,1) (1,2) 
		 */
	int sum=1;
	for(int i=0;i<2;i++) { //for(int i=0;i<arr1.length;i++) 과 같음
		for(int j=0;j<3;j++) { //for(int j=0; arr1[i].length;i++) 과 같음
			arr1[i][j]=sum;
					sum++;
		}//각 배열에 값을 저장했음
	}
	for(int i=0;i<2;i++) {
		for(int j=0;j<3;j++) {
		 System.out.print(arr1[i][j]+"\t");
		}
		
	}
	System.out.println();
	int sum1=1;
	int [][] array2=new int[2][5];
	for(int i=0;i<array2.length;i++) {
		for(int j=0;j<array2[i].length;j++) {
			array2[i][j]=sum1;
			sum1++;
			System.out.println(sum1);
		}
	}
	
	//Arrays.equals(배열1, 배열2)-> 배열의 원소가 같은지 비교해줌
	
	
	}
}
	


