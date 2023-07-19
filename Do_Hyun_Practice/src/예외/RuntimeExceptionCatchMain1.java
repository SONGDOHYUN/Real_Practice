package 예외;

public class RuntimeExceptionCatchMain1 {

	public static void main(String[] args) throws NullPointerException, ArrayIndexOutOfBoundsException{
		System.out.println("--NullPointException에 대해 알아봅시다.--");
		String str=null;
		try {
			//예외가 예상되는 코드를 적음
			int length=str.length();
			
		} catch (Exception e) {
			//예외 발생시 해결시킬 코드를 적음
			e.printStackTrace();
			System.out.println("NullpointException이 발생했습니다: "+e.getMessage());
			str="새로운 스트링입니다.";
			int length=str.length();
			System.out.println("str의 길이는: "+length);
			System.out.println("--오류를 해결했습니다.--");
		}
		System.out.println();
		
		
		System.out.println("--ArrayIndexOutOfBoundsException에 대해 알아봅시다--");
		int[] intArray1=new int[3];
		//intArray1=null;
		
		try {
			//오류 예상 코드
			intArray1[3]=99; //인덱스는 0,1,2까지 밖에 없음
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ArrayIndexOutOfBoundsException가 발생했습니다: "+e.getMessage());
			intArray1[2]=99;
			for(int intArray2:intArray1) {
				System.out.println(intArray2);
			}
			System.out.println("오류를 해결했습니다.");
			
		}
		
	}

}
