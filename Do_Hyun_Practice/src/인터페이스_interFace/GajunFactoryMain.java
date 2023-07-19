package 인터페이스_interFace;

import java.sql.Array;

public class GajunFactoryMain {

	public static void main(String[] args) {
		System.out.println("--가전제품을 생성해보겠습니다--");
		
		//Tv 생성
		//GajunTV tv1=new GajunTV(); ->추상 클래스라서 직접적인 객체 생성안되고 조참자객 해야함
		GajunTV tv1=new GajunMiniTV();
		GajunTV tv2=new GajunMiniTV();
		
		//smartPhone 생성
		GajunSmartPhone phone1= new GajunSmartPhone();
		GajunSmartPhone phone2= new GajunSmartPhone();
		
		//인터페이스의 조참자객
		GajunOnOff[] onOffArray= new GajunOnOff[4];
		onOffArray[0]=tv1;
		onOffArray[1]=tv2;
		onOffArray[2]=phone1;
		onOffArray[3]=phone2;
		
//		GajunOnOff[] onOffArray2= {
//				new GajunSmartPhone(),
//				new GajunSmartPhone()
//		};
//		
//		
//		System.out.println("---------");
//		System.out.println(onOffArray2[0]);
//		System.out.println(onOffArray2[1]);
		
		System.out.println("--가전제품 생성을 완료했습니다--");
		
		System.out.println("--가전제품 검사를 시행해보겠습니다--");
		//onOffArray[0].gumsa(onOffArray);
		
		GajunOnOff.gumsa(onOffArray);
		
		
		
		
		
		
		
	}

}
