package OOP;

public class AccountMemberFieldMain {

	public static void main(String[] args) {
		//**********case 1************
		Account acc1=new Account();
		/*
		acc1.no=1111;
		acc1.owner="도현계좌1";
		acc1.balance=8000;
		acc1.iyul=3.0;
		*/
		
		//캡슐화 했을 시
		acc1.setAccountData(1111, "도현계좌1", 8000, 3.0);
		
		//계좌 잔고 8000원 증가
		acc1.deposit(8000);
		acc1.headerPrint();
		acc1.print();
		
		//은행 모든 계좌에 잔고 500원씩 증가
		Account accAll=new Account();
		accAll.setAccountData(2222, "도현계좌2", 1000, 2.0);
		
		acc1.deposit(800);
		accAll.deposit(800);
	
		//계좌 잔고 1000원씩 증가->memberField 사용해서 증가시키기
		/*
		acc1.balance+=1000;
		accAll.balance+=1000;
		*/
		acc1.deposit(1000);
		accAll.deposit(1000);
		System.out.println("모든 잔고:"+ acc1.getBalance()+", "+accAll.getBalance());
		
	}

}
