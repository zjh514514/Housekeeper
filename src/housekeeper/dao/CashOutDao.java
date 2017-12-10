package housekeeper.dao;

import java.util.List;

import housekeeper.entities.CashOut;

public interface CashOutDao {

	/**
	 * 保存一条支出记录
	 * 
	 * @param cashOut
	 */
	public void save(CashOut cashOut);

	/**
	 * 删除一条支出记录
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改一条支出记录信息
	 * 
	 * @param cashOut
	 */
	public void update(CashOut cashOut);

	/**
	 * 查询某一成员支出记录
	 * 
	 * @param member
	 * @return
	 */
	public List<CashOut> queryByMember(Integer memberId);

	/**
	 * 查询某一成员某一父类支出记录
	 * 
	 * @param Item
	 * @param Member
	 * @return
	 */
	public List<CashOut> queryByItem(Integer ItemId, Integer memberId);

	/**
	 * 查询某一成员某一子类支出记录
	 * 
	 * @param subItem
	 * @param Member
	 * @return
	 */
	public List<CashOut> queryBySubItem(Integer subItemId, Integer memberId);

	/**
	 * 查询一条支出记录
	 * 
	 * @param id
	 * @return
	 */
	public List<CashOut> queryById(Integer id);

	/**
	 * 查询某一成员某账户支出记录
	 * 
	 * @param accountId
	 * @param memberId
	 * @return
	 */
	public List<CashOut> queryByAccount(Integer accountId, Integer memberId);
}
