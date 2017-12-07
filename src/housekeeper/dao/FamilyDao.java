package housekeeper.dao;

import java.util.List;

import housekeeper.entities.Family;

public interface FamilyDao {

	/**
	 * 添加一个家庭
	 * 
	 * @param family
	 */
	public void save(Family family);

	/**
	 * 删除某一家庭
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改某一家庭信息
	 * 
	 * @param family
	 */
	public void update(Family family);

	/**
	 * 通过家庭名称查询某一家庭信息
	 * 
	 * @param username
	 * @return
	 */
	public List<Family> query(String familyName);

	/**
	 * 通过用户名查询家庭信息
	 * 
	 * @param username
	 * @return
	 */
	public List<Family> queryByUsername(String username);

	/**
	 * 查询某一家庭信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Family> queryById(Integer id);

}
