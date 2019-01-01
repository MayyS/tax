package gdpu.tax.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")

public class Role {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String roleName;
	private String roleDesc;

	@JSONField(serialize = false)
	@ManyToMany
	@JoinTable(name = "role_permission",joinColumns = {@JoinColumn(name = "roleId")},
			inverseJoinColumns = {@JoinColumn(name = "permissionId")}

	)
	private Set<Permission>permissions=new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				", roleDesc='" + roleDesc + '\'' +
				", permissions=" + permissions +
				'}';
	}
}
