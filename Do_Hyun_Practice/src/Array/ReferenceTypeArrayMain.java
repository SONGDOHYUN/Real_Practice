package Array;

public class ReferenceTypeArrayMain {

	public static void main(String[] args) {
		Account[] accArray=new Account[5]; //배열개수 5개로 설정
		accArray[0]=new Account(1111, "주인1", 1000, 1.0);
		accArray[1]=new Account(2222, "주인2", 2000, 2.0);
		accArray[2]=new Account(3333, "주인3", 3000, 3.0);
		accArray[3]=new Account(4444, "주인4", 4000, 4.0);
		accArray[4]=new Account(5555, "주인5", 5000, 5.0);
		
		//정보 모두 출력
		Account.headerPrint();
		for(Account newArray:accArray) {
			newArray.print();
		}
		
	}

}
