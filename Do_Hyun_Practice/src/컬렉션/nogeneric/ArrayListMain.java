package 컬렉션.nogeneric;

import java.util.ArrayList;
import java.util.Iterator;

//ArrayList 클래스의 기본적인 add, set, get, remove, equals 등등 메소드 알아보기
//큰 원리: 어떤 클래스의 필드(멤버필드, 멤버메소드)등등을 사용하고 싶으면 항상 그 타입으로 캐스팅을 해야 쓸 수 있음!

public class ArrayListMain {

	public static void main(String[] args) {
		//Acoount 객체 생성
		Account acc1 = new Account(1111, "BING", 33000, 0.5);
		Account acc2 = new Account(2222, "KING", 12000, 0.1);
		Account acc3 = new Account(3333, "KING", 89000, 0.8);
		Account acc4 = new Account(4444, "YONG", 45000, 1.2);
		Account acc5 = new Account(5555, "SANG", 99000, 0.9);
		
		//ArrayList의 배열 객체 생성해서 각 Account 객체 담기 : add로 담는다?
		ArrayList accountList=new ArrayList();
		//=ArrayList<Object> accountList=new ArrayList<Object>();이거랑 같음: 타입 안정함
		
		int size=accountList.size();
		System.out.println("추가 전 accountList의 size: "+size); //0
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		//accountList.add(acc4);
		//accountList.add(acc5);
		System.out.println("추가 후 accountList의 size: "+accountList.size()); //3
		System.out.println(accountList);
		System.out.println();
		
		System.out.println("1. add(index, element): 지정된 인덱스에 객체 저장하기->그 인덱스에 원래 있던 객체는 뒤로 하나씩 밀림, 삭제되는 것 아님");
		accountList.add(1, acc4);
		System.out.println(accountList);
		System.out.println("추가 후 accountList의 size: "+accountList.size()); //3->4
		System.out.println();
		
		System.out.println("2. set(index, element): 지정된 인덱스에 객체 저장하기->그 인덱스에 원래 있던 객체 대체!!함");
		accountList.set(0, acc5);
		System.out.println(accountList);
		System.out.println("추가 후 accountList의 size: "+accountList.size()); //그대로 4임
		System.out.println();
		
		System.out.println("3. get(index) 메소드");
		//Account 클래스의 print()메소드 사용하려고 함
		Account accountObject1 =(Account)accountList.get(1);
		accountObject1.print();
		System.out.println();
		
		System.out.println("4. remove(index) 메소드");
		accountList.remove(1);
		System.out.println(accountList);
		System.out.println("삭제 후 accountList의 크기: "+accountList.size()); //3
		System.out.println();
		
		System.out.println("************업무 실행************");
		System.out.println("1. 계좌 전체 출력");
		/*
		 * 	for(Account accountArray: accountList) {
			
		} -> Type mismatch: cannot convert from element type Object to Account라는 오류가 뜸
		  -> ArrayList<Object> accountList=new ArrayList<Object>(); 
		     =ArrayList accountList=new ArrayList(); 이거랑 같음: 타입 안정했는데 Account라고 써놔서 에러뜨는거임
		 */
		for(Object accountArray: accountList) {
			((Account)accountArray).print();
		}
		
		System.out.println("2. 계좌번호 3333 찾기");
		for(int i=0;i<accountList.size();i++) {
			Account accountInfo=(Account)accountList.get(i);
			if(accountInfo.getNo()==3333) {
				accountInfo.print();
				break;
			}
		}
		
		System.out.println("3. 계좌주 이름 KING인 계좌 모두 찾기, enhanced for문 사용하기");
		for(Object accountArray: accountList) {
			Account tempAccount=(Account)accountArray;
			if(tempAccount.getOwner()=="KING") {
				tempAccount.print();
			}
		}
		
		System.out.println("4. 계좌번호 5555 한개 삭제");
		for(int i=0;i<accountList.size();i++) {
			Account tempAccount=(Account)accountList.get(i);
			if(tempAccount.getNo()==5555) {
				accountList.remove(tempAccount);
			}
		}System.out.println(accountList);
		
//		System.out.println("5. 계좌주 이름이 KING인 계좌 모두 삭제");
//		/*
//		 * 인덱스 0번이 삭제되면 1번이 0번으로 됨->자리 당겨져서 인덱스가 변경됨 
//		 *                               이 문제를 해결하기 위해서는 요소를 삭제한 후에 
//		 *                               i 변수를 감소시켜 다음 요소를 건너뛰지 않도록 해야함
//		 * 해결방법1) 삭제 후 인덱스 -1 해줘야함: i--;
//		 * 해결방법2) "Iterator"를 사용해서 요소 삭제할 수도 있음
//		 * 
//		 * 
//		 */
//		System.out.println("삭제 전: "+accountList);
//		for(int i=0;i<accountList.size();i++) {
//			Account tempAccount=(Account)accountList.get(i);
//			if(tempAccount.getOwner().equals("KING")) {
//				accountList.remove(i);
//				//i--; ->이거로 인덱스 -1해줘야함
//			}
//		}System.out.println("삭제 후: "+accountList);
//		
		System.out.println();
		System.out.println("5-1. 계좌주 이름이 KING인 계좌 모두 삭제: Iterator 클래스 사용");
		System.out.println("삭제 전: "+accountList);
	
		System.out.println("--Iterator 사용하여 삭제하기--");
		Iterator<Object> iterator=accountList.iterator();
		//accountList라는 배열에서 순회하면 객체를 얻기 위해 iterator()메소드 실행해 객체 반환받아서 iterator 변수에 저장함
		while(iterator.hasNext()) {
			Account tempAccount=(Account)iterator.next();
			if(tempAccount.getOwner().equalsIgnoreCase("KING")) {
				iterator.remove();
			}
		}
		System.out.println("삭제 후: "+accountList);
		
		
	}

}
