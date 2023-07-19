package Practice_1;

public class Car {
	
	
	private String name; //클래스에서만 접근가능한 멤버변수(객체를 사용해야만 사용할 수 있는) 선언
	private int doorCount;
	
	public String getName() { //데이터 가져와야하니까(읽어야하니까) 해당 멤버필드 리턴하게 작성
		return name;
	}
	
	public void setName(String name) { //데이터 변경해야하니까 해당 데이터 매개변수로 갖고 매개변수 대입하는 식 있게 작성
		this.name=name;
	}
	
	public int getDoorCount() {
		return doorCount;
	}
	
	public void setDoorCount(int doorCount) {
		this.doorCount=doorCount;
	}
	
	private Car(String name,int doorCount){ 
		setName(name);
		setDoorCount(doorCount); //생성시 데이터 초기화하게끔(데이터 변경) setter 사용함
	}

	
	
	public static void main(String[] args) {
		Car car=new Car("자동차1", 4); //setter를 통해 car 객체에 자동차1, 4라는 값이 저장됨->출력코드는 없어서 출력 안됨
		System.out.println(car); // 주소값출력
		car.getName(); //name값 가져오고(getter) 반환만 하는거라 출력은 안됨
		System.out.println(car.getName()); //자동차 1 출력됨
		System.out.println("자동차 이름:"+car.getName()); //자동차1 출력됨
		System.out.println("문의 개수:"+car.getDoorCount());//4 출력됨
	}

}
