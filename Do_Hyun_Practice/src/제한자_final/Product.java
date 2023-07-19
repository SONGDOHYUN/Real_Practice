package 제한자_final;

public class Product {	
	
	//멤버필드
	private int no;
	private String name;
	
	//기본 생성자
	public Product() {
	}
	
	//생성자 오버로딩
	public Product(int no, String name) {
		this.no=no;
		this.name=name;
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
		return "Product [no=" + no + ", name=" + name + "]";
	}
	
}
