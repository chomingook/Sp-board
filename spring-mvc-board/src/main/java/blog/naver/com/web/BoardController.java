package blog.naver.com.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import blog.naver.com.service.Board;
import blog.naver.com.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//5.1 수정된 결과값을 List로 보내기 action
	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public String boardModify(Board board){
		boardService.getupdateBoard(board);
		return "redirect:/board/boardList";
		
	}
	
	//5.수정화면 나타내기 boardModify.jsp 
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)// get요청방식
	public String boardModify(Model model,
			@RequestParam(value="boardNo") int boardNo){
			model.addAttribute(boardService.viewBoard(boardNo));
		return "/board/boardModify";	//forwarding 됨다
	}
	
	//4.1 삭제된 결과값을 List로 보내기 action
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.POST)
	public String boardRemove(Board board){
		boardService.getdeleteBoard(board);
		return "redirect:/board/boardList";
		
	}
	
	//4.삭제화면 나타내기 boardRemove.jsp 
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.GET)// get요청방식
	public String boardRemove(){
		return "/board/boardRemove";	//forwarding 됨다
	}
	
	
	//3.회원 하나의 값을 화면에 보여주기 boardView.jsp
	@RequestMapping(value="/board/boardView")
	public String boardView(Model model,
			@RequestParam(value="boardNo") int boardNo){
			model.addAttribute(boardService.viewBoard(boardNo));
				return "/board/boardView";
		
	}
	//2.DB에 있는 회원데이터를 리스트 및 rowCount값 화면에 보여주기  boardList.jsp
	@RequestMapping(value="/board/boardList")
	public String boardList(Model model,
		@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = boardService.getBoardListPerCurrentPage(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "/board/boardList";
	 }
	//1.2회원 입력된 값을 List로 보내기 action
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)// post요청방식
	public String boardAdd(Board board){
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";	//redirect 됨다
		
	}
	//1.회원 입력화면 출력하기 boardAdd.jsp
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)// get요청방식
	public String boardAdd(){
		return "/board/boardAdd";	//forwarding 됨다
	}
	
	
	
	
}
