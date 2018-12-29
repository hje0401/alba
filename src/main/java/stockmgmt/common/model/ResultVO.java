package stockmgmt.common.model;

import org.json.simple.JSONObject;

public class ResultVO {
	/** 결과코드 */
    private Boolean result = false;

    /** 오류코드 */
    private String errorCode;

    /** 오류메세지 */
    private String errorMessage;
    
    private JSONObject body = new JSONObject();

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
    
    public JSONObject getBody() {
		return body;
	}

	public void setBody(JSONObject body) {
		this.body = body;
	}

	public String toString() {
        StringBuffer objectValue = new StringBuffer();

        objectValue.append("result=").append(this.result)
            .append(", errorCode=").append(this.errorCode)
            .append(", errorMessage=").append(this.errorMessage)
            .append(", body=").append(this.body.toString());

        return objectValue.toString();
    }
}
