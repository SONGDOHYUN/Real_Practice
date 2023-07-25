package 컬렉션.nogeneric;

public class MyArrayListMain {

	public static void main(String[] args) {
		//객체 생성
		MyArrayList myArrayList=new MyArrayList();
		System.out.println("추가 전 List size: "+myArrayList.size()); //0
		myArrayList.add(new Account(1, "주인1", 100, 1.0)); 
		//!!MyArrayList라는 배열에 0부터 인덱스 순서대로  Account 객체가 저장됨!!
		
		myArrayList.add(new Account(2, "주인2", 200, 2.0));
		myArrayList.add(new Account(3, "주인3", 300, 3.0));
		System.out.println("추가 후 List size: "+myArrayList.size()); //3
		System.out.println(myArrayList.get(1)); //2번 Account 정보 출력됨
		System.out.println();
		
		System.out.println("--Account 타입으로 casting 하여 Account의 필드를 사용하겠습니다--");
		Account accountObject=(Account)myArrayList.get(1);
		accountObject.headerPrint();
		accountObject.print();
		
		System.out.println("--myArrayList를 하나 삭제 : null 값으로 만들겠습니다--");
		myArrayList.remove(0); //remove메소드 실행 시 index 0번 null값 만들고 size 1 감소됨
		System.out.println("myArrayList의 0번째 Account 객체: "+myArrayList.get(0)); //null
		System.out.println("myArrayList의 배열 크기: "+myArrayList.size()); //그래도 여전히 3
		System.out.println("myArrayList의 배열 전체 출력");
		for(int i=0;i<myArrayList.size();i++) {
			System.out.println(myArrayList.get(i));
		}
		
		Account.headerPrint();
		for(int i=0;i<myArrayList.size();i++) {
			if(myArrayList.get(i) !=null) {
				Account arrayAccount=(Account)myArrayList.get(i);
				arrayAccount.print();
				//System.out.println(myArrayList.get(i));
			}else {
				System.out.println("myArrayList의 index "+myArrayList.index(i)+"의 값은 null입니다.");
			}
		}
		
	}

}
