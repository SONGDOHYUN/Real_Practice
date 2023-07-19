package OOP;

public class PrimitiveTypeArrayMain {
	
	public static void main(String[] args) {
		int intType=90;
		
		int[] intArray=new int[5];
		intArray[0]=90;
		intArray[1]=10;
		intArray[2]=20;
		intArray[3]=30;
		intArray[4]=40;
		
		System.out.println("--for문--");
		for(int i=0;i<intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		System.out.println("--int 값의 총점+ for문 돌리기--");
		int intTot=0;
		for(int tot:intArray) {
			intTot+=tot;
		}
		System.out.println("int 값의 총점: "+intTot);
		
		System.out.println("--char로 해보겠습니다--");
		char[] charArray=new char[3];
		charArray[0]='가';
		charArray[1]='나';
		charArray[2]='다';
		char charTot;
		for(char tot:charArray) {
			System.out.print(tot);
		}
		
		System.out.println("--boolean으로 해보겠습니다--");
		boolean[] booleanArray=new boolean[3];
		booleanArray[0]=true;
		booleanArray[1]=false;
		//booleanArray[2]는 자동으로 false로 기본값 설정된다
		
		for(boolean tot:booleanArray) {
			System.out.println(tot);
		}
		
		
		
		
		
		
		
		
		
	}

}
