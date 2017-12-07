package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.MemberDao;
import housekeeper.entities.Family;
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
		hql = "FROM Member";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<Member> queryByUsername(String username) {
		hql = "FROM Member m WHERE m.username = ?";
		return getSession().createQuery(hql).setParameter(0, username).list();
	}

	@Override
	public List<Member> queryById(Integer id) {
		hql = "FROM Member m WHERE m.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

	@Override
	public List<Member> queryByFamily(Family family) {
		hql = "FROM Member m WHERE m.family = ?";
		return getSession().createQuery(hql).setParameter(0, family).list();
	}

}
