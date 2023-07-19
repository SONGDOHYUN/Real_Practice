package 포함;

public class CarFactoryMain {

	public static void main(String[] args) {
		/*
		 * 자동차 공장
		 */
		Engine engine1=new Engine("엔진1", 100);
		Engine engine2=new Engine();
		engine2.setType("엔진2");
		engine2.setCc(200);
		
		//엔진 객체 같게 가질 수 있음
		Car car1=new Car(1, "자동차모델1", engine1);
		Car car2=new Car(2, "자동차모델2", engine1);
		
		//car1, car2의 엔진 객체의 객체 주소값 출력됨 = 두개가 같음
		System.out.println(car1.getEngine());
		System.out.println(car2.getEngine());
		
		System.out.println("--차량 엔진 검사--");
		Engine engine3=new Engine("엔진3", 300);
		Engine engine4=car1.getEngine();
		boolean fact1=engine1.equals(engine4);
		System.out.println("engine4의 주소값은 engine1과 같다?: "+fact1);
		engine4.print();
		
		
		
		
	}

}
