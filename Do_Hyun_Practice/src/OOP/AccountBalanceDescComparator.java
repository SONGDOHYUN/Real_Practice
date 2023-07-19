package OOP;

import java.util.Comparator;

//객체 생성하고 비교해야해서 클래스 새로 만든거임
public class AccountBalanceDescComparator implements Comparator<AccountArray>{
	//잔고 내림차순
	@Override
	public int compare(AccountArray acc1, AccountArray acc2) {
		//뒤-앞하면 내림차순으로 된다
		return acc2.getBalance()-acc1.getBalance();
		//앞-뒤하면 오름차순으로 된다
		//return acc1.getBalance()-acc2.getBalance();
	}

}
