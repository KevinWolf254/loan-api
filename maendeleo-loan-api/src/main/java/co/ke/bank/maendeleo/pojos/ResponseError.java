package co.ke.bank.maendeleo.pojos;

import java.util.Date;

public class ResponseError extends Response{

	private Date timeStamp;

	public ResponseError() {
		super();
	}

	public ResponseError(int code, String desc) {
		super(code, desc);
		this.timeStamp = new Date();
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
