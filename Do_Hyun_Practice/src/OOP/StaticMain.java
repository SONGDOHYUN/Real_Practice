package OOP;

public class StaticMain {

	public static void main(String[] args) {
		//정적 변수, 메소드 사용
		System.out.println("static 변수 기본값: "+Static.static_field);
		Static.static_field=1;
		System.out.println("static 변수 설정한 뒤: "+Static.static_field);
		Static.static_method();
		
		//객체 생성하여 static 클래스의 변수, 메소드 사용
		Static st1=new Static();
		System.out.println("객체 생성 후 static 변수의 기본값: "+st1.static_field);
		System.out.println("객체 생성 후 instance 변수의 기본값: "+st1.instance_field);
		st1.instance_field=55;
		System.out.println("객체 생성 후 instance 변수 설정한 뒤: "+st1.instance_field);
		Static.static_method();
		st1.static_method();
		st1.instance_method();
	}
	
}
