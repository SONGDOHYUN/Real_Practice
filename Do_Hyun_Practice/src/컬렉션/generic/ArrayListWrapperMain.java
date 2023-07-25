package 컬렉션.generic;

import java.util.ArrayList;

public class ArrayListWrapperMain {

	public static void main(String[] args) {
		System.out.println("--String generic 시작--");
		ArrayList<String> nameList=new ArrayList<String>(); 
		//리스트를 생성하고 그 리스트 각각 안에는 String 타입의 요소들이 저장될 것이다.
		nameList.add("1번");
		nameList.add("2번");
		nameList.add("3번");
		nameList.add("4번");
		nameList.add(new String("5번"));
		System.out.println("추가 후: "+nameList.size()); //5
		System.out.println(nameList);
		
		System.out.println("--get(index)--");
		String name=nameList.get(0);
		System.out.println(name);
		System.out.println(nameList.get(2));
		
		System.out.println("--remove(index)--");
		nameList.remove(0);
		System.out.println("삭제 후 nameList: "+nameList.size()); //4
		System.out.println("삭제 후 nameList: "+nameList);
		System.out.println();
		
		System.out.println("--remove(element)--");
		boolean isRemove =nameList.remove(new String("6번"));
		System.out.println("삭제 가능? "+isRemove); //false: 미리 있는거 아님, 생성하자마자 없애니깐
		System.out.println(nameList); // [2번, 3번, 4번, 5번]
		String name2=nameList.get(0); //2번
		nameList.remove(name2);
		System.out.println("삭제 후: "+nameList.size()); //3
		System.out.println("삭제 후: "+nameList); //[3번, 4번, 5번]
		System.out.println();
		
		System.out.println("--Wrapper 객체--");
		ArrayList<Integer> scoreList=new ArrayList<Integer>();
		//새로운 배열 List를 만들었고 각각 배열에는 Integer 타입의 객체가 저장되며 그 전체 리스트/배열 객체의 주소값은 scoreList에 저장됨
		scoreList.add(1);
		scoreList.add(2);
		scoreList.add(3);
		scoreList.add(4);
		scoreList.add(new Integer(5)); //해당 코드가 구식 or 현재는 잘 사용되지 않는다고 알려주는 것
		System.out.println("배열 크기: "+scoreList.size());//5
		System.out.println(scoreList);
		System.out.println("--get(index)--");
		int score1=scoreList.get(0);
		System.out.println("score1: "+score1); //1
		System.out.println(scoreList.get(1)); //2
		int score2 =scoreList.get(1).intValue(); //2
		int score3=scoreList.get(2).valueOf(score2);
		System.out.println(">>>>>"+score3);
		System.out.println("scoreList: "+scoreList);
		System.out.println("--set(index)--");
		scoreList.set(2, score3);
		System.out.println(">>>"+score3);//2
		System.out.println(score2);
		System.out.println(scoreList);
		System.out.println("--remove--");
		scoreList.remove(2);
		System.out.println(score2);
		scoreList.remove(score2); //index 2번이 사라짐
		System.out.println(scoreList);
	}

}
