package shop.socialnetwork.dto;

public class BdRplyDto {
	private int bdRplyNo;
	private String mId;
	private String rplyContent;
	private int groupNo;
	private int stepNo;
	private int levNo;
	private int bdNo;
	
	public BdRplyDto() {}

	public BdRplyDto(int bdRplyNo, String mId, String rplyContent, int groupNo, int stepNo, int levNo, int bdNo) {
		super();
		this.bdRplyNo = bdRplyNo;
		this.mId = mId;
		this.rplyContent = rplyContent;
		this.groupNo = groupNo;
		this.stepNo = stepNo;
		this.levNo = levNo;
		this.bdNo = bdNo;
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
	
}
