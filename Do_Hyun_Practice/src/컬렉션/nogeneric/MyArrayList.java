package 컬렉션.nogeneric;

public class MyArrayList{	
	//멤버필드
	private Object[] elementData; //Object클래스의 배열타입의 elementData라는 변수 선언
	private int size;
	
	//기본 생성자 -> 기본 객체 생성할 때 size=0, elementData 변수는 Object 타입 배열크기 10개짜리로 초기화됨
	public MyArrayList() {
		size=0;
		elementData=new Object[10];
	}
	
	//멤버메소드
	public int size() {
		return size;
	}
	
	//add 메소드
	//add 메소드를 실행했을 때 object element 객체가 elementData 배열의 size 인덱스 주소값에 저장됨, int size 숫자 +1 
	public void add(Object element) {
		elementData[size]=element; 
		size++;
	}
	
	//get 메소드
	public Object get(int index) {
		return elementData[index];
	}
	
	
	//remove 메소드
	public Object remove(int index) {
		Object removeElement=elementData[index]; 
		//removeElement라는 객체는 elementData배열의 index번째의 주소값에 저장됨
		elementData[index]=null;
		//size--;
		return removeElement;
		
	}
	
	//인덱스 값 가져오기
	public int index(int index) {
		return index;
	}
	
	
	

}
