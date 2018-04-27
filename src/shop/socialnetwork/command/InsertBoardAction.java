package shop.socialnetwork.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.dao.BoardDao;
import shop.socialnetwork.dto.BdImgDto;
import shop.socialnetwork.dto.BoardDto;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
public class InsertBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		// 파일 업로드를 하기 위해서 cos.jar 추가 및 객체 생성
		MultipartRequest multi = null;
		
		// 업로드 될 파일의 최대 사이즈 (10메가)
		int sizeLimit = 10 * 1024 * 1024;
		
		// 파일이 업로드될 실제 tomcat 폴더의 경로 (WebContent 기준)
		String savePath = request.getRealPath("/boardImages");
		
		try {
			multi = new MultipartRequest(
					request,
					savePath,
					sizeLimit,
					"UTF-8",
					new DefaultFileRenamePolicy() // 기본 이름 재명명 정책 객체
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = new BoardDto();
		BdImgDto bdImgDto = new BdImgDto();
		
		int bdNo = boardDao.selectBoardBdNo() + 1;
		int imgNo = boardDao.selectBdImgImgNo() + 1;
		int fNo = 0;
		// 세션에 들어가 있는 아이디를 받아와야 함, 현재 미구현
		String mId = multi.getParameter("mId");
		
		String fileName = multi.getFilesystemName("imgUrl");
		String src = "./boardImages/";
		String imgUrl = src + fileName;
		String bdContent = multi.getParameter("bdContent");
		
		// 등록한 파일이 있다면 파일 번호에 1을 입력
		if (fileName != null) {
			fNo = 1;
		}
		
		boardDto.setBdNo(bdNo);
		boardDto.setBdContent(bdContent);
		boardDto.setmId(mId);
		
		bdImgDto.setImgNo(imgNo);
		bdImgDto.setBdNo(bdNo);
		bdImgDto.setfNo(fNo);
		bdImgDto.setImgUrl(imgUrl);
		
		boardDao.insertBoard(boardDto);
		boardDao.insertBoardImage(bdImgDto);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("printBoard.do");
		
		return actionForward;
	}

}