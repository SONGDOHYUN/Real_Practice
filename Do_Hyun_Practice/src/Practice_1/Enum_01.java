package Practice_1;

/*
 * 1. Enum(열거타입)이란
 * - 한정된 데이터 값만 갖는 데이터 타입!
 * ex)요일-월,화,수.../계절-봄, 여름...
 * - 클래스처럼 보이게하는 상수
 * - 서로 관련있는 상수들끼리 모아 상수들을 정의한 것
 * 
 * 2. Enum 정의 : 따로 java class 파일을 만들어서 사용한다.
 * 
 * 3. 문법: enum 열거체 이름{상수1, 상수2...}
 * ex)
 * - enum Company{SK, LG, SAMSUNG}
 * - 사용법: Company.SK
 * 
 * 4. 주로 사용되는 Method
 * - values(): enum의 요소들을 enum 타입의 배열로 리턴한다.
 * - ordinal() : 해당 요소의 index 값을 리턴한다.
 * - valueOf(): enum에서 String 값을 가져온다.
 * - compareTo(): 매개값으로 주어진 열거 객체가 기준->전 후 몇번째에 위치하는지 비교한다
 * ->전에 위치: 음수 리턴, 후에 위치: 양수 리턴
 */


public class Enum_01 {

	enum Season{
		봄, 여름, 가을, 겨울
	} //enum 클래스 내부에 선언
	
//	public class People{
//		public String name;
//		public Season fav_Season;
//	
	public static void main(String[] args) {
		for(Season sea: Season.values()) {
			System.out.println(sea);
		}
		
		Season season1=Season.가을;
		Season season2=Season.봄;
		
		int result1=season1.compareTo(season2);
		int result2=season2.compareTo(season2);
		int result3=season2.compareTo(season1);
		System.out.println(result1); //봄보다 가을이 2개 더 뒤에 있음:+2
		System.out.println(result2); //같은 위치: 0
		System.out.println(result3); //가을보다 봄이 2개 더 앞에 있음:-2
		
		
//		People people=new People();
//		
//		Season season=Season.봄;
//		System.out.println(season); //봄 출력
//		System.out.println(Season.여름); //여름 출력
//		
//		
//		people.name="미미";
//		people.fav_Season=Season.봄;
//		System.out.println("이름이 무엇입니까?"+ people.name);
//		System.out.println("좋아하는 계절은 무엇입니까?"+people.fav_Season);
//		
		}
	}
	
		

