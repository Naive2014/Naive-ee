package onest.dao;

import onest.entity.Users;

public interface UsersDao {
	//常量属性??
	//抽象方法
	//
	/**
	 * 用户注册将users对象写入到数据库表Users�?
	 * @param users 注册对象
	 */
	public void UsersInsert(Users users);
	/**
	 * 查询个人的信息
	 * @param id 当前用户的id
	 * @return 返回个人信息 如果未查询到 则返回null
	 */
	public Users UsersSelect(String id);
	
	/**
	 * 用户登录功能的实体?
	 * @param username 帐号
	 * @param password 密码
	 * @return 登录是否成功 true表示登录成功 false表示登录失败
	 */
	public boolean UsersLogin(String username,String password);
	/**
	 * 修改个人信息
	 * @param id 当前用户的id
	 * @param users 当前用户修改后的新信息?
	 */
	public void UsersUpdate(String id,Users users);
	/**
	 * 删除个人信息
	 * @param id 当前用户的id
	 */
	public void UsersDelete(String id);
	/**
	 * 获取id
	 * @param username 帐号
	 * @param password 密码
	 */
	public String UsersGetID(String username);
}
