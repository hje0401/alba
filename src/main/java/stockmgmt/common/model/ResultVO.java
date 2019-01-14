package stockmgmt.common.model;

import org.json.simple.JSONObject;

public class ResultVO<T> {
	/** 결과코드 */
    private Boolean result = false;

    /** 오류코드 */
    private String errorCode;

    /** 오류메세지 */
    private String errorMessage;
    
    private T body;

    public ResultVO() {
    }

    public ResultVO(Boolean result) {
        this.result = result;
    }

    public ResultVO(Boolean result, String errorCode) {
        this.result = result;
        this.errorCode = errorCode;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ResultVO [result=" + result + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", body="
				+ body + "]";
	}


}
