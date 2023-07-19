package 컬렉션.nogeneric;

public class Car {	
	//멤버필드
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	
	//기본 생성자
	public Car() {
	}
	
	//생성자 오버로딩
	public Car(String no, int inTime) {
		this.no=no;
		this.inTime=inTime;
	}

	//생성자 오버로딩
	public Car(String no, int inTime, int outTime, int fee) {
		super();
		this.no = no;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = fee;
	}
	
	//멤버메소드
	public void setIpChaDate(String no, int inTime) {
		this.no=no;
		this.inTime=inTime;
	}
	
	//멤버메소드
	public void setOutTime(String no, int outTime) {
		this.no=no;
		this.outTime=outTime;
	}
	
	//주차요금 계산
	public void calculateFee() {
		this.fee=(this.outTime-this.inTime)*1000;
	}
	
	//헤더 정보 출력
	public static void headerPrint() {
		System.out.println("-----------------------------------");
		System.out.printf("%s %s %s %s\n","차량번호","입차시간","출차시간","주차요금");
		System.out.println("-----------------------------------");
	}
	
	//차량정보 출력
	public void print() {
		
		System.out.printf("%7s %7d %7d %8d\n",this.no,this.inTime,this.outTime,this.fee);
	}
	
	//getter, setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
	

}
