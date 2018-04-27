package shop.socialnetwork.command;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.dao.BoardDao;
import shop.socialnetwork.dto.BdImgDto;
import shop.socialnetwork.dto.BdRplyMemberDto;
import shop.socialnetwork.dto.BoardDto;
import shop.socialnetwork.dto.BoardMemberDto;

public class PrintBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = BoardDao.getInstance();
		List<BoardDto> listBoardDto = new ArrayList<BoardDto>();
		List<BdImgDto> listBdImgDto = new ArrayList<BdImgDto>();
		List<BoardMemberDto> listBoardMemberDto = new ArrayList<BoardMemberDto>();
		List<BdRplyMemberDto> listBdRplyMemberDto = new ArrayList<BdRplyMemberDto>();
		
		try {
			listBoardDto = boardDao.printBoard();
			listBdImgDto = boardDao.printImage();
			listBoardMemberDto = boardDao.printNickName();
			listBdRplyMemberDto = boardDao.printThreeReply();
			
			// 천의 자리 마다 ,(=콤마)를 넣는 과정
			for(int i = 0; i < listBoardDto.size(); i++) {
				// 좋아요 수
				double oldLikeHits = listBoardDto.get(i).getLikeHits();
				DecimalFormat decimalFormat = new DecimalFormat("#,##0");
				int newLikeHits = Integer.parseInt(decimalFormat.format(oldLikeHits));
				listBoardDto.get(i).setLikeHits(newLikeHits);
				
				// 댓글 수
				double oldRplyHits = listBoardDto.get(i).getRplyHits();
				int newRplyHits = Integer.parseInt(decimalFormat.format(oldRplyHits));
				listBoardDto.get(i).setRplyHits(newRplyHits);
				
			}
	
			request.setAttribute("listBoardDto", listBoardDto);
			request.setAttribute("listBdImgDto", listBdImgDto);
			request.setAttribute("listBoardMemberDto", listBoardMemberDto);
			request.setAttribute("listBdRplyMemberDto", listBdRplyMemberDto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/boardList.jsp");
		
		return actionForward;
	}

}
