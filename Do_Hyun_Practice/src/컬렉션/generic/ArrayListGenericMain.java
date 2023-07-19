package 컬렉션.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListGenericMain {

	public static void main(String[] args) {
		//객체생성
		Account acc1 = new Account(1111, "BING", 33000, 0.5);
		Account acc2 = new Account(2222, "KING", 12000, 0.1);
		Account acc3 = new Account(3333, "KING", 89000, 0.8);
		Account acc4 = new Account(4444, "YONG", 45000, 1.2);
		Account acc5 = new Account(5555, "SANG", 99000, 0.9);
		
		//ArrayList 리스트 배열 객체 생성
		ArrayList<Account> accountList=new ArrayList<Account>();
		System.out.println("배열 리스트 생성: "+accountList); //아직 아무것도 없음
		System.out.println("배열 리스트 크기: "+accountList.size()); //0
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
		accountList.add(new Account(6666, "ZONG", 60000, 6.0));
		System.out.println("추가 후 배열 리스트 생성: "+accountList); 
		System.out.println("추가 후 배열 리스트 크기: "+accountList.size()); //6
		
		System.out.println("--set[element]--");
		Account acc6=new Account(1, "주인1", 1000, 1.0);
		accountList.set(0, acc6);
		System.out.println("set 후 배열: "+accountList);
		System.out.println("set 후 배열: "+accountList.size()); //6
		
		System.out.println("--get[element]--");
		System.out.println("0번 인덱스 정보: "+accountList.get(0));
		Account account=accountList.get(0);
		account.print();
		account.setOwner("바뀐 주인 1");
		System.out.println("변경 후 accountList: "+accountList);
		
		System.out.println("--remove[element]--");
		accountList.remove(0);
		System.out.println("삭제 후 0번 인덱스는 당겨짐?: "+accountList.get(0)); //당겨짐
		System.out.println("삭제 후: "+accountList);
		System.out.println("삭제 후: "+accountList.size()); //5
		System.out.println();
		
		System.out.println("******업무실행*****");
		System.out.println("--계좌전체출력: 향상 for문--");
		Account.headerPrint();
		for(Account accountArray: accountList) {
			accountArray.print();
		}
		
		System.out.println("--일반 for 문--");
		for(int i=0;i<accountList.size();i++) {
			accountList.get(i).print();
		}
		
		System.out.println("--Iterator 사용--");
		Iterator<Account> accountArray=accountList.iterator(); //객체 반환해서 accountArray에 담음
		while(accountArray.hasNext()) {
			Account account1=accountArray.next();
			account1.print();
		}
		
		System.out.println("--1. 계좌번호 3333 찾기--");
		for(int i=0;i<accountList.size();i++) {
			if(accountList.get(i).getNo()==3333) {
				accountList.get(i).print();
				break;
			}
		}
		
		System.out.println("--2. 계좌주 KING 모두 찾기--");
		for(Account array:accountList) {
			if(array.getOwner().equalsIgnoreCase("KING")) {
				array.print();
			}
		}
		
		System.out.println("--3. 계좌번호 4444 삭제--");
//		for(Account array: accountList) {
//			if(array.getNo()==4444) {
//				accountList.remove(array);
//			}
//		}
		
		Iterator<Account> accountArray1=accountList.iterator();
		while(accountArray1.hasNext()) {
			if(accountArray1.next().getNo()==4444) {
				accountArray1.remove();
			}
		}
		System.out.println("삭제 후: "+accountList);
		
		System.out.println("--4. KING 계좌 여러개 삭제--");
		Iterator<Account> accountArray2=accountList.iterator();
		while(accountArray2.hasNext()) {
			if(accountArray2.next().getOwner().equalsIgnoreCase("KING")) {
				accountArray2.remove();
			}
		}
		System.out.println("삭제 후: "+accountList);
		
		
		
		
		
	}

}
