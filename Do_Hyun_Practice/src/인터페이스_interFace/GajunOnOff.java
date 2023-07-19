package 인터페이스_interFace;

public interface GajunOnOff {
	
	//인터페이스의 고유 메소드(추상 메소드)
	public abstract void on();
	public abstract void off();
	
	
	public static void gumsa(GajunOnOff[] gajuns) {
		for(int i=0;i<gajuns.length;i++) {
			System.out.println("검사 시작합니다");
			gajuns[i].on();
			GajunVolume tempGajun2=(GajunVolume)gajuns[i];
			//이렇게 형변환하면 tempGajun1 객체를 GajunVolume 인터페이스 필드 사용할 수 있게함
			tempGajun2.volumeUp();
			tempGajun2.volumeDown();
			gajuns[i].off();
			System.out.println("검사 끝입니다");
		}
	}
	
}
