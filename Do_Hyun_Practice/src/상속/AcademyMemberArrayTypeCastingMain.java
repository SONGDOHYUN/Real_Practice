package 상속;

public class AcademyMemberArrayTypeCastingMain {

	public static void main(String[] args) {
		
		System.out.println("--배열인 객체들을 업캐스팅 해보겠습니다--");
		AcademyMember[] m1= {
			new AcademyStudent(1, "학생1", "반이름1"),	
			new AcademyStudent(2, "학생2", "반이름2")	
		};
		System.out.println("인덱스 0번의 정보: "+m1[0]);
		System.out.println("인덱스 1번의 정보: "+m1[1]);
		m1[0].print(); //AcademyStudent 클래스에서 오버라이딩한 메소드
		
		System.out.println("--for문 사용해서 정보 출력--");
		for(AcademyMember memberArray: m1) {
			System.out.println(memberArray);
		}
		System.out.println();
		AcademyMember[] m2= new AcademyGansa[1];
		m2[0]=new AcademyGansa(2, "강사2", "과목2");
		System.out.println();
		
		System.out.println("★★★★★★업캐스팅하는 이유가 뭐야!->한데로 묶기 위함이잖아! 그 예시를 써라★★★★★★");
		//학생, 강사, 직원 모두 학원 멤버라는 큰 부모 클래스로 묶음
		AcademyMember[] m3= {
			new AcademyStudent(1, "KIM", "JAVA"),
			new AcademyGansa(4, "OIM", "ANDROID"),
			new AcademyStaff(6, "QIM", "ACCOUNTING")
		};
		System.out.println("--for문 돌리기--");
		for(int i=0;i<m3.length;i++) {
			m3[i].print();
		}
		System.out.println();
		System.out.println("배열 객체들을 다운캐스팅 해보겠습니다->for문 돌려서 배열 하나하나가 자식 클래스를 참조하고 있는지 확인하고 필요에 따른 정보 출력하기");
		/*
		if(m3 instanceof AcademyStudent[] && m3 instanceof AcademyGansa[] &&m3 instanceof AcademyStaff[]) {
			System.out.println("다운캐스팅 가능");
		}else System.out.println("다운캐스팅 불가능");
		이렇게 하면 안됨...다운캐스팅 불가능이라고 뜸
		m3 배열의 인덱스 하나하나마다 각 자식 클래스를 참조하고 있는지 instanceOf 연산자를 써서 확인해야하기 때문임
		->따라서 for-each문=enhanced for문 돌려야함
		*/
		for(AcademyMember memberArray:m3) {
			if(memberArray instanceof AcademyStudent) {
				System.out.println("m3 배열은 AcademyStudent를 참조하므로 다운캐스팅 가능합니다");
				AcademyStudent student=(AcademyStudent)memberArray;
				System.out.println("AcademyStudent클래스의 고유 멤버필드 className: "+student.getClassName());
			}else if(memberArray instanceof AcademyGansa) {
				System.out.println("m3 배열은 AcademyGansa를 참조하므로 다운캐스팅 가능합니다");
				AcademyGansa gansa=(AcademyGansa)memberArray;
				System.out.println("AcademyGansa클래스의 고유 멤버필드 subject: "+gansa.getSubject());
			}else if(memberArray instanceof AcademyStaff) {
				System.out.println("m3 배열은 AcademyStaff를 참조하므로 다운캐스팅 가능합니다");
				AcademyStaff staff=(AcademyStaff)memberArray;
				System.out.println("AcademyStaff클래스의 고유 멤버필드 depart: "+staff.getDepart());
			}else //아무것도 해당안될 시
			System.out.println("다운캐스팅 불가능합니다.");
		}
	
	}

}
