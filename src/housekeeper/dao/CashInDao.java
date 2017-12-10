package housekeeper.dao;

import java.util.List;

import housekeeper.entities.CashIn;

public interface CashInDao {

	/**
	 * 保存一条收入记录
	 * 
	 * @param cashIn
	 */
	public void save(CashIn cashIn);

	/**
	 * 删除一条收入记录
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改一条收入记录信息
	 * 
	 * @param cashIn
	 */
	public void update(CashIn cashIn);

	/**
	 * 查询某一成员的收入记录
	 * 
	 * @param menber
	 * @return
	 */
	public List<CashIn> queryByMember(Integer memberId);

	/**
	 * 查询某一成员某一父类收入记录
	 * 
	 * @param Item
	 * @param Member
	 * @return
	 */
	public List<CashIn> queryByItem(Integer ItemId, Integer memberId);

	/**
	 * 查询某一成员某一子类收入记录
	 * 
	 * @param subItem
	 * @param Member
	 * @return
	 */
	public List<CashIn> queryBySubItem(Integer subItemId, Integer memberId);

	/**
	 * 查询某一条收入记录
	 * 
	 * @param id
	 * @return
	 */
	public List<CashIn> queryById(Integer id);

	/**
	 * 查询某一成员某账户收入记录
	 * 
	 * @param accountId
	 * @param memberId
	 * @return
	 */
	public List<CashIn> queryByAccount(Integer accountId, Integer memberId);
}
