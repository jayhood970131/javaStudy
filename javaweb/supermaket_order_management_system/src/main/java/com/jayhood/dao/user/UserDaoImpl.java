package com.jayhood.dao.user;

import com.jayhood.dao.BaseDao;
import com.jayhood.entity.User;
import com.mysql.cj.util.StringUtils;

import javax.xml.transform.Result;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null){
            String sql = "select * from smbms_user where userCode = ? and userPassword = ?";
            Object[] params = {userCode,userPassword};
            pstm = connection.prepareStatement(sql);
            rs = BaseDao.execute(connection,pstm,rs,params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreationData(rs.getTimestamp("creationDate"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResources(null,pstm,rs);
        }
        return user;
    }

    public boolean saveUserPassword(Connection connection, String oldPassword, String newPassword) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        boolean isModified = false;

        if (connection != null){
            String sql = "update smbms_user set userPassword = ? where userPassword = ?";
            Object[] params = {newPassword,oldPassword};
            pstm = connection.prepareStatement(sql);
            updateRows = BaseDao.execute(connection,pstm,params);
            if (updateRows != 0){
                isModified = true;
            }
            BaseDao.closeResources(null,pstm,null);;
        }
        return isModified;
    }

    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int userCount = 0;
        List<Object> list = new ArrayList<Object>();
        if (connection != null) {
            StringBuffer strBuff = new StringBuffer();
            strBuff.append("select count(1) as count from smbms_user u,smbms_role r " +
                    "where u.userRole = r.id");

            if (!StringUtils.isNullOrEmpty(userName)) {
                strBuff.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }
            if (userRole > 0) {
                strBuff.append(" and u.userRole = ?");
                list.add(userRole);
            }
            pstm = connection.prepareStatement(strBuff.toString());
            Object[] params = list.toArray();
            rs = BaseDao.execute(connection,pstm,rs,params);

            if (rs.next()){
                userCount = rs.getInt("count"); // 从结果集中获取最终数据
            }
            BaseDao.closeResources(null,pstm,rs);
        }
        return userCount;
    }

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if (connection != null){
            StringBuffer strBuff = new StringBuffer();
            strBuff.append("select u.*,r.roleName as userRoleName from smbms_user u," +
                    "smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(userName)){
                strBuff.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }
            if (userRole > 0){
                strBuff.append(" and u.userRole = ?");
                list.add(userRole);
            }

            // 在数据库中，分页使用limit
            strBuff.append(" order by creationDate DESC limit ?,?");
            list.add((currentPageNo - 1)*pageSize);
            list.add(pageSize);

            pstm = connection.prepareStatement(strBuff.toString());
            Object[] params = list.toArray();

            rs = BaseDao.execute(connection,pstm,rs,params);

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setUserRole(rs.getInt("userRole"));
                user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(user);
            }
            BaseDao.closeResources(null,pstm,rs);
        }
        return userList;
    }

    public boolean deleteUser(Connection connection, int userId) throws SQLException {
        PreparedStatement pstm = null;
        boolean isDelete = false;

        if (connection != null){
            String sql = "delete from smbms_user where id = ?";
            pstm = connection.prepareStatement(sql);
            Object[] params = {userId};
            int updateRows = BaseDao.execute(connection,pstm,params);
            if (updateRows != 0){
                isDelete = true;
            }
            BaseDao.closeResources(null,pstm,null);
        }
        return isDelete;
    }

    public User viewUser(Connection connection, int userId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null){
            String sql = "select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.id = ? and u.userRole = r.id";
            Object[] params = {userId};
            pstm = connection.prepareStatement(sql);
            rs = BaseDao.execute(connection,pstm,rs,params);
            if (rs.next()){
                user = new User();
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setUserRoleName(rs.getString("userRoleName"));
            }
            BaseDao.closeResources(null, pstm, rs);
        }
        return user;
    }

    public boolean saveUserInfo(Connection connection, User user) throws SQLException {
        PreparedStatement pstm = null;
        boolean isSaved = false;

        if (connection != null) {
            String sql = "update smbms_user set userName = ?, gender = ?, birthday = ?, phone = ?, address = ?, userRole = ? where id = ?";
            Object[] params = {user.getUserName(), user.getGender(), user.getBirthday(), user.getPhone(), user.getAddress(), user.getUserRole(), user.getId()};
            pstm = connection.prepareStatement(sql);
            int updateRows = BaseDao.execute(connection,pstm,params);
            if (updateRows != 0) {
                isSaved = true;
            }
            BaseDao.closeResources(null, pstm, null);
        }
        return false;
    }


}
