package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.FamilyDao;
import housekeeper.entities.Family;
import housekeeper.tools.HibernateTools;

@Repository
public class FamilyDaoImpl extends HibernateTools implements FamilyDao {

	private String hql = null;

	@Override
	public void save(Family family) {
		getSession().save(family);
	}

	@Override
	public void delete(Integer id) {
		hql = "DELETE FROM Family f WHERE f.familyId = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void update(Family family) {
		hql = "UPDATE Family f SET f.password = ? , f.familyName = ? WHERE f.familyId = ?";
		getSession().createQuery(hql).setParameter(0, family.getPassword()).setParameter(1, family.getFamilyName())
				.setParameter(2, family.getFamilyId()).executeUpdate();
	}

	@Override
	public List<Family> query(String familyName) {
		hql = "FROM Family f WHERE f.familyName = ?";
		return getSession().createQuery(hql).setParameter(0, familyName).list();
	}

	@Override
	public List<Family> queryByUsername(String username) {
		hql = "FROM Family f WHERE f.username = ?";
		return getSession().createQuery(hql).setParameter(0, username).list();
	}

	@Override
	public List<Family> queryById(Integer id) {
		hql = "FROM Family f WHERE f.familyId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

}
