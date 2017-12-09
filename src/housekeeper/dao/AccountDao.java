package housekeeper.dao;

import java.util.List;

import housekeeper.entities.Account;

public interface AccountDao {

	/**
	 * 增加账户选项
	 * 
	 * @param accountDao
	 */
	public void save(Account account);

	/**
	 * 删除账户选项
	 * 
	 * @param accountId
	 */
	public void delete(Integer accountId);

	/**
	 * 修改账户选项
	 * 
	 * @param accountDao
	 */
	public void update(Account account);

	/**
	 * 获取所有账户选项
	 */
	public List<Account> getAll();

	/**
	 * 查询某一名称的账户选项
	 * 
	 * @param name
	 * @return
	 */
	public List<Account> queryByName(String name);
}
