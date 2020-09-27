package com.jayhood.controller;

import com.jayhood.pojo.Books;
import com.jayhood.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

    // 跳转到增加书籍
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    // 添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook=>" + books);
        booksService.addBook(books);
        return "redirect:/books/allBook";
    }

    @RequestMapping("/toUpdateBook/{bookId}")
    public String toUpdatePaper(@PathVariable("bookId") int id, Model model) {
        Books books = booksService.queryBookById(id);
        model.addAttribute("books", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook=> " + books);
        booksService.updateBook(books);
        return "redirect:/books/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        booksService.deleteBookById(id);
        return "redirect:/books/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        List<Books> booksList = booksService.queryBookByName(queryBookName);
        model.addAttribute("bookList", booksList);
        return "allBook";
    }


}
