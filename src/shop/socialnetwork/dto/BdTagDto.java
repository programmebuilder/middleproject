package shop.socialnetwork.dto;

public class BdTagDto {
	private int bdTagNo;
	private int bdNo;
	private String bdTagContent;
	
	public BdTagDto() {}

	public BdTagDto(int bdTagNo, int bdNo, String bdTagContent) {
		super();
		this.bdTagNo = bdTagNo;
		this.bdNo = bdNo;
		this.bdTagContent = bdTagContent;
	}

	public int getBdTagNo() {
		return bdTagNo;
	}

	public void setBdTagNo(int bdTagNo) {
		this.bdTagNo = bdTagNo;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getBdTagContent() {
		return bdTagContent;
	}

	public void setBdTagContent(String bdTagContent) {
		this.bdTagContent = bdTagContent;
	}

}
