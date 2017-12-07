package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.CashInDao;
import housekeeper.entities.CashIn;
import housekeeper.entities.Item;
import housekeeper.entities.Member;
import housekeeper.entities.SubItem;
import housekeeper.tools.HibernateTools;

@Repository
public class CashInDaoImpl extends HibernateTools implements CashInDao {

	private String hql = null;

	@Override
	public void save(CashIn cashIn) {
		getSession().save(cashIn);
	}

	@Override
	public void delete(Integer id) {
		hql = "DELETE FROM CashIn c WHERE c.cashInId = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void update(CashIn cashIn) {
		hql = "UPDATE CashIn c SET c.time = ? , c.site = ? , c.people = ? , c.money = ? , c.remark = ? , c.item = ? , c.subItem = ? WHERE c.cashInId = ?";
		getSession().createQuery(hql).setParameter(0, cashIn.getTime()).setParameter(1, cashIn.getSite())
				.setParameter(2, cashIn.getPeople()).setParameter(3, cashIn.getMoney())
				.setParameter(4, cashIn.getRemark()).setParameter(5, cashIn.getItem())
				.setParameter(6, cashIn.getSubItem()).setParameter(7, cashIn.getCashInId()).executeUpdate();
	}

	@Override
	public List<CashIn> queryByMember(Member member) {
		hql = "FROM CashIn c WHERE c.member = ?";
		return getSession().createQuery(hql).setParameter(0, member).list();
	}

	@Override
	public List<CashIn> queryByItem(Item item, Member member) {
		hql = "FROM CashIn c WHERE c.item = ? AND c.member = ?";
		return getSession().createQuery(hql).setParameter(0, item).setParameter(1, member).list();
	}

	@Override
	public List<CashIn> queryBySubItem(SubItem subItem, Member member) {
		hql = "FROM CashIn c WHERE c.subItem=? AND c.member = ?";
		return getSession().createQuery(hql).setParameter(0, subItem).setParameter(1, member).list();
	}

	@Override
	public List<CashIn> queryById(Integer id) {
		hql = "FROM CashIn c WHERE c.cashInId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

}
