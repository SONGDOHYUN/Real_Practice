package 상속;

public class AcademyMemberConstructorMain {

	public static void main(String[] args) {
		AcademyStudent st1= new AcademyStudent();
		AcademyStudent st2= new AcademyStudent(2, "학생2이려나", "반이름2이려나");
		System.out.println(st1.getClassName());
		System.out.println(st2.getClassName());
		
		
	}

}
