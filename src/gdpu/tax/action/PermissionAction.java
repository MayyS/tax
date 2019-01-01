package gdpu.tax.action;

import com.alibaba.fastjson.JSON;
import gdpu.tax.base.action.BaseAction;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.Permission;
import gdpu.tax.service.PermissionService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:S
 * @Date:18/12/31
 */
public class PermissionAction extends BaseAction {

    @Autowired
    private PermissionService permissionService;

    private Permission permission;


    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void listUI_result() throws IOException {
        System.out.println("permission_listUI_result");
        PageResult pageResult=permissionService.findObjects("from Permission",getPage(),getRows());

        Map<String,Object>map=new HashMap<>();
        map.put("total",pageResult.getTotalCount());
        map.put("rows",pageResult.getItems());

        String jsonString= JSON.toJSONString(map);
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        System.out.println(jsonString);
        response.getWriter().write(jsonString);
    }

    public void deleteByAjax()throws IOException{
        List<Object>list=permissionService.findRolePermissionByPermissionId(permission.getId());
        Map<String,Object>map=new HashMap<>();
        if(list!=null&&list.size()>0){
            map.put("message","当前删除的权限有被role_permission表关联，不能删除！");
        }else{
            permissionService.delete(permission);
            map.put("message","删除成功！");
            map.put("success",true);
        }
        String jsonString=JSON.toJSONString(map);

        HttpServletResponse response=ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonString);
    }

    public String add(){
        System.out.println("permisison add");
        permissionService.save(permission);
        return "list";
    }

    public String editUI(){
        permission=permissionService.findObjectById(permission.getId());
        return "editUI";
    }


    public String edit(){
        permissionService.update(permission);
        return "list";
    }

}
