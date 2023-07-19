package OOP;

import java.util.Comparator;

//ArraysMain애서 객체 만들어서 쓰려고 설계도인 "AccountArray" 만듬

public class AccountArray implements Comparable<AccountArray>{
	
	//멤버필드
	private int no;
	private String owner;
	private int balance;
	private double iyul;
	
	//기본 생성자
	public AccountArray() {
		
	}
	
	//생성자 오버로딩
	public AccountArray(int no, String owner, int balance, double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
	}
	
	//멤버 메소드
	public void setAccountData(int no, String owner, int balance, double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
	}
	
	//입금
	public void deposit(int money) {
		this.balance+=money;
	}
	
	//출금
	public void withdraw(int money) {
		this.balance-=money;
	}
	
	//계좌 헤더(머릿말) 출력
	public static void headerPrint() {
		System.out.println("--------------------------");
		System.out.printf("%s %5s %4s %4s \n", "번호", "이름", "잔고", "이율");
		System.out.println("--------------------------");
	}
	
	//계좌 객체 정보 출력
	public void print() {
		System.out.printf("%d %6s %8d %5.1f\n", this.no, this.owner, this.balance, this.iyul);
	}

	//getter, setter -> 멤버필드에 private 해놔서임
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

	//toString 오버라이딩
	@Override
	public String toString() {
		return "AccountArray [no=" + no + ", owner=" + owner + ", balance=" + balance + ", iyul=" + iyul + "]";
	}
	
	/*
	 * Comparable(인터페이스)-compareTo(); : 객체를 자연적 순서로 정렬할 때 사용함 
	 * -> 주로 파라미터 한개(객체 1개)를 갖고 this.멤버필드를 사용하기 때문에 따로 클래스 만들기는 비추
	 * Comparator(인터페이스)-compare(); : 객체를 외부적인 순서 정의를 통해 정렬할 때 사용함 -> 클래스 따로 만들어서 해당 compare 메소드를 재정의하는게 낫다
	 * -> 파라미터를 2개 이상(객체 2개) 갖고 비교하기 때문에 따로 클래스 만드는 거 추천
	 * 둘 다 현재-비교대상>0 : 1 반환, 현재-비교대상=0 : 0 반환, 현재-비교대상<0 : -1 반환
	 */
	
	
	//Comparable 인터페이스 오버라이딩
	@Override
	public int compareTo(AccountArray nextAccountArray) {
		//잔고 오름차순(1,2,3)
//		if(this.getBalance()-nextAccountArray.getBalance()>0) {
//			return 1;
//		}else
//		return -1;
		//잔고 내림차순(3,2,1): 내림차순은 그냥 오름차순의 반대라고 외워버리기!
		if(this.getBalance()-nextAccountArray.getBalance()>0) {
			return -1;
		}else return 1;
		
	}
}
