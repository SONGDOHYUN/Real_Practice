package OOP;

/*
 * 캡슐화 시작
 * 캡슐화란? 
 * -> 외부 클래스에서 객체의 접근을 막고 멤버 메소드만을 사용해서 접근할 수 있도록 클래스 설계하는 것
 * -> 즉 private + memberField, public + memberMethod (getter, setter로만 접근할 수 있게끔 함)
 * 방법-> 
 * 1. MemberField에 private 붙임
 * 2. MemberMethod는 public 설정함
 */

public class Account {
	
	//캡슐화하여 외부에서 memeberField에 직접적으로 접근 못하게 함
	private int no;
	private String owner;
	private int balance;
	private double iyul;
	
	//getter, setter
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public double getIyul() {
		return iyul;
	}
	
	public void setIyul(double iyul) {
		this.iyul = iyul;
	}
	
	//메소드
	void setAccountData(int no, String owner, int balance, double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
	}

	//입금
	void deposit(int money) {
		this.balance+=money;
	}
	
	//출금
	void withDraw(int money) {
		this.balance-=money;
	}
	
	//계좌헤더 출력
	void headerPrint() {
		System.out.println("-----");
		System.out.printf("%s %5s %4s %4s \n", "번호", "이름", "잔고", "이율");
	}
	
	//계좌객체정보 출력
	void print() {
		System.out.printf("%d %6s %8d %5.1f\n", this.no, this.owner, this.balance, this.iyul);
	}
	

}
