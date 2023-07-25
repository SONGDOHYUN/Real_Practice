package 컬렉션.nogeneric;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain extends Object{

	public static void main(String[] args) {
		//객체생성: key-value: NonGeneric->최상위 객체 Object
		HashMap<Object, Object> carMap=new HashMap<Object,Object>();
		System.out.println("추가 전: "+carMap.size()); //0
		Car car1=new Car("1111", 1, 10, 1000);
		carMap.put(car1.getNo(), car1); //car1의 주요 key(고유번호)에 value(car1객체의 값, 주소 저장)
		
		carMap.put("2222", new Car("2222", 2));
		//car의 고유 key 2222에 해당되는 car 객체 저장
		carMap.put("3333", new Car("3333",15));
		carMap.put("4444", new Car("4444",16));
		carMap.put("5555", new Car("5555",17));
		
		System.out.println("추가 후: "+carMap); //1111=컬렉션.nogeneric.Car@3830f1c0
		System.out.println("추가 후: "+carMap.size()); //5
		
		System.out.println("key가 중복 안된다는 것을 알아보겠습니다");
		Car car2=new Car("1111", 0);
		carMap.put("1111", car2);
		System.out.println("중복 여부: "+carMap); //1111=컬렉션.nogeneric.Car@7d6f77cc: 중복 안돼서 값 바뀜
		
		System.out.println("--key 사용: get--");
		Car getCar=(Car)carMap.get("3333"); //HashMap타입이라 Car 클래스 필드 사용하려면 캐스팅해줘야함
		getCar.print();
		
		System.out.println("--key 사용: remove--");
		carMap.remove("3333");
		System.out.println(carMap);
		System.out.println("삭제 후: "+carMap.size()); //4
		
//		System.out.println("-------삭제 후 carMap 전체 출력-------");
//		Set<Map.Entry<Object, Object>> entryList=carMap.entrySet();
//		for(Map.Entry<Object, Object> entries:entryList) {
//			String key=(String)entries.getKey();
//			Car value=(Car)entries.getValue();
//			System.out.println("Key: "+key);
//			System.out.println("value: "+value);
//		}
		
		System.out.println("--전체 출력: entrySet() 사용 1번--");
		Set<Map.Entry<Object, Object>> entry =carMap.entrySet();
		//Set entrySet = carMap.entrySet(); -> 이렇게 할 수도 있음
		for(Map.Entry<Object, Object> entrySet: entry) {
			System.out.println("key: "+entrySet.getKey());
			System.out.println("value: "+entrySet.getValue());
			String key=(String)entrySet.getKey();
			Car car=(Car)entrySet.getValue();
			car.print();
		}
		System.out.println();
		
		System.out.println("--전체 출력: entrySet() 사용 2번--");
		Set entrySet=carMap.entrySet();
		for(Object entries: entrySet) {
			Entry entry1 =(Entry)entries;
			String key=(String)entry1.getKey();
			Car car=(Car)entry1.getValue();
			car.print();
		}
		System.out.println();
		
		System.out.println("--전체출력: Iterator 사용--");
		Iterator<Map.Entry<Object, Object>> iteratorArray=carMap.entrySet().iterator();
		//Map.Entry 타입의 객체변수 선언->carMap을 entrySet()으로 키-값 한쌍으로 Set에 저장한 뒤 iterator() 호출하여 순회한다.
		while(iteratorArray.hasNext()) { //다음 객체가 있으면 다음 코드 진행
			Map.Entry<Object, Object> entryObject=iteratorArray.next(); //객체 반환
			String key=(String)entryObject.getKey();
			//System.out.println(key); 1111,2222,4444,5555 나오는 것 확인
			Car car=(Car)entryObject.getValue();
			car.print();
			/*String key=(String)iteratorArray.next().getKey(); 띄엄띄엄만 됨
			 *System.out.println(key);
			 *Car car=(Car)iteratorArray.next().getValue();
			 */
		}
		
		
		
	}

}
