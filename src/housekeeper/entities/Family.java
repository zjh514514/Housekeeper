package housekeeper.entities;

import org.springframework.stereotype.Component;

@Component("family")
public class Family {

	private Integer familyId;
	private String username;
	private String password;
	private String familyName;

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
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

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return "Family [familyId=" + familyId + ", username=" + username + ", password=" + password + ", familyName="
				+ familyName + "]";
	}

}
