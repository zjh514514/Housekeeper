package housekeeper.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import housekeeper.dao.CardDao;
import housekeeper.entities.Card;
import housekeeper.tools.HibernateTools;

@Repository
public class CardDaoImpl extends HibernateTools implements CardDao {

	private String hql = null;

	@Override
	public void save(Card card) {
		getSession().save(card);
	}

	@Override
	public void delete(Integer id) {
		hql = "DELETE FROM Card c WHERE c.cardId = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void update(Card card) {
		hql = "UPDATE Card c SET c.cardName = ? , c.cardNumber = ? , c.money = ? , c.remark = ? WHERE c.cardId = ?";
		getSession().createQuery(hql).setParameter(0, card.getCardName()).setParameter(1, card.getCardNumber())
				.setParameter(2, card.getMoney()).setParameter(3, card.getRemark()).setParameter(4, card.getCardId())
				.executeUpdate();
	}

	@Override
	public List<Card> queryByMember(Integer memberId) {
		hql = "FROM CardQuery c WHERE c.id.memberId = ?";
		return getSession().createQuery(hql).setParameter(0, memberId).list();
	}

	@Override
	public List<Card> queryById(Integer id) {
		hql = "FROM Card c WHERE c.cardId = ?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

}
