package 포함;

public class ReferenceVariableMain {

	public static void main(String[] args) {
		System.out.println("--기본형 변수(swap)--");
		int score1=90;
		int score2=80;
		int tempScore3;
		System.out.println("sore1: "+score1+", score2: "+score2);
		tempScore3=score1;
		score1=score2;
		score2=tempScore3;
		System.out.println("sore1: "+score1+", score2: "+score2);
		
		System.out.println("--참조형 변수--");
		DuoMember member1=new DuoMember(1, "회원1");
		DuoMember member2=new DuoMember(2, "회원2");
		DuoMember member3= member1;
		System.out.println(member3.getNo()+"\t"+member3.getName());
		
		System.out.println("--참조형 변수를 비교해보겠습니다.--");
		boolean isFact=true;
		if(member1==member3) {
			System.out.println("member1: "+member1);
			System.out.println("member3: "+member3);
		}else {
			System.out.println("값이 같지 않습니다.");
		}
		
		System.out.println("--참조 변수(swap)--");
		System.out.println("swap 전 member1: "+member1+", member2: "+member2);
		DuoMember tempMember;
		tempMember=member1;
		member1=member2;
		member2=tempMember;
		System.out.println("swap 후 member1: "+member1+", member2: "+member2);
		//바뀌 것 확인됨
		
		
		
		
	}

}
