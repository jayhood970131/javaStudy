package com.jayhood.mapper;

import com.jayhood.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUsers() {
        SqlSession sqlSession = getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(4, "王五", "223344");
        mapper.addUser(user);

        mapper.deleteUser(4);

        return mapper.selectUsers();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
