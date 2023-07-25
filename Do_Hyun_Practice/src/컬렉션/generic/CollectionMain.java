package 컬렉션.generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionMain {

	public static void main(String[] args) {
		//Arrays 메소드 사용해서 List 생성하기
		List<Integer> intList=Arrays.asList(1,6,2,7,3,4,5); 
		//리스트로 바꿔주는 메소드여서 변수 받을 때 타입은 List 타입으로 바꿔야함
		List<String> nameList=Arrays.asList("1번", "9번","7번","2번","8번", "3번","4번","5번");
		System.out.println(intList);
		System.out.println(nameList);
		
		System.out.println("--String, Wrapper--");
		System.out.println(">>sort[Integer]>>"); //기본적으로 오름차순임
		System.out.println("정렬 전 List "+intList);
		System.out.println("정렬 전 List "+nameList);
		Collections.sort(intList);
		Collections.sort(nameList);
		System.out.println("정렬 후 List "+intList);
		System.out.println("정렬 후 List "+nameList);
		
		System.out.println(">>reverse>>");
		Collections.reverse(intList);
		Collections.reverse(nameList);
		System.out.println("reverse 정렬 후 List "+intList);
		System.out.println("reverse 정렬 후 List "+nameList);
		
		System.out.println(">>shuffle>>"); //랜덤으로 정렬
		Collections.shuffle(intList);
		Collections.shuffle(nameList);
		System.out.println("shuffle 정렬 후 List "+intList);
		System.out.println("shuffle 정렬 후 List "+nameList);
		System.out.println();
		
		System.out.println(">>>>>>>>Account>>>>>>>");
		List<Account> accountList=Arrays.asList(
				new Account(4523,"BING",33000,0.5),
				new Account(2367,"KING",23000,0.1),
				new Account(1234,"KING",89000,0.2),
				new Account(8909,"YONG",99000,0.7),
				new Account(2789,"SANG",12000,0.3)
				);
		System.out.println("그냥 리스트 출력: "+accountList);
		Collections.sort(accountList);
		System.out.println("정렬 후 리스트 출력: "+accountList);
		Collections.reverse(accountList);
		System.out.println("reverse 정렬 후 리스트 출력: "+accountList);
		Collections.shuffle(accountList);
		System.out.println("shuffle 정렬 후 리스트 출력: "+accountList);
		
		System.out.println();
		System.out.println("--sort[Comparator]--");
		System.out.println("balance를 내림차순: 높은 것 부터 나오게 정렬하겠습니다");
		Collections.sort(accountList, new AccountBalanceDescComparator());
		/*List를 커스텀한 비교자 클래스의 객체!!로 정렬하겠다는 코드임
		 *첫 번째 인자로 정렬할 컬렉션을 전달하고(accountList) 
		 *두 번째 인자로는 정렬에 사용할 Comparator 객체!!를 전달함.->그래서 new 생성자 쓴거임 
		 *Comparator 객체!!는 컬렉션의 요소들을 비교하여 정렬 기준을 제공하는 역할을 합니다.
		*/
		System.out.println("정렬 후: "+accountList);
		System.out.println("Owner이름으로 오름차순하여 정렬하겠습니다");
		Collections.sort(accountList,new AccountOwnerAscComparator());
		System.out.println("정렬 후: "+accountList);
	}

}
