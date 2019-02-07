package co.ke.bank.maendeleo.pojos;

public class Response {

	private int code;
	private String desc;
	
	public Response() {
		super();
	}
	public Response(int code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
