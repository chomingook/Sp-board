package blog.naver.com.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //유연성 검사를 자체적으로 할수있음
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String BOARD_NS = "blog.naver.com.BoardMapper.";
	
	 /*테이블 : board , 기능 : 데이터 입력하기*/
	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.insert(BOARD_NS+"boardAdd", board);
	}

	/* 테이블 : board , 기능 : 전체 로우 카운터 가져오기*/
	@Override
	public int selectTotalBoardCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(BOARD_NS+"selectTotalBoardCount");
	}

	/* 테이블 : board , 기능 : 한 페이지의 데이터 가져오기*/ 
	@Override
	public List<Board> selectBoardListPerPage(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(BOARD_NS+"selectBoardListPerPage", map);
	}

	@Override
	public Board selectBoardByKey(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(BOARD_NS+"boardView", boardNo);
	}

	@Override
	public int deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.delete(BOARD_NS+"boardRemove", board);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update(BOARD_NS+"boardModify", board);
	}

	

	
}
