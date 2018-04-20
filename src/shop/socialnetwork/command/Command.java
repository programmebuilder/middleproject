package shop.socialnetwork.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}