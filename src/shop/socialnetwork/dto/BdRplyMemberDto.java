package shop.socialnetwork.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class BdRplyMemberDto implements Serializable{
	private String mId;
	private String mPasswd;
	private String mBirth;
	private String mNm;
	private String mImg;
	private String rplyContent;
	private int groupNo;
	private int stepNo;
	private int levNo;
	private int bdNo;
	private Timestamp rplyUpLdTime;
	
	public BdRplyMemberDto() {}
	
	public BdRplyMemberDto(String mId, String mPasswd, String mBirth, String mNm, String mImg, String rplyContent,
			int groupNo, int stepNo, int levNo, int bdNo, Timestamp rplyUpLdTime) {
		super();
		this.mId = mId;
		this.mPasswd = mPasswd;
		this.mBirth = mBirth;
		this.mNm = mNm;
		this.mImg = mImg;
		this.rplyContent = rplyContent;
		this.groupNo = groupNo;
		this.stepNo = stepNo;
		this.levNo = levNo;
		this.bdNo = bdNo;
		this.rplyUpLdTime = rplyUpLdTime;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPasswd() {
		return mPasswd;
	}

	public void setmPasswd(String mPasswd) {
		this.mPasswd = mPasswd;
	}

	public String getmBirth() {
		return mBirth;
	}

	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
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
