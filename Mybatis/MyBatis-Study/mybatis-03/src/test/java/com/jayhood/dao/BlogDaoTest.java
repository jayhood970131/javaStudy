package com.jayhood.dao;

import com.jayhood.pojo.Blog;
import com.jayhood.utils.IdUtils;
import com.jayhood.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogDaoTest {
    @Test
    public void insertBlogs() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
        blog.setId(IdUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);
        blog.setId(IdUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);
        blog.setId(IdUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.commit();
        session.close();
    }

    @Test
    public void queryBlogsIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "");
        map.put("author", "");
        List<Blog> blogs = mapper.queryBlogsIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogsChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "");
        map.put("author", "%牛%");
        List<Blog> blogs = mapper.queryBlogsChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "");
        map.put("author", "狂神鸭");
        map.put("id", "517ab63904b14d1b9d58ff239a9c481e");
        mapper.updateBlog(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogsForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);
        mapper.queryBlogsForeach(map);

        sqlSession.commit();
        sqlSession.close();
    }
}
