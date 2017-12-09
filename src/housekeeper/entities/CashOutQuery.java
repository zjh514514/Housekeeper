package housekeeper.entities;
// Generated 2017-12-9 17:20:53 by Hibernate Tools 5.2.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CashOutQuery generated by hbm2java
 */
@Entity
@Table(name = "CashOutQuery", catalog = "GuanJiapo")
public class CashOutQuery implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1298659829141462233L;
	private CashOutQueryId id;

	public CashOutQuery() {
	}

	public CashOutQuery(CashOutQueryId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "cashoutId", column = @Column(name = "CASHOUT_ID", nullable = false)),
			@AttributeOverride(name = "time", column = @Column(name = "TIME", length = 19)),
			@AttributeOverride(name = "site", column = @Column(name = "SITE")),
			@AttributeOverride(name = "people", column = @Column(name = "PEOPLE")),
			@AttributeOverride(name = "money", column = @Column(name = "MONEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "remark", column = @Column(name = "REMARK")),
			@AttributeOverride(name = "itemId", column = @Column(name = "ITEM_ID")),
			@AttributeOverride(name = "subitemId", column = @Column(name = "SUBITEM_ID")),
			@AttributeOverride(name = "itemName", column = @Column(name = "ITEM_NAME")),
			@AttributeOverride(name = "subitemName", column = @Column(name = "SUBITEM_NAME")),
			@AttributeOverride(name = "memberId", column = @Column(name = "MEMBER_ID")) })
	public CashOutQueryId getId() {
		return this.id;
	}

	public void setId(CashOutQueryId id) {
		this.id = id;
	}

}
