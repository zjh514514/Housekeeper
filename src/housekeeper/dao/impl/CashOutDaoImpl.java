package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.CashOutDao;
import housekeeper.entities.CashIn;
import housekeeper.entities.CashOut;
import housekeeper.tools.HibernateTools;

@Repository
public class CashOutDaoImpl extends HibernateTools implements CashOutDao {

	private String hql = null;

	@Override
	public void save(CashOut cashOut) {
		getSession().save(cashOut);
	}

	@Override
	public void delete(Integer id) {
		hql = "DELETE FROM CashOut c WHERE c.cashOutId = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void update(CashOut cashOut) {
		hql = "UPDATE CashOut c SET c.time = ? , c.site = ? , c.people = ? , c.money = ? , c.remark = ? , c.item = ? , c.subItem = ? , c.account = ? WHERE c.cashOutId = ?";
		getSession().createQuery(hql).setParameter(0, cashOut.getTime()).setParameter(1, cashOut.getSite())
				.setParameter(2, cashOut.getPeople()).setParameter(3, cashOut.getMoney())
				.setParameter(4, cashOut.getRemark()).setParameter(5, cashOut.getItem())
				.setParameter(6, cashOut.getSubItem()).setParameter(7, cashOut.getAccount())
				.setParameter(8, cashOut.getCashOutId()).executeUpdate();
	}

	@Override
	public List<CashOut> queryByMember(Integer memberId) {
		hql = "FROM CashOutQuery c WHERE c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, memberId).list();
	}

	@Override
	public List<CashOut> queryByItem(Integer itemId, Integer memberId) {
		hql = "FROM CashOutQuery c WHERE c.id.itemId = ? AND c.id.memberId = ? ";
		return getSession().createQuery(hql).setParameter(0, itemId).setParameter(1, memberId).list();
	}

	@Override
	public List<CashOut> queryBySubItem(Integer subItemId, Integer memberId) {
		hql = "FROM CashOutQuery c WHERE c.id.subitemId = ? AND c.id.memberId = ? ";
		return getSession().createQuery(hql).setParameter(0, subItemId).setParameter(1, memberId).list();
	}

	@Override
	public List<CashOut> queryById(Integer id) {
		hql = "FROM CashOutQuery c WHERE c.id.cashoutId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

	@Override
	public List<CashOut> queryByAccount(Integer accountId, Integer memberId) {
		hql = "FROM CashOutQuery c WHERE c.id.accountId = ? AND c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, accountId).setParameter(1, memberId).list();
	}

}
