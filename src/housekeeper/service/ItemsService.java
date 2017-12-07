package housekeeper.service;

import java.util.List;

import housekeeper.entities.Item;
import housekeeper.entities.SubItem;

public interface ItemsService {

	/**
	 * 增加一条父类信息
	 * 
	 * @param item
	 * @return
	 */
	public String addItems(String itemName, Integer type);

	/**
	 * 增加一条子类信息
	 * 
	 * @param subItem
	 * @return 0
	 */
	public String addSubItems(String subItemName, Integer itemId);

	/**
	 * 删除一条父类信息
	 * 
	 * @param id
	 * @return
	 */
	public String deleteItem(Integer id);

	/**
	 * 删除一条子类信息
	 * 
	 * @param id
	 * @return
	 */
	public String deleteSubItem(Integer id);

	/**
	 * 修改一条父类信息
	 * 
	 * @param item
	 * @return
	 */
	public String updateItem(String itemName, Integer id);

	/**
	 * 修改一条子类信息
	 * 
	 * @param subItem
	 * @return
	 */
	public String updateSubItem(String subItemName, Integer id);

	/**
	 * 查询收入或支出的父类
	 * 
	 * @param type
	 * @return
	 */
	public List<Item> queryItem(Integer type);

	/**
	 * 查询某一父类下的所有子类
	 * 
	 * @param item
	 * @return
	 */
	public List<SubItem> querySubItem(Integer itemId);
}
