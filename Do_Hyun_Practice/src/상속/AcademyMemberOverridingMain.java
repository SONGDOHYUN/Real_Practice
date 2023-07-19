package 상속;

public class AcademyMemberOverridingMain {

	public static void main(String[] args) {
		AcademyMember academyMember=new AcademyMember(1, "멤버1");
		academyMember.print();
		
		AcademyStudent st1=new AcademyStudent(1, "학생1", "반이름1");
		AcademyStudent st2=new AcademyStudent(2, "학생2", "반이름2");
		
		AcademyGansa gs1=new AcademyGansa(3, "강사1", "과목1");
		AcademyGansa gs2=new AcademyGansa(4, "강사2", "과목2");
		
		AcademyStaff sf1=new AcademyStaff(5, "직원1", "부서1");
		AcademyStaff sf2=new AcademyStaff(6, "직원2", "부서2");
		
		//super.print() 때문에 AcademyMember의 print(): no, name 출력 후 재정의된 코드 출력됨
		System.out.println("--student--");
		st1.print();
		st2.print();
		
		System.out.println("--gansa--");
		gs1.print();
		gs2.print();
		
		System.out.println("--staff--");
		sf1.print();
		sf2.print();
		
		
	}

}
