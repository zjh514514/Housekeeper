package housekeeper.entities;

import org.springframework.stereotype.Component;

@Component("card")
public class Card {

	private Integer cardId;
	private String cardName;
	private String cardNumber;
	private Double money;
	private String remark;

	private Member member;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", money=" + money
				+ ", remark=" + remark + ", member=" + member + "]";
	}

}
