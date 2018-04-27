package shop.socialnetwork.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.dao.BoardDao;
import shop.socialnetwork.dto.BdRplyDto;

public class ModifyReplyCountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao boardDao = BoardDao.getInstance();
		BdRplyDto bdRplyDto = (BdRplyDto)request.getAttribute("bdRplyDto");
		
		int bdNo = bdRplyDto.getBdNo(); // 입력한 댓글의 게시물 번호
		int rplyHits = boardDao.selectBoardRplyHits(bdNo);
		
		boardDao.updateBoardRplyHits(rplyHits, bdNo); // 댓글 수 수정
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("printBoard.do");
		
		return actionForward;
	}

}
	