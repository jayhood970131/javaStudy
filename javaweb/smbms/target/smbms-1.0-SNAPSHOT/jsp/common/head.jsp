<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/8
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/base.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/public.css">
</head>
<body>
<%--头部--%>
    <header class="publicHeader">
        <h1>超市订单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b">${userSession.userName}</span>，欢迎您</p>
            <a href="${pageContext.request.contextPath}/servlet/logoutServlet">退出</a>
        </div>
    </header>
<%--时间--%>
    <section class="publicTime">
        <span id="time">2019年1月1日 11.11 星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<%--主体内容--%>
    <section class="publicMain">
        <div class="left">
            <h2 class="leftH2">
                <span class="span1"></span>功能列表<span></span>
            </h2>
            <nav>
                <ul class="list">
                    <li><a href="${pageContext.request.contextPath}/jsp/billlist.jsp">订单管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/providerlist.jsp">供应商管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/userlist.jsp">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/rolelist.jsp">角色管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/pwdmodify.jsp">密码修改</a></li>
                    <li><a href="${pageContext.request.contextPath}/servlet/logoutServlet">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>
        <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>

