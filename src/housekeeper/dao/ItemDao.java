package housekeeper.dao;

import java.util.List;

import housekeeper.entities.Item;

public interface ItemDao {

	/**
	 * 获取所有父类信息
	 * 
	 * @return
	 */
	public List<Item> getAll();

	/**
	 * 保存一条父类信息
	 * 
	 * @param item
	 */
	public void save(Item item);

	/**
	 * 删除一条父类
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改一条父类信息
	 * 
	 * @param id
	 * @param name
	 */
	public void update(Integer id, String name);

	/**
	 * 查询收入或支出的父类
	 * 
	 * @param type
	 */
	public List<Item> queryByType(Integer type);

	/**
	 * 通过父类名查询父类信息
	 * 
	 * @param name
	 * @return
	 */
	public List<Item> queryByName(String name);

	/**
	 * 查询某一父类信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Item> queryById(Integer id);

}
