package 상속;

public class AcademyMemberOverridngArrayMain {

	public static void main(String[] args) {
		
		//배열 초기화, 정의하는 방법/문법 기억하기!!!!!
		AcademyStudent[] st1= {
				new AcademyStudent(1, "학생1", "반이름1"),
				new AcademyStudent(2, "학생2", "반이름2"),
				new AcademyStudent(3, "학생3", "반이름3"),
		};
		
		AcademyGansa[] gs1=new AcademyGansa[3];
		gs1[0]=new AcademyGansa(4, "강사1", "과목1");
		gs1[1]=new AcademyGansa(5, "강사2", "과목2");
		gs1[2]=new AcademyGansa(6, "강사3", "과목3");
		
		AcademyStaff[] sf1= {
				new AcademyStaff(7, "직원1", "부서1"),
				new AcademyStaff(8, "직원2", "부서2")
		};
		
		//System.out.println("AcademyStaff배열의 크기: "+sf1.length);
		System.out.println("--AcademyMemeber 전체 출력--");
		System.out.println("--student for문 사용하여 출력--");
		for(int i=0;i<st1.length;i++) {
			st1[i].print();
		}
		System.out.println("--student 향상 for문 사용하여 출력--");
		for(AcademyStudent stArray1: st1) {
			stArray1.print();
		}
		
		
		
		
		
		
	}

}
