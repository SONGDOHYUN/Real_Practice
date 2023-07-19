package 제한자_abstract;

public class AbstractClassChild extends AbstractClassParent{
	@Override
	public void abstractMethod1() {
		System.out.println("부모의 추상 메소드를 자식 클래스에서 override했습니다.");
	}
}
