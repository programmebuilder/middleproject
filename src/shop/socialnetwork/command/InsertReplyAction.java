package shop.socialnetwork.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.dao.BoardDao;
import shop.socialnetwork.dto.BdRplyDto;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = BoardDao.getInstance();
		BdRplyDto bdRplyDto = new BdRplyDto();
		
		int bdRplyNo = boardDao.selectBdRplyBdRplyNo() + 1;
		String mId = request.getParameter("mId");
		String rplyContent = request.getParameter("rplyContent");
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		int groupNo = bdRplyNo; // 한 그룹 번호 = 해당 댓글 번호
		
		// 답글이 없으므로 기본 데이터 0 입력
		int stepNo = 0;
		int levNo = 0;
		
		bdRplyDto.setBdRplyNo(bdRplyNo);
		bdRplyDto.setmId(mId);
		bdRplyDto.setRplyContent(rplyContent);
		bdRplyDto.setGroupNo(groupNo);
		bdRplyDto.setStepNo(stepNo);
		bdRplyDto.setLevNo(levNo);
		bdRplyDto.setBdNo(bdNo);
		
		boardDao.insertReply(bdRplyDto);
		
		request.setAttribute("bdRplyDto", bdRplyDto);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("modifyReplyCount.do");
		
		return actionForward;
	}

}
