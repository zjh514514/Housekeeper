package housekeeper.entities;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("cashIn")
public class CashIn {

	private Integer cashInId;
	private Date time;
	private String site;
	private String people;
	private Double money;
	private String remark;

	private Account account;
	private Member member;
	private Item item;
	private SubItem subItem;

	public Integer getCashInId() {
		return cashInId;
	}

	public void setCashInId(Integer cashInId) {
		this.cashInId = cashInId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public SubItem getSubItem() {
		return subItem;
	}

	public void setSubItem(SubItem subItem) {
		this.subItem = subItem;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CashIn [cashInId=" + cashInId + ", time=" + time + ", site=" + site + ", people=" + people + ", money="
				+ money + ", remark=" + remark + ", account=" + account + ", member=" + member + ", item=" + item
				+ ", subItem=" + subItem + "]";
	}

}
