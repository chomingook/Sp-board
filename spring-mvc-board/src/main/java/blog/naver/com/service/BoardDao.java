package blog.naver.com.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	
	// 테이블 : board , 기능 : 데이터 수정 
    public int updateBoard(Board board);

	 // 테이블 : board , 기능 : 데이터 삭제 
	 public int deleteBoard(Board board);

	// 테이블 : board , 기능 : 하나의 데이터 가져오기
    public Board selectBoardByKey(int boardNo);
    
	/* 테이블 : board , 기능 : 한 페이지의 데이터 가져오기 */
	public int selectTotalBoardCount();

	/* 테이블 : board , 기능 : 전체 로우 카운터 가져오기 */
	public List<Board> selectBoardListPerPage(Map<String, Integer> map);

	/* 테이블 : board , 기능 : 데이터 입력하기 */
	public int insertBoard(Board board);


}
