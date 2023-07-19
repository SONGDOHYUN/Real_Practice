package Practice_1;
/*
 * 자바의 입출력 클래스: 예외 처리를 함께하면서 쓰인다!! (외부와의 상호작용하면서 예기치 못한 상황이 생길 수도 있기 때문임)
 * 
 * 1. ByteStreamClass: 바이트기반 입출력 클래스
 * - 데이터를 바이트 단위로 처리하는 클래스 ex) 이미지, 오디오, 비디오 등의 이진 데이터 처리
 * - 예) InputStream, OutputStream, FileInputStream, FileOutputStream
 *  
 * 2. CharacterStreamClass: 문자기반 입출력 클래스
 * - 데이터를 문자 단위로 처리하는 클래스 ex) 텍스트 파일, 문자열
 * - 예) Reader, Writer, FileReader, FileWriter
 * 
 * 3. 일반적인 입출력 스트림
 * 3-1. InputStream, OutputStream: 바이트기반 입출력 추상 클래스
 * -> 하위 클래스: FileInputStream, FileOutputStream, ByteArrayInputStream, ByteArrayOutputStream
 * 
 * 3-2. Reader, Writer 클래스
 * -> 하위 클래스: FileReader, FileWriter, BufferedReader, BufferedWriter
 * 
 * 3-3. File 클래스: 파일과 관련된 입출력을 수행하는 클래스
 * -> 파일의 생성, 삭제, 읽기, 쓰기 등
 * 
 * 3-4. Socket, ServerSocket: 네트워크 소켓 프로그래밍을 위한 클래스
 * 
 * 3-5. PrintStream, PrintWriter: 텍스트 데이터를 출력하기 위한 클래스
 * ->System.out 등의 표준출력 스트림을 관리하는데 사용됨
 * 
 * 4. 데이터를 읽고 쓴다는 무슨 뜻?
 * 
 * 4-1. 읽기 : 정보 가져오기
 * -> DB에서 데이터를 가져와서!! 소프트웨어가 쓸 수 있게 형태를 변환하는 것
 * -> 예) 파일에서 텍스트를 가져와서 메모리에 저장 등
 * 
 * 4-2. 쓰기 : 정보 입력하기
 * -> 소프트웨어에서 생성된 데이터를 타겟으로 전달, 저장하는 것
 * -> 예) 소프트웨어에서 생성된 데이터를 파일에 저장 등
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class InputOutput {

}
