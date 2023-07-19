package 제한자_abstract;

public abstract class Employee {
	//멤버필드
	private int no;
	private String name;
	private int pay;
	
	//기본 생성자
	public Employee() {
		
	}
	
	//생성자 오버로딩1
	public Employee(int no, String name, int pay) {
		this.no=no;
		this.name=name;
		this.pay=pay;
	}
	
	//생성자 오버로딩2
	public Employee(int no, String name) {
		this.no=no;
		this.name=name;
	}
	
	//멤버메소드
	public void print() {
		System.out.println(this.no+"\t"+this.name+"\t"+this.pay+"\t");
	}
	
	//추상메소드
	public abstract void calculatePay();
	
	//getter, setter
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
	
	
}
