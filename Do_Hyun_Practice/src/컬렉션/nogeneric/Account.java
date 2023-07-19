package 컬렉션.nogeneric;

public class Account {	
	//멤버필드
	private int no;
	private String owner;
	private int balance;
	private double iyul;
	
	//기본 생성자
	public Account() {
	}

	//생성자 오버로딩
	public Account(int no, String owner, int balance, double iyul) {
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}
	//멤버메소드
	public void setAccountData(int no,String owner,
			int balance,double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
	}
	
	//입금메소드
	public void deposit(int money) {
		this.balance+=money;
	}
	
	//출금메소드
	public void withdraw(int money) {
		this.balance-=money;
	}
	
	//계좌헤더출력
	public static void headerPrint() {
		System.out.println("--------------------------");
		System.out.printf("%s %5s %4s %4s \n", "번호", "이름", "잔고", "이율");
		System.out.println("--------------------------");
	}
	
	//계좌객체정보 출력
	public void print() {
		System.out.printf("%d %6s %8d %5.1f\n", this.no, this.owner, this.balance, this.iyul);
	}
	
	//toString 오버라이딩
	@Override
	public String toString() {
		return "Account [no=" + no + ", owner=" + owner + ", balance=" + balance + ", iyul=" + iyul + "]";
	}
	
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
	
	
	
	
	

}
