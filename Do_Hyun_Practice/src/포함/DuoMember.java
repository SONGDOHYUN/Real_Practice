package 포함;

public class DuoMember {

	//멤버필드
	private int no; //회원 번호
	private String name; //회원 이름
	
	//기본 생성자
	public DuoMember() {
	}
	
	//생성자 오버로딩
	public DuoMember(int no, String name) {
		this.no=no;
		this.name=name;
	}
	
	//멤버 메소드
	public void print() {
		System.out.println(this.no+"\t"+this.name);
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
	
	//toString 오버라이딩 -> 없애면 객체의 주소값을 볼 수 있다.
//	@Override
//	public String toString() {
//		return "DuoMember [no=" + no + ", name=" + name + "]";
//	}
}
