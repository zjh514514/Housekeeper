package housekeeper.dao;

import java.util.List;

import housekeeper.entities.CashIn;
import housekeeper.entities.Item;
import housekeeper.entities.Member;
import housekeeper.entities.SubItem;

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
	public List<CashIn> queryByMember(Member member);

	/**
	 * 查询某一成员某一父类收入记录
	 * 
	 * @param Item
	 * @param Member
	 * @return
	 */
	public List<CashIn> queryByItem(Item Item, Member member);

	/**
	 * 查询某一成员某一子类收入记录
	 * 
	 * @param subItem
	 * @param Member
	 * @return
	 */
	public List<CashIn> queryBySubItem(SubItem subItem, Member member);

	/**
	 * 查询某一条收入记录
	 * 
	 * @param id
	 * @return
	 */
	public List<CashIn> queryById(Integer id);
}
