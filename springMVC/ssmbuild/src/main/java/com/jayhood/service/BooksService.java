package com.jayhood.service;

import com.jayhood.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(int id);

    // 查询全部的书
    List<Books> queryAllBook();

    // 查询书籍
    List<Books> queryBookByName (String bookName);

}
