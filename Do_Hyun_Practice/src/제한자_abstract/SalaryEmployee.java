package 제한자_abstract;

public class SalaryEmployee extends Employee{
	//고유멤버필드
	private int annualSalary; //연봉
	
	//기본생성자
	public SalaryEmployee() {
		
	}

	//생성자 오버로딩
	public SalaryEmployee(int no, String name, int annualSalary) {
		super(no,name);
		this.annualSalary = annualSalary;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("연봉: "+this.annualSalary);
	}
	
	//추상메소드 재정의
	@Override
	public void calculatePay() {
		int monthPay=this.annualSalary/12;
		this.setPay(monthPay);
	}
	
	//getter, setter
	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	
}
