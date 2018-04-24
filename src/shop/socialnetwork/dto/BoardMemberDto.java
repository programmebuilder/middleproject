package shop.socialnetwork.dto;

import java.io.Serializable;

public class BoardMemberDto implements Serializable{
	private String mId;
	private String mNm;
	private String mImg;
	private int bdNo;
	
	public BoardMemberDto() {}

	public BoardMemberDto(String mId, String mNm, String mImg, int bdNo) {
		super();
		this.mId = mId;
		this.mNm = mNm;
		this.mImg = mImg;
		this.bdNo = bdNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmNm() {
		return mNm;
	}

	public void setmNm(String mNm) {
		this.mNm = mNm;
	}

	public String getmImg() {
		return mImg;
	}

	public void setmImg(String mImg) {
		this.mImg = mImg;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}
	
}
