package 제한자_final;

public class EmployeePayPrintFinalMain {

	public static void main(String[] args) {
		
		//공통으로 묶기 위해 조참자객할거임->업캐스팅, Employee 클래스 필드만 쓸 수 있음, 오버라이딩은 자식거 가능
		Employee[] empArray= {
  (Employee)new HourlyEmployee(1, "시간직원1", 10, 1000000),	
			new HourlyEmployee(2, "시간직원2", 20, 20000),	
			new SalaryEmployee(3, "연봉직원3", 300000000),
			new SalaryEmployee(4, "연봉직원4", 4000000),
		};
		
		System.out.println("--모든 직원의 급여 정보를 추출해보겠습니다--");
		for(Employee emp: empArray) {
			emp.calculatePay();
			System.out.println("++"+emp.getName()+"의 급여 명세서 입니다++");
			emp.print();
			
			double incentive=emp.incentivePay();
			System.out.println("++"+emp.getName()+"의 인센티브는 "+incentive+"입니다");
			emp.setPay(emp.getPay()+(int)incentive);
			System.out.println("++"+emp.getName()+"의 인센티브 포함된 급여는 "+emp.getPay()+"입니다");
		}
	}

}
