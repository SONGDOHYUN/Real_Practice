package 제한자_final;

public abstract class Employee {
	
	//멤버필드
	public static final double INCENTIVE_RATE=0.1;
	private int no;
	private String name;
	private int pay; //사원 급여
	
	//기본 생성자
	public Employee() {
	}
	
	//생성자 오버로딩
	public Employee(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	//추상메소드
	public abstract void calculatePay();
	
	/*
    인센티브계산(급여가 100만원이넘으면 10%인센티브지급)
    	- 재정의금지(변경금지,회장님의방침)
    	- 모든사원들의 인센티브계산방법동일
   */
	
	//인센티브 계산 메소드: final 메소드-> 오버라이딩 못함
	public double incentivePay() {
		double incentive=0.0;
		if(this.pay>=1000000) {
			incentive=this.pay*Employee.INCENTIVE_RATE;
		}
		return incentive;
	}
	
	//고유 메소드
	public void print(){
    	System.out.print("직원번호: "+this.no+"\t 직원이름: "+this.name+"\t 직원급여: "+this.pay+"\t");
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	//INCENTIVE_RATE는 final이라서 setter는 없고 getter만 있음
	public static double getIncentiveRate() {
		return INCENTIVE_RATE;
	}
	
	
	
	
	
	
}
