package housekeeper.dao;

import java.util.List;

import housekeeper.entities.Family;
import housekeeper.entities.Member;

public interface MemberDao {

	/**
	 * 增加成员
	 * 
	 * @param member
	 */
	public void save(Member member);

	/**
	 * 删除某一成员
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改某一成员信息
	 * 
	 * @param member
	 */
	public void update(Member member);

	/**
	 * 获取所有成员信息
	 * 
	 * @return
	 */
	public List<Member> getAll();

	/**
	 * 通过用户名查询某一成员
	 * 
	 * @param username
	 * @return
	 */
	public List<Member> queryByUsername(String username);

	/**
	 * 查询某一成员
	 * 
	 * @param id
	 * @return
	 */
	public List<Member> queryById(Integer id);

	/**
	 * 查询某一家庭下的所有成员
	 * 
	 * @param family
	 * @return
	 */
	public List<Member> queryByFamily(Integer familyId);
}
