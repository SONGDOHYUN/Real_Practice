package OOP;

//주차장에서 차 관련 정보 수집

public class Car {

	// MemberField
	String no;
	int inTime;
	int outTime;
	int fee;
	
	//입차 시 데이터 저장
	void setCarIn(String no, int inTime) {
		this.no=no;
		this.inTime=inTime;
	};
	
	//출차 시 데이터 저장
	void setCarOut(String no,int outTime) {
		this.no=no;
		this.outTime=outTime;
	};
	
	//주차요금 계산
	void parkingFee(int inTime, int outTime) {
		this.fee=(this.outTime-this.inTime)*500;
	};
	
	//차량 정보 출력
	void headerPirnt() {
		System.out.println("-----차량 정보 출력-----");
		System.out.printf("%s %s %s %s \n","차량번호", "입차시간", "출차시간","주차요금");
		System.out.printf("%s %5d %5d %6d \n",this.no,this.inTime,this.outTime,this.fee);
	}
		
	
	
	public static void main(String[] args) {
		
	}

}
