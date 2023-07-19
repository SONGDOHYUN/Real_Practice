package OOP;

public class AccountMany {
	
	//AccountArray(틀, 설계도) 타입의 변수!!! 다섯개를 멤버 필드로 가지고 있는 AccountMany(틀, 설계도)만듬
	//객체를 멤버필드로 가질 수 있음
	//여러개의 객체를 관리하는데 용이함
	
	/***************중요*****************
	 * AccountArray 타입으로 선언된 acc1 변수는 AccountArray의 객체를 참조할 수 있는 변수!!임
	 * acc1은 AccountArray 타입의 변수로 선언되었기 때문에, AccountArray 객체를 참조할 수 있는 변수임
       ->변수는 객체 자체가 아니라, 객체를 가리키는 역할을 수행함
       ->변수는 객체의 메모리 주소를 저장하고, 이를 통해 해당 객체에 접근하고 사용할 수 있음
       ->변수는 객체를 생성하고 할당하는 과정을 거쳐야!!!!!! 객체를 참조할 수 있음
	 * 
	 */
	public AccountArray acc1;
	
	//AccountArrayMain에서 acc2에 배열을 넣고 싶어서 타입을 배열 타입으로 변경함
	public AccountArray[] acc2;
	public AccountArray[] acc3;
	
	public AccountArray acc4;
	public AccountArray acc5;

}
