package 상속;

public class AcademyStudent extends AcademyMember{
	
	//AcademyStudent의 고유멤버필드
	private String className;
	
	//기본 생성자
	public AcademyStudent() {
		super();
	}
	
	//생성자 오버로딩
	public AcademyStudent(int no, String name,String className) {
		super(no, name);
		this.className=className; //이걸 넣어줘야함...!
		//System.out.println("반이름은: "+this.className);
	}
	
//	public AcademyStudent(int no, String name,String className) {
//		this.no=no;
//		this.name=name;
//		this.className = className;
//	}
	
	//멤버 메소드
	@Override
	public void print() {
		super.print();
		System.out.println("className은: "+this.className);
	}
	
	//getter, setter
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	
}
