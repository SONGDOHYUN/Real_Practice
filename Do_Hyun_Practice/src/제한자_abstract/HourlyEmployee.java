package 제한자_abstract;

public class HourlyEmployee extends Employee{
	//멤버필드
	private int workHour;
	private int payPerHour;
	
	//기본생성자
	public HourlyEmployee() {
		
	}
	
	//생성자 오버라이딩
	public HourlyEmployee(int no,String name, int workHour, int payPerHour) {
		super(no,name);
		this.workHour = workHour;
		this.payPerHour = payPerHour;
	}
	
	//오버라이딩한 일반메소드
	@Override
	public void print() {
		super.print();
		System.out.println(this.workHour+"\t"+this.payPerHour);
	}
	
	//오러라이딩한 추상메소드
	@Override
	public void calculatePay() {
		this.setPay(this.payPerHour*this.workHour);
	}
	
	//getter, setter
	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	public int getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	} 
	
	
	
	
	
	
}
