package OOP;

import java.util.Arrays;

public class PrimitiveTypeArrayStudentMain implements Comparable<PrimitiveTypeArrayStudentMain>{
	//정렬하기->compareTo 메소드 사용 + totArray로 오름차순 정렬...?
	/*
	 * 내가 헷갈렸던 부분: 객체가 아닌데 PrimitiveTypeArrayStudentMain other를 넣어서 비교할 수 있느냐
	 * -> , compareTo 메소드의 파라미터인 other는 PrimitiveTypeArrayStudentMain 타입의 변수이며, 객체를 참조하는 역할을 함 
	 * -> compareTo 메소드는 현재 객체와 비교할 다른 객체를 전달받아 비교 작업을 수행하는 메소드임
	 * -> PrimitiveTypeArrayStudentMain 클래스가 Comparable<PrimitiveTypeArrayStudentMain> 인터페이스를 구현하면 배열에 저장된 요소들!!!을 정렬할 수 있음. 
	 * -> 따라서 Comparable 인터페이스를 구현한 클래스의 객체가 없어도, 배열의 요소를 정렬하기 위해 Comparable 인터페이스를 사용할 수 있음
	 */
	int totArray =0;
	@Override
	public int compareTo(PrimitiveTypeArrayStudentMain other) {
		//오름차순
		if(this.totArray>other.totArray) {
			return 1;
		}else if(this.totArray<other.totArray) {
			return -1;
		}
		return 0;
		//내림차순
//		if(this.totArray-other.totArray>0) {
//			return -1;
//		}else if(this.totArray-other.totArray<0) {
//			return 1;
//		}else return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("--배열 객체 생성 초기화--");
		int[] noArray= {1,2,3,4,5,6,7,8,9,10};
		String[] nameArray = { "KIM", "LEE", "PARK", "CHOI", "SIM", "KIM", "PIM", "MIN", "AIM", "LIM" };
		int[] korArray = { 12, 80, 34, 80, 0, 93, 80, 61, 100, 80 };
		int[] engArray = { 32, 46, 64, 96, 0, 98, 62, 81, 100, 99 };
		int[] mathArray = { 93, 89, 88, 46, 54, 23, 90, 85, 100, 34 };
		int[] totArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] avgArray = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		char[] gradeArray = { 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F' };
		int[] rankArray = { 0,0,0,0,0,0,0,0,0,0,0};
		
		/*
		 * 총점, 평균, 평점 계산
		 */
		
		//총점
		for(int i=0;i<noArray.length;i++) {
			totArray[i]=korArray[i]+engArray[i]+mathArray[i];
			avgArray[i]=totArray[i]/3.0;
			
			//평점
			if(avgArray[i]>=90) {
				gradeArray[i]='A';
			}else if(avgArray[i]>=80) {
				gradeArray[i]='B';
			}else if(avgArray[i]>=70) {
				gradeArray[i]='C';
			}else if(avgArray[i]>=60) {
				gradeArray[i]='D';
			}gradeArray[i]='F';
		}
		
		//총점으로 석차계산-> 2번 학생의 석차 계산하기
		//두개 비교해서 총점 높으면 rank를 1++하면 됨->못할수록 7,8등으로 rank 높아짐
		for(int i=0;i<noArray.length;i++) {
			if(totArray[3]<=totArray[i]) {
				rankArray[3]++;
			}
		}
		System.out.println("1번 학생의 석차는?: "+rankArray[3]+"등"); 
		
		//총점으로 석차계산-> no=n인 학생의 석차 계산하기
		for(int i=0;i<noArray.length;i++) {
			rankArray[i]=0;
			for(int j=0;j<noArray.length;j++) {
				if(totArray[i]<=totArray[j]) {
					rankArray[i]++;
				}
			}
		}
		System.out.println("총점으로 n번의 학생의 석차 확인하기: "+rankArray[8]+"등");
		
		//학생 검색: 번호가 3번인 학생의 정보 출력
		System.out.println("학생번호 3번의 학생 정보를 출력합니다.");
		for(int i=0;i<noArray.length;i++) {
			if(noArray[i]==3) {
//				System.out.println("국어점수: "+korArray[i]+"점");
//				System.out.println("영어점수: "+engArray[i]+"점");
//				System.out.println("수학점수: "+mathArray[i]+"점");
				System.out.printf("%s %2d\n %5s %2d\n %5s %2d\n","국어점수:",korArray[i],"영어:", engArray[i], "수학:", mathArray[i]);
			}
		}
		
		//국어 점수 80인 학생 수, 정보 출력하기
		int count=0;
		for(int i=0;i<noArray.length;i++) {
			if(korArray[i]==80) {
				count++;
			}
		}
		System.out.println("국어점수 80점인 학생의 수: "+count+"명");
		
		System.out.println("totArray를 오름 차순으로 정렬해보겠습니다.");
		//자동적으로 compareTo 메소드 사용하게 됨
		Arrays.sort(totArray);
		System.out.println("compareTo 메소드를 사용해 오름차순 정렬된 totArray: "+Arrays.toString(totArray));
		
		//swap, temp 개념 이해하기
		int a=10;
		int b=3;
		int temp;
		System.out.println("a: "+a); //10
		System.out.println("b: "+b); //3
		temp=a; //temp=10
		a=b;    //a=3
		b=temp; //b=10
		System.out.println("a: "+a); //3
		System.out.println("b: "+b); //10
		
		//변수 사용해서 학생 총점 내림차순 정렬하기
		for(int i=0;i<noArray.length;i++) {
			for(int j=0;j<noArray.length;j++) {
				if(totArray[i]>totArray[j]) {
					int tempTot=0;
					temp=totArray[i];
					totArray[i]=totArray[j];
					totArray[j]=tempTot;
				}
			}
		}
		System.out.println(Arrays.toString(totArray));
		
		
		
	
	}
}
