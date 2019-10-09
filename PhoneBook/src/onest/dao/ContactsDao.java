package onest.dao;
import java.util.ArrayList;
import onest.entity.*;
public interface ContactsDao {

	//方法
	/**
	 * 添加联系人方法
	 * @param contacts 被添加的联系人实体
	 */
	public void ContactsAdd(Contacts contacts);
	
	/**
	 * 查询当前用户的所有的联系人
	 * @param id 当前用户的id
	 * @return 当前用户的所有的联系人信息
	 */
	public ArrayList<Contacts> ContactsSelect(String id);
	
	/**
	 * 查询当前用户下的指定id的联系人信息
	 * @param id 当前用户的id
	 * @param pid 当前用户关乎的联系人id
	 * @return 当前用户关乎的联系人详细信息
	 */
	public Contacts ContactsSelectOne(String pid,String id);
	
	/**
	 * 删除当前id用户下pid的值
	 * @param id 当前用户的id
	 * @param pid 被删除的联系人的id
	 */
	public void ContactsDelete(String pid,String id);
	
	/**
	 * 删除当前id用户下所有的值
	 * @param id 当前用户的id
	 */
	public void ContactsDeleteALL(String id);
	
	/**
	 * 修改当前id用户下id的值，新值为contacts
	 * @param id 当前用户的id
	 * @param pid 被修改的联系人的id
	 * @param contacts 被修改的联系人的新值
	 */
	public void ContactsUpdate(String pid,String id,Contacts contacts);
}
