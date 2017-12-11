package housekeeper.entities;
// Generated 2017-12-11 20:27:19 by Hibernate Tools 5.2.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MemberQuery generated by hbm2java
 */
@Entity
@Table(name = "MemberQuery", catalog = "GuanJiapo")
public class MemberQuery implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8551886811875528293L;

	private MemberQueryId id;

	public MemberQuery() {
	}

	public MemberQuery(MemberQueryId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "memberId", column = @Column(name = "MEMBER_ID", nullable = false)),
			@AttributeOverride(name = "name", column = @Column(name = "NAME")),
			@AttributeOverride(name = "username", column = @Column(name = "USERNAME")),
			@AttributeOverride(name = "password", column = @Column(name = "PASSWORD")),
			@AttributeOverride(name = "balance", column = @Column(name = "BALANCE", precision = 22, scale = 0)),
			@AttributeOverride(name = "role", column = @Column(name = "ROLE")),
			@AttributeOverride(name = "familyId", column = @Column(name = "FAMILY_ID", nullable = false)),
			@AttributeOverride(name = "familyName", column = @Column(name = "FAMILY_NAME")) })
	public MemberQueryId getId() {
		return this.id;
	}

	public void setId(MemberQueryId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberQuery [id=" + id + "]";
	}

}
