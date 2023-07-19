package OOP;

public class Static {
	public int instance_field;
	static int static_field=2;
	
	public void instance_method() {
		System.out.println("객체 메소드 출력");
	}
	
	public static void static_method() {
		System.out.println("정적/공통 메소드 출력");
	}
}
