package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.CashInDao;
import housekeeper.entities.CashIn;
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
		hql = "UPDATE CashIn c SET c.time = ? , c.site = ? , c.people = ? , c.money = ? , c.remark = ? , c.item = ? , c.subItem = ? , c.account = ? WHERE c.cashInId = ?";
		getSession().createQuery(hql).setParameter(0, cashIn.getTime()).setParameter(1, cashIn.getSite())
				.setParameter(2, cashIn.getPeople()).setParameter(3, cashIn.getMoney())
				.setParameter(4, cashIn.getRemark()).setParameter(5, cashIn.getItem())
				.setParameter(6, cashIn.getSubItem()).setParameter(7, cashIn.getAccount())
				.setParameter(8, cashIn.getCashInId()).executeUpdate();
	}

	@Override
	public List<CashIn> queryByMember(Integer memberId) {
		hql = "FROM CashInQuery c WHERE c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, memberId).list();
	}

	@Override
	public List<CashIn> queryByItem(Integer itemId, Integer memberId) {
		hql = "FROM CashInQuery c WHERE c.id.itemId = ? AND c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, itemId).setParameter(1, memberId).list();
	}

	@Override
	public List<CashIn> queryBySubItem(Integer subItemId, Integer memberId) {
		hql = "FROM CashInQuery c WHERE c.id.subitemId = ? AND c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, subItemId).setParameter(1, memberId).list();
	}

	@Override
	public List<CashIn> queryById(Integer id) {
		hql = "FROM CashInQuery c WHERE c.id.cashinId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

	@Override
	public List<CashIn> queryByAccount(Integer accountId, Integer memberId) {
		hql = "FROM CashInQuery c WHERE c.id.accountId = ? AND c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, accountId).setParameter(1, memberId).list();
	}

}
