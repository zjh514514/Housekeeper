package housekeeper.service;

import java.util.List;

import housekeeper.entities.Account;

public interface AccountService {

	/**
	 * 增加账户选项
	 * 
	 * @param name
	 * @return
	 */
	public String addAccount(String name);

	/**
	 * 删除账户选项
	 * 
	 * @param id
	 * @return
	 */
	public String deleteAccount(Integer id);

	/**
	 * 修改账户选项
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public String updateAccount(Integer id, String name);

	/**
	 * 获取所有账户选项
	 * 
	 * @return
	 */
	public List<Account> query();

}
