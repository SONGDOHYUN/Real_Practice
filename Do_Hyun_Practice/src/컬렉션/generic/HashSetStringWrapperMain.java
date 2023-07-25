package 컬렉션.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HashSetStringWrapperMain {

	public static void main(String[] args) {
		//객체 생성
		Account acc1 = new Account(1111, "BING", 11000, 1.0);
		Account acc2 = new Account(2222, "KING", 22000, 2.0);
		Account acc3 = new Account(3333, "KING", 33000, 3.0);
		Account acc4 = new Account(4444, "YONG", 44000, 4.0);
		Account acc5 = new Account(5555, "SANG", 55000, 5.0);
		
		HashSet<Account> accountSet=new HashSet<Account>();
		accountSet.add(acc1);
		accountSet.add(acc2);
		accountSet.add(acc3);
		accountSet.add(acc4);
		accountSet.add(acc5);
		accountSet.add(new Account(6666, "주인6",66000, 6.0));
		System.out.println("추가 후: "+accountSet); //순서 마음대로 됨
		//List<Account> list=(List<Account>)accountSet; ->List랑 HashSet은 서로 상속도 아닌 관련 없는 클래스라 캐스팅 안됨
		//Collections.sort(list);
		//정렬하려면 List로 accountSet을 담으면 됨
		List<Account> list=new ArrayList<Account>(accountSet);
		Collections.sort(list);
		System.out.println("정렬 후: "+list);
		System.out.println();
		
		System.out.println("전체출력");
		for(Account accountList:list) {
			accountList.print();
		}
		System.out.println();
		
		System.out.println("--String Wrapper--");
		HashSet<String> nameList=new HashSet<String>();
		nameList.add("주인1");
		nameList.add("주인2");
		nameList.add("주인3");
		nameList.add("주인4");
		System.out.println("추가 후: "+nameList);
		System.out.println("추가 후 크기: "+nameList.size());
		
		//List 타입으로 담아서 Collections.sort()로 오름차순 정렬시키기
		List<String> name=new ArrayList<String>(nameList);
		Collections.sort(name);
		System.out.println("졍렬 후 nameList: "+name);
		boolean isAdd=nameList.add("주인5");
		System.out.println("추가 가능? "+isAdd);
		
		System.out.println("--Integer Wrapper--");
		//Math.random()-> 0부터 1까지의(1 미포함) 난수 발생시킴 : 0이상 1미만
		HashSet<Integer> intList=new HashSet<Integer>();
		System.out.println(">>>"+intList); //아직 뭐 없음
		while(intList.size()<6) { //size가 5이면
			intList.add((int)(Math.random()*45+1)); //1이상~46미만(미포함) 까지의 난수 발생
			//요소 한개 더 추가됨
		}System.out.println(intList); //size가 6이면 더 생성안되고 while문 종료->따라서 총 6개 나옴
		
		
		//size 숫자 설정하는 것 잘하기
		System.out.println("LottoSet으로 45 숫자에서의 7개 숫자 랜덤하게 뽑기");
		HashSet<Integer> lotto=new HashSet<Integer>();
		while(lotto.size()<=6) {
			lotto.add((int)((Math.random()*45)+1));
		}System.out.println(lotto);
		
		
		
		
		
		
		
	}

}
