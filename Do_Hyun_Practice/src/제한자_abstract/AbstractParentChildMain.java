package 제한자_abstract;

public class AbstractParentChildMain {

	public static void main(String[] args) {
		//AbstractClassParent parent=new AbstractClassParent(); ->추상클래스라 객체 못만듬
		
		AbstractClassChild child=new AbstractClassChild();
		child.abstractMethod1();
		child.method2();
		
		//업캐스팅 될까?
		System.out.println("--업캐스팅은 될까요?--");
		AbstractClassParent parent= new AbstractClassChild();
		parent.abstractMethod1(); //자식 클래스에서 구체화돼서 사용가능함
		parent.method2();
		
	}

}
