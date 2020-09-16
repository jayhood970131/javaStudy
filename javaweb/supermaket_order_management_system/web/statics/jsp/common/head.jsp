<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/10
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>超市订单管理系统</title>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/base.css"></link>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <script type="text/javascript " src="${pageContext.request.contextPath}/statics/js/time.js" charset="UTF-8"></script>
</head>
<body>
    <%-- 头部 --%>
    <header class="head clearfix">
        <div class="left">
            <span class="bg-shopcart"></span>
            <h2 class="head-title">超市订单管理系统</h2>
        </div>
        <div class="right">
            <span class="head-user">${userSession.userName}</span> 欢迎您！
            <button class="btn-exit" id="btn-exit" onclick="window.location.href='${pageContext.request.contextPath}/logout.do'">退出</button>
        </div>
    </header>
    <%-- tips --%>
    <section class="tips">
        <div class="left">
            <span class="bg-clock"></span>
            <span class="time" id="time">2020年06月10日 09:57:22 星期三</span>
        </div>
        <div class="right">
            <span>温馨提示: 为了能正常浏览，请使用高版本浏览器(IE10+)</span>
        </div>
    </section>
    <%--   导航栏 --%>
    <section class="main">
        <nav class="left nav">
            <h2 class="h-fn">
                <span></span> 功能列表
                <span></span>
            </h2>
            <ul class="list-fn">
                <li><a href="${pageContext.request.contextPath}/statics/jsp/billlist.jsp"><span></span>订单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/statics/jsp/providerlist.jsp"><span></span>供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userList.do"><span></span>用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/statics/jsp/rolelist.jsp"><span></span>角色管理</a></li>
                <li><a href="${pageContext.request.contextPath}/statics/jsp/pwdmodify.jsp"><span></span>密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/logout.do"><span></span>退出系统</a></li>
            </ul>
        </nav>

