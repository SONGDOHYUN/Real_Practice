package 접근제한자.prince_korea;

import 접근제한자.president.Korea.YS;

public class YSChild extends YS{
	
	//부모클래스(YS)의 protected 붙은 필드들 사용 가능
	@Override
	public void access() {
		System.out.println("YS 부모 클래스의 access 메소드 재정의합니다.");
		YSChild child=new YSChild();
		child.member2=2;
		child.method2();
	}
	
	
	
	
	
}
