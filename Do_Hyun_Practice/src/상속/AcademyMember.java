package 상속;

public class AcademyMember {
	
	//멤버필드
	public int no;
	public String name;
	
	//기본 생성자
	public AcademyMember() {
	}

	//생성자 오버로딩
	public AcademyMember(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	//멤버메소드
	public void print() {
		System.out.println(this.no+"\t"+this.name+"\t");
	}
	
	//getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//toString 오버라이딩
	@Override
	public String toString() {
		return "AcademyMember [no=" + no + ", name=" + name+"]";
	}
	
}
