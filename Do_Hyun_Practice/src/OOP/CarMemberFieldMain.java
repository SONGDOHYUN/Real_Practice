package OOP;
//주차관리 프로그램 생성

public class CarMemberFieldMain {

	public static void main(String[] args) {
		//차령번호 1234 12시 입차
		Car car1=new Car();
		car1.setCarIn("1234", 12);
		
		//2가지 방법으로 출력할 수 있음
		System.out.println("car1 차량번호:"+car1.no+"\ncar1 입차시간:"+car1.inTime);
		car1.headerPirnt();
		
		//car1 차량 16시 출차
		car1.outTime=16;
		
		//주차요금 계산
		car1.parkingFee(16, 12);
		car1.headerPirnt();
		
	}

}
