package vrmaster_user;

public class PaymentInfo {
	private String cardNum;
	private int securityCode;
	
	public PaymentInfo(String cardNum, int secCode) {
		setCardNum(cardNum);
		setSecurityCode(secCode);
	}
	
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int secNum) {
		this.securityCode = secNum;
	}
}
