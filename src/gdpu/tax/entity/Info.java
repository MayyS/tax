package gdpu.tax.entity;

import javax.persistence.Entity;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="info")
public class Info implements java.io.Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="type")
	private String type;
	
	@Column(name="source")
	private String source;
	
	@Column(name="content")
	private String content;
	
	@Column(name="creator")
	private String creator;
	
	@Column(name="createTime")
	private Date createTime;
	
	@Column(name="state")
	private String state;
	
	/** default constructor */
	public Info() {
	}

	/** minimal constructor */
	public Info(String title) {
		this.title = title;
	}
	/** full constructor */
	public Info(String type, String source, String title, String content, String creator, Timestamp createTime, String state) {
		this.type = type;
		this.source = source;
		this.title = title;
		this.content = content;
		this.creator = creator;
		this.createTime = createTime;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Info [id=" + id + ", title=" + title + ", type=" + type + ", source=" + source + ", creator=" + creator
				+ ", createTime=" + createTime + ", state=" + state + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
