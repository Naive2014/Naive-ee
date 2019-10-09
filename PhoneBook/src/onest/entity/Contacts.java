package onest.entity;

public class Contacts {
	private String name;
	private String address;
	private String mobile;
	private String qq;
	private String wechat;
	private String school;
	private String sex;
	private String id;//用户ID
	private String pid;//联系人ID
	public Contacts(){}
	
	public Contacts(String name,
			String address,
			String mobile,
			String qq,
			String wechat,
			String school,
			String sex){
		this.name=name;
		this.address=address;
		this.mobile=mobile;
		this.qq=qq;
		this.wechat=wechat;
		this.school=school;
		this.sex=sex;
	}
	public String getName(){
		return this.name;
	}
	
	public void setName (String name){
		this.name=name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress (String address){
		this.address=address;
	}
	
	public String getMobile(){
		return this.mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public String getWechat(){
		return this.wechat;
	}
	
	public void setWechat(String wechat){
		this.wechat=wechat;
	}
	
	public String getQQ(){
		return this.qq;
	}
	
	public void setQQ(String qq){
		this.qq=qq;
	}
	
	public String getSchool(){
		return this.school;
	}
	
	public void setSchool(String school){
		this.school=school;
	}
	
	public String getSex(){
		return this.sex;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public String getPid(){
		return this.pid;
	}
	
	public void setPid(String pid){
		this.pid=pid;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
}
