package 제한자_final;

public class SalaryEmployee extends Employee{
	//고유멤버필드
	private int annualSalary; //연봉
	
	//기본 생성자
	public SalaryEmployee() {
	}
	
	//생성자 오버로딩
	public SalaryEmployee(int no, String name,int annualSalary) {
		super(no,name);
		this.annualSalary = annualSalary;
	}
	
	//print 메소드 오버라이딩
	@Override
	public void print() {
		super.print();
		System.out.println("연봉은: "+this.annualSalary);
	}
	
	//추상메소드 오버라이딩
	@Override
	public void calculatePay() {
		this.setPay(this.annualSalary/12);
	}
	
	//getter, setter
	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	
}
