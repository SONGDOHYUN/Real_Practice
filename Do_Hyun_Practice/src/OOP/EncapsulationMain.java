package OOP;

public class EncapsulationMain {

	public static void main(String[] args) {
		Encapsulation en1=new Encapsulation();
		en1.setMemberField1(1);
		//en1.setMemberField2(false);
		en1.setMemberField3('가');
		en1.setMemberField4(0.5);
		
		System.out.println(en1.getMemberField1());
		System.out.println(en1.isMemberField2());
		System.out.println(en1.getMemberField3());
		System.out.println(en1.getMemberField4());
		
	}

}
