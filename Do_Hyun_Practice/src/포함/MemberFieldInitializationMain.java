package 포함;

public class MemberFieldInitializationMain {

	public static void main(String[] args) {
		//객체 생성
		//얘는 멤버 필드 직접 입력함
		MemberField memberField1= new MemberField(3, 3.0, '나', 
				true, 
				"직접 설정된 회원입니다.", 
				new DuoMember(3333, "듀오멤버3입니다."));
		
		//여기 생성된 객체는 따로 멤버필드 설정안해서 원래 MemberField 설계도에 저장되어 있는 정보대로 입력됨
		MemberField memberField2=new MemberField();
		System.out.println(memberField1.toString());
		System.out.println(memberField2.toString());
		System.out.println();
		
		//memberField2의 Duomember 객체의 값을 바꾸고 싶음
		/*
		 *********헷갈렸던 부분: 이때 memberField2의 Duomember member6의 객체 주소 값은 동일한가? 
		 * -> 동일하지 않음. memberField2의 member6 멤버 필드를 새로운 DuoMember 객체로 변경하면
		 *    member6의 객체 주소 값도 바뀌기 때문임
		 *    
		 *    이유)) Java에서 객체는 참조 타입이기 때문에 변수에는 !!객체의 주소 값이!! 저장되고, 
		 *          !!!객체 자체가 변수에 직접 저장되는 것이 아니기 때문임!!!!
		 *
		 */
		System.out.println("memberField2의 Duomember 객체의 값을 바꾸겠습니다.");
		System.out.println("바꾸기 전: "+memberField2.getMember6());
		memberField2.setMember6(new DuoMember(7, "바꾼 회원 7"));
		System.out.println("바꾼 후: "+memberField2.getMember6());
	}

}
