package Practice_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import 컬렉션.generic.Account;
import 컬렉션.generic.AccountBalanceDescComparator;
import 컬렉션.nogeneric.Car;

/*
 * 0. Generic이란?
 * -> 데이터 타입!!!을 일반화(Generalize)한 것을 의미함
 * -> 하나의 값이 여러 다른 데이터 타입을 가질 수 있도록 하는 방법!
 * -> 특정값(specific)한 값을 갖기보단 필요에 의해 클래스 외부에서 지정할 수 있도록하는 일반(Generic)타입
 * 
 * ★★★★★★★★★해석★★★★★★★★★
 * List<String> nameList=new ArrayList<String>();
 * -> ArrayList 클래스의 배열 객체/리스트를 생성하고 그 !!리스트 안에는 각각 String 타입의 요소들이 저장됨!!
 * -> 그렇게 만들어진 배열 객체/주소값을 nameList에 저장하겠다.
 * 
 * 
 * 0-1. Generic 타입의 사용:클래스 및 인터페이스 선언-> !!객체 생성!!하여 구체적인 타입 명시해준다.
 * <T>-Type: 참조타입만 올 수 있음, 기본형 타입은 Wrapper로 감싸줘야함
 *              Classname<Student>: 사용자가 만든 클래스도 들어갈 수 있음
 * <E>-Element
 * <K>-Key
 * <V>-Value
 * <N>-Number
 * 
 * -> ##예시 //큰 뭉텅이로 생각하기
 * public class Classname<T>{}
 * public Interface InterFaceName<T>{}
 * 
 * Classname<String> className= new ClassName<String>();
 * -> 선언했으면 객체 생성하고 각<>에 해당되는 구체적인 타입을 명시해주면 됨
 * -> className이라는 객체의 제네릭 타입은 String으로 모두 변환됨
 * 
 * 1. 컬렉션 프레임워크란? 다 객체 대상임!!!!!
 * -> 다수의 데이터를 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스와 인터페이스의 집합
 * -> 데이터를 저장하는 자료 구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해놓은 것
 * -> 배열을 보완하는 컬렉션: 사이즈 조정 가능함
 * 
 * 2. 컬렉션 프레임워크에 헷갈렸던 부분
 
 **컬렉션 프레임워크: 데이터를 일관성있게 저장, 관리하기 위한 인터페이스+클래스의 집합
- 구성요소: 인터페이스(Collection, List, Set, Map 등등)
         구현체(ArrayList, LinkedList, HashSet, HashMap 등등)
         알고리즘과 유틸리티 클래스(편한 메소드를 제공하는 클래스라고 보면 됨 for 정렬, 검색, 변환, 복사 등등)
 * 		 예) Arrays!(밑에 메소드 예시 있음), Collections!(sort(), reverse(),shuffle() 등등)
 * 		 예)
 * 			Collections.sort(accountList, new AccountBalanceDescComparator());
 * 
			/*List를 커스텀한 비교자 클래스의 객체!!로 정렬하겠다는 코드임
			 *첫 번째 인자로 정렬할 컬렉션을 전달하고(accountList) 
			 *두 번째 인자로는 정렬에 사용할 Comparator 객체!!를 전달함.->그래서 new 생성자 쓴거임 
			 *Comparator 객체!!는 컬렉션의 요소들을 비교하여 정렬 기준을 제공하는 역할을 합니다.
 * 			
 * 참고1 ))AccountBalanceDescComparator 클래스
 * public class AccountBalanceDescComparator implements Comparator<Account>{
	@Override
	public int compare(Account acc1, Account acc2) {
		return acc2.getBalance()-acc1.getBalance(); //뒤-앞하면 내림차순임
		return acc1.getBalance()-acc2.getBalance(); //앞-뒤하면 오름차순임
		
		0,1,-1를 반환해야하므로 return 타입은 int여야함
	}
}

 * 참고2) AccountOwnerAscComparator 클래스
 * public class AccountOwnerAscComparator implements Comparator<Account>{
	@Override
	public int compare(Account acc1, Account acc2) {
	    //오름차순
		return acc1.getOwner().compareTo(acc2.getOwner());
		//Owner이름으로 내림차순하려면
		//return acc2.getOwner().compareTo(acc1.getOwner()); 하면 됨
		 
		 
		★★헷갈리지말것★★
		이름으로 정렬하는거여도 결국 0,1,-1을 반환하기 때문에 반환타입은 int여야함
	}
}
 * 
 * 
 * ★★★★★★Array[배열] VS List[리스트] 차이점★★★★★★
- 공통점: 둘 다 데이터를 저장하는 자료 구조임

- Array[배열] : 생성 시 크기가 고정됨-> 크기 변경하려면 배열 새로 만들거나 복사해야함
               동일한 타입의 요소만 저장 가능함
               Java에서 기본 자료 구조로 제공되기 때문에 배열과 관련된 다양한 메소드 사용 가능
                   
- List[리스트] : 추가, 수정을 통해 크기 수정 가능
               Generic을 사용해서 다양한 타입의 요소 저장 가능
               Java.util.List라는 클래스를 구현하므로 더 많은 메소드, 기능 사용 가능
               컬렉션 프레임워크에 속함->데이터 관리 용이함

 * 
 * 
 * 3. 대표적인 구현 클래스들 알아보기 : List-ArrayList (부모-자식 관계임, List 인터페이스를 구현하는 다양한 클래스(예: ArrayList, LinkedList)가 있음)
 * 
 * - List, Array[ArrayList 아님]는 부모-자식 관계 아님 : 각 다른 배열 자료 구조임
 * - Arrays와 Array는 다른것임: Arrays는 배열과 관련된 유틸리티 메서드를 제공하는 클래스이고, 
 *                          Array는 고정 크기의 배열 자료 구조임
 *                          
 * ★★★★★★★★★★★★★★★Arrays[JAVA에서 배열 관련 메소드를 제공하는 클래스]의 대표적인 메소드★★★★★★★★★★★★★★★★
 * - toString(): 배열 요소를 문자열로 반환함
 * - equals()
 * - sort(): 배열 객체/요소들을 기본적으로 !!오름차순!!으로 정렬함
 * - binarySearch(): 정렬된 배열에서 특정 요소의 위치를 이진 검색을 통해 찾습니다. 
 * 					 요소가 배열에 존재하는 경우 해당 요소의 인덱스를 반환하고, 
 * 					 없는 경우 삽입 지점의 음수 값으로 반환합니다. 
 * - copyOf()
 * - fill(): 배열의 모든 요소를 특정 값으로 채움
 * - asList(): 배열을 고정된 크기의 리스트로 바꿔줌, 이 리스트 크기는 변경할 수 없음
 * 
 * 예시))
 * 		List<Integer> intList=Arrays.asList(1,2,3,4,5); 
		//리스트로 바꿔주는 메소드여서 변수 받을 때 타입은 List 타입으로 바꿔야함!!
		List<String> nameList=Arrays.asList("1번", "2번", "3번","4번","5번");
 * 
 * 
 * 3-1. List 컬렉션 중 ArrayList: 
 * -> List 인터페이스의 구현 클래스로 ArrayList에 객체를 추가하면 객체가 인덱스로 관리됨
 * -> 객체 저장 시 Object 타입으로 저장되어 모든 종류의 객체 저장할 수 있음
 * -> 따라서 찾아올 때 원래 타입으로 변환해야하므로 형변환(String)이런식으로 감싸는거 꼭 해야함!!!!!!!!!! 
 * -> 생성방법) ArrayList를 생성하기 위해서는 저장할 객체 타입을 파라미터로 표기하고
 *           기본 생성자를 호출하면 됨
 * -> List<String>list=new ArrayList<String>(20);->객체 20개짜리 ArrayList 만듬, 설정 따로 안하면 10개짜리 만들어짐
 * 
 * 
 * 3-2. ArrayList의 메소드: add, set, remove, get 등등
 * - add(index, element): 지정된 인덱스에 객체 저장하기->그 인덱스에 원래 있던 객체는 뒤로 하나씩 밀림, 삭제되는 것 아니고 ArrayList.size() 한개 증가됨
 * - set(index, element): 지정된 인덱스에 객체 저장하기->그 인덱스에 원래 있던 객체 대체!!함 -> ArrayList.size() 변화 없음(증가, 감소 X)
 * - remove(index): 해당 인덱스의 객체 삭제함-> 자리 당겨짐: 빈 인덱스에 뒷자리 애들이 채움
 *                                    -> 그래서 검사 안하는 인덱스가 생길 수도 있음
 *          해결방식)이 문제를 해결하기 위해서는 요소를 삭제한 후에 
		 *        i 변수를 감소시켜 다음 요소를 건너뛰지 않도록 해야함
		 * 해결방법1) 삭제 후 인덱스 -1 해줘야함: i--;
		 * 해결방법2) "Iterator"를 사용해서 요소 삭제할 수도 있음                       
 * 
 * ★★★★★★★★★★★★★★★Iterator 클래스 in Collection에서 자주 쓰임!!★★★★★★★★★★★★★★★★
 * (도현-컬렉션-nongeneric-HashSetMain보기)
 * Iterator 클래스 + 주로 while문과 함께 쓰임
 * 				: Java 컬렉션에서 인덱스(요소)를 순회하고 삭제하는 데 사용되는 인터페이스입니다. 
 *                Iterator는 컬렉션의 요소에 접근하고 조작하는 기능을 제공하여 컬렉션을 안전하게 순회할 수 있습니다.
 * 
 * Iterator 주요 메소드>> 사용 순서: hasNext()로 있는지 확인-> next()로 다음 객체를!! 반환->remove()함
 * - boolean hasNext(): 다음 요소가 있는지 확인함: 있으면 true, 없으면 false 반환함
 * - E(타입) next(): 다음 번호의 요소/객체를 반환함. 
 *                  hasNext() 메서드로 확인한 후에 호출해야함.
 *                  ->HasNext()로 다음 요소가 A인 것을 확인함
 *                  ->next()로 다음 요소인 A객체를 반환하는 것임
 *                  ->그래서 next()로 해당 객체 반환하기 전에 일단 존재하는지 hasNext()메소드 먼저 써야한다는 것 
 *                  
 *                  반환된 요소는 컬렉션의 타입에 따라 적절한 타입으로 캐스팅하여 사용할 수 있음.
 * - void remove(): next()로 반환된 요소를 삭제함. 
 *                  이 메서드는 next() 메서드 이후에 호출되어야 하며, 한 번만 호출할 수 있음. 
 *                  remove()를 호출하여 요소를 삭제하면 순회 중인 컬렉션에서 해당 요소가 제거됨.
 * 
 * 예시))
 * 
 * ArrayList<Integer> numbers = new ArrayList<>();
	numbers.add(1);
	numbers.add(2);
	numbers.add(3);
	numbers.add(4);

	Iterator<Integer> iterator = numbers.iterator();
	-> 해당 코드에서는 numbers라는 컬렉션에서 Iterator 객체를 얻기 위해 iterator() 메소드[객체 반환]를 호출합니다. 
	   이 메소드는 numbers 컬렉션의 요소를 순차적으로 접근하기 위한 Iterator 객체를 반환합니다. 
	   이후 Iterator<Integer> 타입의 변수 iterator에 할당되어 사용됩니다.
	   
	while (iterator.hasNext()) { 다음 요소가 있으면(true면) 다음 코드 실행
	    int number = iterator.next(); //다음 요소를 반환해서 int 타입의 number라는 변수에 담음
	    if (number % 2 == 0) {
	        iterator.remove();
	    }
	}
 * 
 * 
 * 추가 설명))for문과 while문의 차이 : 둘 다 반복문을 구현함
 * 
 * for 문:
	초기화, 조건식, 증감식을 한 곳에 모아서 사용할 수 있는 구문입니다.
	주로 반복 횟수가 정해져 있거나 범위가 정해진 경우에 사용됩니다.
	예시: for (int i = 0; i < 10; i++) { ... }
	
* while 문:
	반복 조건을 따로 지정하여 반복을 수행하는 구문입니다.
	반복 횟수가 불명확하거나 조건에 따라 반복을 계속할지 결정해야 하는 경우에 사용됩니다.
	예시: while (조건식) { ... }
 * 
 * 
 * 
 * 4. Set[집합]-HashSet
 * - HashSet: Set 인터페이스를 구현한 클래스
 *            중복을 허용하지 않고 순서가 없는 요소들의 집합을 저장함
 *             
 * 4-1. 주요 메소드 : add, remove 등등
 * - toArray(): HashSet에 저장된 요소들을 배열로 변환하는 기능을 제공
 *         문법: Object[] (배열타입) toArray();
 *         -> toArray() 메소드를 호출하면 HashSet에 저장된 요소들이 순서를 유지한 채로 
 *         Object 타입의 배열로 반환됩니다. 
 *         반환된 배열의 길이는 HashSet에 저장된 요소의 개수와 동일합니다. 
 *         각 요소는 Object 타입으로 저장되므로, 
 *         필요에 따라 적절한 형변환을 통해 원하는 타입으로 사용할 수 있습니다.
 * 예시) 
 * HashSet<String> set = new HashSet<>();
	set.add("Apple");
	set.add("Banana");
	set.add("Orange");
	
	String[] arr = set.toArray(new String[set.size()]); : String 타입의 객체들이 저장되어 있는 arr이라는 배열에 각각 담음
	
	System.out.println(Arrays.toString(arr));
 * 
 * 
 * 5. Map-HashMap
 * - HashMap: Map 인터페이스를 구현한 클래스
 *            키-값(key-value)의 쌍으로 데이터를 저장함
 *            key가 아닌 value의 중복을 허용함, 순서가 없음
 *            키는 고유한 것으므로 중복 안되고 키를 통해 CRUD 가능
 *            
 * 
 * 5-1. 주요 메소드: !!!put(add 대신)!!! , remove, get, !!entrySet()!! 등등
 * - entrySet(): Map 인터페이스에서 제공되는 메소드로, 해당 맵의 모든 키-값 쌍을 담은 Set 컬렉션을 반환함
 * 		   문법 : Set<Map.Entry<K:Key, V:Value>> entrySet();
 * 				
 * ★★★★★★★★★★★★★★★★★!!헷갈렸던 부분!!★★★★★★★★★★★★★★★★★
 * 
 * 				->Map.Entry<Integer, String>: [그냥 문법, 뭉텅이로 생각하고 외우기]
 * 											  Map 인터페이스에서 정의된 키-값 쌍을 나타내는 객체를 말함. 
 *                                            이 객체는 getKey()와 getValue() 메서드를 통해 키와 값을 가져올 수 있음.
 * 				-> entrySet() 메소드를 호출하면 맵의 각 키-값 쌍이 Set에 담겨 반환됨, 
 *                 이를 활용하여 맵에 저장된 모든 요소를 반복하거나 검색하는 등 다양한 작업을 수행할 수 있습니다. 
 *                 각 Map.Entry 객체(한덩이로 보기)는 getKey() 메소드를 통해 키를 얻고, 
 *                 getValue() 메소드를 통해 값에 접근할 수 있습니다.
 *                 
 *              -> Iterator<Map.Entry<Integer, String>>: 
 *                 Map.Entry<Integer, String> 객체들로 구성된 컬렉션을 순회하기 위한 
 *                 Iterator 타입을 선언하는 코드임   
 * 예시)
 * 
 * Map<String, Integer> map = new HashMap<>();
	map.put("Apple", 3);
	map.put("Banana", 5);
	map.put("Orange", 2);

	Set<Map.Entry<String, Integer>> entries = map.entrySet();
	for (Map.Entry<String, Integer> entry : entries) {
	    String key = entry.getKey();
	    int value = entry.getValue();
	    System.out.println("Key: " + key + ", Value: " + value);
	}
 * 
 * 
 * 
 * 
 * 
 * 예시) 
 * 		HashMap<Object, Object> carMap=new HashMap<Object,Object>();
		Car car1=new Car("1111", 1, 10, 1000);
		carMap.put(car1.getNo(), car1); //car1의 주요 key(고유번호)에 value(car1객체의 값, 주소 저장)
 * 
 * 		or
 * 
	  		carMap.put("2222", new Car("2222", 2));
			//car의 고유 key 2222에 해당되는 car 객체 저장
			carMap.put("3333", new Car("3333",15));
			carMap.put("4444", new Car("4444",16));
			carMap.put("5555", new Car("5555",17));
 * 
 * - containsKey(), containsValue(), 
 * 
 * 
 * 6. Wrapper 클래스
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class Collection<K,V> {
	private K K_variable; //K 타입 변수 선언
	private V V_variable;
	
	void set(K K_variable,V V_variable) {
		this.K_variable=K_variable;
		this.V_variable=V_variable;
	}
	
	K getK_variable() {
		return K_variable;
	}
	
	V getV_variable() {
		return V_variable;
	}
	
	public static void main(String[] args) {
		Collection<String, Integer>collection=new Collection<String, Integer>();
		collection.set("K타입 String 변수", 10);
		System.out.println(collection.getK_variable());
		System.out.println(collection.getV_variable());
		System.out.println(collection.getClass().getName());
		System.out.println(collection.getK_variable().getClass().getName());
		
		List<Boolean>list=Arrays.asList(); //T 타입 파라미터에 맞게 매개값 순차적으로 입력 혹은 T[]배열 넣기
		
	}

}
