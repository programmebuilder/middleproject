package shop.socialnetwork.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.dao.BoardDao;
import shop.socialnetwork.dto.BdImgDto;
import shop.socialnetwork.dto.BoardDto;

public class insertBoardCommand implements Command {

	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = BoardDao.getInstance();
		
		BoardDto boardDto = new BoardDto();
		BdImgDto bdImgDto = new BdImgDto();
		
		int maxBdNo = boardDao.selectBoardBdNo() + 1;
		String bdContent = request.getParameter("bdContent");
		boardDto.setBdNo(maxBdNo);
		boardDto.setBdContent(bdContent);
		boardDto.setmId(request.getParameter("mId"));
		
		// 이미지 갯수
		int imageCount = Integer.parseInt(request.getParameter("count"));
		
		boardDao.insertBoard(boardDto);
		int boardSeq = boardDao.getBoardSeq(bdContent);
		
		bdImgDto.setBdNo(boardSeq);
		
		// 현재 에러 나는 부분
		/*bdImgDto.setImgUrl(imgurl);
		
		boardDao.insertBoardImage(bdImgDto, count, boardSeq);*/
		
		CommandForward commandForward = new CommandForward();
		commandForward.setRedirect(true);
		commandForward.setPath("printBoardCommand.do");
		
		return commandForward;
	}

}