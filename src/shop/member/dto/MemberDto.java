package shop.member.dto;

public class MemberDto {
	private String mId;
	private String mPasswd;
	private String mBirth;
	private String mNm;
	private String mPhone;
	private String mImg;
	
	public MemberDto(String mId, String mPasswd, String mBirth, String mNm, String mPhone, String mImg) {
		super();
		this.mId = mId;
		this.mPasswd = mPasswd;
		this.mBirth = mBirth;
		this.mNm = mNm;
		this.mPhone = mPhone;
		this.mImg = mImg;
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

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmImg() {
		return mImg;
	}

	public void setmImg(String mImg) {
		this.mImg = mImg;
	}

}
