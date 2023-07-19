package 컬렉션.generic;

import java.util.Comparator;

public class AccountOwnerAscComparator implements Comparator<Account>{
	@Override
	public int compare(Account acc1, Account acc2) {
		return acc1.getOwner().compareTo(acc2.getOwner());
		//Owner이름으로 내림차순하려면
		//return acc2.getOwner().compareTo(acc1.getOwner()); 하면 됨
	}
}
