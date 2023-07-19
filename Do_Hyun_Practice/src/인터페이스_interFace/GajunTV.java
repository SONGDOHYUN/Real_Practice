package 인터페이스_interFace;

/*
 * 가전 TV는 on,Off 기능과  volume 조절 기능을 가진다
 * ->인터페이스 implement해서 TV 클래스에 맞게 재정의하기
 */

public abstract class GajunTV extends GajunGumsa implements GajunOnOff, GajunVolume{
	//GajunGumsa라는 클래스를 상속 받아서 해당 클래스의 고유 멤버필드들 사용 가능
	//interface implements해서 해당 interface의 고유 멤버필드 재정의 하는 등 사용 가능
	
	//고유 멤버필드
	String tvName;
	
	//기본 생성자
	public GajunTV() {
	}
	
	//on,off 메소드 재정의
	@Override
	public void on() {
		System.out.println("TV.on()->재정의함");
	}
	
	@Override
	public void off() {
		System.out.println("TV.off()->재정의함");
		
	}
	
	//volume 메소드 재정의
	@Override
	public void volumeUp() {
		System.out.println("TV.volumeUp()->재정의");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("TV.volumeDown()->재정의");
	}
	
	//GajunTV 클래스의 고유 메소드
	public void tvFunction1() {
		System.out.println("GajunTV클래스의 고유 메소드tvFunction()입니다.");
	}
	
	//GajunTv 클래스의 고유 메소드->추상 메소드->상속 자식 클래스에서 재정의 해야함
	public abstract void tvFunction2();

	@Override
	public String toString() {
		return "GajunTV [tvName=" + tvName + "]";
	}
	
	
}
