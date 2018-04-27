package shop.socialnetwork.command;

/* 
 * Note: Redirect를 할 것인지 dispatcher를 할 것인지 선택하기 위해서 만든 class
 * Author: 안태현
 * Since: 20/04/2018
 * */
public class ActionForward {
	private boolean isRedirect;
	private String path;
	
	public ActionForward() {}

	public ActionForward(boolean isRedirect, String path) {
		super();
		this.isRedirect = isRedirect;
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
