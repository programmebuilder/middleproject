package shop.socialnetwork.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class BdRplyDto implements Serializable{
	private int bdRplyNo;
	private String mId;
	private String rplyContent;
	private int groupNo;
	private int stepNo;
	private int levNo;
	private int bdNo;
	private Timestamp rplyUpLdTime;
	
	public BdRplyDto() {}
	
	public BdRplyDto(int bdRplyNo, String mId, String rplyContent, int groupNo, int stepNo, int levNo, int bdNo,
			Timestamp rplyUpLdTime) {
		super();
		this.bdRplyNo = bdRplyNo;
		this.mId = mId;
		this.rplyContent = rplyContent;
		this.groupNo = groupNo;
		this.stepNo = stepNo;
		this.levNo = levNo;
		this.bdNo = bdNo;
		this.rplyUpLdTime = rplyUpLdTime;
	}

	public int getBdRplyNo() {
		return bdRplyNo;
	}

	public void setBdRplyNo(int bdRplyNo) {
		this.bdRplyNo = bdRplyNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getRplyContent() {
		return rplyContent;
	}

	public void setRplyContent(String rplyContent) {
		this.rplyContent = rplyContent;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getStepNo() {
		return stepNo;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	public int getLevNo() {
		return levNo;
	}

	public void setLevNo(int levNo) {
		this.levNo = levNo;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public Timestamp getRplyUpLdTime() {
		return rplyUpLdTime;
	}

	public void setRplyUpLdTime(Timestamp rplyUpLdTime) {
		this.rplyUpLdTime = rplyUpLdTime;
	}
	
}
