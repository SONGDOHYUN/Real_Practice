package Practice_1;
/*
 * 1. 다형성[Polymorphism]이란? : 하나의 변수에 다양한 타입의 객체를 대입할 수 있는 것
 * -> 전제: 상속관계에 있어야함, 오버라이딩, 업캐스팅
 * -> 하나의 객체/메소드가 여러가지 형태를 가질 수 있는 것: 
 * -> 예시) 오버로드(메소드 이름만 같고 매개변수 다르게 해서 생성자나 메소드 여러개 만드는 것), 
 *         오버라이딩(메소드 이름, 매개변수, 반환타입 같아야함: 부모클래스 메소드 선언부 그대로 가져와야함: 재정의), 상속받은 객체의 참조변수 형변환
 * -> 조상클래스 타입의 참조변수로 자식 클래스 객체를 참조할 수 있게 함 : 조상 참조로 자식 객체 생성가능: 조참자객
 * 
 *  * "!!조참자객!! 왼쪽은 조참=오른쪽은 자객: 포커싱은 항상 왼쪽의 변수!!->조상은 자식 객체 참조가능->업캐스팅임
 *         : 자식 객체 참조했지만 결국 조상 타입으로 형이 변환되기 때문에 
 *           자식 클래스의 멤버필드, 멤버 메소드는 사용 못하고 조상 클래스의 멤버 필드, 멤버 메소드만 사용 가능함
 *           자식 클래스 고유의 필드, 메소드 사용하려면 다시 다운 캐스팅 하면 됨
 *			 "     
 * -> Parent p= new Child(); - 가능
 * -> Child c= new Parent(); - 불가능
 * 
 * 
 * 2. 형변환(Casting)이란? : !!!상속관계나 인터페이스 구현 관계일때만 가능!!!서로 관련 없는 클래스, 인터페이스일때는 불가능함!!
 * -> 형제끼리는 캐스팅 불가능함
 * -> 데이터 타입을 변경하는 것
 * -> 상속받은 객체를 형변환 시키는 것 = 객체에 속한 멤버변수/메소드들의 사용범위가 달라지는 것임
 * -> 큰 원리: 자식은 부모거를 다 쓸 수 있지만 부모는 자식거를 못 씀
 * -> 근데 자식 클래스에 오버라이딩 된 메소드 있으면 오버라이딩 된 메소드가 실행됨
 * 
 * ★★★★★★★★★★★★★★★★★헷갈리는 부분★★★★★★★★★★★★★★★★★
 * List<> list=new ArrayList<>(); -> 이건 업캐스팅인가> 조참자객이니까? ->ㄴㄴ 그냥 형변환임, 상속관계 아니고 구현관계라서!
 * 
 * -> List<> list = new ArrayList<>();의 코드는 업캐스팅이 아니라 
 *    다형성(polymorphism)을 이용한 참조 변수의 다형성을 보여주는 예시임.
      ArrayList<>은 List<> 인터페이스를 구현한 클래스임. 
      List<>는 인터페이스이며, ArrayList<>은 이 인터페이스를 구현한 구체적인 클래스임.
	  
	  !!다형성을 이용하면 하나의 변수에 다양한 타입의 객체를 대입할 수 있습니다.!! 
	  
	  List<> list = new ArrayList<>();의 경우, 
	  ArrayList<> 객체를 생성하여 List<> 타입의 변수 list에 대입하고 있습니다. 
	  이것은 ArrayList<> 객체가 List<> 타입으로 업캐스팅되는 것이 아니라, 
	  List<> 타입으로 참조되는 것입니다. -> 그래서 다형성임
 * 	
 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 *    업캐스팅은 일반적으로 !!상속 관계에서!! 부모 클래스로 자식 클래스를 참조하는 것을 의미하는데, 
 *    ArrayList<>과 List<>은 !!구현 관계이므로!! 업캐스팅이라기보다는 
 *    다형성을 통한 참조 변수의 !!다형성을!! 나타내는 것으로 이해할 수 있습니다.
 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 * 
 * 
 * 
 * 
 * 
 * 2-1. 업캐스팅(upcasting)
 * -> !!!!!!!!!!!!!상속관계에서!!!!!!!!!자식을 부모로 형변환 하는 것 
 * -> Child child = new Child();
 *    Parent parent = (Parent) child; 업캐스팅
 *    Parent parent = child;
 *    Parent parent = new Child(); 참조다형성 및 업캐스팅!!!! 한 것
 *    
 *    
 *    
 *   ★★★★★★★★★★★★★ㅍ *********헷갈렸던 부분*********★★★★★★★★★★★★★★★
 * -> 이때는 주체가 "parent(객체)"임!!!!!!
 * -> 큰 원리는 부모클래스(멤버필드, 멤버 메소드)만 쓸 수 있지만
 *    ★★★★★★★★자식 클래스에 오버라이딩 된 메소드 있으면 그게 실행됨!!!!!!!!
 * -> 확실히 하기 위한 또 다른 예시)))))))
 *  class Animal{
 *   public void eat(){
 *   	sysout("동물이 먹습니다.");
 *   }
 *   
 *   public void live(){
 *   	sysout("동물이 삽니다.");
 *   }
 *  }
 * 
 * class Cat extends Animal{
 * 	public void meow(){
 * 		sysout("야옹합니다.");
 * 	}
 * 	
 * 	@overrride
 * 	public void live(){
 * 		sysout("고양이가 삽니다.");	
 * 	}
 * }
 * 
 * public class 다형성Main(){
 * 	public static void main(String[] args) {
 * 		Cat cat=new Cat();
 * 		Animal animal=(Animal) cat;
 * 	  =>결국 이 과정을 한줄로 표현하면
 * 		Animal animal=(Animal: 이거 있다고 생각하면 됨->업캐스팅 됐구나...그럼 부모 클래스만 쓸 수 있겠다...!하면 됨)new Cat();
 * 	
 * ★★★★★★★★정확한 코드해석★★★★★★★★
 * `Animal animal = (Animal: 생략되어있다고 보기)new Cat();`는 다음과 같은 코드입니다:

1. `Cat` 클래스는 `Animal` 클래스를 상속받은 자식 클래스입니다.
2. `new Cat()`은 `Cat` 클래스의 인스턴스(=객체)!!!!를 생성합니다.
3. 생성된 `Cat` 인스턴스는 `Cat` 클래스의 모든 멤버(필드 및 메소드)를 가지고 있습니다.
4. `Animal animal`은 `Animal` 클래스의 변수!!!!입니다. 즉, `animal` 변수는 `Animal` 타입의 참조를 저장할 수 있습니다.
5. `=`를 통해 `new Cat()`에서 생성된 `Cat` 인스턴스를 `animal` 변수에 할당합니다.
6. 이로써 `animal` 변수는 `Cat` 클래스의 인스턴스를 참조(=사용)할 수 있습니다.

	=> 결과적으로, `Animal` 타입의 `animal` 변수는 `Cat` 클래스의 인스턴스를 참조/사용하게 됩니다. 
	   그러나 업캐스팅이 발생한 했음!!!!. 
	   업캐스팅을 통해 `animal` 변수는 `Animal` 클래스의 멤버들에만 접근할 수 있게 되고, 
	   `Cat` 클래스에 정의된 고유한 멤버들에는 직접적인 접근은 불가능합니다.
 * 
 * 
 * 
 * 	  =>그리고 여기서 주체는 cat 객체가 아닌 왼쪽에 있는 animal객체임
 * 	  =>animal이 부모 클래스라 cat 객체를 생성해도 부모로 자동 형변환됨
 * 	  =>그럼 결국 animal은 Animal 클래스만 사용할 수 있음
 * 	  =>animal.eat() ->가능
 * 	  =>animal.meow() ->컴파일 에러: 불가능
 * 
 * 	 ★★★★★★★★단 자식 클래스에 부모 메소드를 오버라이딩 한 게 있을 경우 오버라이딩 된 자식 클래스의 메소드가 실행됨		
 * 	  =>animal.live()->가능: "고양이가 삽니다." 출력됨
 * }
 * }
 * 
 * 
 * 
 * -> 업캐스팅 하는 이유: 상속관계에서 상속받은 서브클래스 갯수에 상관없이 
 *    공통으로 중복되는 멤버/메소드를 하나의 인스턴스로 <<<묶어서 관리하기 위함>>>
 * -> 부모클래스 부모 객체 이름= (부모클래스)자식 객체 이름 : (부모클래스)생략가능, 자동형변환됨
 * -> 원래 자식거 못쓰고 <<<부모꺼에만 있는 메소드/변수만 쓸 수 있음>>>
 * -> 단, 자식꺼에 부모것을 재정의한(오버라이딩)한 메소드가 있는 경우 부모 메소드->오버라이딩 된 메소드 순서로 코드 진행되어 
 *    결과적으로 오버라이딩 된 메소드가 실행됨
 *    
 *  *******헷갈렸던 부분*************  
 * -> 업캐스팅 시 자식 클래스의 멤버 필드, 멤버 메소드는 사용 못하고 부모 클래스만 사용 가능함
 * -> 그럼 굳이 왜 업캐스팅 하느냐?
 * -> 업캐스팅으로 객체를 좀 더 일반적인 타입으로 캐스팅함으로써 다양한 하위 클래스의 객체를
 *    !!하나의 상위 클래스, 상위 컬렉션에 저장!!할 수 있기 때문임!!!!!!!!
 *    
 *    
 * -> ##예시 부모클래스: Shape, 자식클래스: Rectangle, Triangle, Circle
 * 	Rectangle[] r = new Rectangle[];
	r[0] = new Rectangle();
	r[1] = new Rectangle();
	
	Triangle[] t = new Triangle[];
	t[0] = new Triangle();
	t[1] = new Triangle();
	
	Circle[] c = new Circle[];
	c[0] = new Circle();
	c[1] = new Circle();   이런 코드를 업캐스팅해서 하나의 클래스로 묶는다
	
	->
	
	Shape[] s = new Shape[];
	s[0] = new Rectangle();
	s[1] = new Rectangle();
	s[2] = new Triangle();
	s[3] = new Triangle();
	s[4] = new Circle();
	s[5] = new Circle();
 * 
 * 
 * 
 * 2-2. 다운캐스팅(downcasting) : 업캐스팅된 것!을 대상으로 원래대로 되돌려 <<<자식클래스 고유 기능 복구/회복/사용하기 위해서>>>
 * -> 부모를 자식으로 형변환 하는 것
 * -> 업캐스팅 안된 부모를 다운캐스팅하면 오류남: 전제->다운캐스팅은 업캐스팅이 선례되어야 실행 가능함 -> ClassCastException
 * -> 다운캐스팅 하는 이유: 오버라이딩한 메소드가 아닌 이상 업캐스팅 시 자식의 고유 메소드 사용못함
 *    따라서 업캐스팅한 자식을 다시 다운캐스팅해야 고유 메소드를 사용할 수 있기 때문에 실시됨
 * -> 자식클래스 자식객체 이름 = (자식클래스) 부모객체이름
 * -> (자식클래스) 생략 불가, 자동 형변환 안돼서 꼭 명시해야함
 * 
 * 3. instance of 연산자 + if 문이랑 같이 쓰임
 * -> 객체가 어느 클래스 타입에 속하는지 판별해 true/false를 반환해줌
 * -> 참조타입만 사용가능! 기본형(int, boolean 등등은 못씀)
 * -> if(a[참조변수/객체] instance of B[클래스명]) -> "a가 B 클래스 타입을 참조하고 있나요? or a가 B클래스의 객체인가요?" 라는 뜻
 * -> 여기서 true 가 나오면 검사한 클래스 B로 형변환이 가능하다.
 * -> 다운캐스팅을 하려는데 생부모인지 업캐스팅 된 부모인지 헷갈리고 객체 구별 어려울 때 도움 주는 연산자임
 * 
 *  *  class Animal{
 *   public void eat(){
 *   	sysout("동물이 먹습니다.");
 *   }
 *   
 *   public void live(){
 *   	sysout("동물이 삽니다.");
 *   }
 *  }
 * 
 * class Cat extends Animal{
 * 	public void meow(){
 * 		sysout("야옹합니다.");
 * 	}
 * 	
 * 	@overrride
 * 	public void live(){
 * 		sysout("고양이가 삽니다.");	
 * 	}
 * }
 * 
 * public class 다형성Main(){
 * 	public static void main(String[] args) {
 * 		Cat cat=new Cat();
 * 		Animal animal=(Animal) cat;
 * or  
 *      Animal animal=new Cat();
 * ----------업캐스팅됨---------------
 * 
 * ------Cat의 객체 주소를 저장한 animal 변수(객체를 저장했으니 객체라고 봐도 될 듯) 다운캐스팅 하려고 함->instance of 연산자 사용해서 확인 후 다운캐스팅 하기
 * 
 * if(animal(소문자: 객체/인스턴스) instance of Cat(대문자: 클래스 이름)){
 * 
 *    ★★★★★★★★★★위 코드 해석★★★★★★★★★★★
 *    animal 객체가!! Cat 클래스!!의 객체(=인스턴스입니까?)
 *    ->animal 변수에 Cat 클래스 객체를 저장했으니 animal 객체는 Cat 클래스의 객체임
 *    
 *    true면
 *    Cat cat =(Cat)animal;
 *    Animal 타입의 animal 객체를 다운캐스팅(=animal 변수의 값을 Cat 타입으로 바꿈) 한 것을 
 *    Cat 클래스를 사용하는 cat 변수에 담음
 *    
 *    
 *    
 *    ★★★★★★★★★★다시 코드 해석★★★★★★★★★★★
 *    Cat cat = (Cat) animal;은 다운캐스팅을 수행하는 코드입니다. 아래와 같이 해석할 수 있습니다:

1. (Cat)은 형변환 연산자로, animal 변수의 값을 Cat 타입으로 변환함
   animal 변수는 이전에 Animal 타입이었고!!!! 업캐스팅된 객체를 참조하고 있습니다.

2. 다운캐스팅은 업캐스팅된 객체를 다시 원래의 자식 클래스 타입으로 변환하는 것을 의미합니다.
   (Cat) animal은 Animal 타입의 animal 변수의 값을 Cat 타입으로 변환한 것임!!!!!!!
   
3. Cat cat은 Cat 클래스의 변수로, cat 변수에 Cat 타입의 참조를 저장할 수 있습니다.
   "="를 통해 (Cat) animal에서 변환된 값을 cat 변수에 할당합니다. ->animal이 Cat 타입이 돼서 가능함

4. 이제 cat 변수는 Cat 클래스의 인스턴스를 참조하게 됩니다.

5. 결과적으로, animal 변수에서 다운캐스팅을 수행하여 cat 변수에 Cat 클래스의 인스턴스를 참조하게 됩니다. 
  이로써 cat 변수는 Cat 클래스에 정의된 멤버 필드와 메소드에 접근할 수 있습니다.
  
  ★★★★★★★★★★따라서 결과★★★★★★★★★★★
  cat.meow();-> 가능:  원래 자식 고유 메소드라서 사용 가능
  cat.eat();-> 가능!!!!!!!!: 자식은 부모 클래스를 그대로 사용할 수 있기 때문임
            -> !!큰원리 까먹지 않기: 부모 클래스를 수정해서 쓸거면 오버라이딩해서 쓰면 되고 아니면 그대로 가져와서 쓸 수 있음
  cat.live();-> 가능: "고양이가 삽니다" 출력됨
             -> 부모 클래스의 live()메소드를 자식 입맛에 맞게 오버라이딩 했기 때문임!!   
 * }
 *      
 *      
 * 
 * 
 * 
 */
	class Animall{
		String name;
		boolean fact;
		
		int method1(int a) {
			return a;
		}
	}
	
	class Dog extends Animall{
		int method1(int a) { //재정의
			System.out.println(a+1);
			return a+1;
		}
		void method2() {
			System.out.println("오버라이딩 안된 자식 고유 메소드");
		}
		
	}
	
	public class Polymorphism다형성_형변환 {
		
		public static void main(String[] args) {
			/*
			int a= 100;
			Animal animal= new Animal();
			Dog dog = new Dog();
			dog.name="말티즈";
			dog.method1(a);//101
			System.out.println(dog.fact + dog.name); //false, 말티즈
			*/
			
			/***********형변환-upcasting: ***********/
			//Animal animal = new Dog(); //참조다형성
			Dog dog= new Dog();
			Animall animal= (Animall)dog;
			animal.name="부모 멤버 변수 사용 가능";
			System.out.println(animal.name);
			animal.method1(1); //2출력->오버라이딩된 메소드는 자식꺼여도 사용 가능
			//animal.method2();// 업캐스팅되어 자식꺼 사용 불가능함
			((Dog)animal).method2(); //이렇게 다운 캐스팅해주면 원래 기능 회복되어 자식고유 메소드 사용 가능
			
			/***********형변환-downcasting: ***********/
			Dog dog1= (Dog)animal;
			dog1.name="";
			dog1.method1(0);
			dog1.method2(); // 다 사용 가능
			
			/***********instance of: ***********/
			Animall animal2= new Animall();
			Dog dog2= new Dog();
			//Animal animal2 = (Animal) dog2; //자식을 부모로 업캐스팅
			 
			if(dog2 instanceof Animall) { //dog2가 Animal 클래스를 참조하고 있나요? 
				Animall animal3 =(Animall)dog2;
				animal2.name="자식을 부모로 업캐스팅했습니다.";
				System.out.println(animal2.name);
			}else {
				System.out.println("형변환을 할 수 없습니다.");
			}
			
			System.out.println("animal2 instanceOf Animal: "+ (animal2 instanceof Animall)); //true: 자기자신참조
			System.out.println("dog2 instanceOf Animal: "+ (dog2 instanceof Animall)); //true: 자식이 부모 참조
			System.out.println("animal2 instanceOf Dog: "+ (animal2 instanceof Dog)); //false: 부모가 자식 참조? 노노
			System.out.println("dog2 instanceOf Dog: "+ (dog2 instanceof Dog)); //true: 자기 자신 참조
			
			
		}
	}
	

