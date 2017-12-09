package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.SubItemDao;
import housekeeper.entities.SubItem;
import housekeeper.tools.HibernateTools;

@Repository
public class SubItemDaoImpl extends HibernateTools implements SubItemDao {

	private String hql = null;

	@Override
	public List<SubItem> getAll() {
		hql = "FROM SubItem";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void save(SubItem subItem) {
		getSession().save(subItem);
	}

	@Override
	public void delete(Integer id) {
		hql = "DELETE FROM SubItem s WHERE s.subItemId = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void update(Integer id, String name) {
		hql = "UPDATE SubItem s SET s.subItemName = ? WHERE s.subItemId = ?";
		getSession().createQuery(hql).setParameter(0, name).setParameter(1, id).executeUpdate();
	}

	@Override
	public List<SubItem> queryByItem(Integer itemId) {
		hql = "FROM SubItemQuery s WHERE s.id.itemId = ?";
		return getSession().createQuery(hql).setParameter(0, itemId).list();
	}

	@Override
	public List<SubItem> queryByName(String name) {
		hql = "FROM SubItem s WHERE s.subItemName= ?";
		return getSession().createQuery(hql).setParameter(0, name).list();
	}

	@Override
	public List<SubItem> queryById(Integer id) {
		hql = "FROM SubItem s WHERE s.subItemId= ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

}
