package Practice_1;
/*
 * 1. Thread란?
 * -> 실행되고 있는 어플리케이션 하나 
 * 
 * 2. Thread 생성방법?
 * -> Thread 클래스를 상속받아서 직접 생성
 * -> Runnable 인터페이스를 구현하여 클래스 객체를 매개변수로 받음
 * -> 자바에서는 synchronized 키워드, Lock 객체, Atomic 클래스 등을 사용하여 스레드 동기화를 구현할 수 있음
 * -> 자바는 스레드 동기화를 위해 synchronized 키워드, wait(), notify(), notifyAll() 메서드를 제공함
 * 
 * 강사님 자료))
 * 
 * - 쓰레드객체 만드는 방법(형식)

	type A:
	1. Thread 클래스를 상속받는다.
	2. Thread class의 run(); 를 overriding 한다.
		동사원형:public void run()
	3. ThreadMain 클래스에 객체를 생성한다.
	4. Thread 객체를통해서 Thread를 시작시킨다.->객체.start();
	
    type B:
	1. Runnable interface를 implements 한다.
	2. Runnable interface를 implements 한객체를
	   Thread 클래스의 생성자에 넣어서 Thread 객체를 생성한다
    3. Thread 를 시작시킨다.

   형식>>
    1. Thread 클래스를 상속받아서 만든다..
      ex> public class ThreadEx extends Thread{
          		// run 메쏘드를 재정의 해야한다.
          		 public void run(){
          		 	//사용자가만든 쓰레드 가 실행할코드
          		 }
          } 
    2. Runnable interface를 implements 해서만든다
      ex>  public class ThreadImpl implements Runnable{
           		public void run(){
          		 }
           } 
 * 
 * 
 * 
 * 3. Thread의 메소드: sleep();
 * -> 아무일도 하지 않고 주어진 시간이 경과되기만을 기다리는 메소드
 * -> 1000이 1초를 뜻함
 * -> sleep 메소드 실행 시 interruptedException 발생할 수 있음
 * 
 * 4. Thread 풀 생성
 * -> 자바는 스레드 풀을 사용할 수 있도록 ExecutorService 인터페이스와 Executors 클래스 메소드 중
 *    newCachedThreadPool(자동생성)과 newFixedThreadPool(갯수정하기) 메소드를 제공함
 * -> 최대치로 생성-> Executors.newFixedThreadPool(Runtime.getRuntime().availavleProcessors())
 * -> 완전 수동: ThreadPoolExecutor( 코어 스레드 수, 최대 스레드 개수, 놀고 있는 시간, 놀고있는 시간 단위, 작업 큐 )
 * -> 하나하나 설정하여 스레드 생성 new ThreadPoolExecutor(3,100,120L,TimeUnit SECONDS, new SynchronousQueue<Runnable>())   
 * ->    
 *    
 * 5. Thread 풀이란?
 * -> 
 * 
 * 6. Synchronized
 * - 동기화:  !!동시에 여러 작업 진행 안되게!! 조절하는 것
 *          여러 작업이 일정한 간격을 가지고 시행되도록 조정하는 것
 *         ->공유 자원에 여러 스레드가 동시에 접근 못하게 하는 것 
	public synchronized void printLower()
 * 
 * 
 * 
 */
public class Thread {

	public static void main(String[] args) {
		
	}

}
