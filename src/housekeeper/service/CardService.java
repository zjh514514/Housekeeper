package housekeeper.service;

import java.util.List;

import housekeeper.entities.Card;

public interface CardService {

	/**
	 * 增加一张银行卡
	 * 
	 * @param name
	 * @param number
	 * @param money
	 * @param remark
	 * @param memberId
	 * @return
	 */
	public String addCard(String name, String number, Double money, String remark, Integer memberId);

	/**
	 * 删除一张银行卡
	 * 
	 * @param id
	 * @return
	 */
	public String deleteCard(Integer id);

	/**
	 * 修改某一银行卡信息
	 * 
	 * @param name
	 * @param number
	 * @param money
	 * @param remark
	 * @param id
	 * @return
	 */
	public String updateCard(String name, String number, Double money, String remark, Integer id);

	/**
	 * 查询某一成员下所有的银行卡
	 * 
	 * @param memberId
	 * @return
	 */
	public List<Card> queryByMember(Integer memberId);

	/**
	 * 查询某一银行卡信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Card> queryById(Integer id);
}
