package bean;

public class Setting {
	private boolean needBlank;
	private boolean needAll;
	private boolean needOut;
	private String title;
	private boolean needUp;
	private boolean shortOrLong;
	private String sub;
	private boolean needTip;
	private boolean needArrow;

	public boolean isNeedBlank() {
		return needBlank;
	}

	public void setNeedBlank(boolean needBlank) {
		this.needBlank = needBlank;
	}

	public boolean isNeedAll() {
		return needAll;
	}

	public void setNeedAll(boolean needAll) {
		this.needAll = needAll;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isNeedOut() {
		return needOut;
	}

	public void setNeedOut(boolean needOut) {
		this.needOut = needOut;
	}

	public boolean isNeedUp() {
		return needUp;
	}

	public boolean isShortOrLong() {
		return shortOrLong;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public boolean isNeedTip() {
		return needTip;
	}

	public void setNeedTip(boolean needTip) {
		this.needTip = needTip;

	}

	public boolean isNeedArrow() {
		return needArrow;
	}

	public void setIsNeedArrow(boolean needArrow) {
		this.needArrow = needArrow;
	}

	public Setting(boolean needBlank, boolean needAll, boolean needOut,
			String title, boolean needUp, boolean shortOrLong, String sub,
			boolean needArrow) {
		this.needBlank = needBlank;
		this.needAll = needAll;
		this.needOut = needOut;
		this.title = title;
		this.needUp = needUp;
		this.shortOrLong = shortOrLong;
		this.sub = sub;
		this.needArrow = needArrow;
	}
}
