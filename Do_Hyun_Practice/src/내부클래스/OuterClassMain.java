package 내부클래스;

import 내부클래스.OuterClass.InnerClass;

public class OuterClassMain {

	public static void main(String[] args) {
		//객체 생성
		OuterClass oc=new OuterClass();
		System.out.println(oc.outer_member_field); //8888
		oc.outer_member_method();
		oc.outer_inner_class_user();
		
		System.out.println(">>>>>InnerClass에 접근>>>>>");
		OuterClass.InnerClass ic=new OuterClass().new InnerClass();
		System.out.println(ic);
		System.out.println("ic의 innerClass 멤버필드: "+ic.inner_member_field); //3333
		ic.inner_outer_user();
		
		
		
		
		
		
		
		
		
	}

}
