package OOP;

import java.util.Arrays;

public class AccountManyMain {

	public static void main(String[] args) {
		
		//AccountMany클래스의 멤버 변수를 사용하기 위해 AccountMany클래스의 변수 생성함
		AccountMany accountMany= new AccountMany();
		
		//AccountArray 객체를 참조/가리킬 수 있는 변수 acc1에 대해 AccountArray 객체를 생성한 뒤 각 멤버필드 설정함 
		accountMany.acc1=new AccountArray(1, "주인1", 1000, 1.0);
		accountMany.acc1.setBalance(2000);
		System.out.println(accountMany.acc1.getBalance());
		
		//acc2는 배열이 아니라 AccountArray 타입의 객체이기 때문에 배열 문법을 쓸 수 없다.
		//만약 AccountMany 클래스에서 acc2의 타입을 AccountArray[]라는 배열 타입으로 바꾼다면 가능함
		
		/*************헷갈렸던 부분
		 *배열을 사용하고자 할 때는 변수를 배열 타입으로 선언해야 함
		 *-> AccountArray acc2; -> AccountArray[] acc2;
		 *-> 이렇게 수정한 후, acc2 변수에 배열을 할당하고 싶다면, 배열을 생성하여 할당한다.
		 */
		accountMany.acc2 = new AccountArray[] {
			    new AccountArray(2, "주인2", 2000, 2.0),
			    new AccountArray(3, "주인3", 3000, 3.0),
			    new AccountArray(4, "주인4", 4000, 4.0)
			};
		System.out.println("acc2 배열 출력하기: "+Arrays.toString(accountMany.acc2));
		
		AccountArray.headerPrint();
		accountMany.acc1.print();
		System.out.println();
		
		accountMany.acc3=new AccountArray[5]; //배열 크기 5개로 설정함
		accountMany.acc3[0]= new AccountArray(11, "1111", 10, 1.0);
		accountMany.acc3[3]= new AccountArray(33, "3333", 30, 3.0);
		System.out.println("acc3 배열의 길이: "+accountMany.acc3.length);
		System.out.println("acc3 배열 출력: "+Arrays.toString(accountMany.acc3));
		System.out.println();
		
		AccountArray.headerPrint();
		
		//accountMany.acc3.print(); 
		/*->이렇게는 안됨 
		 * : 각 요소들이 AccountArray를 참조하면서 그 클래스의 변수와 메소들 사용할 수 있는거라 
		     큰 범위의 acc3에서는 print()메소드 사용할 수 없다. 
		     따라서 배열의 각 요소의 print()메소드 호출 or for문 돌려서 반복/전체 출력하면 됨
		*/
		
		accountMany.acc3[0].print();
		accountMany.acc3[3].print();
		
		//각각 인덱스 지정해서 print() 호출할 수도 있지만 for문, 향상된 for문 사용해서 반복 돌려서 다 출력할 수 있음
		System.out.println("---일반 for문 돌립니다---");
		for(int i=0; i<accountMany.acc3.length; i++) {
			if(accountMany.acc3[i]==null) {
				System.out.println("null이지롱");
			}else
			accountMany.acc3[i].print();
		}
		
		System.out.println("--향상된 for문 돌립니다--");
		for(AccountArray newCopyArray: accountMany.acc3) {
			if(newCopyArray==null) {
				System.out.println("--값 없음--");
			}else {
				newCopyArray.print();
			}
		}
		
		
	}
}
