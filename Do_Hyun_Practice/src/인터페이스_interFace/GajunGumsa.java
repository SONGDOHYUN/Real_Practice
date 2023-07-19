package 인터페이스_interFace;

public class GajunGumsa {

	//고유멤버필드
	private GajunOnOff[] gajuns; //GajunOff인터페이스의 배열타입의 gajuns 변수 선언
	
	//기본 생성자
	public GajunGumsa() {
	}
	
	//생성자 오버로딩
	public GajunGumsa(GajunOnOff[] gajuns) {
		this.gajuns=gajuns;
	}
	
	//getter, setter
	public GajunOnOff[] getGajuns() {
		return gajuns;
	}

	public void setGajuns(GajunOnOff[] gajuns) {
		this.gajuns = gajuns;
	}
	
	//고유메소드->"검사"라는 메소드를 통해 on/off기능과 volume 기능을 확인하고 싶음
	public void gumsa(GajunOnOff[] gajuns) {
		for(GajunOnOff tempGajun1: gajuns) {
			/*
			 * tempGajun1은 gajuns라는 배열의 element를 하나하나 가져오는 역할을 함
			 * gajuns라는 배열안에 들어있는 element 타입은 GajunOnOff 타입임
			 * 따라서 tempGajun1의 타입은 GajunOnOff타입의 요소들을 하나하나 가져와서 대입하는 역할이라
			 * GajunOnOff[] 타입이 아닌 GajunOnOff 타입이어야함
			 */
			System.out.println("검사 시작합니다");
			tempGajun1.on();
			GajunVolume tempGajun2=(GajunVolume)tempGajun1;
			//이렇게 형변환하면 tempGajun1 객체를 GajunVolume 인터페이스 필드 사용할 수 있게함
			tempGajun2.volumeUp();
			tempGajun2.volumeDown();
			tempGajun1.off();
			System.out.println("검사 끝입니다");
		}
	}
	
	
	
}
