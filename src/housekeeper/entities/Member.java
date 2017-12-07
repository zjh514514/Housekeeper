package housekeeper.entities;

import org.springframework.stereotype.Component;

@Component("member")
public class Member {

	private Integer memberId;
	private String name;
	private String username;
	private String password;
	private Double balance;
	private String role;
	private Family family;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", balance=" + balance + ", role=" + role + ", family=" + family + "]";
	}

}
