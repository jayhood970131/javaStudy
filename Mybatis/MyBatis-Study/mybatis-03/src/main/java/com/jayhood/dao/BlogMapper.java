package com.jayhood.dao;

import com.jayhood.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    List<Blog> queryBlogsIf(Map map);

    List<Blog> queryBlogsChoose(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogsForeach(Map map);
}
