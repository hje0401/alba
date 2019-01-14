package stockmgmt.stockhistory.model;

public class StockHistoryVO {
	
	private String prodCode;
	private String inoutCnt;
	private String gubun;
	private String regDate;
	private String regId;
	private String stockMemo;
	private String stockEtc;
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getInoutCnt() {
		return inoutCnt;
	}
	public void setInoutCnt(String inoutCnt) {
		this.inoutCnt = inoutCnt;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getStockMemo() {
		return stockMemo;
	}
	public void setStockMemo(String stockMemo) {
		this.stockMemo = stockMemo;
	}
	public String getStockEtc() {
		return stockEtc;
	}
	public void setStockEtc(String stockEtc) {
		this.stockEtc = stockEtc;
	}
	@Override
	public String toString() {
		return "StockHistoryVO [prodCode=" + prodCode + ", inoutCnt=" + inoutCnt + ", gubun=" + gubun + ", regDate="
				+ regDate + ", regId=" + regId + ", stockMemo=" + stockMemo + ", stockEtc=" + stockEtc + "]";
	}
	
}
