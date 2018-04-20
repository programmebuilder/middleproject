package shop.member.dto;

public class FollowingDto {
	private int fwNo;
	private String mFwId;
	private String mId;
	
	public FollowingDto() {}

	public FollowingDto(int fwNo, String mFwId, String mId) {
		super();
		this.fwNo = fwNo;
		this.mFwId = mFwId;
		this.mId = mId;
	}

	public int getFwNo() {
		return fwNo;
	}

	public void setFwNo(int fwNo) {
		this.fwNo = fwNo;
	}

	public String getmFwId() {
		return mFwId;
	}

	public void setmFwId(String mFwId) {
		this.mFwId = mFwId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}
	
}
