package housekeeper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import housekeeper.dao.ItemDao;
import housekeeper.dao.SubItemDao;
import housekeeper.entities.Item;
import housekeeper.entities.SubItem;
import housekeeper.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Resource
	private ItemDao itemDao;
	@Resource
	private SubItemDao subItemDao;

	@Resource(name = "item")
	private Item item;
	@Resource(name = "subItem")
	private SubItem subItem;

	@Override
	public String addItems(String itemName, Integer type) {
		try {
			if (itemName == null)
				itemName = "";
			if (type != null) {
				if (type != 0 && type != 1)
					type = -1;
				if (itemName != "" && type != -1 && itemDao.queryByName(itemName).size() == 0) {
					item.setItemName(itemName);
					item.setType(type);
					itemDao.save(item);
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
	public String addSubItems(String subItemName, Integer itemId) {
		try {
			if (subItemName == null)
				subItemName = "";
			if (subItemName != "" && itemId != null && subItemDao.queryByName(subItemName).size() == 0
					&& itemDao.queryById(itemId).size() != 0) {
				item.setItemId(itemId);
				subItem.setSubItemName(subItemName);
				subItem.setItem(item);
				System.out.println("1");
				subItemDao.save(subItem);
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
	public String deleteItem(Integer id) {
		try {
			if (id != null && itemDao.queryById(id).size() != 0) {
				itemDao.delete(id);
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
	public String deleteSubItem(Integer id) {
		try {
			if (id != null && subItemDao.queryById(id).size() != 0) {
				subItemDao.delete(id);
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
	public String updateItem(String itemName, Integer id) {
		try {
			if (itemName == null)
				itemName = "";
			if (id != null && itemName != "" && itemDao.queryByName(itemName).size() == 0
					&& itemDao.queryById(id).size() != 0) {
				System.out.println("1");
				itemDao.update(id, itemName);
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
	public String updateSubItem(String subItemName, Integer id) {
		try {
			if (subItemName == null)
				subItemName = "";
			if (id != null && subItemName != "" && subItemDao.queryByName(subItemName).size() == 0
					&& subItemDao.queryById(id).size() != 0) {
				subItemDao.update(id, subItemName);
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
	public List<Item> queryItem(Integer type) {
		if (type != null) {
			if (type != 0 && type != 1)
				type = -1;
			if (type != -1) {
				List<Item> items = itemDao.queryByType(type);
				if (items.size() != 0) {
					return items;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<SubItem> querySubItem(Integer itemId) {
		if (itemId != null) {
//			item.setItemId(itemId);
			List<SubItem> subItems = subItemDao.queryByItem(itemId);
			if (subItems.size() != 0) {
				return subItems;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
