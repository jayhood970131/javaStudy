package com.jayhood.controller;

import com.jayhood.pojo.Books;
import com.jayhood.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {


    // controller调用service层
    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;

    // 查询全部书籍,返回到书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> booksList = booksService.queryAllBook();

        model.addAttribute("bookList", booksList);
        return "allBook";
    }
}
