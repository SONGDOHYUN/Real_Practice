package 제한자_final;

public class FinalFieldClassMain {

	public static void main(String[] args) {
		
		System.out.println("--final에 대해 알아보겠습니다--");
		FinalFieldClass ffc1=new FinalFieldClass();
		
		String ffcName=ffc1.product1.getName();
		System.out.println("변경 전 ffcName: "+ffcName);
		ffc1.product1.setName("바뀐 이름 상품2");
		System.out.println("변경 후 ffcName: "+ffc1.product1.getName());
		System.out.println();
		
		/*
		 * ffc1.PORT_NUMBER=1;
		 * -> 오류: The final field FinalFieldClass.INCENTIVE_RATE cannot be assigned
		 */
		System.out.println("ffc1의 PORT_NUMBER: "+ffc1.PORT_NUMBER);
		System.out.println("ffc1의 INCENTIVE_RATE: "+ffc1.INCENTIVE_RATE);
		System.out.println("ffc1의 PI: "+ffc1.PI);
		
		//PI앞에 static 붙였어서 클래스이름.PI로 값 가져올 수 있음
		System.out.println("FinalFieldClass의 PI: "+FinalFieldClass.PI);
		
		FinalFieldClass ffc2=new FinalFieldClass();
		System.out.println("ffc2의 PORT_NUMBER: "+ffc2.PORT_NUMBER);
		System.out.println("ffc2의 INCENTIVE_RATE: "+ffc2.INCENTIVE_RATE);
		System.out.println("ffc2의 PI: "+ffc2.PI);
		System.out.println("FinalFieldClass의 PI: "+FinalFieldClass.PI);
		System.out.println("Math Class의 PI: "+Math.PI);
		
		System.out.println();
		System.out.println("final method 알아보기");
		ffc2.method2();
		//오버라이딩 안됐지만 부모 클래스의 고유 메소드라서 접근/사용가능했던 것임
		
	}

}
