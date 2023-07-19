package 제한자_abstract;

public class EmployeePayPrintAbstractMain {

	public static void main(String[] args) {
		
		//배열객체로 공통된 부분 묶기 위해 업캐스팅->조참자객
		Employee[] empArray= {
			new HourlyEmployee(1, "시간당월급직원1", 10, 1000),	
			new HourlyEmployee(2, "시간당월급직원2", 20, 2000),	
			new SalaryEmployee(3, "연봉직원3", 300000),
			new SalaryEmployee(4, "연봉직원4", 400000),
		};
		
		System.out.println("--배열을 출력해보겠습니다--");
		for(Employee array1: empArray) {
			array1.calculatePay();
			System.out.println("급여명세표: ");
			array1.print();
		}
		
	}

}
