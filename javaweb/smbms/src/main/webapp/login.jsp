<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/6
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/base.css"
    />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/login.css"
    />

</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市订单管理系统</h1>
        </header>
        <section class="loginContent">
            <form action="${pageContext.request.contextPath}/servlet/loginServlet" class="loginForm" method="post" name="actionForm" id="actionForm">
                <div class="info">${error}</div>
                <div class="inputbox">
                    <label for="userCode">用户名：</label>
                    <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required>
                </div>
                <div class="inputbox">
                    <label for="userPassword">密码：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录">
                    <input type="reset" value="重置">
                </div>
            </form>
        </section>
    </section>
</body>
</html>
