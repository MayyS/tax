package gdpu.tax.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//ORM思想
//JPA
@Entity//标明当前类会与数据库建立关联关系
@Table(name="user")//User对象关联数据库表user
public class User {
	
	@Id//主键
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略，自增长
	private Integer id;
	
	@Column(name="name")//数据库的列名称
	private String name;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private boolean gender;//性别 true:男,false：女
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="mobile")
	private String mobile;//手机
	
	@Column(name="email")
	private String email;//邮箱
	
	@Column(name="state")
	private String state;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "userId")},
				inverseJoinColumns = {@JoinColumn(name = "roleId")}
	)
	public Set<Role>roles=new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dept='" + dept + '\'' +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", gender=" + gender +
				", birthday=" + birthday +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", state='" + state + '\'' +
				", roles=" + roles +
				'}';
	}
}
