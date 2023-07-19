package 포함;

public class MemberField {
	
	//멤버필드 세팅
	private int member1=1;
	private double memeber2=2.0;
	private char member3='가';
	private boolean member4=false;
	private String memeber5="회원입니다.";
	private DuoMember member6=new DuoMember(1111, "듀오멤버1입니다.");
	
	//기본 생성자
	public MemberField() {
		
	}
	
	//생성자 오버로딩
	public MemberField(int member1, double memeber2, char member3, boolean member4, String memeber5,
			DuoMember member6) {
		this.member1 = member1;
		this.memeber2 = memeber2;
		this.member3 = member3;
		this.member4 = member4;
		this.memeber5 = memeber5;
		this.member6 = member6;
	}

	//toString 오버라이딩
	@Override
	public String toString() {
		return "MemberField [member1=" + member1 + ", memeber2=" + memeber2 + ", member3=" + member3 + ", member4="
				+ member4 + ", memeber5=" + memeber5 + ", member6=" + member6 +" no는: "+member6.getNo() + "]";
	}
	
	//getter, setter
	public int getMember1() {
		return member1;
	}

	public void setMember1(int member1) {
		this.member1 = member1;
	}

	public double getMemeber2() {
		return memeber2;
	}

	public void setMemeber2(double memeber2) {
		this.memeber2 = memeber2;
	}

	public char getMember3() {
		return member3;
	}

	public void setMember3(char member3) {
		this.member3 = member3;
	}

	public boolean isMember4() {
		return member4;
	}

	public void setMember4(boolean member4) {
		this.member4 = member4;
	}

	public String getMemeber5() {
		return memeber5;
	}

	public void setMemeber5(String memeber5) {
		this.memeber5 = memeber5;
	}

	public DuoMember getMember6() {
		return member6;
	}

	public void setMember6(DuoMember member6) {
		this.member6 = member6;
	}
	
	
	
	
	
}
