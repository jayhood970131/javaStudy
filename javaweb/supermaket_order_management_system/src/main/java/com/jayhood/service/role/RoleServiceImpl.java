package com.jayhood.service.role;

import com.jayhood.dao.BaseDao;
import com.jayhood.dao.role.RoleDao;
import com.jayhood.dao.role.RoleDaoImpl;
import com.jayhood.entity.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl  implements RoleService{
    private RoleDao roleDao;
    public RoleServiceImpl(){
        this.roleDao = new RoleDaoImpl();
    }
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = new ArrayList<Role>();

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResources(connection,null,null);
        }
        return roleList;
    }

//    @Test
//    public void test(){
//        List<Role> roleList = getRoleList();
//        System.out.println(roleList.get(0).getRoleName());
//    }
}
