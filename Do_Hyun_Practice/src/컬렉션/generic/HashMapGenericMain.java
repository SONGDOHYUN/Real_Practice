package 컬렉션.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapGenericMain {

	public static void main(String[] args) {
		//객체 생성: key-value
		HashMap<String, Car> carMap=new HashMap<String, Car>();
		carMap.put("1111", new Car("1111", 10));
		carMap.put("2222", new Car("2222", 20));
		carMap.put("3333", new Car("3333", 30));
		carMap.put("4444", new Car("4444", 40));
		carMap.put("5555", new Car("5555", 50));
		System.out.println("carMap 크기: "+carMap.size());
		
		System.out.println("get(key)");
		carMap.get("1111").print();
		
		System.out.println("remove(key)");
		carMap.remove("1111");
		
		System.out.println("--전체 출력--");
		Car.headerPrint();
		Set<Map.Entry<String, Car>> carEntry=carMap.entrySet();
		for(Map.Entry<String, Car> entry: carEntry) {
			String key=entry.getKey();
			Car car=entry.getValue();
			//System.out.println("key: "+key);
			car.print();
		}
		System.out.println("keySet-> "+carMap.keySet());
		System.out.println("--입차시간--");
		Car car1=new Car("1234", 15);
		if(!carMap.containsKey("1234")) {
			carMap.put(car1.getNo(), car1);
		}
		System.out.println("추가 후 :"+carMap);
		
		System.out.println("--차량번호 1234번 찾기--");
		Car findCar=carMap.get("1234");
		findCar.print();
		
		System.out.println("--입차시간 30시간 이후의 차량 찾기--");
		Set<Map.Entry<String, Car>> carList=carMap.entrySet(); //각각 집합으로 담음->담아야 key나 value로 찾을 생각할 수 있음
		for(Map.Entry<String, Car> List: carList) {
			if(List.getValue().getInTime()>=30) {
				Car carInfo=List.getValue();
				carInfo.print();
			}
		}
		
		System.out.println("1234번 24시에 출차함");
		/*
		int outTime=carMap.get("1234").getOutTime();
		outTime=24;
		이렇게 해도 되지만 getter, setter를 사용하기 위해서 time자체를 담는게 아니라 Car 객체 하나를 아예 받는게 더 용이함
		 * 
		 */
		Car car3=carMap.get("1234");
		car3.setOutTime(24);
		car3.calculateFee();
		System.out.println("출차 후: "+car3.getOutTime());
		
		Car.headerPrint();
		Set<Map.Entry<String, Car>> carEntry1=carMap.entrySet();
		for(Map.Entry<String, Car> entry: carEntry1) {
			String key=entry.getKey();
			Car car=entry.getValue();
			//System.out.println("key: "+key);
			car.print();
		}
		
		
		
	}

}
