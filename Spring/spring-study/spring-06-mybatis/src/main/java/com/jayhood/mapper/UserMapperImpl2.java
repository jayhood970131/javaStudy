package com.jayhood.mapper;

import com.jayhood.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUsers() {
        SqlSession sqlSession = getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectUsers();
    }
}