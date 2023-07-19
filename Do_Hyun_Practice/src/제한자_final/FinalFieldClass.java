package 제한자_final;

public class FinalFieldClass extends FInalMethodClass{

	//객체에 final 붙임->다른 객체 할당 못함
	public static final Product product1=new Product(1, "상품1");
	
	//final+(기본변수)->상수화되어 고정된 값이 됨
	public final int PORT_NUMBER=90;
	public final double INCENTIVE_RATE=0.1;
	public static final double PI=3.141592;
	public static final int EARTH_RADIUS=6400;
	
	//기본 생성자
	public FinalFieldClass() {
		/*
		this.INCENTIVE_RATE=0.2;
		-> 오류: The final field FinalFieldClass.INCENTIVE_RATE cannot be assigned
		-> final로 값 고정되어 있어서 변경할 수 없다는 뜻
		 * 
		 */
		System.out.println("--기본 생성자 실행 시 출력되는 코드들 입니다--");
		System.out.println("PORT_NUMBER: "+PORT_NUMBER);
		System.out.println("INCENTIVE_RATE: "+INCENTIVE_RATE);
		System.out.println("PI: "+PI);
		System.out.println("EARTH_RADIUS: "+EARTH_RADIUS);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("product1의 no 값: "+product1.getNo());
		product1.setNo(5);
		System.out.println("product1의 no 값: "+product1.getNo());
		
		System.out.println("PI: "+Math.PI);
		System.out.println("PI: "+FinalFieldClass.PI);
		
	}
	
}
