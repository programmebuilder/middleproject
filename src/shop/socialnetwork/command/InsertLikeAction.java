package shop.socialnetwork.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.dao.BoardDao;
import shop.socialnetwork.dto.LikeTbDto;

public class InsertLikeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao boardDao = BoardDao.getInstance();
		LikeTbDto likeTbDto = new LikeTbDto();
		
		int likeNo = boardDao.selectLikeTbLikeNo() + 1; // 좋아요 번호(primary key)
		String mId = request.getParameter("mId"); // 좋아요를 누른 아이디
		int bdNo = Integer.parseInt(request.getParameter("bdNo")); // 좋아요 누른 게시물 번호
		
		likeTbDto.setLikeNo(likeNo);
		likeTbDto.setmId(mId);
		likeTbDto.setBdNo(bdNo);
		
		boardDao.insertLike(likeTbDto);
		
		request.setAttribute("likeTbDto", likeTbDto);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath(""); // 좋아요 개수 변경으로 이동
		
		return actionForward;
	}

}
