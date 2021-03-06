package housekeeper.entities;
// Generated 2017-12-9 16:05:59 by Hibernate Tools 5.2.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SubItemQueryId generated by hbm2java
 */
@Embeddable
public class SubItemQueryId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7575707917428805723L;
	private int itemId;
	private int subitemId;
	private String subitemName;

	public SubItemQueryId() {
	}

	public SubItemQueryId(int itemId, int subitemId) {
		this.itemId = itemId;
		this.subitemId = subitemId;
	}

	public SubItemQueryId(int itemId, int subitemId, String subitemName) {
		this.itemId = itemId;
		this.subitemId = subitemId;
		this.subitemName = subitemName;
	}

	@Column(name = "ITEM_ID", nullable = false)
	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Column(name = "SUBITEM_ID", nullable = false)
	public int getSubitemId() {
		return this.subitemId;
	}

	public void setSubitemId(int subitemId) {
		this.subitemId = subitemId;
	}

	@Column(name = "SUBITEM_NAME")
	public String getSubitemName() {
		return this.subitemName;
	}

	public void setSubitemName(String subitemName) {
		this.subitemName = subitemName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubItemQueryId))
			return false;
		SubItemQueryId castOther = (SubItemQueryId) other;

		return (this.getItemId() == castOther.getItemId()) && (this.getSubitemId() == castOther.getSubitemId())
				&& ((this.getSubitemName() == castOther.getSubitemName())
						|| (this.getSubitemName() != null && castOther.getSubitemName() != null
								&& this.getSubitemName().equals(castOther.getSubitemName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getItemId();
		result = 37 * result + this.getSubitemId();
		result = 37 * result + (getSubitemName() == null ? 0 : this.getSubitemName().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SubItemQueryId [itemId=" + itemId + ", subitemId=" + subitemId + ", subitemName=" + subitemName + "]";
	}

}
