package shop.socialnetwork.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.socialnetwork.command.Command;
import shop.socialnetwork.command.CommandForward;

/* 
 * Note: command와 jsp를 연결해주는 역할을 하는 서블릿 
 * Author: 안태현
 * Since: 20/04/2018
 * */
@WebServlet("/BoardFrontController")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardFrontController() {
        super();
    }
    
    /* doGet과 doPost에 중복된 내용을 적지 않기 위해서 만든 메소드 */
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI(); // URI 정보를 확인하기 위해서 생성
    	String contextPath = request.getContextPath();
    	String commandPath = requestURI.substring(contextPath.length() + 1); // *.do 결과값을 얻기 위해 사용
    	
    	Command command = null;
    	CommandForward commandForward = null;
    	
    	/* *.do 요청에 해당하는 command를 호출 */
    	
    	if (commandForward != null) {
    		if (commandForward.isRedirect()) {
    			response.sendRedirect(commandForward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(commandForward.getPath());
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
