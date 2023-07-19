package 제한자_final;

public class HourlyEmployee extends Employee{
	//고유멤버필드
	private int workHour; //일한시간
	private int payPerHour; //시간 당 급여
	
	//기본 생성자
	public HourlyEmployee() {
	}
	
	//생성자 오버로딩
	public HourlyEmployee(int no, String name, int workHour, int payPerHour) {
		super(no,name);
		this.workHour = workHour;
		this.payPerHour = payPerHour;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("worksHour: "+this.workHour+"\t payPerHour: "+this.payPerHour);
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

	//부모 추상 메소드 자식 클래스에서 재정의
	//시간 당 급여 메소드
	@Override
	public void calculatePay() {
		this.setPay(this.payPerHour*this.workHour);
	}
	
	
}
