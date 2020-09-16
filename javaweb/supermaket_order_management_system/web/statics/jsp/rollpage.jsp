<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/16
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="page-bar">
        <ul class="page-num-ul clearfix">
            <li class="left">
                共${param.totalCount}条记录   ${param.currentPageNo}/${param.totalPageCount}页
                <c:if test="${param.currentPageNo > 1}">
                 <a href="javascript:page_nav(document.forms[0],1);">首页</a>
                    <a href="javascript:page_nav(document.forms[0],${param.currentPageNo - 1});">上一页</a>
                </c:if>
                <c:if test="${param.currentPageNo < param.totalPageCount}">
                    <a href="javascript:page_nav(document.forms[0],${param.currentPageNo + 1});">下一页</a>
                    <a href="javascript:page_nav(document.forms[0],${param.totalPageCount});">最后一页</a>
             </c:if>
            </li>
        </ul>
        <span class="page-go-form">
            <label>跳转至</label>
            <input type="text" name="inputPage" id="inputPage" class="page-key"/>页
            <button type="button" class="page-btn" onclick="jump_to(document.forms[0],document.getElementById('inputPage').value)">Go</button>
        </span>
    </div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/rollpage.js" charset="UTF-8"></script>
