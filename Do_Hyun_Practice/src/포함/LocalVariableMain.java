package 포함;

public class LocalVariableMain {

	public static void main(String[] args) {
		
		//DuoMember 객체 생성 및 정보 설정
		DuoMember member1=new DuoMember(1, "회원1");
		DuoMember member2=new DuoMember(2, "회원2");
		
		member1.print();
		member2.print();
		
		//boolean 유효성 검사
		System.out.println("condition에 따른 member 출력입니다.");
		boolean condition1 = false; //false로 초기화 되어있음
		if(condition1) {
			member1.print();
		}else{
			member2.print();
		}
		
		System.out.println("객체의 값을 null로 설정한 뒤");
		DuoMember member3=new DuoMember();
		System.out.println(member3.getNo()+"\t"+member3.getName());
		if(member3.getName()==null) {
			//member3=new DuoMember(3, "회원3");
			member3.setNo(3);
			member3.setName("회원3");
			member3.print();
		}else {
			member3.print();
		}
		
		
	}

}
