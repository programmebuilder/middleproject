package shop.socialnetwork.dto;

import java.io.Serializable;
import java.security.Timestamp;

public class BoardDto implements Serializable{
	private int bdNo;
	private String bdContent;
	private Timestamp bdUpLdTime;
	private String mId;
	private int likeHits;
	private int rplyHits;
	
	public BoardDto() {}

	public BoardDto(int bdNo, String bdContent, Timestamp bdUpLdTime, String mId, int likeHits, int rplyHits) {
		super();
		this.bdNo = bdNo;
		this.bdContent = bdContent;
		this.bdUpLdTime = bdUpLdTime;
		this.mId = mId;
		this.likeHits = likeHits;
		this.rplyHits = rplyHits;
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

	public Timestamp getBdUpLdTime() {
		return bdUpLdTime;
	}

	public void setBdUpLdTime(Timestamp bdUpLdTime) {
		this.bdUpLdTime = bdUpLdTime;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getLikeHits() {
		return likeHits;
	}

	public void setLikeHits(int likeHits) {
		this.likeHits = likeHits;
	}

	public int getRplyHits() {
		return rplyHits;
	}

	public void setRplyHits(int rplyHits) {
		this.rplyHits = rplyHits;
	}

}