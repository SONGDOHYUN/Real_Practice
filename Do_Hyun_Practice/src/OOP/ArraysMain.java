package OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



// 배열타입 [] 배열 이름={};
/* 배열 객체 생성 시
 * -일단 배열 크기 설정한다. 그리고 객체 생성하거나 값 넣는다.
 * -일반 객체 생성 시: Account(클래스 이름) plainA= new Account();
 * -배열 객체 생성 시: AccountArray(배열 클래스 이름)[] arrayA=new AccountArray[개수];
 * -------------- <데이터_타입>[] <배열_이름> = new <데이터_타입>[<크기>];
 * -------------- double[] grades = {1.5, 2.8, 3.7};
 * 
 *******************중요]
 *
	 배열:  
	      - 같은데이타형을 가진 멤버필드(기억장소) 여러개의 모음타입 
	      - 배열타입변수의 선언형식
	           데이타타입[] 이름;  ex> int[] ia; , char[] ca;
		  - 사용: 
		       1.배열타입객체의생성	
			   2.배열객체멤버필드의 초기화 
	      -특징   
			  1.모든 배열형의 변수는 참조변수이다.
			    (배열은 객체다.)
			  2.같은타입만 정의가가능하다 
			  3.길이가 고정되어있다. 
 * 
 */


public class ArraysMain {

	public static void main(String[] args) {
		int[] intArrays= {1,3,5,7,9};
		String[] strArrays1= {"가","나","다"};
		String[] strArrays2= {"가","나","다"};
		System.out.println(Arrays.toString(strArrays2));
		
		//Arrays.equals(): 각 배열 비교해서 동일한지 확인함
		System.out.println("--1. 배열 비교--");
		boolean isSame=Arrays.equals(strArrays1, strArrays2);
		System.out.println(isSame);
		
		//Arrays.fill(): 배열 개수를 다 설정된 숫자로 채움
		System.out.println("--2. 배열 원소 채우기--");
		//Arrays.fill(intArrays, 1); //[1,1,1,1,1] 나옴
		//System.out.println(Arrays.toString(intArrays));
		
		//Q. arraysA에 {1,2,3,4,5}로 설정하려면? ->향상된 for문 말고 일반 for문 써서 숫자 채움
		int[] arrayA=new int[5]; //{0,0,0,0,0}
		for(int i=1;i<arrayA.length+1;i++) {
			arrayA[i-1]=i;
		}
		System.out.println("arraysA에 숫자 채우면: "+Arrays.toString(arrayA));
		
		//Arrays.copyOf()
		System.out.println("--3. 배열 복사--");
		int[] intArrays3=Arrays.copyOf(intArrays, intArrays.length+3);
		System.out.println(Arrays.toString(intArrays3));
		System.out.println();
		
		System.out.println("--3-1. 참조형 배열 복사--");
		
		//설정 -> 배열 객체 만들려고 "AccountArray"라는 클래스 설계도 만들었음
		AccountArray[] account= {
				new AccountArray(2222, "LEE", 56000, 0.9),
				new AccountArray(1111, "KIM", 58900, 1.3),
				new AccountArray(3333, "PARK", 90000, 3.3),
		};
		System.out.println("account 배열 출력: "+Arrays.toString(account));
		
		AccountArray[] newCopyArray1= Arrays.copyOf(account, 5);
		System.out.println("newCopyArray1 배열 출력: "+Arrays.toString(newCopyArray1)); 
		//->복사하려는 배열보다 길게 복사하려하면 남는 배열값은 null로 설정됨
		AccountArray[] newCopyArray2=Arrays.copyOfRange(account, 0, 6); //인덱스 0-5까지만 출력됨
		System.out.println("newCopyArray2 배열 출력: "+Arrays.toString(newCopyArray2));
		System.out.println("-------향상된 for문 사용-------");
		for(AccountArray newCopyArray3:account) {
			System.out.println(newCopyArray3);
		}
		AccountArray[] newCopyArray4=new AccountArray[account.length+1];
		System.out.println("newCopyArray4 배열 출력: "+Arrays.toString(newCopyArray4)); //null값 4개 생성됨
		//System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(account, 0, newCopyArray4, 0, account.length);
		System.out.println("newCopyArray4의 복사 후 배열 출력: "+Arrays.toString(newCopyArray4));
		
		System.out.println("----------------Arrays.sort(): 오름차순함----------------");
		int[] scoreArray= {70,10,20,30,40,50};
		String[] nameArray= {"Song","Kim","Park"};
		Arrays.sort(nameArray);
		System.out.println(Arrays.toString(nameArray));
		for(String name: nameArray) {
			System.out.print(" name: "+name);
		}
		System.out.println();
		System.out.println("---------Arrays.sort()-Comparable: compareTo() 사용함-----------");
		AccountArray.headerPrint();
		for(AccountArray newCopyArray5: account) {
			newCopyArray5.print();
		}
		List<AccountArray> AccountList=new ArrayList<>();
		for(AccountArray newCopyArray6:account) {
			AccountList.add(newCopyArray6);
		}
		System.out.println("AccountList 출력하기: "+AccountList);
		//Arrays.sort(AccountList); -> List 타입의 AccountList는 Arrays.sort()로 정렬할 수 없음
		//Collections.sort(AccountList);
		System.out.println("정렬된 AccountList 출력하기: "+AccountList);
		//AccountArray Class에서 Comparable 인터페이스를 사용해서 compare() 메소드를 잔고 기준으로 내림차순하게 오버라이딩했음->Arrays.sort() 쓰면 오버라이딩 된 메소드를 사용해서 알아서 정렬됨
		
		System.out.println("---------Arrays.sort()-Comparator: compare() 사용함-----------");
		//sort 중 배열과 Comparator의 객체를 비교함
		Arrays.sort(account, new AccountBalanceDescComparator());
		for(AccountArray newCopyArray7: account) {
			newCopyArray7.print();
		}
		
		
		
		
	}
}
