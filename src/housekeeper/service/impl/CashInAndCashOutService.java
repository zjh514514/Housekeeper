package housekeeper.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import housekeeper.dao.CashInDao;
import housekeeper.dao.CashOutDao;
import housekeeper.dao.ItemDao;
import housekeeper.dao.MemberDao;
import housekeeper.dao.SubItemDao;
import housekeeper.entities.Account;
import housekeeper.entities.CashIn;
import housekeeper.entities.CashOut;
import housekeeper.entities.Item;
import housekeeper.entities.Member;
import housekeeper.entities.SubItem;

@Service
public class CashInAndCashOutService implements housekeeper.service.CashInAndCashOutService {

	@Resource
	private CashInDao cashInDao;
	@Resource
	private CashOutDao cashOutDao;
	@Resource
	private CashIn cashIn;
	@Resource
	private CashOut cashOut;
	@Resource
	private MemberDao memberDao;
	@Resource
	private ItemDao itemDao;
	@Resource
	private SubItemDao subItemDao;
	@Resource
	private Account account;

	@Resource(name = "member")
	private Member member;
	@Resource(name = "item")
	private Item item;
	@Resource(name = "subItem")
	private SubItem subItem;

	@Override
	public String addCashIn(String time, String site, String people, Double money, String remark, Integer memberId,
			Integer itemId, Integer subItemId, Integer accountId) {
		try {
			Date date;
			if (time == null || time == "") {
				date = new Date();
			} else {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
			}
			if (site == null)
				site = "";
			if (people == null)
				people = "";
			if (money == null)
				money = 0.0;
			if (remark == null)
				remark = "";
			if (memberId != null && itemId != null && subItemId != null && accountId != null
					&& memberDao.queryById(memberId).size() != 0 && itemDao.queryById(itemId).size() != 0
					&& subItemDao.queryById(subItemId).size() != 0) {
				item.setItemId(itemId);
				subItem.setSubItemId(subItemId);
				member.setMemberId(memberId);
				account.setAccountId(accountId);
				cashIn.setMoney(money);
				cashIn.setPeople(people);
				cashIn.setRemark(remark);
				cashIn.setSite(site);
				cashIn.setTime(date);
				cashIn.setAccount(account);
				cashIn.setItem(item);
				cashIn.setMember(member);
				cashIn.setSubItem(subItem);
				cashInDao.save(cashIn);
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
	public String addCashOut(String time, String site, String people, Double money, String remark, Integer memberId,
			Integer itemId, Integer subItemId, Integer accountId) {
		try {
			Date date;
			if (time == null) {
				date = new Date();
			} else {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
			}
			if (site == null)
				site = "";
			if (people == null)
				people = "";
			if (money == null)
				money = 0.0;
			if (remark == null)
				remark = "";
			if (memberId != null && itemId != null && subItemId != null && accountId != null
					&& memberDao.queryById(memberId).size() != 0 && itemDao.queryById(itemId).size() != 0
					&& subItemDao.queryById(subItemId).size() != 0) {
				item.setItemId(itemId);
				subItem.setSubItemId(subItemId);
				member.setMemberId(memberId);
				account.setAccountId(accountId);
				cashOut.setMoney(money);
				cashOut.setPeople(people);
				cashOut.setRemark(remark);
				cashOut.setSite(site);
				cashOut.setTime(date);
				cashOut.setAccount(account);
				cashOut.setItem(item);
				cashOut.setMember(member);
				cashOut.setSubItem(subItem);
				cashOutDao.save(cashOut);
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
	public String deleteCashIn(Integer id) {
		try {
			if (id != null && cashInDao.queryById(id).size() != 0) {
				cashInDao.delete(id);
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
	public String deleteCashOut(Integer id) {
		try {
			if (id != null && cashOutDao.queryById(id).size() != 0) {
				cashOutDao.delete(id);
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
	public String updateCashIn(String time, String site, String people, Double money, String remark, Integer itemId,
			Integer subItemId, Integer id, Integer accountId) {
		try {
			if (id != null) {
				if (site == null)
					site = "";
				if (people == null)
					people = "";
				if (money == null)
					money = 0.0;
				if (remark == null)
					remark = "";
				Date date;
				if (time == null) {
					date = new Date();
				} else {
					date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
				}
				if (itemId != null && subItemId != null && accountId != null && cashInDao.queryById(id).size() != 0
						&& itemDao.queryById(itemId).size() != 0 && subItemDao.queryById(subItemId).size() != 0) {
					item.setItemId(itemId);
					subItem.setSubItemId(subItemId);
					account.setAccountId(accountId);
					cashIn.setCashInId(id);
					cashIn.setMoney(money);
					cashIn.setPeople(people);
					cashIn.setRemark(remark);
					cashIn.setSite(site);
					cashIn.setTime(date);
					cashIn.setAccount(account);
					cashIn.setItem(item);
					cashIn.setSubItem(subItem);
					cashInDao.update(cashIn);
					return "SUCCESS";
				} else {
					return "FAILED";
				}
			} else {
				return "FAILED";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@Override
	public String updateCashOut(String time, String site, String people, Double money, String remark, Integer itemId,
			Integer subItemId, Integer id, Integer accountId) {
		try {
			if (id != null) {
				if (site == null)
					site = "";
				if (people == null)
					people = "";
				if (money == null)
					money = 0.0;
				if (remark == null)
					remark = "";
				Date date;
				if (time == null) {
					date = new Date();
				} else {
					date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
				}
				if (itemId != null && subItemId != null && accountId != null & cashOutDao.queryById(id).size() != 0
						&& itemDao.queryById(itemId).size() != 0 && subItemDao.queryById(subItemId).size() != 0) {
					item.setItemId(itemId);
					subItem.setSubItemId(subItemId);
					account.setAccountId(accountId);
					cashOut.setCashOutId(id);
					cashOut.setMoney(money);
					cashOut.setPeople(people);
					cashOut.setRemark(remark);
					cashOut.setSite(site);
					cashOut.setTime(date);
					cashOut.setAccount(account);
					cashOut.setItem(item);
					cashOut.setSubItem(subItem);
					cashOutDao.update(cashOut);
					return "SUCCESS";
				} else {
					return "FAILED";
				}
			} else {
				return "FAILED";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@Override
	public List<CashIn> queryCashInByMember(Integer memberId) {
		if (memberId != null && memberDao.queryById(memberId).size() != 0) {
			// member.setMemberId(memberId);
			List<CashIn> cashIns = cashInDao.queryByMember(memberId);
			if (cashIns.size() != 0) {
				return cashIns;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashOut> queryCashOutByMember(Integer memberId) {
		if (memberId != null && memberDao.queryById(memberId).size() != 0) {
			// member.setMemberId(memberId);
			List<CashOut> cashOuts = cashOutDao.queryByMember(memberId);
			if (cashOuts.size() != 0) {
				return cashOuts;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashIn> queryCashInByItem(Integer itemId, Integer memberId) {
		if (itemId != null && memberId != null) {
			// item.setItemId(itemId);
			// member.setMemberId(memberId);
			List<CashIn> cashIns = cashInDao.queryByItem(itemId, memberId);
			if (cashIns.size() != 0) {
				return cashIns;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashOut> queryCashOutByItem(Integer itemId, Integer memberId) {
		if (itemId != null && memberId != null) {
			// item.setItemId(itemId);
			// member.setMemberId(memberId);
			List<CashOut> cashOuts = cashOutDao.queryByItem(itemId, memberId);
			if (cashOuts.size() != 0) {
				return cashOuts;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashIn> queryCashInBySubItem(Integer subItemId, Integer memberId) {
		if (subItemId != null && memberId != null) {
			subItem.setSubItemId(subItemId);
			member.setMemberId(memberId);
			List<CashIn> cashIns = cashInDao.queryBySubItem(subItemId, memberId);
			if (cashIns.size() != 0) {
				return cashIns;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashOut> queryCashOutBySubItem(Integer subItemId, Integer memberId) {
		if (subItemId != null && memberId != null) {
			// subItem.setSubItemId(subItemId);
			// member.setMemberId(memberId);
			List<CashOut> cashOuts = cashOutDao.queryBySubItem(subItemId, memberId);
			if (cashOuts.size() != 0) {
				return cashOuts;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashIn> queryCashInById(Integer id) {
		if (id != null) {
			List<CashIn> cashIns = cashInDao.queryById(id);
			if (cashIns.size() != 0) {
				return cashIns;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashOut> queryCashOutById(Integer id) {
		if (id != null) {
			List<CashOut> cashOuts = cashOutDao.queryById(id);
			if (cashOuts.size() != 0) {
				return cashOuts;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashIn> queryCashInByAccount(Integer accountId, Integer memberId) {
		if (accountId != null && memberId != null) {
			List<CashIn> cashIns = cashInDao.queryByAccount(accountId, memberId);
			if (cashIns.size() != 0) {
				return cashIns;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CashOut> queryCashOutByAccount(Integer accountId, Integer memberId) {
		if (accountId != null && memberId != null) {
			List<CashOut> cashOuts = cashOutDao.queryByAccount(accountId, memberId);
			if (cashOuts.size() != 0) {
				return cashOuts;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
