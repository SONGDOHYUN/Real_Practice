package OOP;

public class Constructor {
	private int member1;
	private int member2;

	Constructor(){
		System.out.println("따로 안써도 자동 생성되는 기본 생성자: "+this); //객체의 주소 입력됨
		this.member1=1;
		this.member2=2;
		System.out.println("-------기본 생성자 끝------");
	}
	
	//생성자 오버로딩
	Constructor(int member1, int member2){
		System.out.println("--------오버로딩한 생성자 호출---------: "+this);
		this.member1=member1;
		this.member2=member2;
	}
	
	public void print() {
		System.out.println("member1: "+member1);
		System.out.println("member2: "+member2);
	}

}
