package housekeeper.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.MemberDao;
import housekeeper.entities.Member;
import housekeeper.tools.HibernateTools;

@Repository
public class MemberDaoImpl extends HibernateTools implements MemberDao {

	private String hql = null;

	@Override
	public void save(Member member) {
		getSession().save(member);
	}

	@Override
	public void delete(Integer id) {
		hql = "DELETE FROM Member m WHERE m.memberId = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void update(Member member) {
		hql = "UPDATE Member m SET m.password = ? , m.balance = ? , m.name = ? , m.role = ? WHERE m.memberId = ?";
		getSession().createQuery(hql).setParameter(0, member.getPassword()).setParameter(1, member.getBalance())
				.setParameter(2, member.getName()).setParameter(3, member.getRole())
				.setParameter(4, member.getMemberId()).executeUpdate();
	}

	@Override
	public List<Member> getAll() {
		hql = "FROM MemberQuery";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<Member> queryByUsername(String username) {
		hql = "FROM Member m WHERE m.username = ?";
		return getSession().createQuery(hql).setParameter(0, username).list();
	}

	@Override
	public List<Member> queryById(Integer id) {
		hql = "FROM MemberQuery m WHERE m.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

	@Override
	public List<Member> queryByFamily(Integer familyId) {
		hql = "FROM MemberQuery m WHERE m.id.familyId = ?";
		return getSession().createQuery(hql).setParameter(0, familyId).list();
	}

	@Override
	public double sumCashIn(Integer id, Date time) {
		hql = "SELECT SUM(c.id.money) FROM CashInQuery c WHERE c.id.memberId = ? AND c.id.time = ?";
		return (double) getSession().createQuery(hql).setParameter(0, id).setParameter(1, time).list().get(0);
	}

	@Override
	public double sumCashOut(Integer id, String time) {
		hql = "SELECT SUM(c.id.money) FROM CashOutQuery c WHERE c.id.memberId = ? AND c.id.time LIKE %?%";
		return (double) getSession().createQuery(hql).setParameter(0, id).setParameter(1, time).list().get(0);
	}

}
