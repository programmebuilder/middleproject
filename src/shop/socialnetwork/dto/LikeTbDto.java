package shop.socialnetwork.dto;

public class LikeTbDto {
	private int likeNo;
	private String mId;
	private int bdNo;
	
	public LikeTbDto() {}

	public LikeTbDto(int likeNo, String mId, int bdNo) {
		super();
		this.likeNo = likeNo;
		this.mId = mId;
		this.bdNo = bdNo;
	}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

}
