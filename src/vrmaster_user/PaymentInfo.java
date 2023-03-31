package vrmaster_user;

import java.io.Serializable;

public class PaymentInfo implements Serializable {
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
	
	public boolean equals(PaymentInfo pay) {
		return this.cardNum == pay.getCardNum() && this.securityCode == pay.getSecurityCode();
	}
}
