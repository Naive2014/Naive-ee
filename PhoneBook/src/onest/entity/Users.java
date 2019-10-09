package onest.entity;
/**
 * Users类是本系统的实体�? 对应ER图里的用户实�?
 * @author onest
 *
 */
public class Users {
	private String username;
	private String password;
	private String address;
	private String mobile;
	private String name;
	private String qq;
	private String wechat;
	private String email;
	private String id;
	public Users(){
		super();
	}
	/**
	 * 系统进行初始�?  id 在系统实现里自动生成 不需要用户输�?
	 * @param username 账号
	 * @param password 密码
	 * @param address 地址
	 * @param mobile 手机
	 * @param name 该账号在系统里显示的名字
	 * @param qq qq
	 * @param wechat 微信�?
	 * @param email 邮箱�?
	 */
	public Users(String username,
			String password,
			String address,
			String mobile,
			String name,
			String qq,
			String wechat,
			String email
			){
		this.username=username;
		this.password=password;
		this.address=address;
		this.mobile=mobile;
		this.name=name;
		this.qq=qq;
		this.wechat=wechat;
		this.email=email;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getMobile(){
		return this.mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getQQ(){
		return this.qq;
	}
	
	public void setQQ(String qq){
		this.qq=qq;
	}
	
	public String getWechat(){
		return this.wechat;
	}
	
	public void setWechat(String wechat){
		this.wechat=wechat;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getid(){
		return this.id;
	}
	
	public void setid(String id){
		this.id=id;
	}
}
