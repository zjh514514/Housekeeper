package housekeeper.service;

import java.util.List;

import housekeeper.entities.CashIn;
import housekeeper.entities.CashOut;

public interface CashInAndCashOutService {

	/**
	 * 增加一条收入记录
	 * 
	 * @param time:格式yyyy-MM-dd
	 *            HH:mm
	 * @param site
	 * @param people
	 * @param money
	 * @param remark
	 * @param memberId
	 * @param itemId
	 * @param subItemId
	 * @param accountId
	 * @return
	 */
	public String addCashIn(String time, String site, String people, Double money, String remark, Integer memberId,
			Integer itemId, Integer subItemId, Integer accountId);

	/**
	 * 增加一条支出记录
	 * 
	 * @param time
	 * @param site
	 * @param people
	 * @param money
	 * @param remark
	 * @param memberId
	 * @param itemId
	 * @param subItemId
	 * @param accountId
	 * @return
	 */
	public String addCashOut(String time, String site, String people, Double money, String remark, Integer memberId,
			Integer itemId, Integer subItemId, Integer accountId);

	/**
	 * 删除某一收入记录
	 * 
	 * @param id
	 * @return
	 */
	public String deleteCashIn(Integer id);

	/**
	 * 删除某一支出记录
	 * 
	 * @param id
	 * @return
	 */
	public String deleteCashOut(Integer id);

	/**
	 * 修改某一收入记录信息
	 * 
	 * @param time
	 * @param site
	 * @param people
	 * @param money
	 * @param remark
	 * @param itemId
	 * @param subItemId
	 * @param id
	 * @param accountId
	 * @return
	 */
	public String updateCashIn(String time, String site, String people, Double money, String remark, Integer itemId,
			Integer subItemId, Integer id, Integer accountId);

	/**
	 * 修改某一支出记录信息
	 * 
	 * @param time
	 * @param site
	 * @param people
	 * @param money
	 * @param remark
	 * @param itemId
	 * @param subItemId
	 * @param id
	 * @param accountId
	 * @return
	 */
	public String updateCashOut(String time, String site, String people, Double money, String remark, Integer itemId,
			Integer subItemId, Integer id, Integer accountId);

	/**
	 * 查询某一成员下所有的收入信息
	 * 
	 * @param memberId
	 * @return
	 */
	public List<CashIn> queryCashInByMember(Integer memberId);

	/**
	 * 查询某一成员下所有的支出信息
	 * 
	 * @param memberId
	 * @return
	 */
	public List<CashOut> queryCashOutByMember(Integer memberId);

	/**
	 * 查询某一成员下某一父类的收入记录
	 * 
	 * @param itemId
	 * @param memberId
	 * @return
	 */
	public List<CashIn> queryCashInByItem(Integer itemId, Integer memberId);

	/**
	 * 查询某一成员下某一父类的支出记录
	 * 
	 * @param itemId
	 * @param memberId
	 * @return
	 */
	public List<CashOut> queryCashOutByItem(Integer itemId, Integer memberId);

	/**
	 * 查询某一成员下某一子类的收入记录
	 * 
	 * @param subItemId
	 * @param memberId
	 * @return
	 */
	public List<CashIn> queryCashInBySubItem(Integer subItemId, Integer memberId);

	/**
	 * 查询某一成员下某一子类的支出记录
	 * 
	 * @param subItemId
	 * @param memberId
	 * @return
	 */
	public List<CashOut> queryCashOutBySubItem(Integer subItemId, Integer memberId);

	/**
	 * 查询某一条收入记录
	 * 
	 * @param id
	 * @return
	 */
	public List<CashIn> queryCashInById(Integer id);

	/**
	 * 查询某一条支出记录
	 * 
	 * @param id
	 * @return
	 */
	public List<CashOut> queryCashOutById(Integer id);

	/**
	 * 查询某一成员下某账户的收入记录
	 * 
	 * @param accountId
	 * @param memberId
	 * @return
	 */
	public List<CashIn> queryCashInByAccount(Integer accountId, Integer memberId);

	/**
	 * 查询某一成员下某账户的支出记录
	 * 
	 * @param accountId
	 * @param memberId
	 * @return
	 */
	public List<CashOut> queryCashOutByAccount(Integer accountId, Integer memberId);

}
