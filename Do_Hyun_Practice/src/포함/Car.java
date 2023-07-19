package 포함;

public class Car {	 
	
	//멤버필드
	private int no; //차량 번호
	private String model; //차량 모델명
	private Engine engine; 
	/*
	 ********중요!!!!!!
	 *-> [Engine engine]: 차량 엔진 객체 주소!!를 저장!!할 변수!!!!!!
	 *-> Engine 객체의 주소값을 참조하는 변수임 ==>> 이거 자체가 객체가 아니고 객체를 가리키는 변수라는 것!!
	 *-> Engine 객체의 주소값을 저장하고 해당 객체/Engine 클래스에 접근하여 객체의 멤버필드, 메소드 사용할 수 있게함
	 */
	
	//기본 생성자
	public Car() {
	}
	
	//생성자 오버로딩
	public Car(int no, String model, Engine engine) {
		this.no=no;
		this.model=model;
		this.engine=engine;
	}
	
	//멤버 메소드
	public void print() {
		System.out.println(this.no+"\t"+this.model);
		this.engine.print();
	}
	
	//getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	//toString 오버라이딩
	@Override
	public String toString() {
		return "Car [no=" + no + ", model=" + model + ", engine=" + engine + "]";
	}
	
	
	
	
}
