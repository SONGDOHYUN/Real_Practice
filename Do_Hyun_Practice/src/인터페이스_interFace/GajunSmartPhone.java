package 인터페이스_interFace;

public class GajunSmartPhone extends GajunGumsa implements GajunOnOff,GajunVolume{
	//고유 멤버필드
	String phoneName;
	
	//on, off
	@Override
	public void on() {
		System.out.println("GajunSmartPhone.on()->재정의");
	}
	
	@Override
	public void off() {
		System.out.println("GajunSmartPhone.off()->재정의");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("GajunSmartPhone.volumeOn()->재정의");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("GajunSmartPhone.volumeDown()->재정의");
	}

	@Override
	public String toString() {
		return "GajunSmartPhone [phoneName=" + phoneName + "]";
	}
	
	
}
