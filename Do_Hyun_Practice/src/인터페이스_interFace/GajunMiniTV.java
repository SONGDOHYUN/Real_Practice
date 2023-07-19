package 인터페이스_interFace;

public class GajunMiniTV extends GajunTV{
	
	//고유 멤버필드
	String miniTvName;
	
	//GajunTv 클래스의 추상 메소드 오버라이딩
	
	@Override
	public void tvFunction2() {
		System.out.println("GajunTV.tvFunction2()를 GajunMiniTV에서 재정의함");
	}
	
	@Override
	public void on() {
		super.on();
		System.out.println("GajunMiniTV클래스에 on() 한번 더 재정의함");
	}

	@Override
	public String toString() {
		return "GajunMiniTV [miniTvName=" + miniTvName + "]";
	}
	
}
