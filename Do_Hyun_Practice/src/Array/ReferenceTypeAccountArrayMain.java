package Array;

import java.util.Arrays;

public class ReferenceTypeAccountArrayMain {

	public static void main(String[] args) {
		System.out.println("---0. 값 목록으로 배열 생성---");
		/*
		Account[] accArray=new Account[5];
		accArray= {
				new Account(1111, "주인1", 1000, 1.0),
				new Account(2222, "주인2", 2000, 2.0),
				new Account(3333, "주인3", 3000, 3.0),
				new Account(4444, "주인4", 4000, 4.0),
				new Account(5555, "주인5", 5000, 5.0)
		};
		-> 이렇게 하면 "Array constants can only be used in initializers"라는 오류 뜸
		-> 배열 초기화는 선언과 동시에 이루어져야한다는 뜻임
		-> 예시1) int[] numbers = {1, 2, 3, 4, 5}; // 배열 선언과 동시에 초기화하거나
		-> 예시2) int[] numbers;
    			numbers = new int[]{1, 2, 3, 4, 5}; // 초기화 블록 내에서 배열 초기화 해야함
		*/
		
		Account[] accArray=new Account[] {
				new Account(1111, "주인1", 9000, 1.0),
				new Account(2222, "광인2", 2000, 2.0),
				new Account(3333, "은인3", 3000, 3.0),
				new Account(4444, "낭인4", 4000, 4.0),
				new Account(5555, "주인5", 5000, 5.0)
		};
		System.out.println("1. 계좌 개수: "+accArray.length+"개");
		System.out.println("2. 계좌 정보 전체 출력");
		Account.headerPrint();
		for(int i=0;i<accArray.length;i++) {
			accArray[i].print();
		}
		System.out.println("3. 은행계좌의 총 잔고");
		int totBalance=0;
		for(int i=0;i<accArray.length;i++) {
			totBalance+= accArray[i].getBalance();
		}
		System.out.println(">>>"+totBalance+"원");
		System.out.println("4. 은행계좌들 중 계좌번호 3333 찾아서 정보 출력하기");
		Account.headerPrint();
		for(int i=0;i<accArray.length;i++) {
			if(accArray[i].getNo()==3333) {
				accArray[i].print();
				break; //error 안 생기게 하기 위해서 break 걸어준다.
			}
		}
		System.out.println("5.은행 계좌들중에서 계좌잔고 50000원 이상인 VIP계좌 여러개 찾아서 출력[enhanced for]");
		Account.headerPrint();
		for(Account vipBalance:accArray) {
			if(vipBalance.getBalance()>=5000) {
				vipBalance.print();
			}
		}
		
		System.out.println("6.은행 계좌들중에서 이름이 주인인 계좌 여러개 찾아서 출력[String객체배우고난후에]");
		for(int i=0;i<accArray.length;i++) {
			if(accArray[i].getOwner().startsWith("주인")) {
				accArray[i].print();
			}
		}
		
		System.out.println("7.6666번계좌 3000원입금");
		for(Account newAccountArray:accArray) {
			if(newAccountArray.getNo()==5555) {
				newAccountArray.deposit(3000);
				System.out.println(">>>입금 후: "+newAccountArray.getBalance()+"원");
			}
		}
		System.out.println("계좌 잔고 순으로 오름차순 정렬");
		Account.headerPrint();
		Arrays.sort(accArray);
		System.out.println(">>정렬 후: "+Arrays.toString(accArray));
		
		System.out.println("--temp 사용해서 계좌 오름차순으로 정렬해보기--");
		//여기선 이중 for 문 변수 2개 쓰고 length-1한 뒤 temp 변수 사용하는게 중요함
		for(int i=0;i<accArray.length-1;i++) { 
			//따로 accArray[i]의 값을 불러오는게 아니라 비교할 횟수!!그 자체를 실행하기 위해 필요한 for문임
			for(int j=0;j<accArray.length-1;j++) {
				//여기서 현재꺼랑 다음꺼의 직접적인 비교가 이루어지는것임
				if(accArray[j].getBalance()>accArray[j+1].getBalance()) {
					//오름차순이니까 이 경우에는 자리가 바뀌어야함->자리 바꾸려면 임시 용기인 temp 사용하면 됨
					Account temp;
					temp=accArray[j];
					accArray[j]=accArray[j+1];
					accArray[j+1]=accArray[j];
				}
			}
		} 
		System.out.println(">>정렬 후: ");
		for(Account seqArray: accArray) {
			seqArray.print();
		}
		
		System.out.println("--temp 사용해서 계좌 내림차순으로 정렬해보기--");
		//2(1번자리),3(2번자리)->자리를 바꿔야함->일단 1번자리를 비워야하니까 temp에 담아서 값 온전하게 저장!!후 자리 바꾸면 됨
		for(int i=0;i<accArray.length-1;i++) {
			for(int j=0;j<accArray.length-1;j++) {
				Account temp;
				if(accArray[j].getBalance()<accArray[j+1].getBalance()) {
					temp=accArray[j];
					accArray[j]=accArray[j+1];
					accArray[j+1]=temp;
				}
			}
		}
		System.out.println(">>잔고 내림차순 정렬 후: ");
		for(Account newSeqArray2:accArray) {
			newSeqArray2.print();
		}
		
		
		
		
		
		
		
		
	}

}
