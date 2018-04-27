package shop.socialnetwork.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.command.Action;
import shop.socialnetwork.command.ActionForward;
import shop.socialnetwork.command.InsertBoardAction;
import shop.socialnetwork.command.InsertReplyAction;
import shop.socialnetwork.command.ModifyReplyCountAction;
import shop.socialnetwork.command.PrintBoardAction;

/* 
 * Note: command와 jsp를 연결해주는 역할을 하는 서블릿 
 * Author: 안태현
 * Since: 27/04/2018
 * */
@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardFrontController() {
        super();
    }
    
    /* doGet과 doPost에 중복된 내용을 적지 않기 위해서 만든 메소드 */
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// URI 정보를 확인하기 위해서 생성
    	String requestURI = request.getRequestURI(); 
    	String contextPath = request.getContextPath();
    	
    	// *.do 결과값을 얻기 위해 사용
    	String commandPath = requestURI.substring(contextPath.length() + 1); 
    	
    	Action action = null;
    	ActionForward actionForward = null;
    	
    	// *.do 요청에 해당하는 command를 호출
    	if (commandPath.equals("printBoard.do")) { // 글 출력
    		action = new PrintBoardAction();
    		try {
    			actionForward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if (commandPath.equals("insertBoard.do")) { // 글 작성
    		action = new InsertBoardAction();
    		try {
    			actionForward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (commandPath.equals("insertReply.do")) { // 댓글 작성
    		action = new InsertReplyAction();
    		try {
    			actionForward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (commandPath.equals("modifyReplyCount.do")) { // 댓글 수 수정
    		action = new ModifyReplyCountAction();
    		try {
    			actionForward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	// redirect와 dispatcher중에 무엇을 선택할 지 결정
    	if (actionForward != null) {
    		if (actionForward.isRedirect()) {
    			response.sendRedirect(actionForward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(actionForward.getPath());
    			dispatcher.forward(request, response);
    		} // END OF IF
    	} // END OF IF
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
