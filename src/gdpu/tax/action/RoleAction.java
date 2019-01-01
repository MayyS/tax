package gdpu.tax.action;

import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import gdpu.tax.entity.Permission;
import gdpu.tax.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import gdpu.tax.base.action.BaseAction;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.Role;
import gdpu.tax.service.RoleService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

//第一次实训

/*

public class RoleAction extends BaseAction{



	//-----------定义并初始化所有的权限集合--------------
		private  List<String> permissionList;
		public  List<String> getPermissionList() {
			return permissionList;
		}
		public  void setPermissionList(List<String> permissionList) {
			this.permissionList = permissionList;
		}
		public RoleAction() {
			permissionList = new ArrayList<String>();
			permissionList.add("角色管理");
			permissionList.add("用户管理");
			permissionList.add("信息管理");
			permissionList.add("咨询管理");
			permissionList.add("投诉管理");
			permissionList.add("调查管理");
			permissionList.add("告知管理");
			permissionList.add("预约管理");
		}
		//--------------------------------------------------

		private Integer[] roots;

		public Integer[] getRoots() {
			return roots;
		}
		public void setRoots(Integer[] roots) {
			this.roots = roots;
		}

		public String getRootsString() {
			StringBuffer sb=new StringBuffer();
			if(roots==null)return null;
			for(int i:roots) {
				sb.append(permissionList.get(i)+" ");
			}
			return sb.toString();
		}

		private Role role;

		public Role getRole() {
				return role;
			}
		public void setRole(Role role) {
			this.role = role;
		}


		private List<Role> roleList;

		public List<Role> getRoleList() {
			return roleList;
		}
		public void setRoleList(List<Role> roleList) {
			this.roleList = roleList;
		}

		@Autowired
		private RoleService roleService;



	public String listUI() {
		String hql="from Role ";

		List<Object>conditions=null;

		if(role!=null) {
			conditions=new ArrayList<>();
			if(StringUtils.isNotBlank(role.getRoleName().trim())){
				hql = hql + " where name like ?";
				conditions.add("%"+role.getRoleName().trim()+"%");  //trim()：去掉字符串的前后空格
			}

		}
		pageResult=roleService.findObjects(hql, conditions, getPageNo(), getPageSize());
		return "listUI";
	}
	public String addUI() {
		return "addUI";
	}


	public String editUI() {
		role=roleService.findObjectById(role.getId());
		return "editUI";
	}

	public String deleteSelected() {
		roleService.deleteAll(getSelectedRows());
		return "list";
	}

	public String delete() {
		roleService.delete(role);
		return "list";
	}

	public String edit() {
//		role.setPermissions(getRootsString());
		roleService.update(role);
		return "list";
	}

	public String add() {
//		role.setPermissions(getRootsString());
		roleService.save(role);
		return "list";
	}


}
*/


//第二次实训
public class RoleAction extends BaseAction{

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	private Role role;

	private String permissionIds;

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String listUI(){
		return "listUI";
	}

	public void listUI_result() throws IOException {
		PageResult pageResult=roleService.findObjects("from Role",getPage(),getRows());
		Map<String,Object>map=new HashMap<>();
		map.put("total",pageResult.getTotalCount());
		map.put("rows",pageResult.getItems());
		String jsonObj= JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonObj);
		System.out.println(jsonObj);
	}

	public String addUI(){
		return "addUI";
	}
	public String add(){
		roleService.save(role);
		return "list";
	}

	public String editUI(){
		role=roleService.findObjectById(role.getId());
		return "editUI";
	}

	public String edit(){
		roleService.update(role);
		return "list";
	}

	public void deleteByAjax() throws IOException {
		Role roledb=roleService.findObjectById(role.getId());
		Set<Permission>permissions=roledb.getPermissions();
		Map<String,Object>map=new HashMap<>();
		if(permissions!=null &&permissions.size()>0){
			map.put("message","删除用户失败，角色被权限关联，不能删除");
		}else{
			List<Object>list=roleService.findUserRoleByRoleId(role.getId());

			if(list!=null&&list.size()>0){
				map.put("message","删除失败，角色有被用户关联，不能删除");
			}else{
				roleService.delete(roledb);
				map.put("message","");
				map.put("success",true);
			}
		}
		String jsonString = JSON.toJSONString(map);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonString);
	}

	public String rolePermission(){
		return "rolePermission";
	}

	public void getRolePermissionJson() throws IOException {
		Role roledb=roleService.findObjectById(role.getId());

		Set<Permission>permissions=roledb.getPermissions();

		List<Permission>allPermissionList=permissionService.findObjects("from Permission");

		List<Map<String,Object>>list=new ArrayList<>();

		for (Permission p:allPermissionList){
			Map<String,Object>map=new HashMap<>();
			map.put("id",p.getId());
			map.put("pId",p.getPid());
			map.put("name",p.getPermissionName());
			map.put("open",true);

			if(permissions!=null&&permissions.size()>0){
				for(Permission roleP:permissions){
					if(p.getId()==roleP.getId()){
						System.out.println("dsfdf");
						map.put("checked",true);
						break;

					}
				}
			}
			list.add(map);
		}
		String jsonString=JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);

		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonString);
	}

	public String saveUserRole(){
		roleService.savaRolePermission(role.getId(),permissionIds);
		return "list";
	}
}