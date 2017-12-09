package housekeeper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import housekeeper.dao.AccountDao;
import housekeeper.entities.Account;
import housekeeper.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	@Resource
	private Account account;

	@Override
	public String addAccount(String name) {
		try {
			if (name == null)
				name = "";
			if (accountDao.queryByName(name).size() == 0) {
				account.setAccountName(name);
				accountDao.save(account);
				return "SUCCESS";
			} else {
				return "FAILED";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@Override
	public String deleteAccount(Integer id) {
		try {
			if (id != null) {
				accountDao.delete(id);
				return "SUCCESS";
			}
			return "FAILED";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@Override
	public String updateAccount(Integer id, String name) {
		try {
			if (name == null)
				name = "";
			if (id != null) {
				account.setAccountId(id);
				account.setAccountName(name);
				accountDao.update(account);
				return "SUCCESS";
			} else {
				return "FAILED";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@Override
	public List<Account> query() {
		List<Account> accounts = accountDao.getAll();
		if (accounts.size() != 0)
			return accounts;
		else {
			return null;
		}
	}

}
