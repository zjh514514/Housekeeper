package housekeeper.dao;

import java.util.List;

import housekeeper.entities.Card;

public interface CardDao {

	/**
	 * 保存一张银行卡
	 * 
	 * @param card
	 */
	public void save(Card card);

	/**
	 * 删除一张银行卡
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改一张银行卡的信息
	 * 
	 * @param card
	 */
	public void update(Card card);

	/**
	 * 查询某一成员的所有银行卡
	 * 
	 * @param member
	 * @return
	 */
	public List<Card> queryByMember(Integer memberId);

	/**
	 * 查询某一张银行卡
	 * 
	 * @param id
	 * @return
	 */
	public List<Card> queryById(Integer id);
}
