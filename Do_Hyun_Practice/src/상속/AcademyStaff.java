package 상속;

public class AcademyStaff extends AcademyMember{

	//AcademyStaff의 고유 멤버필드
	private String depart;
	
	//기본 생성자
	public AcademyStaff() {
		super();
	}
	
	//생성자 오버로딩
	public AcademyStaff(int no, String name, String depart) {
		super(no,name);
		this.depart=depart;
		//System.out.println("depart는: "+this.depart);
	}
	
//	public AcademyStaff(int no, String name, String depart) {
//		this.no=no;
//		this.name=name;
//		this.depart=depart;
//	}
	
	//메소드 오버라이딩
	@Override
	public void print() {
		super.print();
		System.out.println("depart는: "+this.depart); 
		//이렇게 상속받는 메소드 재정의해서 원하는 코드를 더 추가할 수 있음
	}
	
	//getter, setter
	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	
	
	
	
}
