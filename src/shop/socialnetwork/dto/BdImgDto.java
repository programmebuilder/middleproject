package shop.socialnetwork.dto;

import java.io.Serializable;

public class BdImgDto implements Serializable {
	private int imgNo;
	private int bdNo;
	private int fNo;
	private String imgUrl;
	
	public BdImgDto() {}

	public BdImgDto(int imgNo, int bdNo, int fNo, String imgUrl) {
		super();
		this.imgNo = imgNo;
		this.bdNo = bdNo;
		this.fNo = fNo;
		this.imgUrl = imgUrl;
	}
	
	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
