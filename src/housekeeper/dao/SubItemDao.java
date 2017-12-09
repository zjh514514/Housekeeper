package housekeeper.dao;

import java.util.List;

import housekeeper.entities.SubItem;

public interface SubItemDao {

	/**
	 * 获取所有子类
	 * 
	 * @return
	 */
	public List<SubItem> getAll();

	/**
	 * 增加一条子类信息
	 * 
	 * @param subItem
	 */
	public void save(SubItem subItem);

	/**
	 * 删除一条子类信息
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改一条子类信息
	 * 
	 * @param id
	 * @param name
	 */
	public void update(Integer id, String name);

	/**
	 * 查询某一父类下所有子类
	 * 
	 * @param item
	 * @return
	 */
	public List<SubItem> queryByItem(Integer itemId);

	/**
	 * 通过子类名查询子类
	 * 
	 * @param name
	 * @return
	 */
	public List<SubItem> queryByName(String name);

	/**
	 * 查询一条子类信息
	 * 
	 * @param id
	 * @return
	 */
	public List<SubItem> queryById(Integer id);
}
