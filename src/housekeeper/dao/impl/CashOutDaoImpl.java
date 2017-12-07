package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.CashOutDao;
import housekeeper.entities.CashOut;
import housekeeper.entities.Item;
import housekeeper.entities.Member;
import housekeeper.entities.SubItem;
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
		hql = "UPDATE CashOut c SET c.time = ? , c.site = ? , c.people = ? , c.money = ? , c.remark = ? , c.item = ? , c.subItem = ? WHERE c.cashOutId = ?";
		getSession().createQuery(hql).setParameter(0, cashOut.getTime()).setParameter(1, cashOut.getSite())
				.setParameter(2, cashOut.getPeople()).setParameter(3, cashOut.getMoney())
				.setParameter(4, cashOut.getRemark()).setParameter(5, cashOut.getItem())
				.setParameter(6, cashOut.getSubItem()).setParameter(7, cashOut.getCashOutId()).executeUpdate();
	}

	@Override
	public List<CashOut> queryByMember(Member member) {
		hql = "FROM CashOut c WHERE c.member = ?";
		return getSession().createQuery(hql).setParameter(0, member).list();
	}

	@Override
	public List<CashOut> queryByItem(Item item, Member member) {
		hql = "FROM CashOut c WHERE c.item = ? AND c.member= ? ";
		return getSession().createQuery(hql).setParameter(0, item).setParameter(1, member).list();
	}

	@Override
	public List<CashOut> queryBySubItem(SubItem subItem, Member member) {
		hql = "FROM CashOut c WHERE c.subItem= ? AND c.member= ? ";
		return getSession().createQuery(hql).setParameter(0, subItem).setParameter(1, member).list();
	}

	@Override
	public List<CashOut> queryById(Integer id) {
		hql = "FROM CashOut c WHERE c.cashOutId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

}
