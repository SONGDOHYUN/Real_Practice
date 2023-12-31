package 컬렉션.generic;

import java.util.Comparator;

public class AccountBalanceDescComparator implements Comparator<Account>{
	@Override
	public int compare(Account acc1, Account acc2) {
		return acc2.getBalance()-acc1.getBalance(); //뒤-앞하면 내림차순임
	}
}
