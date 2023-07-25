package JDBC;

import java.util.List;

/*
 * DAO가(-CRUD통해서-DB연결했었음)
 * Service-DAO: 서비스는 DAO에 접근해서 DAO 도움을 받아 DB에 접근하고자 함
 * 따라서 Service 구체화된 비즈니스 CRUD나 메소드가 있는거임 
 * 
 * 
 * AddressFinalDao의 객체를 멤버 필드로 선언함+기본 생성자에 AddressFinalDao 생성자도 넣음으로서
 * ->AddressFinalService 객체 생성 시 자동적으로 AddressFinalDao 필드 모두 사용가능해짐
 */
public class AddressFinalService {
	//DAO를 멤버필드로 선언한다->그래야 Dao.메소드()해서 쓸 수 있으니까
	private AddressFinalDao addressFinalDao;
	
	//기본 생성자->서비스 객체 생성 시 DAO 객체도 생성하여 DAO 필드정보 다 물고올 수 있게끔함
	public AddressFinalService() throws Exception{
		this.addressFinalDao=new AddressFinalDao();
	}
	
	//주소록 한개 쓰기: DAO insert() 응용
	public int Write(Address insertAddress) throws Exception{
		int writeAddress=addressFinalDao.insert(insertAddress);
		return writeAddress;
	}
	
	//주소록 no로 한개 보기: DAO select By No응용
	public Address addressDetail(int no) throws Exception{
		Address findAddress=addressFinalDao.findByNo(no);
		return findAddress;
	}
	
	//주소록 no로 1개 수정
	public int modify(Address updateAddress) throws Exception{
		int modifyAddress=addressFinalDao.update(updateAddress);
		return modifyAddress;
	}
	
	//주소록 1개 삭제
	public int delete(int no) throws Exception{
		int deleteAddress=addressFinalDao.delete(no);
		return deleteAddress;
	}
	
	//주소록 전체보기
	public List<Address> list() throws Exception{
		List<Address> addressList=addressFinalDao.findAll();
		return addressList;
	}
	
}
