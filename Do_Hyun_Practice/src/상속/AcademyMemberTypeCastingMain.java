package 상속;

public class AcademyMemberTypeCastingMain {

	public static void main(String[] args) {
		System.out.println("--업캐스팅을 해보겠습니다--");
		AcademyStudent st1=new AcademyStudent(1, "학생1", "반이름1");
		
		//업캐스팅
		AcademyMember m1=st1;
		//m1.className 안됨-> AcademyStudent 클래스(자식 클래스)의 고유한 멤버필드니까
		System.out.println(m1); //AcademyMember클래스의 toString 메소드 출력
		m1.print(); //여기서는 className 출력 가능
		//            : AcademyStudent에서 print()메소드를 className도 출력하게끔 오버라이딩 해놔서!!
		
		AcademyMember m2=new AcademyGansa();
		System.out.println(m2); //다 0 or null로 초기화됨
		System.out.println("------");
		AcademyMember m3=new AcademyStaff(2, "직원2", "부서2");
		m3.print();
		System.out.println();
		
		System.out.println("--다운캐스팅을 해보겠습니다--");
		if(m1 instanceof AcademyStudent && m2 instanceof AcademyGansa && m3 instanceof AcademyStaff) {
			System.out.println("모두 다운캐스팅 가능합니다.");
		}else System.out.println("다운캐스팅...어렵겠는데요?");
		
		AcademyStudent student1=(AcademyStudent)m1;
		System.out.println("반이름: "+student1.getClassName());
		int no1=student1.getNo(); //return만 했음-> 출력하려면 sysout 해줘야함
		System.out.println("학생 번호: "+no1);
		student1.print();
	}

}
