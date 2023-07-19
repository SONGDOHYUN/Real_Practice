package 상속;

public class AcademyGansa extends AcademyMember{ //AcademyMember클래스 사용 가능
	
	//강사 고유의 멤버필드
	private String subject;
	
	//메소드 오버라이딩
	@Override
		public void print() {
			super.print();
			System.out.println("subject는: "+this.subject);
		}
	/* 이렇게 써도 됨	
	public void gansaPrint() {
		this.print();
		System.out.println("subject는: "+this.subject);
	}
	*/
	
	//기본생성자->초기화함
	public AcademyGansa() {
		super();
	}
	
	//생성자 오버로딩 -> 1. 이렇게 하거나
	public AcademyGansa(int no, String name, String suject) {
		super(no,name);
		this.subject=suject;
		//System.out.println("고유 과목은: "+this.subject);
	}
	
	/* 2. 이렇게 직접 부모 클래스 생성자의 파라미터 끌고 와서 직접 쓰면서 정의할수도 있음
	public AcademyGansa(int no, String name, String subject) {
		//상속받아서 no, name 멤버필드 쓸 수 있음
		this.no=no;
		this.name=name;
		this.subject = subject;
	}
	
	*/
	//getter, setter
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
	
}
