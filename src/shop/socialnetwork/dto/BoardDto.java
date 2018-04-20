package shop.socialnetwork.dto;

import java.security.Timestamp;

public class BoardDto {
	private int bdNo;
	private String bdContent;
	private Timestamp upldTime;
	private String mId;
	
	public BoardDto() {}

	public BoardDto(int bdNo, String bdContent, Timestamp upldTime, String mId) {
		super();
		this.bdNo = bdNo;
		this.bdContent = bdContent;
		this.upldTime = upldTime;
		this.mId = mId;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getBdContent() {
		return bdContent;
	}

	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}

	public Timestamp getUpldTime() {
		return upldTime;
	}

	public void setUpldTime(Timestamp upldTime) {
		this.upldTime = upldTime;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}
	
}