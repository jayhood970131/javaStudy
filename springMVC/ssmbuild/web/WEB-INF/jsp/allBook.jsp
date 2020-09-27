<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/9/25
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h1>书籍展示</h1>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
               <div class="page-header">
                   <h1>
                       <small>书籍列表----显示所有书籍</small>
                   </h1>
               </div>
            </div>

            <div class="row">
                <div class="col-md-4 column">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/toAddBook">新增书籍</a>
                </div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <form action="${pageContext.request.contextPath}/books/queryBook" method="post" class="form-inline">
                        <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                        <input type="submit" value="查询" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <c:forEach var="book" items="${bookList}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/books/toUpdateBook/${book.bookID}">修改</a>
                                &nbsp; | &nbsp;
                                <a href="${pageContext.request.contextPath}/books/deleteBook/${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</body>
</html>
