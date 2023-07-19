package 컬렉션.nogeneric;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {

	public static void main(String[] args) {
		//객체 생성
		Account acc1 = new Account(1111, "BING", 33000, 0.5);
		Account acc2 = new Account(2222, "KING", 12000, 0.1);
		Account acc3 = new Account(3333, "KING", 89000, 0.8);
		Account acc4 = new Account(4444, "YONG", 45000, 1.2);
		Account acc5 = new Account(5555, "SANG", 99000, 0.9);
		
		HashSet<Object> accountSet=new HashSet<Object>();
		System.out.println("추가 전 set size: "+accountSet.size()); //0
		accountSet.add(acc1);
		accountSet.add(acc2);
		accountSet.add(acc3);
		accountSet.add(acc4);
		accountSet.add(acc5);
		System.out.println("추가 후 set size: "+accountSet.size()); //5
		System.out.println(accountSet); //순서없이 마구잡이로 출력되는 거 볼 수 있음
		
		System.out.println("add: 중복객체");
		boolean isAdd=accountSet.add(acc1);
		System.out.println("추가할 수 있는가?: "+isAdd);
		System.out.println(accountSet.size());
		
		System.out.println("remove: 객체 삭제");
		boolean isRemove=accountSet.remove(new Account());
		//remove(new Account()): accountSet에서 new Account()와 동일한 요소를 삭제한다는 뜻
		//그런데 new Account()는 생성자이기 때문에 remove 메소드 실행 시 새로운 객체가 생성되므로 이미 set안에 있는 객체는 삭제할 수 없음->그래서 false나옴
		//!!!!!!!!즉, 삭제할 수 없는 새로운 객체이므로 false가 반환됨
		//삭제 성공하면 true, 아니면 false를 isRemove에 저장함
		System.out.println("삭제할 수 있는가?: "+isRemove);
		boolean isRemove1=accountSet.remove(acc5);
		System.out.println("삭제할 수 있는가?: "+isRemove1);
		System.out.println(accountSet); //no=5555번 삭제됨
		
		System.out.println("--전체출력: Iterator 사용--");
		Iterator<Object> iterator=accountSet.iterator();
		while(iterator.hasNext()) {
			Account account =(Account)iterator.next();
			account.print();
			//Object tempAccount=iterator.next();
			//System.out.println(tempAccount);
		}
		
		System.out.println("--전체출력: enhanced for문 사용--");
		for(Object tempAccount: accountSet) {
			Account account=(Account)tempAccount;
			account.print();
		}
		
		System.out.println("--전체출력: toArray(Object[]출력)--");
		Object[] accountArray= accountSet.toArray(); //accountSet을 배열형태로 만듬-> 따로 담아야함
		for(Object account: accountArray) {
			Account realAccount=(Account)account;
			realAccount.print();
			//System.out.println(account);
		}
		
		
		
	}

}
